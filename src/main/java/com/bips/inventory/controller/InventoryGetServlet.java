package com.bips.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.inventory.beans.InventoryBeanModel;

@WebServlet("/personservlet1/*")
public class InventoryGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InventoryGetServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		//out.print("BIPS guys not are really amazing...");
		
		getServletContext().getRequestDispatcher("/login/Home.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}