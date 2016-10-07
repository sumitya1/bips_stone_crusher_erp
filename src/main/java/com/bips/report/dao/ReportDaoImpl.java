package com.bips.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bips.inventory.dao.DataConnection;
import com.bips.report.beans.DateSelectorBean;
import com.bips.report.beans.SalesByDateBean;


public class ReportDaoImpl implements ReportDao{

	private Connection dbConnection = null;
	private List<DateSelectorBean> dptlist= null;
	private Statement stmt = null;
	private String query = null;
	private List<SalesByDateBean> slslist= null;

	public List<DateSelectorBean> findData(String dp_report_type,String fromdate,String todate) throws ClassNotFoundException{


		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			stmt=dbConnection.createStatement();
			query="select * from "+dp_report_type+" where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

			ResultSet rs=stmt.executeQuery(query);
			DateSelectorBean datebean = null;
			dptlist = new ArrayList<DateSelectorBean>();
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


				dptlist.add(datebean);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return dptlist;
	}

	@Override
	public List<SalesByDateBean> SalesByDate(String tr_report_type, String tr_fromdate, String tr_todate) throws ClassNotFoundException {

		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			stmt=dbConnection.createStatement();

			if(tr_report_type.equals("tr_sales")){
				query="select sum(TOTAL) as total,SYSTEMDATE from sales group by SYSTEMDATE order by total desc";
			}
			
			if(tr_report_type.equals("tr_fuel")){
				query="select item,fuel from inventory where SYSTEMDATE in("+"'"+tr_fromdate+"'"+","+"'"+tr_todate+"'"+")"+" order by SYSTEMDATE desc";
			}


			ResultSet rs=stmt.executeQuery(query);
			SalesByDateBean slsbean = null;
			slslist = new ArrayList<SalesByDateBean>();
			while(rs.next()){
				slsbean = new SalesByDateBean();
				slsbean.setTotal(rs.getNString(1));
				slsbean.setDate(rs.getNString(2));

				slslist.add(slsbean);
			}


		}catch (SQLException e) {

			e.printStackTrace();
		} 



		return slslist;
	}



}


