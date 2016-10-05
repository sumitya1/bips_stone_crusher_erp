package com.bips.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bips.report.dao.*;

public class TestPDF {
	
	private static Connection dbConnection = null;
	private  static Statement statement = null;
	private static String sql;
	private static ResultSet rs;
	
	public static void main(String[] args) throws Exception {
	
		sql = "select ITEM_NAME, RENT_RATE, RENT_TYPE from inventoryitems";
		
		dbConnection = DataConnection.connectionInstance().createConnection();
		statement= dbConnection.createStatement();
		rs = statement.executeQuery(sql);
		while(rs.next()){
			System.out.println();
			
			while(rs.next()){
				System.out.println("value 1 is:-"+rs.getNString(1)+
						"value 2 is:-"+rs.getNString(2)+
						"value 3 is:-"+rs.getNString(3)
						);
			
		}

	}
	}
}
