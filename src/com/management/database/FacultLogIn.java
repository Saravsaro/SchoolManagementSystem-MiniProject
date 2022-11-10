package com.management.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.exception.AccountNotFoundException;

public class FacultLogIn {
	static Connection con=conn.connect();
	public static boolean logIn(String LoginId,String Pass) throws SQLException {
		try {
		PreparedStatement pd=con.prepareStatement("select * from faculty where login=? and pass_word=?;");
		pd.setString(1, LoginId);
		pd.setString(2, Pass);
		ResultSet result=pd.executeQuery();
		result.next();
		if(result.getString(1)!=null && result.getString(2)!=null) {
			System.out.println("====================================");
			System.out.println("\t< Logged in Successfully >");System.out.println();
		    System.out.println("Welcome "+"< "+result.getString(1)+" >");
			return true; } 
		else {   return false; }  }
		catch(Exception e) {  return false; }  }	
	public static void profile(String LoginId,String Pass) throws SQLException {
		PreparedStatement pd1=con.prepareStatement("select * from faculty where login=? and pass_word=?;");
		pd1.setString(1, LoginId);
		pd1.setString(2, Pass);
		ResultSet result=pd1.executeQuery();
		while(result.next()) {
			System.out.println("====================================");
			System.out.println("Name:\t\t  "+    		 result.getString(1));
			System.out.println("BOD:\t\t  "+ 			 result.getString(3));
			System.out.println("Gender:\t\t  "+ 		 result.getString(4));
			System.out.println("Age:\t\t  "+ 			 result.getInt(6));
			System.out.println("Handling subject: "+ 	 result.getString(5));
			System.out.println("LogIn ID:\t  "+ 		 result.getString(2));
			System.out.println("Mobile NO:\t  "+ 		 result.getLong(8));
			System.out.println("Experience:\t  "+ 	     result.getInt(9));
			System.out.println("Salary:\t\t  "+ 		 result.getInt(10));
		}
	}
	public static boolean FaclogIn(String LoginId) {
		try {
			PreparedStatement pd=con.prepareStatement("select * from faculty where login=?;");
			pd.setString(1, LoginId);
			ResultSet result=pd.executeQuery();
			result.next();
			if(result.getString(1)!=null && result.getString(2)!=null) {return true; } 
			else {   return false; }  }
			catch(Exception e) {  return false; }  }
	public static void profile(String LoginId) throws SQLException  {
		PreparedStatement pd1=con.prepareStatement("select * from faculty where login=?;");
		pd1.setString(1, LoginId);
		ResultSet result=pd1.executeQuery();
		while(result.next()) {
			System.out.println("====================================");
			System.out.println("Name:\t\t  "+    		 result.getString(1));
			System.out.println("BOD:\t\t  "+ 			 result.getString(3));
			System.out.println("Gender:\t\t  "+ 		 result.getString(4));
			System.out.println("Age:\t\t  "+ 			 result.getInt(6));
			System.out.println("Handling subject: "+ 	 result.getString(5));
			System.out.println("LogIn ID:\t  "+ 		 result.getString(2));
			System.out.println("Mobile NO:\t  "+ 		 result.getLong(8));
			System.out.println("Experience:\t  "+ 	     result.getInt(9));
			System.out.println("Salary:\t\t  "+ 		 result.getInt(10));
		}
	}
	
}
