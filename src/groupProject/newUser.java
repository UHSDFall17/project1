package com.group1.project1.anyDont;
//Created by James Rodgers
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewUser {

	String username = "", password="";
	public static String[] usersTask;
	public void amendCredentials()
	{
		String newInfo = this.username + " " + this.password; 
		FileWriter fw = null;
		
		try {
			File file = new File("user_password.txt");
			//if file exist then it will write a new line then the info
			//if it doesn't exist then it will create file and now write a new line
            if(file.exists()){
            	fw = new FileWriter(file, true);
            	 fw.append(System.getProperty("line.separator"));
			}
            else
            {
            	fw = new FileWriter(file, true);
            }
            fw.append(newInfo);
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}
	
	public boolean createUserFile()
	{
		boolean result = false;
		String newFile = this.username + ".txt"; 
		FileWriter fw = null;
		
		try {
			File file = new File(newFile);
			fw = new FileWriter(file, true);
            fw.close();
            result = true;
            
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
		return result;
	}
	
	
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
	

	public Boolean uniqueUsernames()
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
		
		Scanner checkForUsername =null;
		try 
		{
			checkForUsername = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		
		while(checkForUsername.hasNext())
		{
			if(this.username.equals(checkForUsername.next()))
			{
				//closes file
				checkForUsername.close();
				return false;
			}
		}
		//closes file
		checkForUsername.close();
		return true;
	}
}
