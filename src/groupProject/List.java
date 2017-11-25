package com.group1.project1.anyDont;

import java.util.*;
import java.io.File;

public class List {
	
	Scanner sc;
	private String listName;
	private ArrayList<Task> taskList;
	
	protected List()
	{
		sc = new Scanner(System.in);
		taskList = new ArrayList<Task>();
	}
	
	protected List(String name)
	{
		listName = name;
		sc = new Scanner(System.in);
		taskList = new ArrayList<Task>();
	}
	
	protected int listFunction()
	{
		int op;
		do{
			print("HELLO, WHAT WOULD YOU LIKE TO DO?");  //INSERT USERNAME LATER
			print("1: DISPLAY TASKS");
			print("2: CREATE NEW TASK");
			print("3: EDIT A TASK");
			print("4: MARK A TASTK AS COMPLETED");
			print("5: REMOVE A TASK");
			print("6: RETURN");
			System.out.print("ENTER AN INDEX: "); 
			op = sc.nextInt();
			
			switch(op) {
			case 1: displayTasks(); break;
			case 2: createTask(); break;
			case 3: editTask(); break;
			case 4: markTask(); break;
			case 5: removeTask(); break;
			case 6: break;
			default: print("INVALID INDEX");
			}
		} while(op != 6);
		
		return 0;
	}
	
	protected static void print(String msg)
	{
		System.out.println(msg);
	}

	protected void displayTasks()
	{
		String output;
		if(taskList.isEmpty() == true) {
			print("LIST IS EMPTY");
		}else {
			print("");
			for(int i = 1; i <= taskList.size(); i++){
				output = i + ". " + taskList.get(i-1).printDescription() + " DUE: " + taskList.get(i-1).printDate() + " STATUS: " + taskList.get(i-1).checkCompletion();
				print(output);
			}
		}
	}
	
	protected void createTask()
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
	
	protected void editTask()
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
			print("4: CREATE SUBTASK");
			print("5: RETURN");
			System.out.print("ENTER INPUT NUMBER: ");
			op = sc.nextInt();
			switch(op) {
			case 1: task.setTime(); break;
			case 2: repeatTask(i-1); break;
			case 3: task.getNote(); break;
			case 4: task.addSubtask(); break;
			case 5: break;
			default: print("INVALID INPUT NUMBER");
			}
		} while(op != 5);
		
	}
	
	protected void repeatTask(int i)
	{
		
	}
	
	protected void markTask()
	{
		System.out.print("INDEX OF THE TASK TO BE MARKED COMPLETED: ");
		int i = sc.nextInt();
		taskList.get(i-1).markCompleted();
		print("TASK COMPLETED");
		print("REMOVE THE TASK?");
		print("Y/N: ");
		String temp;
		temp = sc.next().toUpperCase();
		if(temp.equals("Y")){
			taskList.remove(i-1);
			print("TASK REMOVED");
			for(int x = i-1; x <= taskList.size(); x++){
				taskList.set(x, taskList.get(x+1));
			}
		}
	}
	
	protected void removeTask()
	{
		System.out.print("INDEX OF THE TASK YOU WISH TO REMOVE: ");
		int i = sc.nextInt();
		
		try {
			taskList.remove(i-1);
			print("TASK REMOVED");
		
			//sort remaining tasks;
			for(int x = i-1; x <= taskList.size(); x++){
				taskList.set(x, taskList.get(x+1));
			}
		} catch (IndexOutOfBoundsException e) {
			print("INDEX IS OUT OF RANGE");
		}
	}

	
}
