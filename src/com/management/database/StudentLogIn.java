package com.management.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentLogIn {
	static Connection con=conn.connect();
	public static boolean logIn(String studentId,String Pass)  {
		try {
		PreparedStatement pd=con.prepareStatement("select * from studentTable where studentId=? and pass_word=?;");
		pd.setString(1, studentId);
		pd.setString(2, Pass);
		ResultSet result=pd.executeQuery();
		result.next();
		if(result.getString(1)!=null && result.getString(2)!=null) {  return true; } 
		else{   return false;  }}
		catch(Exception e) { System.out.println("Invalid student ID or password!!");  return false;}}		
	public static boolean marksheet(String studentId) throws SQLException  {
		Connection con=conn.connect();
		
		PreparedStatement pd=con.prepareStatement("select * from marksheet where studentId=?");
		pd.setString(1, studentId);
		ResultSet result=pd.executeQuery();
		result.next();
		if(result.getString(1)!=null && result.getString(2)!=null) 
		{  return true; } 
		else   
		{   return false;  }
		}
	public static void profile(String studentId,String Pass) { 		
		try {
			PreparedStatement pd=con.prepareStatement("select * from studentTable where studentID=? and pass_word=?;");
			pd.setString(1, studentId);
			pd.setString(2, Pass);
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
				System.out.println("Fees Paid:\t"  +result.getInt(10));
				System.out.println("Fees Total:\t"  +result.getInt(11));
				System.out.println("Fees pending:\t"  +result.getInt(12));
			}else  {System.out.println( "Error in returning student details!");}}
			catch(Exception e) {
				System.out.println("Incorrect Student ID or Password!!");}}
	public static void marksheeta(String studentID) {
		PreparedStatement pd;
		try {
			pd = con.prepareStatement("select * from marksheet where studentId=?");
			pd.setString(1, studentID);
			ResultSet result=pd.executeQuery();
			System.out.println("----------------------------------------------------------");
			System.out.println("SubjectCode"+"\tSubjectName"+"\tScoredMark:  "+"\tTotalMark");
			System.out.println("----------------------------------------------------------");
			while(result.next()) {
				System.out.println(result.getString(1)+"\t\t"+result.getString(2)+"\t\t"+result.getLong(4)+"\t\t"+result.getLong(5));}
			System.out.println("----------------------------------------------------------");
		} catch (SQLException e) { System.out.println("Error in Marksheet"); }
		
		
	}
	public static boolean logIn2(String studentId)  {
		try {
		PreparedStatement pd=con.prepareStatement("select * from studentTable where studentId=?;");
		pd.setString(1, studentId);
		ResultSet result=pd.executeQuery();
		result.next();
		if(result.getString(1)!=null && result.getString(2)!=null) {  return true; } 
		else{   return false;  }}
		catch(Exception e) { System.out.println("Invalid student ID or password!!");  return false;}}
	public static void NewAdd() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("\tFill student form: "); System.out.println();
		System.out.print("Student Name: "); 	String Name=sc.nextLine();	System.out.println();
		System.out.print("BOD: ");				String BOD=sc.nextLine();	System.out.println();
		System.out.print("Gender: ");			String Gender=sc.nextLine();System.out.println();
		System.out.print("Father Name: ");		String Father=sc.nextLine();System.out.println();
		System.out.print("Student Class: ");	String Class=sc.nextLine();	System.out.println();
		System.out.print("Student ID: ");		String ID=sc.nextLine();	System.out.println();
		System.out.print("New password: ");		String pass=sc.nextLine();	System.out.println();
		System.out.print("Adress: ");			String Adress=sc.nextLine();System.out.println();
		System.out.print("School Bus: ");		String Bus=sc.nextLine();	System.out.println();
		System.out.print("Age: ");				int Age=sc.nextInt();	 	System.out.println();
		System.out.print("Feespaying: ");		int Feespaying=sc.nextInt();System.out.println();
		System.out.print("Fees Total: ");		int Total=sc.nextInt();		System.out.println();
		System.out.print("Mobile Number: ");	int Number=sc.nextInt();	System.out.println();
		System.out.print("Roll No: ");			Long roll=sc.nextLong();	System.out.println();
		int Pending=Total-Feespaying;
		
		PreparedStatement pd=con.prepareStatement("insert into studentTable values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		pd.setString(1, Name); pd.setString(3, BOD); pd.setString(4, Gender); pd.setString(13, Father); pd.setString(9, Class); 
		pd.setString(2, ID); pd.setString(6, pass); pd.setString(14, Adress); pd.setString(15, Bus); pd.setInt(5, Age);
		pd.setInt(10, Feespaying);pd.setInt(11, Total);pd.setInt(12, Pending);pd.setInt(7, Number); pd.setLong(8, roll);
		int result=pd.executeUpdate();
		if(result>0) {System.out.println("------------------------------------");
						System.out.println("New addmission addedd successfully!!");}
		else {System.out.println("New Addmission Details Error!!");}
		
		
		sc.close();
	}
}
	


