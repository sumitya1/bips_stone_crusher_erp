package com.bips.report.utility;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.bips.report.dao.DataConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReport {

	private static Connection dbConnection = null;
	private  static Statement statement = null;
	private static String sql;
	private static ResultSet rs;
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 22, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	private String[] colnames;

	public String  generateReport(String report_type, String startdate,String enddate) throws Exception {

		sql ="select * from "+report_type+" where SYSTEMDATE in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")";

		dbConnection = DataConnection.connectionInstance().createConnection();
		statement= dbConnection.createStatement();
		rs = statement.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		System.out.println("I am here0 with column no.-"+columnsNumber);

		colnames = new String[columnsNumber];

		for (int i = 1; i <= columnsNumber; i++ ) {
			colnames[i-1] = rsmd.getColumnName(i);
		
		}

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/syadav/Desktop/DeskTop/BIPS/PDFReports/Inventoryreport.pdf"));

		document.open();
		addMetaData(document);
		addTitlePage(document);

		//we have four columnsNumber in our table
		PdfPTable my_report_table = new PdfPTable(columnsNumber);
		//create a cell object
		PdfPCell table_cell;

		for(int j=0; j <columnsNumber ;j++){
			table_cell = new PdfPCell(new Phrase(colnames[j]));
			my_report_table.addCell(table_cell);
		}


		while(rs.next()){
			for(int k=1;k <= columnsNumber;k++){
				String value = rs.getNString(k);
				table_cell = new PdfPCell(new Phrase(value));
				my_report_table.addCell(table_cell);
			}

		}
		document.add(my_report_table);
		document.close();
		writer.close();

		return "Sucessfully Generated Report!";



	}


	private static void addMetaData(Document document) {
		document.addTitle("BIPS INDIA PVT. LTD.");
		document.addSubject("BIPS STONE CRUSHER REPORT");
		document.addKeywords("Java, PDF, BIPS");
		document.addAuthor("BIPS");
		document.addCreator("BIPS");
	}


	private static void addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Inventoryreport of BIPS INDIA PVT. LTD.",blueFont));

		addEmptyLine(preface, 1);
		preface.setAlignment(Element.ALIGN_CENTER);


		document.add(preface);
		// Start a new page
		//document.newPage();
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
