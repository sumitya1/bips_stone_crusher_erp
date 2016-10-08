package com.bips.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bips.inventory.dao.DataConnection;
import com.bips.report.beans.DateSelectorBean;
import com.bips.report.beans.ReportBean;


public class ReportDaoImpl implements ReportDao{

	private Connection dbConnection = null;
	private List<DateSelectorBean> dptlist= null;
	private Statement stmt = null;
	private String query = null;
	private List<ReportBean> slslist= null;

	public List<DateSelectorBean> findDeptData(String dp_report_type,String fromdate,String todate) throws ClassNotFoundException{


		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			stmt=dbConnection.createStatement();
			if(dp_report_type.equals("inventory")){
				query="select * from "+dp_report_type+" where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

				System.out.println("Query is:="+query);

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

			}
			
			if(dp_report_type.equals("sales")){
				query="select * from "+dp_report_type+" where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

				System.out.println("Query is:="+query);

				ResultSet rs=stmt.executeQuery(query);
				DateSelectorBean datebean = null;
				dptlist = new ArrayList<DateSelectorBean>();
				while(rs.next()){
					datebean = new DateSelectorBean();

					datebean.setStone_type(rs.getNString(1));
					datebean.setSystemdate(rs.getNString(2));
					datebean.setRate(rs.getNString(3));
					datebean.setQuantity(rs.getNString(4));
					datebean.setNo_of_trucks(rs.getNString(5));
					datebean.setCompany_name(rs.getNString(6));
					datebean.setAmount(rs.getNString(7));
					datebean.setPayment(rs.getNString(8));
					datebean.setBalance(rs.getNString(9));
					dptlist.add(datebean);
				}

			}
			
			if(dp_report_type.equals("minning")){
				query="select * from "+dp_report_type+" where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

				System.out.println("Query is:="+query);

				ResultSet rs=stmt.executeQuery(query);
				DateSelectorBean datebean = null;
				dptlist = new ArrayList<DateSelectorBean>();
				while(rs.next()){
					datebean = new DateSelectorBean();

					datebean.setNo_of_holes(rs.getNString(1));
					datebean.setFeet(rs.getNString(2));
					datebean.setRate(rs.getNString(3));
					datebean.setSystemdate(rs.getNString(4));
					datebean.setTotal_feet(rs.getNString(5));
					datebean.setTotalrs(rs.getNString(6));
					
					dptlist.add(datebean);
				}

			}


			if(dp_report_type.equals("employee")){
				query="select * from DailyExpenses where SYSTEMDATE in("+"'"+fromdate+"'"+","+"'"+todate+"'"+")";

				System.out.println("Query is:="+query);

				ResultSet rs=stmt.executeQuery(query);
				DateSelectorBean datebean = null;
				dptlist = new ArrayList<DateSelectorBean>();
				while(rs.next()){
					datebean = new DateSelectorBean();

					datebean.setEmployee_name(rs.getNString(1));
					datebean.setRupees(rs.getNString(2));
					datebean.setSystemdate(rs.getNString(3));
					datebean.setDescription(rs.getNString(4));
					
					dptlist.add(datebean);
				}

			}


		} catch (SQLException e) {

			e.printStackTrace();
		}


		return dptlist;
	}

	@Override
	public List<ReportBean> findTrendData(String tr_report_type, String tr_fromdate, String tr_todate) throws ClassNotFoundException {

		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			stmt=dbConnection.createStatement();

			if(tr_report_type.equals("tr_sales")){
				query="select sum(TOTAL),SYSTEMDATE from sales group by SYSTEMDATE";

				ResultSet rs=stmt.executeQuery(query);
				ReportBean slsbean = null;
				slslist = new ArrayList<ReportBean>();
				while(rs.next()){
					slsbean = new ReportBean();
					slsbean.setTotal(rs.getNString(1));
					slsbean.setDate(rs.getNString(2));

					slslist.add(slsbean);
				}

			}

			if(tr_report_type.equals("tr_expense")){
				//query="select item,fuel from inventory where SYSTEMDATE in("+"'"+tr_fromdate+"'"+","+"'"+tr_todate+"'"+")"+" order by SYSTEMDATE desc";
				query="select employee_name,rs,description from DailyExpenses where "
						+ "SYSTEMDATE in("+"'"+tr_fromdate+"'"+","+"'"+tr_todate+"'"+")"+" order by rs desc";

				ResultSet rs=stmt.executeQuery(query);
				ReportBean slsbean = null;
				slslist = new ArrayList<ReportBean>();
				while(rs.next()){
					slsbean = new ReportBean();
					slsbean.setEmployee_name(rs.getNString(1));
					slsbean.setRupees(rs.getNString(2));
					slsbean.setDescription(rs.getNString(3));

					slslist.add(slsbean);
				}

			}

			if(tr_report_type.equals("tr_fuel")){
				query="select item,fuel from inventory where SYSTEMDATE in("+"'"+tr_fromdate+"'"+","+"'"+tr_todate+"'"+")"+" order by SYSTEMDATE desc";

				ResultSet rs=stmt.executeQuery(query);
				ReportBean slsbean = null;
				slslist = new ArrayList<ReportBean>();
				while(rs.next()){
					slsbean = new ReportBean();
					slsbean.setItem_name(rs.getNString(1));
					slsbean.setFuel(rs.getNString(2));

					slslist.add(slsbean);
				}
			}


		}catch (SQLException e) {

			e.printStackTrace();
		} 
		return slslist;

	}



}


