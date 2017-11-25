package com.group1.project1.anyDont;

import java.util.*;
import java.text.SimpleDateFormat;

public class Task {
	
	Scanner sc;
	private String note;
	private String description;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private String date;
	private SimpleDateFormat sdf;
	private boolean isRepeating;
	private boolean isCompleted;
	private ArrayList<String> subtasks;
	
	protected Task()
	{
		sc = new Scanner(System.in);
		note = null;
		description = null;
		date = null;
		sdf = new SimpleDateFormat("MM/dd/yyyy - HH:mm");
		isRepeating = false;
		isCompleted = false;
		subtasks = new ArrayList<String>();
	}
	
	protected String getDescription()
	{
		System.out.print("I WANT TO: ");
		String description = sc.nextLine();
		
		return description;
	}
	
	protected String printDescription()
	{
		return description;
	}
	
	protected String getNote()
	{
		String note = sc.nextLine();
		return note;
	}
	
	protected int getMonth()
	{
		System.out.print("MONTH(1-12): ");
		month = sc.nextInt();
		while(month < 1 || month > 12)
		{
			System.err.println("INVALID INPUT");
			System.out.print("MONTH(1-12): ");
			month = sc.nextInt();
		}
		
		return month;
	}
		
	protected int getDay(int year, int month)
	{
		if(month == 2)
		{
			if(isLeapYear(year) == false)
			{
				System.out.print("DAY(1-28): ");
				day = sc.nextInt();
				while(day < 1 || day > 28)
				{
					System.err.println("INPUT DAY DOES NOT EXIST IN THIS MONTH");
					System.out.print("ENTER DAY(1-28): ");
					day = sc.nextInt();
				}
			}else {
				System.out.print("DAY(1-29): ");
				day = sc.nextInt();
				while(day < 1 || day > 29)
				{
					System.err.println("INPUT DAY DOES NOT EXIST IN THIS MONTH");
					System.out.print("DAY(1-29): ");
					day = sc.nextInt();
				}
			}
		}
		
		if(month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)
		{
			System.out.print("DAY(1-31): ");
			day = sc.nextInt();
			while(day < 1 || day > 31)
			{
				System.err.println("INPUT DAY DOES NOT EXIST IN THIS MONTH");
				System.out.print("DAY(1-31): ");
				day = sc.nextInt();
			}
		}
		
		if(month == 4||month == 6||month == 9||month == 11)
		{
			System.out.print("DAY(1-30): ");
			day = sc.nextInt();
			while(day < 1 || day > 30)
			{
				System.err.println("INPUT DAY DOES NOT EXIST IN THIS MONTH");
				System.out.print("DAY(1-30): ");
				day = sc.nextInt();
			}
		}
		
		return day;
	}
	
	protected int getYear()
	{
		System.out.print("YEAR: ");
		year = sc.nextInt();
		while(year < 2017)
		{
			System.err.println("INPUT CANNOT BE LESS THAN 2017");
			System.out.print("YEAR: ");
			year= sc.nextInt();
		}
		
		return year;
	}
	
	protected boolean isLeapYear(int year)
	{
		if(year % 4 == 0) 
			return true;
		else
			return false;
	}
	
	protected int getHour()
	{
		System.out.print("HOUR(0-23): ");
		hour = sc.nextInt();
		while(hour < 0 || hour > 23)
		{
			System.err.println("INVALID INPUT");
			System.out.print("ENTER HOUR(0-23): ");
			hour = sc.nextInt();
		}
		
		return hour;
	}
	
	protected int getMinute()
	{
		System.out.print("MINUTE(0-59): ");
		minute = sc.nextInt();
		while(minute < 0 || minute > 59)
		{
			System.err.println("INVALID INPUT");
			System.out.print("MINUTE(0-23): ");
			minute = sc.nextInt();
		}
		
		return minute;
	}
	
	protected void setTime()
	{
		getYear();
		getMonth();
		getDay(year, month);
		getHour();
		getMinute();
		setDate(year, month, day, hour, minute);
	}
	
	protected void setDate(int year, int month, int day, int hour, int minute)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		Date taskDate = cal.getTime();
		date = sdf.format(taskDate);
	}
	
	protected String printDate()
	{
		return date;
	}
	
	protected boolean repeatTask()
	{
		isRepeating = true;
		return isRepeating;
	}
	
	protected void isRepeatingSwitch()
	{
		if(isRepeating = true){
			isRepeating = false;
		} else {
			isRepeating = true;
		}
	}
		
	protected boolean markCompleted()
	{
		isCompleted = true;
		return isCompleted;
	}
	
	protected String checkCompletion()
	{
		if(isCompleted = true)
		{
			return "COMPLETED";
			
		}else {
			return "INCOMPLETE";
		}
		
	}
	
	protected void addSubtask()
	{
		System.out.print("DESCRIBE YOUR SUBTASK: ");
		String temp = sc.nextLine();
		
		subtasks.add(temp);
	}
	
	protected void displaySubtask()
	{
		String output;
		if(subtasks.isEmpty() == true) {
			System.out.println("THERE'S NO SUBTASK");
		}else {
			for(int i = 1; i <= subtasks.size(); i++)
			{
				output = i + ". " + subtasks.get(i-1);
				System.out.println(output);
			}
		}
		
		System.out.println("");
	}
	
	protected void deleteSubtask()
	{
		System.out.print("INDEX OF THE SUBTASK YOU WISH TO REMOVE: ");
		int i = sc.nextInt();
		
		try {
			subtasks.remove(i-1);
			System.out.println("SUBTASK REMOVED");
			
			for(int x = i-1; x <= subtasks.size(); x++){
				subtasks.set(x, subtasks.get(x+1));
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("INDEX IS OUT OF RANGE");
		}
	}
}
     
        
 
