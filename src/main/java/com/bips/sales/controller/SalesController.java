package com.bips.sales.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.sales.beans.SalesBean;
import com.bips.sales.dao.SalesDaoImpl;


@WebServlet("/salescontroller/*")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SalesController() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SalesBean salesitems = new SalesBean();
		salesitems.setStone_type(request.getParameter("stone_type"));
		salesitems.setSystemdate(request.getParameter("systemdate"));
		salesitems.setRate(request.getParameter("rate"));
		salesitems.setQuantity(request.getParameter("quantity"));
		salesitems.setNo_of_trucks(request.getParameter("no_of_trucks"));
		salesitems.setCompany_name(request.getParameter("company_name"));
		salesitems.setTotal(request.getParameter("total"));
		salesitems.setPayment_received(request.getParameter("payment_received"));
		salesitems.setBalance(request.getParameter("balance"));
		SalesDaoImpl submtitems = new SalesDaoImpl();
		String msg = submtitems.submitItems(salesitems);
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/sales/success.jsp").forward(request,
				response);
		
	}

}
