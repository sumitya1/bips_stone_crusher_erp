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

	private Connection dbConnection = null;
	private Statement statement = null;
	private String sql = null;
	private ResultSet rs;
	private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 22, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	private String[] colnames;

	public String  generateReport(String report_type ,String fl_report_type, String startdate,String enddate) throws Exception {
		
		if(report_type.equals("department")){
			
			switch(fl_report_type){
				case "inventory" :
		            sql="select * from "+fl_report_type+" where SYSTEMDATE "
							+ "in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")";
		            break;
				case "sales" :
		            sql="select * from "+fl_report_type+" where SYSTEMDATE "
							+ "in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")";
		            break;
			
				case "minning" :
		           	 sql="select * from "+fl_report_type+" where SYSTEMDATE "
							+ "in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")";
		            break;
			
				case "employee" :
		             sql="select employee_name,rs,SYSTEMDATE,description from DailyExpenses where SYSTEMDATE "
							+ "in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")";
		            break;
			}
			
		}	
		else{
			switch(fl_report_type){
			case "tr_sales" :
				System.out.println("table name is="+fl_report_type);
				//sql="select TOTAL,SYSTEMDATE from sales order by SYSTEMDATE desc";
	            break;
			case "tr_fuel" :
				sql="select item,fuel from inventory where SYSTEMDATE in("+"'"+startdate+"'"+","+"'"+enddate+"'"+")"+" order by SYSTEMDATE desc";
	            break;
		
			case "tr_expense" :
				sql ="select employee_name,rs,description from DailyExpenses order by rs desc";
	            break;
		
			}
			
			
		}
		dbConnection = DataConnection.connectionInstance().createConnection();
		statement= dbConnection.createStatement();
		System.out.println("Here 1=");
		rs = statement.executeQuery(sql);

		System.out.println("Here 2=");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		System.out.println("I am here0 with column no.-"+columnsNumber);

		colnames = new String[columnsNumber];

		for (int i = 1; i <= columnsNumber; i++ ) {
			colnames[i-1] = rsmd.getColumnName(i);
		
		}

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/syadav/git/bips_stone_crusher_erp/WebContent/BIPSreport.pdf"));

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


	public void addTitlePage(Document document) throws DocumentException {
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

	public void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
