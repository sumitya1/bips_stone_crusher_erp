package com.bips.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.bips.inventory.dao.DataConnection;
import com.bips.report.beans.DateSelectorBean;


public class ReportDaoImpl implements ReportDao{

	private Connection dbConnection = null;
	private List list= null;

	public List<DateSelectorBean> findData(String fromdate,String todate) throws ClassNotFoundException{
		
				
		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			Statement stmt=dbConnection.createStatement();
			String query="select * from inventory where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";
		
			ResultSet rs=stmt.executeQuery(query);
			DateSelectorBean datebean = new DateSelectorBean();
			
			while(rs.next()){
				
				System.out.println(rs.getNString(1)+"\t"+
						rs.getNString(2)+"\t"+
						rs.getNString(3)+"\t"+
						rs.getNString(4)+"\t"+
						rs.getNString(5)+"\t"+
						rs.getNString(6)+"\t"+
						rs.getNString(7)+"\t"+
						rs.getNString(8)+"\t"+
						rs.getNString(9)
						);
				
				datebean.setItem(rs.getNString(1));
				datebean.setRate(rs.getNString(2));
				datebean.setQuantity(rs.getNString(3));
				datebean.setSystemdate(rs.getNString(4));
				datebean.setUsage(rs.getNString(5));
				datebean.setFuel(rs.getNString(6));
				datebean.setAmount(rs.getNString(7));
				datebean.setPayment(rs.getNString(8));
				datebean.setBalance(rs.getNString(9));
				
				list.add(datebean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	
		// TODO Auto-generated method stub
		
	}

