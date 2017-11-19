package com.group1.project1.anyDont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Corporate {

	private String username = "", emailDomain = "";
	
	public Corporate(String username, String emailDomain){
		this.username=username;
		this.emailDomain = emailDomain;
	}
	
	public void CorporateGreetings()
	{
		System.out.println("Good Morning " + username + "                         " + emailDomain);
	}
	
	public String Options()
	{
		String option = "";
		System.out.println("Would you like to view " + emailDomain + " account information first or go straight to the home page?");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while((option != "account") || (option != "home"))
		{
			System.out.println("please type 'account' for the account information, or 'home' for the home page.");
			option = scanner.nextLine();
			option = option.trim();
		}		
		return option;
	}
	
	public void DisplayCorporateInformation()
	{
		File file = new File(emailDomain + "Corp.txt");
		if(!file.exists())
		{
			FileWriter fw = null;
			try {
				File file1 = new File(emailDomain + "Corp.txt");
				fw = new FileWriter(file1, true);
	            fw.close();
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        }					
		}		
		
		Scanner AccountInformation =null;
		try 
		{
			AccountInformation = new Scanner(new FileInputStream(emailDomain + "Corp.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Corporate Accound File not found");
		}
		//checks if the @###.## matches records if so it returns the type of account if no matches than its regular.
		while(AccountInformation.hasNext())
		{
			System.out.println(AccountInformation.next());
					
		}		
		AccountInformation.close();
	}
}
