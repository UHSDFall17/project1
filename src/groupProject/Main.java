package groupProject;
//Created by James Rodgers
//Modified by Yikchun and Napoleon

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static String username="";
	private static String email = "", password="", domain = "";
	private static String accountType = "";
	static String[] usersTask;
	static Scanner scanner = new Scanner(System.in);
	static boolean finished = false;
	static HomePage homePageVariable = new HomePage();
	static User user = new User();
	static ArrayList<List> lists = new ArrayList<List>();
	//static ArrayList<String> simpleList = new ArrayList<String>();
	//static ArrayList<String> simpleAddList = new ArrayList<String>();
	
	public static void main(String[] args) {
		System.out.println("      Welcome to Any Don't \n-----------------------------------\nEnter username or enter \"signup\"");
		username = scanner.nextLine().trim();
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
		
		if(user.usersTask.length > 0){
			loadData();
		}
		
		GreetingsMessage();		
		if(lists.size() > 0){
			saveData();
		}
		scanner.close();
	}
	
	public static void GreetingsMessage(){
		
		if(accountType.equals("Corporate"))
		{
			String choice = "";
			Corporate corp = new Corporate(username, domain);
			corp.CorporateGreetings();
			choice = corp.Options();
			if(choice.equals("account"))
			{
				corp.DisplayCorporateInformation();
				
			}
			
		}
		else if(accountType.equals("Student"))
		{
			Student student = new Student(username, domain);
			student.StudentGreetings();
		}
		homePageVariable.homePage();
	}
	
	static void returningUser()
	{
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
		domain = user.userDomain();
		accountType = user.checkAccountType();
		String usersProfile = username + ".txt";
		usersTask = user.getUsersDate(usersProfile);
	}
	
	protected static void saveData()
	{
		FileWriter fw = null;
		
		try {
			File file = new File(username + ".txt");
			if(file.exists()){
            	fw = new FileWriter(file, false);
            	 //fw.append(System.getProperty("line.separator"));
			}
            else
            {
            	fw = new FileWriter(file, true);
            }
			for(int i = 0; i < lists.size(); i++)
			{
				ArrayList<Task> taskList = lists.get(i).taskList();
				String listName = lists.get(i).getName();
				fw.append("~Main~");
				fw.append(listName);
				for(int j = 0; j < taskList.size(); j++) 
				{
					String description = taskList.get(j).description(); // TASK NAME
					String note = taskList.get(j).note(); // NOTE IF IT EXISTS
					String duedate = taskList.get(j).date(); // formatted to "MM/dd/yyyy h:mm a"
					String status = taskList.get(j).status();
					
					fw.append("~Task~");
					fw.append(description);
					fw.append("~Note~");
					fw.append(note);
					fw.append("~DueDate~");
					fw.append(duedate);
					fw.append("~Status~");
					fw.append(status);
				}
			}
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}
	
	protected static void loadData()
	{
		List newlist = new List();
		String listName;
		for(int i = 0; i < usersTask.length; i++)
		{
			if(usersTask[i].equals("Main")) {
				listName = usersTask[i+1];
				List temp = new List(listName);
				newlist = temp;
				lists.add(newlist);
			}
			
			if(usersTask[i].equals("Task")) {
				String task = usersTask[i+1];
				String note = usersTask[i+3];
				String duedate = usersTask[i+5];
				String status = usersTask[i+7];
				newlist.loadTaskData(task, note, duedate, status);
			}
		}
	}
	
	/*
	private static void AddTask()
	{
		System.out.println("Enter Name of the List you want to add a task to:");
		String temp = scanner.nextLine().trim();
		
		temp = "Main " + temp;
		simpleAddList.add(temp);
		
		while(!temp.equals("Finish"))
		{
			System.out.println("Type task to add a Task to the list or type Finish");
			temp = scanner.nextLine().trim();
			if(!temp.equals("Finish"))
			{
				temp = "Task " + temp;
				simpleAddList.add(temp);
				System.out.println("Type Due Date to add to the Task or type Skip");
				temp = scanner.nextLine().trim();
				if(!temp.equals("Skip"))
				{
					temp = "DueDate " + temp;
					simpleAddList.add(temp);
				}	
				else
				{
					temp = "DueDate NO Due Date";
					simpleAddList.add(temp);
				}		
				temp = "Checked uncheck";
				simpleAddList.add(temp);
			}			
		}
	}
	
	/*
	public static void saveNewData()
	{
		
		FileWriter fw = null;
		
		try {
			File file = new File(username + ".txt");
			if(file.exists()){
            	fw = new FileWriter(file, false);
            	 //fw.append(System.getProperty("line.separator"));
			}
            else
            {
            	fw = new FileWriter(file, true);
            }
			for(String i: usersTask)
			{
				fw.append("~");
				fw.append(i);
			}
			for(int i=0; i < lists.size(); i++)
			{
				fw.append("~");
				fw.append(simpleList.get(i));
			}
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}*/
	/*
	public static void AddNewDataToExistingList()
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		Scanner profileInformation = null;
		try 
		{
			profileInformation = new Scanner(new FileInputStream(username + ".txt"));
		}
		catch(IOException e)
		{
			System.err.println("User Profile File Not Found");
		}
		profileInformation.useDelimiter("~");
		while(profileInformation.hasNext())
		{
			temp.add(profileInformation.next().trim());
		}	
		
		int tempSize = temp.size(), addListSize = simpleAddList.size(), i =0;
		boolean added = false;
		while( (i < tempSize) && !added)
		{
			if(temp.get(i).equals(simpleAddList.get(0)))
			{
				for(int j=1; j<addListSize; j++)
				{
					temp.add(i+j, simpleAddList.get(j));
					added = true;
				}
			}
			i++;
		}
		
		profileInformation.close();
		//saveNewAddData(temp);
	}
	*/
	

}



