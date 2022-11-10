package com.management.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.management.database.AccountantLogIn;
import com.management.database.AdminActions;
import com.management.database.AdminLogIn;
import com.management.database.FacultLogIn;
import com.management.database.StudentLogIn;

public class ManagementProcess {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("====================================");
		System.out.println("============== LOG IN ==============");
		
		System.out.println("\t 1 -> Admin");
		System.out.println("\t 2 -> Accountant");
		System.out.println("\t 3 -> Faculty");
		System.out.println("\t 4 -> Student");
		System.out.println("====================================");
		System.out.print("Choose Your Log In: ");
		int choice=Integer.parseInt(bufferedReader.readLine());  System.out.println();
		switch(choice) {
		
		//----------------------------------------------------------------------------------------------------------------------------
		case 1:{
			System.out.println("======== Welcome Sir/Madam! ========");  System.out.println();
			System.out.print("Enter your Admin ID: ");
			String adminID=bufferedReader.readLine();
			System.out.print("Enter your Admin Password: ");
			String password=bufferedReader.readLine();System.out.println();
			boolean admin=AdminLogIn.logIn(adminID, password);
			if(admin==true) {do{
				System.out.println("------------------------------------");
				System.out.println("\t 1-> To view Accountant details");
				System.out.println("\t 2-> To view Student details");
				System.out.println("\t 3-> To view Faculty details");
				System.out.println("\t 4-> Log Out");
				System.out.println("------------------------------------");
				System.out.print("Select your option: ");
				int admin1=Integer.parseInt(bufferedReader.readLine());  System.out.println();
				switch(admin1) {
				case 1:System.out.print("Enter Accountant ID: ");
						String AcccountantID=bufferedReader.readLine(); System.out.println();
						boolean acc=AccountantLogIn.accLogIn(AcccountantID);
						if(acc) {
							AdminActions.accountant(AcccountantID);
							System.out.println("------------------------------------");  System.out.println();
							System.out.println("\t 1-> Go Back");
							System.out.println("\t 2-> Log Out");
							System.out.print("Select your option: ");
							int op=Integer.parseInt(bufferedReader.readLine());  System.out.println();
							if(op==1) { break; }
							else if(op==2) { admin =false;System.out.println("\t< Logged out Successfully! >"); break;}
							else { System.out.println(); System.out.println("Please select a valid option!!"); break;}
							}
						else { System.out.println("\tIncorrect Accountant ID!!");System.out.println();break;}
				
				
				case 2:
						boolean temp=true;
						do {System.out.println("------------------------------------");
						System.out.println("\t 1-> New Admission");
						System.out.println("\t 2-> View student details");
						System.out.println("\t 3-> Go Back");
						System.out.println("\t 4-> Log Out");
						System.out.println("------------------------------------");
						System.out.print("Select your option: ");
						int admin2=Integer.parseInt(bufferedReader.readLine());  System.out.println();
						switch(admin2) {
						case 1:StudentLogIn.NewAdd();admin=false;temp=false;break;
						case 2:System.out.print("Enter Student ID: ");
								String studentID=bufferedReader.readLine();System.out.println();
								AdminLogIn.action(studentID);
								System.out.println("------------------------------------");
								System.out.println("\t 1-> Go back");
								System.out.println("\t 2-> Log Out");
								System.out.print("Select your option: ");
								int op=Integer.parseInt(bufferedReader.readLine());  System.out.println();
								if(op==1) {  break; }
								else if(op==2) { admin = false; temp =false; System.out.println("\t< Logged out Successfully! >"); break;}
								else { System.out.println(); System.out.println("Please select a valid option!!"); break;}
								//System.out.println("\t< Logged out Successfully! >");
						case 3:temp=false;break;
						case 4:admin=false;temp=false;System.out.println("\t< Logged out Successfully! >");break;
						default: System.out.println("\tPlease select a valid Option!");;System.out.println();
						}}while(temp==true);
				break;
						
				case 3:System.out.println("------------------------------------");
						System.out.print("Enter your Faculty ID: ");
						String LogIn=bufferedReader.readLine();System.out.println();
						boolean faclog=FacultLogIn.FaclogIn(LogIn);
						if(faclog) { FacultLogIn.profile(LogIn);
						
						do {
							System.out.println("------------------------------------");
							System.out.println("\t 1-> Go back");
							System.out.println("\t 2-> Log Out");
							System.out.print("Select your option: ");
							int op=Integer.parseInt(bufferedReader.readLine());  System.out.println();
							if(op==1) {  break; }
							else if(op==2) { admin=false;faclog =false;System.out.println("\t< Logged out Successfully! >"); break;}
							else { System.out.println(); System.out.println("\tPlease select a valid option!!"); break;}}
						while(faclog);}
						
						else {System.out.println("\tInvalid Faculty ID!!");
						System.out.println(); break;}
				break;
						
				case 4:admin=false;System.out.println("\t< Logged out Successfully! >");break;
				default:System.out.println("\tPlease select a valid Option!");System.out.println();
				}}while(admin);}
			
		break;}
		
		//----------------------------------------------------------------------------------------------------------------------------
		case 2:System.out.println("====================================");
				System.out.print("Enter your LogIn ID: ");String AcccountantID=bufferedReader.readLine();
				System.out.print("Enter your password: ");String Password=bufferedReader.readLine();  System.out.println();
				boolean con=AccountantLogIn.logIn(AcccountantID, Password);
				
				if(con) {
					System.out.println("====================================");
					System.out.println("\t< Logged in Successfully >");  System.out.println();
					System.out.print("Enter StudentID: ");String StudentID=bufferedReader.readLine();  System.out.println();
					System.out.print("Enter class: ");String classs=bufferedReader.readLine();  System.out.println();
					boolean stdlogIn=AccountantLogIn.stdlogIn(StudentID, classs);
				if(stdlogIn) {
					System.out.println("==========================================================");  System.out.println();
					AccountantAction.action(AcccountantID, Password,StudentID,classs);  System.out.println();
					System.out.println("==========================================================");
					System.out.println("\t 1-> Update Fees");
					System.out.println("\t 2-> Log Out");
					System.out.print("Select your option: ");
					int op=Integer.parseInt(bufferedReader.readLine());  System.out.println();
					if       (op==1) {System.out.print("Please enter fees paying: ");
								int pay=Integer.parseInt(bufferedReader.readLine());  System.out.println();
								AccountantAction.payfees(StudentID, classs, pay);}
					else if  (op==2) {con=false;System.out.println("\t< Logged out Successfully! >");}
					else     {  System.out.println("Select a valid option!!"); }  }
				else {  System.out.println("Error!\n   Incorrect student ID  or class!!"); }  }
				else {  System.out.println("Please enter correct AccountantID or password!!"); }  System.out.println();
					
		break;
				
		//----------------------------------------------------------------------------------------------------------------------------		
		case 3:System.out.println("====================================");
				System.out.print("Enter your LogIn ID: ");
				String LogIn=bufferedReader.readLine();
				System.out.print("Enter Password: ");
				String Facpass=bufferedReader.readLine();  System.out.println();
				boolean fac=FacultLogIn.logIn(LogIn, Facpass);
				if(fac) {
					do {
						
					System.out.println("------------------------------------");
					System.out.println("\t 1-> To view profile");
					System.out.println("\t 2-> To view student marksheet");
					System.out.println("\t 3-> Log Out");
					System.out.println("------------------------------------");
					System.out.print("Select your option: ");
					int fp=Integer.parseInt(bufferedReader.readLine());  System.out.println();
					switch(fp) {
					case 1:
							FacultLogIn.profile(LogIn, Facpass);
							System.out.println("------------------------------------");
							System.out.println("\t 1-> Go Back");
							System.out.println("\t 2-> Log Out");
							System.out.print("Select your option: ");
							int op=Integer.parseInt(bufferedReader.readLine());  System.out.println();
							if(op==1) { break; }
							else if(op==2) { fac =false;System.out.println("\t< Logged out Successfully! >"); break;}
							else { System.out.println(); System.out.println("Please select a valid option!!"); break;}
					case 2:	 System.out.println("------------------------------------");
								System.out.print("Enter Student ID: ");
								String studentID=bufferedReader.readLine();   System.out.println();
								boolean std=StudentLogIn.logIn2(studentID);
								if(std) {
								StudentLogIn.marksheeta(studentID);System.out.println();
								System.out.println("------------------------------------");
								System.out.println("\t 1-> Go Back");
								System.out.println("\t 2-> Log Out");
								System.out.print("Select your option: ");
								int fs=Integer.parseInt(bufferedReader.readLine());  System.out.println();
								if(fs==1) { break; }
								else if(fs==2) { fac =false;System.out.println("\t< Logged out Successfully! >"); break;}
								else { System.out.println(); System.out.println("Please select a valid option!!"); break;}
								}
								
					case 3:  fac=false;System.out.println("\t< Logged out Successfully! >");  break;
					default:System.out.println("\tPlease select a valid option!!"); }  } 
					
					while(fac); }
				else {  System.out.println("\tInvalid LogIn ID or password!!");  }
				
				
		break;
		//----------------------------------------------------------------------------------------------------------------------------		
		case 4:System.out.println("====================================");
				System.out.print("Enter your Student ID: ");
				String studentID=bufferedReader.readLine();
				System.out.print("Enter Password: ");
				String password1=bufferedReader.readLine();  System.out.println();
				boolean std=StudentLogIn.logIn(studentID,password1);
				if(std) {
					System.out.println("====================================");
					StudentLogIn.profile(studentID, password1);  
					System.out.println("====================================");
					do {
						System.out.println("\t 1-> To View Marksheet");
						System.out.println("\t 2-> Log Out"); 
						System.out.println("------------------------------------");
						System.out.print("Select your option: ");
						int std1=Integer.parseInt(bufferedReader.readLine());  System.out.println();
						if       (std1==1) { StudentLogIn.marksheeta(studentID);   std=false; }
						else if  (std1==2) {std=false;System.out.println("\t< Logged out Successfully! >");}
						else			   {System.out.println("------------------------------------");
						System.out.println("\tPlease select a valid option!!");  System.out.println();}}
					while(std); }
				
				
		break;
		//----------------------------------------------------------------------------------------------------------------------------
		default :System.out.println("\tPlease select a valid option!");}}}

