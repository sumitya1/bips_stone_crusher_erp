package com.bips.inventory.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bips.inventory.beans.InventoryBeanModel;

public class InventoryDaoImpl implements InventoryDao{
	InventoryBeanModel inventory = new InventoryBeanModel();
	
	@Override
	public void setItems(InventoryBeanModel inventoryitems) {
		Connection dbConnection = null;
		Statement statement = null;
		DataConnection dconn = null;

		String sql = "insert into inventory values("+inventory.getItem()+","+inventory.getRate()
		+ "," +inventory.getQuantity()+")";

		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is inserted into Inventory table for InventoryItems: " + inventory.getSystemdate());

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
	public List<InventoryBeanModel> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}


}
