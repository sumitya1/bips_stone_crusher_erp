package com.bips.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.inventory.beans.PersonBeanModel;

/**
 * Servlet implementation class InventoryTestServlet
 */

//http://localhost:8080/bips_stone_crusher_project/com/bips/inventory/controller
//http://localhost:8080/bips_stone_crusher_project/com/bips/inventory/controller/personservlet
//@WebServlet("/controller/personservlet")
@WebServlet(description="personservlet",urlPatterns="/com/bips/inventory/controller")
public class InventoryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InventoryTestServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.print("BIPS guys are really amazing...");
		PersonBeanModel person = new PersonBeanModel();
		person.setName(request.getParameter("name"));
		person.setName(request.getParameter("email"));
		person.doSomething();
		request.setAttribute("person", person);
		//getServletContext().getRequestDispatcher("/login/Home.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
