package com.bips.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.report.beans.DateSelectorBean;
import com.bips.report.dao.ReportDaoImpl;
import com.bips.report.utility.PDFReport;


@WebServlet("/pdfreport/*")
public class PDFReportGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg = null; 
	private PDFReport pdfreport = null;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		pdfreport = new PDFReport();
		try {
			msg = pdfreport.generateReport();
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/report/record.jsp").forward(request,
				response);

	}

}
