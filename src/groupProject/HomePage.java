package groupProject;
//created by Napoleon de Mesa
//modified by Yikchun Ng

import java.util.ArrayList;
import java.util.Scanner;

public class HomePage extends Main{
   
	Scanner sc = new Scanner(System.in);
	private String user_decision = "";
	
    protected String getUserDecision(){
        return this.user_decision;
    }

    //account type will be "regular", "student", "corporate"
	protected void homePage()
	{		
		do
		{
			System.out.println("-----Homepage-----");
			System.out.println("Hi, " + username);
			if(!lists.isEmpty()) {
				for(int i = 1; i <= lists.size(); i++)
				{
					String listName = lists.get(i-1).getName();
					System.out.println(i + ". " + listName);
				}
				System.out.println("");
			}
			System.out.println("L: CREATE NEW LIST");
			System.out.println("V: VIEW A LIST");
			System.out.println("R: REMOVE LIST");
			System.out.println("X: LOGOUT");
			System.out.print("What would you like to do: ");
			user_decision = sc.nextLine().trim();
			
			if(user_decision.equals("L") || user_decision.equals("l")) 
			{
				createList();
			}
			else if(user_decision.equals("V") || user_decision.equals("v"))
			{
				viewList();
			}
			else if(user_decision.equals("R") || user_decision.equals("r"))
			{
				removeList();
			}
			
			System.out.println("");
		} while(!user_decision.equals("X") && !user_decision.equals("x"));
		
		System.out.println("Logged out");
		System.out.println("Have a good day!");
	}
	
	protected void createList() 
	{
		System.out.print("Name of the list: ");
		String name = sc.nextLine().trim();
		List newlist = new List(name);
		lists.add(newlist);
		System.out.println("List Created");
	}
	
	protected void viewList()
	{
		if(!lists.isEmpty())
		{
			try {
				System.out.print("Enter the index of a list, 0 to return: ");
				int temp = scanner.nextInt();
				if(temp != 0) {
					lists.get(temp-1).listFunction();
				}
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Invalid Index");
			}
			
		} else {
			System.out.println("No List Found");
		}
	}
	
	protected void removeList()
	{
		if(!lists.isEmpty()) {
			System.out.print("Enter index of the list to be removed: ");
			int temp = sc.nextInt();
			lists.remove(temp-1);
			System.out.println("List Removed");
		} else {
			System.out.println("No List Found");
		}
	}
    
	/*
    protected void userDecision(String userDec){
    	
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        if("A".equals(userDec) || "X".equals(userDec) || "a".equals(userDec) || "x".equals(userDec)){
            System.out.println("");
            System.out.println("-----------------------------------");
        }
        else{
            while(!"A".equals(userDec) || !"X".equals(userDec) || !"a".equals(userDec) || !"x".equals(userDec)){
                    System.out.println("Please enter A or X.");
                    user_decision = scanner.next().toUpperCase();
                
                    if(userDec.equals("A") ||userDec.equals("X")|| userDec.equals("a")|| userDec.equals("x")){
                        System.out.println("");
                        System.out.println("-----------------------------------");
                        break;
                    }
            }
        }
        
        
    }
    
    public void displayList(String[] existingTask) {
    	
    	System.out.println("Your lists are as follows: ");
        
        for(int j = 0; j < existingTask.length; j++) {
        	if(usersTask[j].contains("Main")) {
        		System.out.println(usersTask[j].replace("Main", ""));
        	}
        	
        }
        
    }
    
    public void displayTask(String[] Task) {

    	int i = 0;
    	int k = 0;
    	int x = 0;
    	int y = 0;
    	
    	Scanner scanner = new Scanner(System.in);
        usersTask2 = Task;
        
        for(int j = 0; j < Task.length; j++) {
        	if(usersTask[j].contains("Main")) {
        		x++;
        	}
        	
        }
        
        
        
        
        int listToSee = scanner.nextInt();
        
        while(listToSee > x || listToSee < 0) {
        	System.out.println("Please enter a number 0-" + x + " :");
        	listToSee = scanner.nextInt();
        }
    	
    	
    	if(listToSee == 1) {
        	while(i < Task.length) {
        	
        	
        		if(usersTask2[i].contains("Main")) {
        			if(y == 1) {
            			y = 0;
            			break;
            		}
        			
        			System.out.println(usersTask2[i].replace("Main", ""));
        			
        			y++;
        		}
        		else if(usersTask2[i].contains("Task")) {
        			System.out.println("   " + usersTask2[i].replace("Task", ""));
        		}
        		else if(usersTask2[i].contains("DueDate")){
        			System.out.println("      " + usersTask2[i].replace("DueDate", ""));
        		}
        		else if(usersTask2[i].contains("Checked")){
        			System.out.println("      " + usersTask2[i].replace("Checked", ""));
        		}
        		else {
        			break;
        		}
        		
        		
        		
        		i++;
        	}
        }
        else if(listToSee == 2){
        	
        	while(i < Task.length) {
        		
        		if(usersTask2[i].contains("Main")) {
            		k++;
            		if(k == listToSee) {
            			break;
            		}
            	}
        		
        		i++;
        	}
        	
        	while(i < Task.length){
            
            	
            	if(usersTask2[i].contains("Main")) {            		
            		if(y == 1) {
            			y = 0;
            			break;
            		}
            		
            		System.out.println(usersTask2[i].replace("Main", ""));
            		
            		y++;
            	}
            	else if(usersTask2[i].contains("Task")) {
            		System.out.println("   " + usersTask2[i].replace("Task", ""));
            	}
            	else if(usersTask2[i].contains("DueDate")){
            		System.out.println("      " + usersTask2[i].replace("DueDate", ""));
            	}
            	else if(usersTask2[i].contains("Checked")){
            		System.out.println("      " + usersTask2[i].replace("Checked", ""));
            	}
            	else {
            		break;
            	}
            	
            	
            	
            	i++;
            }
        	
        	
        }
        else if(listToSee == 3){
        	
        	while(i < Task.length) {
        		
        		if(usersTask2[i].contains("Main")) {
            		k++;
            		if(k == listToSee) {
            			break;
            		}
            	}
        		
        		i++;
        	}
        	
        	while(i < Task.length) {
            
            	
            	if(usersTask2[i].contains("Main")) {
            		if(y == 1) {
            			y = 0;
            			break;
            		}
        			
        			System.out.println(usersTask2[i].replace("Main", ""));
        			
        			y++;
            	}
            	else if(usersTask2[i].contains("Task")) {
            		System.out.println("   " + usersTask2[i].replace("Task", ""));
            	}
            	else if(usersTask2[i].contains("DueDate")){
            		System.out.println("      " + usersTask2[i].replace("DueDate", ""));
            	}
            	else if(usersTask2[i].contains("Checked")){
            		System.out.println("      " + usersTask2[i].replace("Checked", ""));
            		
            	}
            	else {
            		break;
            	}
            	
            	
            	i++;
            }
        	
        	
        }
        else if(listToSee == 4){
        	
        	while(i < Task.length) {
        		
        		if(usersTask2[i].contains("Main")) {
            		k++;
            		if(k == listToSee) {
            			break;
            		}
            	}
        		
        		i++;
        	}
        	
        	while(i < Task.length){
            
            	
            	if(usersTask2[i].contains("Main")) {
            		if(y == 1) {
            			y = 0;
            			break;
            		}
        			
        			System.out.println(usersTask2[i].replace("Main", ""));
        			
        			y++;
            	}
            	else if(usersTask2[i].contains("Task")) {
            		System.out.println("   " + usersTask2[i].replace("Task", ""));
            	}
            	else if(usersTask2[i].contains("DueDate")){
            		System.out.println("      " + usersTask2[i].replace("DueDate", ""));
            	}
            	else if(usersTask2[i].contains("Checked")){
            		System.out.println("      " + usersTask2[i].replace("Checked", ""));
            	}
            	else {
            		break;
            	}
            	
            	i++;
            }
        	
        	
        }
        else if(listToSee == 5){
        	
        	while(i < Task.length) {
        		
        		if(usersTask2[i].contains("Main")) {
            		k++;
            		if(k == listToSee) {
            			break;
            		}
            	}
        		
        		i++;
        	}
        	
        	while(i < Task.length) {
            
            	
            	if(usersTask2[i].contains("Main")) {
            		if(y == 1) {
            			y = 0;
            			break;
            		}
        			
        			System.out.println(usersTask2[i].replace("Main", ""));
        			
        			y++;
            	}
            	else if(usersTask2[i].contains("Task")) {
            		System.out.println("   " + usersTask2[i].replace("Task", ""));
            	}
            	else if(usersTask2[i].contains("DueDate")){
            		System.out.println("      " + usersTask2[i].replace("DueDate", ""));
            	}
            	else if(usersTask2[i].contains("Checked")){
            		System.out.println("      " + usersTask2[i].replace("Checked", ""));
            	}
            	else {
            		break;
            	}

            	i++;
            }
        	
        	
        }
    	
    }
    */
    
}
