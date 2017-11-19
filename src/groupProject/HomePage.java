package com.group1.project1.anyDont;
//created by Napoleon de Mesa
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
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
//        File file = new File(username + ".txt");
//        try{
//            @SuppressWarnings("resource")
//			Scanner input = new Scanner(file);
//            String name = input.nextLine();
//            System.out.println("Hello " + name);
//            while (input.hasNext()){
//                String num = input.nextLine();
//                System.out.println(num);
//            }
//        }
//        
//        catch(FileNotFoundException e){
//            System.err.format("File does not exist\n");
//        }
//        System.out.println("...");
//      
        
        
        for(int i =0; i < existingTask.length; i++)
        {
        	System.out.println(usersTask[i]);
        }
        
    }
    
    public void userDecision(String userDec){
    	
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        if("A".equals(userDec) || "X".equals(userDec)){
            System.out.println("");
            System.out.println("----------------------------------------------");
        }
        else{
            while(!"A".equals(userDec) || !"X".equals(userDec)){
                    System.out.println("Please enter A or X.");
                    user_decision = scanner.next().toUpperCase();
                
                    if(userDec.equals("A") ||userDec.equals("X")){
                        System.out.println("");
                        System.out.println("----------------------------------------------");
                        break;
                    }
            }
        }
        
        
    }
    
}
