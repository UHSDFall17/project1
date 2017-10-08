package com.group1.project1.anyDont;

import java.util.Scanner;


public class main {

	public static String username="", password="";
	public static String[] usersTask;
	public static boolean finished = false;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("      Welcome to Any Don't \n-----------------------------------\nEnter username or enter \"signup\"");
		username = scanner.nextLine().trim();
		username = username.trim();
		while(finished==false)
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
					finished= false;
				}
				else
				{
					finished=true;
				}
			}
		}
		
		System.out.println("Inside Main");
		
		for(int i= 0; i < usersTask.length; i++)
		{
			System.out.println(usersTask[i]);
		}
	
	
	}
	
	static void returningUser()
	{

		Scanner scanner = new Scanner(System.in);
		returningUser returningUserVariable = new returningUser();
		System.out.println("password: ");
		password = scanner.nextLine().trim();
		returningUserVariable.setUsername(username);
		returningUserVariable.setPassword(password);
		returningUserVariable.loadFile();
		while(!returningUserVariable.CredentialsConfirmed()&& !username.equals("signup"))
		{
			System.out.println("username and/or password do not match records on file.\ntry again or type signup\nusername: ");
			username = scanner.nextLine().trim();
			if(!username.equals("signup"))
			{
				System.out.println("password: ");
				password =scanner.nextLine().trim();
				returningUserVariable.setUsername(username);
				returningUserVariable.setPassword(password);
			}
		}
		if(!username.equals("signup"))
		{
			String usersProfile = username + ".txt";
			usersTask = returningUserVariable.getUsersDate(usersProfile);
		}
	}
	
	static void createNewUser()
	{
		Scanner scanner = new Scanner(System.in);
		newUser newUserVariable = new newUser();
		System.out.println("Enter desired username: ");
		username = scanner.nextLine().trim();
		newUserVariable.setUsername(username);
		System.out.println("Enter desired password: ");
		password = scanner.nextLine().trim();
		newUserVariable.setPassword(password);
		
		while(!newUserVariable.uniqueUsernames())
		{
			System.out.println("Username is arleady taken, please select a new username");
			System.out.println("Enter desired username: ");
			username = scanner.nextLine().trim();
			newUserVariable.setUsername(username);
		}
		
		newUserVariable.createUserFile();
		newUserVariable.amendCredentials();
		String usersProfile = username + ".txt";
		usersTask = newUserVariable.getUsersDate(usersProfile);
	}
}
