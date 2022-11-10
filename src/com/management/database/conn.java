package com.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {
		static final String URL="jdbc:mysql://localhost:3306/";
		 static final String USER="root";
		 static final String PASSWORD="root";
		 static final String DB_NAME="school_management";
		
			
		public static Connection connect(){
				Connection conn=null;
			try{
				conn=DriverManager.getConnection(URL+DB_NAME,USER,PASSWORD);
				
			}catch(SQLException e) 
			{
				System.out.println("Error on connection");
			}
			return conn;
	}

}
