package com.bips.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bips.inventory.dao.DataConnection;
import com.bips.report.beans.DateSelectorBean;


public class ReportDaoImpl implements ReportDao{

	private Connection dbConnection = null;
	private List<DateSelectorBean> list= null;

	public List<DateSelectorBean> findData(String report_type,String fromdate,String todate) throws ClassNotFoundException{


		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			Statement stmt=dbConnection.createStatement();
			String query="select * from "+report_type+" where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

			ResultSet rs=stmt.executeQuery(query);
			DateSelectorBean datebean = null;
			list = new ArrayList<DateSelectorBean>();
			while(rs.next()){
				datebean = new DateSelectorBean();
				
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
			
			for(DateSelectorBean record:list){
				System.out.println("in DaoIMpl"+record.getItem()+
						record.getRate()	
						);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return list;
	}



}


