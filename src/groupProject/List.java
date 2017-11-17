package com.group1.project1.anyDont;

import java.util.*;
import java.util.stream.Stream;
import java.io.File;

public class List {
	
	Scanner sc = new Scanner(System.in);
	private ArrayList<Task> taskList;
	
	public List()
	{
		taskList = new ArrayList<Task>();
	}
	
	public int listFunction()
	{
		int op;
		print("HELLO, WHAT WOULD YOU LIKE TO DO?");  //INSERT USERNAME LATER
		print("1: VIEW LIST");
		print("2: CREATE NEW TASK");
		print("3: EDIT A TASK");
		print("4: REMOVE A TASK");
		print("5: RETURN");
		System.out.print("ENTER AN INDEX: "); 
		op = sc.nextInt();
		if(op == 5)
		{
			return 1;
		}else {
			
			switch(op) {
			case 1: printTask(); break;
			case 2: createTask(); break;
			case 3: editTask(); break;
			case 4: removeTask(); break;
			case 5: return 1;
			default: print("INVALID INDEX");
			}
		}
		
		listFunction();
		return 0;
	}
	
	private static void print(String msg)
	{
		System.out.println(msg);
	}

	private void printTask()
	{

		String output;
		if(taskList.isEmpty() == true) {
			print("LIST IS EMPTY");
		}else {
			print("");
			for(int i = 1; i <= taskList.size(); i++){
				output = i + ". " + taskList.get(i-1).printDescription() + " DUE: " + taskList.get(i-1).printDate() + " STATUS: " + taskList.get(i-1).printStatus();
				print(output);
				print("");
			}
		}
	}
	
	private void createTask()
	{
		Task task = new Task();
		task.getDescription();
		
		System.out.print("ENTER Y IF YOU WISH TO SET TIME, ELSE TO SKIP: ");
		String temp;
		temp = sc.next().toUpperCase();
		if(temp.equals("Y")){
			task.setTime();
		}
		
		taskList.add(task);
		print("");
		print("TASK CREATED");
	}
	
	private int editTask()
	{
		System.out.print("INDEX OF THE TASK YOU WISH TO EDIT: ");
		int i = sc.nextInt();
		Task task = taskList.get(i-1);
		print("");
		print(task.printDescription());
		
		int op;
		do {
			print("1: SET TIME");
			print("2: REPEAT TASK");
			print("3: ADD NOTE");
			print("4: ADD SUBTASK");
			print("5: RETURN");
			System.out.print("ENTER INPUT NUMBER: ");
			op = sc.nextInt();
			switch(op) {
			case 1: task.setTime(); break;
			case 2: task.repeatTask(); break;
			case 3: task.getNote(); break;
			case 4: //create subtask
			case 5: break;
			default: print("INVALID INPUT NUMBER");
			}
		} while(op != 5);
		
		return 0;
	}
	
	private void removeTask()
	{
		System.out.print("INDEX OF THE TASK YOU WISH TO REMOVE: ");
		int i = sc.nextInt();
		taskList.remove(i-1);
		print("TASK REMOVED");
	}

	
}