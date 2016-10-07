package com.bips.report.controller;

import java.io.IOException;
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


		System.out.println("printing here:-"+report_type+"\t"+fl_report_type+"\t"+fromdate+"\t"+todate);

		try {
			msg = pdfreport.generateReport(fl_report_type,fromdate,todate);
			System.out.println("Message is here"+msg);
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/report/success.jsp").forward(request,
				response);

	}

}
