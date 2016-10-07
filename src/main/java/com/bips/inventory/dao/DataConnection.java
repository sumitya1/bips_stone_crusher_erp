package com.bips.inventory.dao;

import java.sql.* ;
public class DataConnection
{
	Connection  connection = null;
	private static DataConnection dconn = null;
	private DataConnection()
	{}
	
	public static DataConnection connectionInstance() throws SQLException, ClassNotFoundException{
		if(dconn == null){
			dconn = new DataConnection();
		}
		return dconn;
	}

	public Connection createConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","lion");
			System.out.println("connection establised"+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}


}
