package com.group1.project1.anyDont;
//Created by James Rodgers
import java.util.Scanner;

public class Main {

	public static String username="", user_decision="";
	private static String email = "", password="", domain = "";
	private static String accountType = "";
	public static String[] usersTask;
	public static boolean finished = false;
	static HomePage homePageVariable = new HomePage();
	static User user = new User();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("      Welcome to Any Don't \n-----------------------------------\nEnter username or enter \"signup\"");
		username = scanner.nextLine().trim();
		username = username.trim();
		while(finished == false)
		{
			if(username.trim().equals("signup"))
			{
				createNewUser();
				finished = true;
			}
			else
			{
				returningUser();
				if(username.equals("signup"))
				{
					finished = false;
				}
				else
				{
					finished = true;
				}
			}
		}
		GreetingsMessage();
		
		scanner.close();
	}
	
	public static void GreetingsMessage(){
		
		if(accountType == "Corporate")
		{
			String choice = "";
			Corporate corp = new Corporate(username, domain);
			corp.CorporateGreetings();
			choice = corp.Options();
			if(choice == "account")
			{
				corp.DisplayCorporateInformation();
				
			}
			
		}
//		else if(accountType == "Student")
//		{
//			String choice = "";
//			Student student = new Student(username, domain);
//			student.StudentGreetings();
//		}
		homePage();
	}
	
	static void returningUser()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("password: ");
		password = scanner.nextLine();
		password = password.trim();
		user.setUsername(username);
		user.setPassword(password);
		user.loadFile();
		while(!user.credentialsConfirmed() && !username.equals("signup"))
		{
			System.out.println("username and/or password do not match records on file.\ntry again or type signup\nusername: ");
			username = scanner.nextLine().trim();
			if(!username.equals("signup"))
			{
				System.out.println("password: ");
				password =scanner.nextLine().trim();
				user.setUsername(username);
				user.setPassword(password);
			}
		}
		if(!username.equals("signup"))
		{
			String usersProfile = username + ".txt";
			usersTask = user.getUsersDate(usersProfile);
			accountType = user.checkAccountType();
			domain = user.userDomain();
		}
	}	
	
	static void createNewUser()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter desired username: ");
		username = scanner.nextLine().trim();
		user.setUsername(username);
		while(!user.uniqueUsernames())
		{
			System.out.println("Username is arleady taken, select a new username\nEnter desired username: ");
			username = scanner.nextLine().trim();
			user.setUsername(username);
		}
		System.out.println("Enter desired password: ");
		password = scanner.nextLine().trim();
		user.setPassword(password);
		System.out.println("Enter Email: ");
		email = scanner.nextLine().trim();
		user.setEmail(email);
		
		user.createUserFile();
		user.amendCredentials();
		accountType = user.checkAccountType();
		String usersProfile = username + ".txt";
		usersTask = user.getUsersDate(usersProfile);
	}

	static void homePage(){
		Scanner scanner = new Scanner(System.in);
		homePageVariable.homePageFunction(username, usersTask, accountType);
		System.out.println("If you want to add a new task enter A, if you want to logout press X.");
		user_decision = scanner.nextLine().trim();
		scanner.close();
		homePageVariable.setUser_Decision(user_decision);
		homePageVariable.userDecision(user_decision);
	}
}

