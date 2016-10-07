package com.bips.report.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bips.report.beans.DateSelectorBean;
import com.bips.report.dao.ReportDaoImpl;


@WebServlet("/dateselector/*")
public class DateSelectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		
		String report_type = request.getParameter("report_type");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		
		HttpSession session=request.getSession();  
		session.setAttribute("report_type",report_type);
        session.setAttribute("fromdate",fromdate);  
        session.setAttribute("todate", todate);
        
		ReportDaoImpl reprtdaoimpl = new ReportDaoImpl();
		
	    List<DateSelectorBean> records = null;
		try {
			records = reprtdaoimpl.findData(report_type,fromdate, todate);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		for(DateSelectorBean record:records){
			System.out.println("in COntrolller"+record.getItem()+
					record.getRate()	
					);
		}
	    request.setAttribute("records", records);
		request.getRequestDispatcher("/report/record.jsp").forward(request,
				response);

	}

}
