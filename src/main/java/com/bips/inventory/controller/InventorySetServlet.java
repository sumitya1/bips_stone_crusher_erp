package com.bips.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.beans.InventorySetBean;
import com.bips.inventory.dao.InventoryDaoImpl;

@WebServlet("/inventoryset/*")
public class InventorySetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InventorySetServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		//out.print("BIPS guys not are really amazing...");
		InventorySetBean inventoryset = new InventorySetBean();
		inventoryset.setItem_name(request.getParameter("item_name"));
		inventoryset.setItem_type(request.getParameter("item_type"));
		inventoryset.setOwner_name(request.getParameter("owner_name"));
		inventoryset.setRent_type(request.getParameter("rent_type"));
		inventoryset.setRent_rate(request.getParameter("rent_rate"));
		InventoryDaoImpl insertitems = new InventoryDaoImpl();
		insertitems.addItems(inventoryset);
		
		//getServletContext().getRequestDispatcher("/login/Home.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}