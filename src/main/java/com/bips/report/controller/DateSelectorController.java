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


@WebServlet("/dateselector/*")
public class DateSelectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		
		
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		ReportDaoImpl reprtdaoimpl = new ReportDaoImpl();
		
	    List<DateSelectorBean> records = null;
		try {
			records = reprtdaoimpl.findData(fromdate, todate);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    request.setAttribute("records", records);
		request.getRequestDispatcher("/report/record.jsp").forward(request,
				response);

	}

}
