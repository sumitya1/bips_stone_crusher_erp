package com.bips.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bips.sales.beans.SalesBean;

public class SalesDaoImpl implements SalesDao{
	private Connection dbConnection = null;
	private  Statement statement = null;

	public String submitItems(SalesBean salesitems) {
		try
		{
			dbConnection = DataConnection.connectionInstance().createConnection();
			PreparedStatement statement=dbConnection.prepareStatement("insert into sales values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1,salesitems.getStone_type());
			statement.setString(2,salesitems.getSystemdate());
			statement.setString(3,salesitems.getRate());
			statement.setString(4,salesitems.getQuantity());
			statement.setString(5,salesitems.getNo_of_trucks());
			statement.setString(6,salesitems.getCompany_name());
			statement.setString(7,salesitems.getTotal());
			statement.setString(8,salesitems.getPayment_received());
			statement.setString(9,salesitems.getBalance());
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
		return "Record is inserted into Sales table on:" + salesitems.getSystemdate();

	}





}
