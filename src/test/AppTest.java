package com.group1.project1.anyDont;

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
		newUser newUserVariable = new newUser();
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
		newUser newUserVariable = new newUser();

		newUserVariable.setUsername(String.valueOf(random));
		newUserVariable.setPassword(String.valueOf(random));
		boolean expectation = true;
		boolean result = newUserVariable.uniqueUsernames();
		assertEquals(expectation, result);
		
	}
	
	@Test
	public void test_new_User_does_not_have_unique_username()
	{
		newUser newUserVariable = new newUser();
		newUserVariable.setUsername("testing");
		newUserVariable.setPassword("testing");
		boolean expectation = false;
		boolean result = newUserVariable.uniqueUsernames();
		if(result)
		{
			newUserVariable.createUserFile();
			newUserVariable.amendCredentials();
		}
		assertEquals(expectation, result);
		
	}
	
}
