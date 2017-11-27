package groupProject;
//created by Napoleon de Mesa

import java.util.Scanner;


public class HomePage {
   
	String user_decision = "";
	public static String[] usersTask;
	public static String[] usersTask2;
	
    
    public String getUser_Decision(){
        return this.user_decision;
    }

    public void setUser_Decision(String user_decision){
        this.user_decision = user_decision;
    }
    
   
    //account type will be "regular", "student", "corporate"
    public void homePageFunction(String username, String[] existingTask,String accountType) {
                
    	String anotherList = null;
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("-----------------------------------");
        System.out.println("");
        usersTask = existingTask;
        
        displayList(usersTask);
        
        System.out.println("");
        System.out.println("Which list would you like to see: ");
        System.out.println("(Please enter a number with respect to the displayed lists. e.g. 1 for the first list or 2 for the second)");
        System.out.println("");
        
        
        displayTask(usersTask);
        
        
        System.out.println("Would you like to see another list? Enter Y or N:");
        anotherList = scanner.nextLine();
        
        while(anotherList.equals("Y") || anotherList.equals("y")) {
    	    displayList(usersTask);
    	   
     	    System.out.println("");
            System.out.println("Which list would you like to see: ");
            System.out.println("(Please enter a number with respect to the displayed lists. e.g. 1 for the first list or 2 for the second)");
            System.out.println("");
           
            displayTask(usersTask);
            
            System.out.println("Would you like to see another list? Enter Y or N:");
            anotherList = scanner.nextLine();
        
    }
    
    public void userDecision(String userDec){
    	
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
	    
    
    
}
