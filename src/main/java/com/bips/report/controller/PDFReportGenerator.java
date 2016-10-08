package com.bips.report.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bips.report.utility.PDFReport;


@WebServlet("/pdfreport/*")
public class PDFReportGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg = null; 
	private PDFReport pdfreport = null;
	private String fl_report_type = null;
	private String fromdate = null;
	private String todate = null;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		pdfreport = new PDFReport();
		HttpSession session=request.getSession(false);  
		String report_type = (String)session.getAttribute("report_type");
		if(report_type.equals("department")){
			fl_report_type = (String)session.getAttribute("dp_report_type");
			fromdate = (String)session.getAttribute("dp_fromdate");
			todate = (String)session.getAttribute("dp_todate");
		}
		else{
			fl_report_type = (String)session.getAttribute("tr_report_type");
			fromdate = (String)session.getAttribute("tr_fromdate");
			todate = (String)session.getAttribute("tr_todate");
		}


		try {
			msg = pdfreport.generateReport(report_type,fl_report_type,fromdate,todate);
			System.out.println("Message is here"+msg);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		//request.setAttribute("msg", msg);
		//request.getRequestDispatcher("/report/success.jsp").forward(request,
		//		response);

	}
	
	
	 protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
		 
		// reads input file from an absolute path
	        String filePath = "/home/syadav/Desktop/DeskTop/BIPS/PDFReports/Inventoryreport.pdf";
	        File downloadFile = new File(filePath);
	        FileInputStream inStream = new FileInputStream(downloadFile);
	        
	        String relativePath = getServletContext().getRealPath("");
	        System.out.println("relativePath = " + relativePath);
	        
		 
	     // obtains ServletContext
	        ServletContext context = getServletContext();
	        
	     // gets MIME type of the file
	        String mimeType = context.getMimeType(filePath);
	        if (mimeType == null) {         
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	         
	     // modifies response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	        
	        // forces download
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	        
	        
	     // obtains response's output stream
	        OutputStream outStream = response.getOutputStream();
	        
	        
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	        
	        
	        inStream.close();
	        outStream.close();   
	 }

}