package com.group1.project1.anyDont;
//Created James Rodgers
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	Random rand = new Random();

	int random = 0;
	boolean setUpComplete = false;
	
	@Before
	public void setUp()
	{
		//sets up the file system for the second test
		User newUserVariable = new User();
		newUserVariable.setUsername("testing");
		newUserVariable.setPassword("testing");
		boolean result = newUserVariable.uniqueUsernames();
		if(result)
		{
			newUserVariable.createUserFile();
			newUserVariable.amendCredentials();
		}
	}
	
	@Test
	public void test_new_User_has_unique_username()
	{
		User newUserVariable = new User();

		newUserVariable.setUsername(String.valueOf(random));
		newUserVariable.setPassword(String.valueOf(random));
		boolean expectation = true;
		boolean result = newUserVariable.uniqueUsernames();
		assertEquals(expectation, result);
		
	}
	
	@Test
	public void test_new_User_does_not_have_unique_username()
	{
		User newUserVariable = new User();
		newUserVariable.setUsername("testing");
		newUserVariable.setPassword("testing");
		boolean expectation = false;
		boolean result = newUserVariable.uniqueUsernames();
		assertEquals(expectation, result);
	}
	
//	@Test
//	public void test_new_user_tasklist_created_after_signup()
//	{
//		boolean userFileCreated = false;
//		boolean expectation = true;
//		//sets up the file system for the second test
//		newUser newUserVariable = new newUser();
//		newUserVariable.setUsername("testing1");
//		newUserVariable.setPassword("testing1");
//		boolean result = newUserVariable.uniqueUsernames();
//		if(result)
//		{
//			newUserVariable.createUserFile();
//			newUserVariable.amendCredentials();
//			userFileCreated = newUserVariable.createUserFile();
//		}
//		assertEquals(expectation, userFileCreated);
//	}
	
	@Test
	public void test_Returning_User_Signin()
	{
		User returningUserVariable = new User();
		returningUserVariable.setUsername("testing");
		returningUserVariable.setPassword("testing");
		returningUserVariable.loadFile();
		boolean expectation = true;
		boolean result = returningUserVariable.credentialsConfirmed();
		assertEquals(expectation, result);
	}
	
//	@Test
//	public void test_Returning_User_File_Downloaded()
//	{
//		String[] usersTask = null;
//		returningUser returningUserVariable = new returningUser();
//		returningUserVariable.setUsername("testing");
//		returningUserVariable.setPassword("testing");
//		returningUser.loadFile();
//		boolean result = returningUserVariable.CredentialsConfirmed();
//		if(result)
//		{
//			usersTask = returningUserVariable.getUsersDate("testing.txt");
//		}
//		assertNotNull(usersTask);
//	}
//	

	
}
