package com.bips.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bips.inventory.beans.InventoryFetchBean;
import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.beans.InventorySetBean;

public class InventoryDaoImpl implements InventoryDao{
	private Connection dbConnection = null;
	private  Statement statement = null;
	private  ResultSet rs = null;
	private  String sql = null;
	private  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private  Date date = new Date();
	private  InventoryFetchBean infb = null;
	private  String systemdate = dateFormat.format(date);
	private  List<InventoryFetchBean> al = null;


	public String submitItems(InventoryGetBean inventoryitems) {

		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			System.out.println("values are-"+inventoryitems.getItem()+"\t"+inventoryitems.getRate()+"\t"
					+inventoryitems.getQuantity()+"\t"
					+inventoryitems.getSystemdate()+"\t"
					+inventoryitems.getUsage()+"\t"
					+inventoryitems.getFuel()+"\t"
					+inventoryitems.getAmount()+"\t"
					+inventoryitems.getPayment()+"\t"
					+inventoryitems.getBalance()+"\t");
			
			
			PreparedStatement statement=dbConnection.prepareStatement("insert into inventory values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1,inventoryitems.getItem());
			statement.setString(2,inventoryitems.getRate());
			statement.setString(3,inventoryitems.getQuantity());
			statement.setString(4,inventoryitems.getSystemdate());
			statement.setString(5,inventoryitems.getUsage());
			statement.setString(6,inventoryitems.getFuel());
			statement.setString(7,inventoryitems.getAmount());
			statement.setString(8,inventoryitems.getPayment());
			statement.setString(9,inventoryitems.getBalance());
			statement.executeUpdate();  
			
		}
		catch( SQLException e )
		{

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}
		return "Record is inserted into Inventory table on:" + inventoryitems.getSystemdate();

	}

	public List<InventoryFetchBean> getAllItems() {

		sql = "select ITEM_NAME, RENT_RATE, RENT_TYPE from inventoryitems";

		try {
			dbConnection = DataConnection.connectionInstance().createConnection();
			statement= dbConnection.createStatement();
			rs = statement.executeQuery(sql);
			al = new ArrayList<InventoryFetchBean>();
			while(rs.next()){
				infb = new InventoryFetchBean();
				infb.setItem_name(rs.getNString(1));
				infb.setRent_rate(rs.getNString(2));
				infb.setRent_type(rs.getNString(3));
				al.add(infb);
			}


		} catch (Exception e) {

		}


		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}
		return al;		


	}

	public String addItems(InventorySetBean setitems) {


		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			PreparedStatement statement=dbConnection.prepareStatement("insert into inventoryitems values(?,?,?,?,?,?,?)");
			statement.setString(1,setitems.getItem_name());
			statement.setString(2,setitems.getItem_type());
			statement.setString(3,setitems.getOwner_name());
			statement.setString(4, setitems.getRent_type());
			statement.setString(5,setitems.getRent_rate());
			statement.setString(6,setitems.getEmi());
			statement.setString(7,systemdate);
			statement.executeUpdate();  
			
		}
		catch( SQLException e )
		{

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{

			if( statement != null )
			{
				try
				{
					statement.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

			if( dbConnection != null )
			{
				try
				{
					dbConnection.close();
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}

		}
		return "Records inserted into db";

	}



}
