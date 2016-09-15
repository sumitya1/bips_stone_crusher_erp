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
		//out.print("BIPS guys are really amazing...");
		InventoryBeanModel inventory = new InventoryBeanModel();
		inventory.setItem(request.getParameter("item"));
		inventory.setItem(request.getParameter("rate"));
		inventory.setItem(request.getParameter("quantity"));
		inventory.setItem(request.getParameter("sysdate"));
		inventory.setItem(request.getParameter("usage"));
		inventory.setItem(request.getParameter("fuel"));
		inventory.setUsage(request.getParameter("amount"));
		inventory.setQuantity(request.getParameter("payment"));
		inventory.setBalance(request.getParameter("balance"));
		InventoryDaoImpl insertitems = new InventoryDaoImpl();
		insertitems.setItems(inventory);
		
		request.setAttribute("inventory", inventory);
		
		getServletContext().getRequestDispatcher("/Manager/Manager.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
