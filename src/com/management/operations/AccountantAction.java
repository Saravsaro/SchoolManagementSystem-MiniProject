package com.management.operations;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.database.AccountantLogIn;
import com.management.database.conn;

public class AccountantAction {
	static Connection con=conn.connect();
	public static void action(String AcccountantID, String Password,String studentID,String classs) throws SQLException, IOException {
		PreparedStatement pd;
		//boolean logIn=AccountantLogIn.logIn(AcccountantID, Password);
		boolean stdlogIn=AccountantLogIn.stdlogIn(studentID, classs);
		if(stdlogIn) {
		do {
		
		try {
			pd = con.prepareStatement("select * from studentTable where studentID=? and class=?  ");
			pd.setString(1, studentID);
			pd.setString(2, classs);
			ResultSet result=pd.executeQuery();
			System.out.println("StudentID"+"\tFees Paid"+"\tFees pending"+"\tFees Total");
			while(result.next()) { 
				System.out.println(result.getString(2)+"\t\t"+result.getInt(10)+"\t\t"+result.getLong(12)+"\t\t"+result.getLong(11));}
			stdlogIn=false;
		} catch (SQLException e) { System.out.println("Error in Fees details returning!!"); }
		
		}while(stdlogIn);}
	}
	public static void payfees(String studentID,String classs,int pay) throws SQLException {
		PreparedStatement pd;PreparedStatement pd1;
		int feespaid;
		int feespending =0;
			pd = con.prepareStatement("select * from studentTable where studentID=? and class=?  ");
			pd.setString(1, studentID);
			pd.setString(2, classs);
			ResultSet result=pd.executeQuery();
			result.next();
			feespaid=result.getInt(10)+pay;
			int feestotal=result.getInt(11);
			if(feespaid<feestotal) {  feespending=feestotal-feespaid;  }
			else{System.out.println("Please ensure fees paying must be less than total fees!!");}
			
		try {
			if(feespending>0) {
			pd1 = con.prepareStatement("update studentTable set feespaid=?, feespending=? where studentID=? and class=?;");
			pd1.setInt(1,feespaid);    pd1.setInt(2,feespending);   pd1.setString(3, studentID);    pd1.setString(4, classs);
			int result1=pd1.executeUpdate();
			if(result1>0) {
				pd = con.prepareStatement("select * from studentTable where studentID=? and class=?  ");
				pd.setString(1, studentID);
				pd.setString(2, classs);
				ResultSet result2=pd.executeQuery();
					System.out.println("\tUpdated successfully!!");
					System.out.println("==========================================================");
					System.out.println("StudentID"+"\tFees Paid"+"\tFees pending"+"\tFees Total");
			while(result2.next()) { 
				System.out.println(result2.getString(2)+"\t\t"+result2.getLong(10)+"\t\t"+result2.getLong(12)+"\t\t"+result2.getLong(11));
				System.out.println("==========================================================");}}
			else {System.out.println("Please ensure fees paying must be less than total fees!!");}
			}} 
		catch (SQLException e) {  System.out.println("Error in update fees!!");  }
		
		
		
		
	}

}
