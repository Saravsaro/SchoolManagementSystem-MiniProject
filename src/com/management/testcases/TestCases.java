package com.management.testcases;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.management.database.AccountantLogIn;
import com.management.database.AdminLogIn;
import com.management.database.FacultLogIn;
import com.management.database.StudentLogIn;

class TestCases {
	
	//   ->  AccountantLogIn method Check   --------------------------------------------------------------
	@Test
	public void AccountantLogIn() throws SQLException{
		boolean newBal=AccountantLogIn.logIn("Harish@123", "H@123"); assertEquals(true, newBal);  }
	
	@Test
	public void AccountantLogInStd() throws SQLException{
		boolean newBal=AccountantLogIn.stdlogIn("BT018", "XII");     assertEquals(true, newBal);  }
	
	@Test
	public void AccountantLogInStdFl() throws SQLException{
		boolean newBal=AccountantLogIn.stdlogIn("BT018", "XI");     assertEquals(false, newBal);  }
	
	@Test
	public void AccountantLogInStdF2() throws SQLException{
		boolean newBal=AccountantLogIn.accLogIn("Harish@123");     assertEquals(true, newBal);  }
	
	
	//   ->  FacultyLogIn Method Check    -----------------------------------------------------------------
	@Test
	public void FacultyLogIn() throws SQLException{
		boolean newBal=FacultLogIn.logIn("Malar@gamil.com","Ma@123");     assertEquals(true, newBal);  }
	
	@Test
	public void FacultyLogIn3() throws SQLException{
		assertEquals("true",String.valueOf(FacultLogIn.logIn("Malar@gamil.com","Ma@123")));  }
	
	@Test
	public void FacultyLogInFl() throws SQLException{
		boolean newBal=FacultLogIn.logIn("Maar@gamil.com","Ma@123");     assertEquals(false, newBal);  }
	
	@Test
	public void FacultyLogIn1() throws SQLException{
		boolean newBal=FacultLogIn.FaclogIn("Malar@gamil.com");     assertEquals(true, newBal);  }
	
	@Test
	public void FacultyLogIn1Fl() throws SQLException{
		boolean newBal=FacultLogIn.FaclogIn("Maar@gamil.com");     assertEquals(false, newBal);  }
	 

	//  ->  AdminLogIn  method check   ---------------------------------------------------------------------
	@Test
	public void AdminLogInCheck() throws SQLException{
		boolean newBal=AdminLogIn.logIn("Harish@123", "H@123");     assertEquals(false, newBal);  }
	
	@Test
	public void AdminLogInCheck1() throws SQLException{
		boolean newBal=AdminLogIn.logIn("sidarth31@gmail.com", "Sidarth@123");assertEquals(true, newBal);  }
	
	@Test
	public void AdminLogInCheck2() throws SQLException{
		boolean newBal=AdminLogIn.logIn("Priya31@gmail.com", "Priya@123");    assertEquals(true, newBal);  }
	
	
	//  ->  StudentLogIn  method check   ---------------------------------------------------------------------
	@Test
	public void StdLogInCheck() throws SQLException{
		boolean newBal=StudentLogIn.logIn("BT018","N@123");     assertEquals(true, newBal);  }
	
	@Test
	public void StdLogInCheck2() throws SQLException{
		boolean newBal=StudentLogIn.marksheet("BT018");assertEquals(true, newBal);  }
	
	@Test
	public void StdLogInCheck3() throws SQLException{
		boolean newBal=StudentLogIn.logIn2("BT018");    assertEquals(true, newBal);  }
	@Test
	public void StdLogInCheckFl() throws SQLException{
		boolean newBal=StudentLogIn.logIn("Harish@123", "H@123");     assertEquals(false, newBal);  }
	
}
