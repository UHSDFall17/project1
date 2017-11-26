package groupProject;




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//Created by James Rodgers
//Modified by Yikchun and Napoleon
import java.util.Scanner;

public class Main {

	public static String username="", user_decision="";
	private static String email = "", password="", domain = "";
	private static String accountType = "";
	public static String[] usersTask;
	public static boolean finished = false;
	static HomePage homePageVariable = new HomePage();
	static User user = new User();
	static ArrayList<List> lists = new ArrayList<List>();
	static ArrayList<String> simpleList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
		GreetingsMessage();		
		saveData(username, usersTask);
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
			System.out.println("debug " + domain);
			Student student = new Student(username, domain);
			student.StudentGreetings();
		}
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
		while(!user_decision.equals("X") || user_decision.equals("x"))
		{
			System.out.println("If you want to create a new list enter L:\n If you want to create a new task enter T\n If you want to logout press X.");
			user_decision = scanner.nextLine().trim();
			scanner.close();
			homePageVariable.setUser_Decision(user_decision);
			homePageVariable.userDecision(user_decision);
			
			if(user_decision.equals("L") || user_decision.equals("l")) 
			{
				NewList();
			}
			else if(user_decision.equals("T") || user_decision.equals("t"))
			{
				
			}
		}
		System.out.println("Have a good day!");
	}
	
	static void createList() 
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Name of the list: ");
		String name = sc.nextLine();
		List newlist = new List(name);
		lists.add(newlist);
	}
		
	private static void NewList()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name of New List:");
		String temp = scanner.nextLine().trim();
		
		temp = "Main " + temp;
		simpleList.add(temp);
		
		while(!temp.equals("Finish"))
		{
			System.out.println("Type task to add a Task to the list or type Finish");
			temp = scanner.nextLine().trim();
			if(!temp.equals("Finish"))
			{
				temp = "Task " + temp;
				simpleList.add(temp);
				System.out.println("Type Due Date to add to the Task or type Skip");
				temp = scanner.nextLine().trim();
				if(!temp.equals("Skip"))
				{
					temp = "DueDate " + temp;
					simpleList.add(temp);
				}
				System.out.println("Type Due Date to add to the Task or type Skip");
				temp = scanner.nextLine().trim();
				if(!temp.equals("Skip"))
				{
					temp = "DueDate " + temp;
					simpleList.add(temp);
				}	
				else
				{
					temp = "DueDate NO Due Date";
					simpleList.add(temp);
				}				
			}			
		}
		
	}
	public static void saveData(String Username, String[] Task)
	{
		
		FileWriter fw = null;
		
		try {
			File file = new File(Username + ".txt");
			if(file.exists()){
            	fw = new FileWriter(file, false);
            	 //fw.append(System.getProperty("line.separator"));
			}
            else
            {
            	fw = new FileWriter(file, true);
            }
			for(String i: Task)
			{
				fw.append("~");
				fw.append(i);
			}
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
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
				for(int j = 0; j < taskList.size(); j++) 
				{
					String description = taskList.get(j).description(); // TASK NAME
					String note = taskList.get(j).note(); // NOTE IF IT EXISTS
					String duedate = taskList.get(j).date(); // formatted to "MM/dd/yyyy h:mm a"
					String status = taskList.get(j).status();  //COMPLETE OR IMCOMPLETE
					
					fw.append("~");
					fw.append(description);
					fw.append(duedate);
					fw.append(status);
					fw.append(note);
				}
			}
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}
}