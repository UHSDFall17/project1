package groupProject;
//created by James Rodgers
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Corporate {

	private String username = "", company = "";
	
	public Corporate(String username, String emailDomain){
		this.username=username;
		setCorpName(emailDomain);
	}
	
	public Corporate(){
		this.username="UNKNOWN";
		this.company = "UNKNOWN";
	}
	
	public void CorporateGreetings()
	{
		System.out.println("Good Morning " + username + "                         " + company);
	}
	
	public String Options()
	{
		String option = "";
		System.out.println("Would you like to view " + company + " account information first or go straight to the home page?");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while((!option.equals("account")) && (!option.equals("home")))
		{
			System.out.println("please type 'account' for the account information, or 'home' for the home page.");
			option = scanner.nextLine();
			option = option.trim();
		}		
		return option;
	}
	
	public void DisplayCorporateInformation()
	{
		File file = new File(company + "Corp.txt");
		if(!file.exists())
		{
			FileWriter fw = null;
			try {
				File file1 = new File(company + "Corp.txt");
				fw = new FileWriter(file1, true);
	            fw.close();
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        }					
		}		
		
		Scanner AccountInformation =null;
		try 
		{
			AccountInformation = new Scanner(new FileInputStream(company + "Corp.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Corporate Accound File not found");
		}
		//checks if the @###.## matches records if so it returns the type of account if no matches than its regular.
		while(AccountInformation.hasNext())
		{
			System.out.println(AccountInformation.nextLine());
					
		}		
		AccountInformation.close();
	}

	public String getCorpName()
	{
		
		return this.company;
	}
	
	public void setCorpName(String emailDomain)
	{
		this.company =  emailDomain.substring(0, emailDomain.indexOf("."));
		this.company = this.company.substring(0,1).toUpperCase() + this.company.substring(1);
	}
}
