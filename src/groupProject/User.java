package groupProject;
//Created by James Rodgers
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	
	private String username = "";
	private String password="";
	private String email = "";
	public static String[] userName_passwords;
	public static String[] usersTask;
	
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
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
	
	public void amendCredentials()
	{
		String newInfo = this.username + " " + this.password + " " + this.email; 
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
	
	public boolean credentialsConfirmed()
	{
		for(int i=0; i < userName_passwords.length-1; i = i + 3)
		{
			if(userName_passwords[i].equals(getUsername()) && userName_passwords[i+1].equals(getPassword()))
			{
				this.email = userName_passwords[i+2];
				return true;
			}
		}
		return false;
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
			profileInformation.next();
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
			usersTask[j] = usersTask[j].trim();
			j++;
			
		}
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
			//reads the password and email
			checkForUsername.next();
			checkForUsername.next();
		}
		//closes file
		checkForUsername.close();
		return true;
	}
	
	public void loadFile()
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
	
	public String checkAccountType()
	{
		String accountType = "Regular", emailDomain = "";		
		//get the @ some.com
		emailDomain = userDomain();
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
		
		Scanner corprateAccount =null;
		try 
		{
			corprateAccount = new Scanner(new FileInputStream("corporate_accounts.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Password file not found");
		}
		//checks if the @###.## matches records if so it returns the type of account if no matches than its regular.
		while(corprateAccount.hasNext())
		{
			String compare = corprateAccount.next();
			if(compare.equals(emailDomain))
			{
				accountType = corprateAccount.next();
			}			
		}		
		corprateAccount.close();
		return accountType;
	}
	
	public String userDomain()
	{
		String emailDomain = "";		
		//get the @ some.com
		emailDomain = email.substring(email.lastIndexOf("@") + 1);
		
		return emailDomain;
	}

}
