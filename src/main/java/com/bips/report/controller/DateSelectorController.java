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
import com.bips.report.beans.ReportBean;
import com.bips.report.dao.ReportDaoImpl;


@WebServlet("/dateselector/*")
public class DateSelectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<DateSelectorBean> dp_records = null;
	private List<ReportBean> tr_records = null;
	private ReportDaoImpl reprtdaoimpl = null;


	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


		String report_type = request.getParameter("report_type");
		if(report_type.equals("department")){

			String dp_report_type = request.getParameter("dp_report_type");
			String dp_fromdate = request.getParameter("dp_fromdate");
			String dp_todate = request.getParameter("dp_todate");

			HttpSession session=request.getSession();  
			session.setAttribute("report_type",report_type);
			session.setAttribute("dp_report_type",dp_report_type);
			session.setAttribute("dp_fromdate",dp_fromdate);  
			session.setAttribute("dp_todate", dp_todate);

			reprtdaoimpl = new ReportDaoImpl();


			try {
				dp_records = reprtdaoimpl.findDeptData(dp_report_type,dp_fromdate, dp_todate);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			request.setAttribute("dp_records", dp_records);
			String forwardstring = "/report/"+dp_report_type+"_record.jsp";
			System.out.println("forwardstring string is_="+forwardstring);
			request.getRequestDispatcher(forwardstring).forward(request,response);
		}
		else{
			String tr_report_type = request.getParameter("tr_report_type");
			String tr_fromdate = request.getParameter("tr_fromdate");
			String tr_todate = request.getParameter("tr_todate");

			HttpSession session=request.getSession();  
			session.setAttribute("report_type",report_type);
			session.setAttribute("tr_report_type",tr_report_type);
			session.setAttribute("tr_fromdate",tr_fromdate);  
			session.setAttribute("tr_todate", tr_todate);
			
			System.out.println("Sales values in controller are:="+report_type+"\t"+tr_report_type+"\t"+tr_fromdate+"\t"+tr_todate);
			
			reprtdaoimpl = new ReportDaoImpl();
				System.out.println("values are:="+tr_report_type+tr_fromdate+tr_todate);
			try {
				tr_records = reprtdaoimpl.findTrendData(tr_report_type,tr_fromdate, tr_todate);
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
			
			request.setAttribute("tr_records", tr_records);
			
			String forwardstring = "/report/"+tr_report_type+"_record.jsp";
			System.out.println("forwardstring string is_="+forwardstring);
			
			request.getRequestDispatcher(forwardstring).forward(request,response);
			
		}


	}

}
