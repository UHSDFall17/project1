package com.group1.project1.anyDont;
//created by Napoleon de Mesa

import java.util.Scanner;


public class HomePage {
   
	String user_decision = "";
	public static String[] usersTask;
	
    
    public String getUser_Decision(){
        return this.user_decision;
    }

    public void setUser_Decision(String user_decision){
        this.user_decision = user_decision;
    }
    
   
    //account type will be "regular", "student", "corporate"
    public void homePageFunction(String username, String[] existingTask,String accountType) {
                
    	
    	System.out.println("----------------------------------------------");
        System.out.println("");
        usersTask = existingTask;
	
	
	for(int i =0; i < existingTask.length; i++)
        {
        	if(usersTask[i].contains("Main")) {
        		System.out.println(usersTask[i].replace("Main", ""));
        	}
        	else if(usersTask[i].contains("Task")) {
        		System.out.println("   " + usersTask[i].replace("Task", ""));
        	}
        	else if(usersTask[i].contains("DueDate")){
        		System.out.println("      " + usersTask[i].replace("DueDate", ""));
        	}
        	else if(usersTask[i].contains("Checked")){
        		System.out.println("      " + usersTask[i].replace("Checked", ""));
        	}
        }
        
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
    
}
