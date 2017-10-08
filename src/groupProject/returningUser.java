package com.group1.project1.anyDont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class returningUser {
	String username = "", password="";
	public static String[] userName_passwords;
	public static String[] usersTask;
	
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean CredentialsConfirmed()
	{
		for(int i=0; i < userName_passwords.length-1; i++)
		{
			if(userName_passwords[i].equals(getUsername()) && userName_passwords[i+1].equals(getPassword()))
			{
				return true;
			}
		}
		return false;
	}
	

	public String[] getUsersDate(String usersProfile)
	{
		Scanner profileInformation =null;
		try 
		{
			profileInformation = new Scanner(new FileInputStream(usersProfile));
		}
		catch(IOException e)
		{
			System.out.println("Password file not found");
		}
		profileInformation.useDelimiter("~");
		int count=0;
		while(profileInformation.hasNext())
		{
			//test if the first letting in the line is M if so count++
			count++;
			String temp = profileInformation.next();
			System.out.println(temp);
		}
		
		usersTask = new String[count];
		profileInformation.close();
		try 
		{
			profileInformation = new Scanner(new FileInputStream(usersProfile));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		profileInformation.useDelimiter("~");
		int j=0;
		while(profileInformation.hasNext())
		{
			usersTask[j] = profileInformation.next();
			j++;
			
		}
		
		for(int i= 0; i < usersTask.length; i++)
		{
			System.out.println(usersTask[i]);
		}
		
		//closes file
		profileInformation.close();
		
		return usersTask;
	}
	
	public static void loadFile()
	{
		
		File file = new File("user_password.txt");
		if(!file.exists())
		{
			FileWriter fw = null;
			try {
				File file1 = new File("user_password.txt");
				fw = new FileWriter(file1, true);
	            fw.close();
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        }					
		}
		
		
		Scanner userLoginInformation =null;
		try 
		{
			userLoginInformation = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Password file not found");
		}
		int count=0;
		while(userLoginInformation.hasNext())
		{
			count++;
			userLoginInformation.next();
		}
		userName_passwords = new String[count];
		userLoginInformation.close();
		try 
		{
			userLoginInformation = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		int j=0;
		while(userLoginInformation.hasNext())
		{
			userName_passwords[j] = userLoginInformation.next();
			j++;
			
		}
		//closes file
		userLoginInformation.close();
		
	}

}
