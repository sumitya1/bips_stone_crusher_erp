package com.bips.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bips.inventory.beans.InventoryFetchBean;
import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.dao.InventoryDao;
import com.bips.inventory.dao.InventoryDaoImpl;



@WebServlet("/inventoryget/*")
public class InventoryGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InventoryGetServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.print("BIPS guys are really amazing...in doget");
		//out.print("item"+request.getParameter("item")+"\n");
		
		InventoryDaoImpl indaoimpl = new InventoryDaoImpl();
		List<InventoryFetchBean> records = indaoimpl.getAllItems();
		out.print("we are here!!!");
		for(InventoryFetchBean lst: records){
			String st1 = lst.getItem_name();
			String st2 = lst.getRent_rate();
			String st3 = lst.getRent_type();
			System.out.println("values fetched are:-"+st1+st2+st3);
		}
		
		out.print("we are here out!!!");
		request.setAttribute("records", records);
		
		request.getRequestDispatcher("/inventory/inventoryindex.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		out.print("BIPS guys are really amazing in doPost");
		//out.print("item"+request.getParameter("item")+"\n");
		
		InventoryGetBean inventory = new InventoryGetBean();
		inventory.setItem(request.getParameter("item"));
		inventory.setRate(request.getParameter("rate"));
		inventory.setQuantity(request.getParameter("quantity"));
		inventory.setSystemdate(request.getParameter("systemdate"));
		inventory.setUsage(request.getParameter("usage"));
		inventory.setFuel(request.getParameter("fuel"));
		inventory.setAmount(request.getParameter("amount"));
		inventory.setPayment(request.getParameter("payment"));
		inventory.setBalance(request.getParameter("balance"));
		InventoryDaoImpl submtitems = new InventoryDaoImpl();
		String msg = submtitems.submitItems(inventory);
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/inventory/success.jsp").forward(request,
				response);

	}

}
