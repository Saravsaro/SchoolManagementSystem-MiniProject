package com.management.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminActions {
	static Connection con=conn.connect();
	public static ResultSet studentProfile(String studentID) throws SQLException { 
		
		PreparedStatement pd=con.prepareStatement("select * from studentTable where studentId=?;");
		try {
			pd.setString(1, studentID);
			ResultSet result=pd.executeQuery();
			result.next();return result;
		} catch (SQLException e) {
			System.out.println("Error in student Connection! ");
		}
		return null;}
	public static void accountant(String accoutantID) {
		try {
 			PreparedStatement pd=con.prepareStatement("select * from accountant where login=?;");
 			pd.setString(1, accoutantID);
 			ResultSet result=pd.executeQuery();
 			while(result.next()) {
 				System.out.println("------------------------------------");
 				System.out.println("Accountant Name:\t" +result.getString(1));
 				System.out.println("Accountant ID:\t\t"   +result.getString(2));
 				System.out.println("LogIn:\t\t\t"         +result.getString(3));
 				
 			}
 			
 			}catch(Exception e) {System.out.println("");}}
	

}
