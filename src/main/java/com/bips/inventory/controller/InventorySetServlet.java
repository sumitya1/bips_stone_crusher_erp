package com.bips.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.inventory.beans.InventoryBeanModel;
import com.bips.inventory.dao.InventoryDaoImpl;


@WebServlet("/personservlet/*")
public class InventorySetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InventorySetServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.print("BIPS guys are really amazing...");
		out.print("item"+request.getParameter("item")+"\n");
		out.print("rate"+request.getParameter("rate")+"\n");
		out.print("quantity"+request.getParameter("quantity")+"\n");
		out.print("sysdate"+request.getParameter("systemdate")+"\n");
		out.print("usage"+request.getParameter("usage")+"\n");
		out.print("fuel"+request.getParameter("fuel")+"\n");
		out.print("amount"+request.getParameter("amount")+"\n");
		out.print("payment"+request.getParameter("payment")+"\n");
		out.print("balance"+request.getParameter("balance")+"\n");
		
		InventoryBeanModel inventory = new InventoryBeanModel();
		inventory.setItem(request.getParameter("item"));
		inventory.setRate(request.getParameter("rate"));
		inventory.setQuantity(request.getParameter("quantity"));
		inventory.setSystemdate(request.getParameter("systemdate"));
		inventory.setUsage(request.getParameter("usage"));
		inventory.setFuel(request.getParameter("fuel"));
		inventory.setAmount(request.getParameter("amount"));
		inventory.setPayment(request.getParameter("payment"));
		inventory.setBalance(request.getParameter("balance"));
		InventoryDaoImpl insertitems = new InventoryDaoImpl();
		insertitems.setItems(inventory);
				
		//request.setAttribute("inventory", inventory);
		
		//getServletContext().getRequestDispatcher("/Manager/Manager.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
