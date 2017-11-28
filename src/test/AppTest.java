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
	public void test_User_Get_Email()
	{
		User test = new User();
		test.setUsername("testingGet@gmail.com");		
		String expectation = "testingGet@gmail.com";
		String result = test.getUsername();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_User_Set_Email()
	{
		User test = new User();
		test.setUsername("testingSet@gmail.com");		
		String expectation = "testingSet@gmail.com";
		String result = test.getUsername();
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
	public void test_User_Get_Username()
	{
		User test = new User();
		test.setUsername("TestGetUsername");		
		String expectation = "TestGetUsername";
		String result = test.getUsername();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_User_Set_Username()
	{
		User test = new User();
		test.setUsername("TestSetUsername");		
		String expectation = "TestSetUsername";
		String result = test.getUsername();
		assertEquals(expectation, result);
	}

	@Test
	public void test_User_Set_Password()
	{
		User test = new User();
		test.setUsername("TestSetPassword");		
		String expectation = "TestSetPassword";
		String result = test.getUsername();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_User_Get_Password()
	{
		User test = new User();
		test.setUsername("TestGetPassword");		
		String expectation = "TestGetPassword";
		String result = test.getUsername();
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
	
	@Test
	public void test_Student_Set_School_Name()
	{
		Student test = new Student();
		test.setSchoolName("uh.edu");		
		String expectation = "UH";
		String result = test.getSchoolName();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Student_Get_School_Name()
	{
		Student test = new Student();
		test.setSchoolName("ut.edu");		
		String expectation = "UT";
		String result = test.getSchoolName();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Corporate_Set_School_Name()
	{
		Corporate test = new Corporate();
		test.setCorpName("stop.com");		
		String expectation = "Stop";
		String result = test.getCorpName();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_Corporate_Get_School_Name()
	{
		Corporate test = new Corporate();
		test.setCorpName("intel.com");		
		String expectation = "Intel";
		String result = test.getCorpName();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Get_Month()
	{
		Task test = new Task();
		test.setMonth(3);		
		int expectation = 3;
		int result = test.getMonth();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Set_Month()
	{
		Task test = new Task();
		test.setMonth(3);		
		int expectation = 3;
		int result = test.getMonth();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Set_Year()
	{
		Task test = new Task();
		test.setYear(2018);		
		int expectation = 2018;
		int result = test.getYear();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Get_Year()
	{
		Task test = new Task();
		test.setYear(2018);		
		int expectation = 2018;
		int result = test.getYear();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Get_Hour()
	{
		Task test = new Task();
		test.setHour(4);		
		int expectation = 4;
		int result = test.getHour();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Set_Hour()
	{
		Task test = new Task();
		test.setHour(4);		
		int expectation = 4;
		int result = test.getHour();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Set_Minute()
	{
		Task test = new Task();
		test.setMinute(40);		
		int expectation = 40;
		int result = test.getMinute();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Get_Minute()
	{
		Task test = new Task();
		test.setMinute(40);		
		int expectation = 40;
		int result = test.getMinute();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Get_Date()
	{
		Task test = new Task();
		test.setDate(2018, 1, 4, 5, 30);		
		String expectation = "1/4/2018 5:30AM";
		String result = test.date();
		assertEquals(expectation, result);
	}
	
	@Test
	public void test_List_Set_Date()
	{
		Task test = new Task();
		test.setDate(2018, 1, 4, 17, 30);		
		String expectation = "1/4/2018 5:30PM";
		String result = test.date();
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