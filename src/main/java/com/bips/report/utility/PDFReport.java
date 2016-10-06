package com.bips.report.utility;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
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
	public String  generateReport() throws Exception {



		sql = "select ITEM_NAME, RENT_RATE, RENT_TYPE from inventoryitems";

		dbConnection = DataConnection.connectionInstance().createConnection();
		statement= dbConnection.createStatement();
		rs = statement.executeQuery(sql);
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Inventoryreport.pdf"));


		document.open();


		addMetaData(document);
		addTitlePage(document);

		//we have four columns in our table
		PdfPTable my_report_table = new PdfPTable(3);
		//create a cell object
		PdfPCell table_cell;
		String ITEM_NAME = "ITEM_NAME";
		String RENT_RATE = "RENT_RATE";
		String RENT_TYPE = "RENT_TYPE";
		table_cell = new PdfPCell(new Phrase(ITEM_NAME));
		my_report_table.addCell(table_cell);

		table_cell = new PdfPCell(new Phrase(RENT_RATE));
		my_report_table.addCell(table_cell);

		table_cell = new PdfPCell(new Phrase(RENT_TYPE));
		my_report_table.addCell(table_cell);


		while(rs.next()){
			System.out.println();

			while(rs.next()){

				String item_name = rs.getNString(1);
				table_cell = new PdfPCell(new Phrase(item_name));
				my_report_table.addCell(table_cell);

				String rent_rate = rs.getNString(2);
				table_cell = new PdfPCell(new Phrase(rent_rate));
				my_report_table.addCell(table_cell);

				String rent_type = rs.getNString(3);
				table_cell = new PdfPCell(new Phrase(rent_type));
				my_report_table.addCell(table_cell);

			}
			document.add(my_report_table);
			document.close();
			writer.close();
		}
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
