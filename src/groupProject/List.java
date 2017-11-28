package groupProject;

import java.util.*;

public class List extends HomePage{
	
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
	
	protected String getName()
	{
		return listName;
	}
	
	protected void setName(String name)
	{
		listName = name;
	}
	
	protected ArrayList<Task> taskList()
	{
		return taskList;
	}
	
	protected int listFunction()
	{
		int op;
		do{
			print("----- " + listName + " -----");
			if(!taskList.isEmpty()) {
				for(int i = 1; i <= taskList.size(); i++){
					print( i + ". " + taskList.get(i-1).description());
					print("   Note: " + taskList.get(i-1).note());
					print("   Due: " + taskList.get(i-1).date());
					print("   Progress: " + taskList.get(i-1).status());
				}
				print("");
			}
			print("1: CREATE NEW TASK");
			print("2: EDIT A TASK");
			print("3: MARK A TASK");
			print("4: REMOVE A TASK");
			print("0: RETURN");
			System.out.print("Enter an index: "); 
			op = sc.nextInt();
			switch(op) {
			case 0: return 1;
			case 1: createTask(); break;
			case 2: editTask(); break;
			case 3: markTask(); break;
			case 4: removeTask(); break;
			default: print("Invalid Index");
			}
			print("");
		} while(op != 0);
		
		return 0;
	}
	
	protected static void print(String msg)
	{
		System.out.println(msg);
	}
	
	protected void createTask()
	{
		Task task = new Task();
		task.getDescription();
		
		System.out.print("Y if you wish to set time, N to skip: ");
		try {
			String temp;
			temp = sc.next().toUpperCase();
			if(temp.equals("Y")){
				task.setTime();
			}
		} catch (NullPointerException ex) {
			print("Invalid input, returning to List");
		}
		
		taskList.add(task);
		print("Task Created");
	}
	
	protected void loadTaskData(String description, String note, String date, String status)
	{
		Task task = new Task(description, note, date, status);
		taskList.add(task);
	}
	
	protected void editTask()
	{
		if(!taskList.isEmpty()) {
			System.out.print("Index of the task to be edited: ");
			int i = sc.nextInt();
			Task task = taskList.get(i-1);
			print("");
			
			int op;
			do {
				print("----- " + task.description() + " -----");
				print("1: SET TIME");
				print("2: ADD NOTE");
				print("3: CREATE SUBTASK");
				print("0: RETURN");
				System.out.print("Enter an index: ");
				op = sc.nextInt();
				switch(op) {
				case 0: break;
				case 1: task.setTime(); break;
				case 2: task.getNote(); break;
				case 3: task.addSubtask(); break;
				default: System.err.println("Invalid index");
				}
			} while(op != 0);
		} else {
			print(listName + " is empty");
		}
		
	}
	
	protected void markTask()
	{
		if(!taskList.isEmpty()) {
			
			System.out.print("Index of the task to be marked: ");
			int i = sc.nextInt();
			String temp;
			if(taskList.get(i-1).status().equals("Incompleted")) {
				taskList.get(i-1).markCompleted();
				print("Task Completed");
				print("Remove the task?");
				System.out.print("Y/N: ");
				temp = sc.next().trim();
				if(temp.equals("Y")||temp.equals("y")) {
					taskList.remove(i-1);
					print("Task Removed");
					for(int x = i-1; x <= taskList.size(); x++){
						taskList.set(x, taskList.get(x+1));
					}
				}
			} else {
				print("Task is already completed. Mark incompleted?");
				System.out.print("Y/N: ");
				temp = sc.next().trim();
				if(temp.equals("Y")||temp.equals("y")) {
					taskList.get(i-1).markCompleted();
					print("Task Reverted");
				}
			}
		} else {
			print(listName + " is empty");
		}
	}
	
	protected void removeTask()
	{
		boolean blah = false;
		if(!taskList.isEmpty()) {
			try {
				System.out.print("Index of the task to be removed: ");
				int i = sc.nextInt();
				taskList.remove(i-1);
				print("Task removed");
				blah=true;
				//sort remaining tasks;
				for(int x = i-1; x <= taskList.size(); x++){
					taskList.set(x, taskList.get(x+1));
				}
			} catch (IndexOutOfBoundsException e) {
				if(!blah)
				{
					System.err.println("Invalid index, returning to List");
				}
			}
		} else {
			print(listName + " is empty");
		}
	}

	
}