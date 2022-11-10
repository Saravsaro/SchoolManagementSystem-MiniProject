package com.management.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.exception.AccountNotFoundException;

public class AdminLogIn {
	static Connection con=conn.connect();
	public static boolean logIn(String LoginId,String Pass) throws SQLException {
		
		try {
		PreparedStatement pd=con.prepareStatement("select * from adminTable where login=? and pass_word=?;");
		pd.setString(1, LoginId);
		pd.setString(2, Pass);
		ResultSet result=pd.executeQuery();
		result.next();
		if(result.getString(1)!=null && result.getString(2)!=null) 
		{  System.out.println("Welcome "+"< "+result.getString(1)+" >");return true;} 
		
		else  {   return false;  }}
		catch(Exception e) {
			System.out.println("Incorrect Admin ID or Password!!");
			return false;}
		
	}
	public static void action(String studentID) {
		try {
			PreparedStatement pd=con.prepareStatement("select * from studentTable where studentID=?");
			pd.setString(1, studentID);
			ResultSet result=pd.executeQuery();
			result.next();
			if(result.getString(1)!=null && result.getString(2)!=null) 
			{  System.out.println("studentName:\t"+result.getString(1)); 
				System.out.println("studentID:\t"+result.getString(2));  
				System.out.println("BOD:\t\t"		+result.getString(3)); 
				System.out.println("Gender:\t\t"	+result.getString(4)); 
				System.out.println("Age:\t\t"		+result.getString(5)); 
				System.out.println("mobNo:\t\t"	+result.getLong(7)); 
				System.out.println("RollNo:\t\t"	+result.getLong(8)); 
				System.out.println("Class:\t\t"		+result.getString(9)); 
				System.out.println("FatherName:\t"	+result.getString(13)); 
				System.out.println("Address:\t"	+result.getString(14)); 
				System.out.println("Bus:\t\t"	+result.getString(15));
			}else  {System.out.println( "Error in returning student details!");}}
			catch(Exception e) {
				System.out.println("Incorrect Student ID or Password!!");}}
	public static void newAdd(String studentName,String studentID,String BOD,String gender,int age,String pass_word,
			Long mobNo,Long RollNo,String classs,int feespaid,int feestotal,String fatherName,String address,String bus) {
		int feespending=feestotal-feespaid;
		try {
			PreparedStatement pd=con.prepareStatement("insert into studentTable "
					+ "(`studentName`,`studentID`,`BOD`,`gender`,`age`,`pass_word`,`mobNo`,`RollNo`,`class`,`feespaid`,`feestotal`,`fatherName`,`address`,`bus`,`feespending`) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pd.setString(1, studentName);pd.setString(2, studentID);pd.setString(3, BOD);pd.setString(4, gender);pd.setInt(5, age);
			pd.setString(6, pass_word);pd.setLong(7, mobNo);pd.setLong(8, RollNo);pd.setString(9, classs);pd.setInt(10, feespaid);
			pd.setInt(11, feestotal);pd.setString(12, fatherName);pd.setString(13, address);pd.setString(14, bus);pd.setInt(15, feespending);
			
			int result=pd.executeUpdate();
			if(result>1) {  System.out.println("New Addmission Added!");  }
			
			else         {System.out.println("Error in student update!"); }
		
	}catch(Exception e) {System.out.println("Error in insert student details!!!");}}}

	

