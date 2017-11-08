package com.group1.project1.anyDont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class HomePage {
   
    public void homePageFunction(String username) {
        
        Scanner reader = new Scanner(System.in);
        String user_decision;
        
        System.out.println("----------------------------------------------");
        System.out.println("");
        
        File file = new File(username + ".txt");
        try{
            Scanner input = new Scanner(file);
            String name = input.nextLine();
            System.out.println("Hello " + name);
            while (input.hasNext()){
                String num = input.nextLine();
                System.out.println(num);
            }
        }
        
        catch(FileNotFoundException e){
            System.err.format("File does not exist\n");
        }
        System.out.println("");
        System.out.println("If you want to add a new task enter A, if you want to logout press X.");
        user_decision = reader.next().toUpperCase();
        
        if("A".equals(user_decision) || "X".equals(user_decision)){
            System.out.println("");
            System.out.println("----------------------------------------------");
        }
        else{
            while(!"A".equals(user_decision) || !"X".equals(user_decision)){
                    System.out.println("Please enter A or X.");
                    user_decision = reader.next().toUpperCase();
                
                    if(user_decision.equals("A") ||user_decision.equals("X")){
                        System.out.println("");
                        System.out.println("----------------------------------------------");
                        break;
                    }
            }
        }
        
        
    }
    
}
