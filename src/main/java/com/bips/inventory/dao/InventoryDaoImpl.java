package com.bips.inventory.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.beans.InventorySetBean;

public class InventoryDaoImpl implements InventoryDao{
	Connection dbConnection = null;
	Statement statement = null;
	DataConnection dconn = null;
	String sql = null;
	@Override
	public void submitItems(InventoryGetBean inventoryitems) {

		sql = "insert into inventory values("+"'"+inventoryitems.getItem()+"'"+
				","+inventoryitems.getRate()
				+ "," +inventoryitems.getQuantity()+ "," +"'"+inventoryitems.getSystemdate()+"'"+
				"," +inventoryitems.getUsage()+ "," +inventoryitems.getFuel()+
				"," +inventoryitems.getAmount()+ "," +inventoryitems.getPayment()+
				"," +inventoryitems.getBalance()+")";

		System.out.println("query is here:"+sql);
		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is inserted into Inventory table for InventoryItems: " + inventoryitems.getSystemdate());

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

	}

	@Override
	public List<InventoryGetBean> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItems(InventorySetBean setitems) {

		sql = "insert into inventoryitems values("+"'"+setitems.getItem_name()+"'"+
				","+setitems.getItem_type()
				+ "," +setitems.getOwner_name()+ "," +"'"+setitems.getRent_type()+"'"+"'"+setitems.getRent_rate()+"'"+")";

		System.out.println("query is here:"+sql);
		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

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

	}



}
