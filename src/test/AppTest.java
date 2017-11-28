package groupProject;
//Created James Rodgers
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
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
		newUserVariable.setEmail("testint@text.junit");
		boolean result = newUserVariable.uniqueUsernames();
		if(result)
		{
			newUserVariable.createUserFile();
			newUserVariable.amendCredentials();
		}
	}
	
	//add test for new prop function and student functions
	
	
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
	public void test_new_User_Credential_appended()
	{
		User newUserVariable = new User();
		String username = RandomStringUtils.randomAlphanumeric(10);
		newUserVariable.setUsername("T" + username);
		while(!newUserVariable.uniqueUsernames())
		{
			username = RandomStringUtils.randomAlphanumeric(10);
			newUserVariable.setUsername("T" + username);
		}

		newUserVariable.setPassword("T" + username);
		newUserVariable.setEmail("T" + username + "@test.junit");
		//appendCredentials
		newUserVariable.amendCredentials();
		newUserVariable.loadFile();
		boolean expectation = true;
		//checks that they were appended
		boolean result = newUserVariable.credentialsConfirmed();
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
	
	@Test
	public void test_Returning_User_Signin()
	{
		User returningUserVariable = new User();
		returningUserVariable.setUsername("testing");
		returningUserVariable.setPassword("testing");
		returningUserVariable.setEmail("testint@text.junit");
		returningUserVariable.loadFile();
		boolean expectation = true;
		boolean result = returningUserVariable.credentialsConfirmed();
		assertEquals(expectation, result);
	}

	
	@Test
	public void test_User_Domain_Function()
	{
		User test = new User();
		test.setEmail("jrodgers@aol.com");
		
		String expectation = "aol.com";
		String result = test.userDomain();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Check_Corporate_Account()
	{
		User returningUserVariable = new User();
		returningUserVariable.setEmail("jrodger@intel.com");
		
		String expectation = "Corporate";
		String result = returningUserVariable.checkAccountType();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Check_Student_Account()
	{
		User returningUserVariable = new User();
		returningUserVariable.setEmail("jrodgers@uh.edu");
		
		String expectation = "Student";
		String result = returningUserVariable.checkAccountType();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Check_Regular_Account()
	{
		User returningUserVariable = new User();
		returningUserVariable.setEmail("jrodgers@aol.com");
		
		String expectation = "Regular";
		String result = returningUserVariable.checkAccountType();
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

	
}
