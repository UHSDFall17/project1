package com.group1.project1.anyDont;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
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
	
	public Task()
	{
		sc = new Scanner(System.in);
		note = null;
		description = null;
		date = null;
		sdf = new SimpleDateFormat("MM/dd/yyyy - HH:mm");
	}
	
	public String getDescription()
	{
		System.out.print("I WANT TO: ");
		String description = sc.nextLine();
		
		return description;
	}
	
	public String printDescription()
	{
		return description;
	}
	
	public String getNote()
	{
		String note = sc.nextLine();
		return note;
	}
	
	public int getMonth()
	{
		System.out.print("MONTH(1-12): ");
		month = sc.nextInt();
		while(month < 1 || month > 12){
			System.err.println("INVALID INPUT");
			System.out.print("MONTH(1-12): ");
			month = sc.nextInt();
		}
		
		return month;
	}
		
	public int getDay(int year, int month)
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
	
	public int getYear()
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
	
	public boolean isLeapYear(int year)
	{
		if(year % 4 == 0) 
			return true;
		else
			return false;
	}
	
	public int getHour()
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
	
	public int getMinute()
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
	
	public void setTime()
	{
		getYear();
		getMonth();
		getDay(year, month);
		getHour();
		getMinute();
		setDate(year, month, day, hour, minute);
	}
	
	public void setDate(int year, int month, int day, int hour, int minute)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		Date taskDate = cal.getTime();
		date = sdf.format(taskDate);
	}
	
	public String printDate()
	{
		return date;
	}
	
	

	protected boolean repeatTask()
	{
		String temp;
		if(!isRepeating) {
			return isRepeating = false;
		}else {
			System.out.println("REPEAT TASK?");
			System.out.print("Y/N : ");
			temp = sc.next();
			temp = temp.toUpperCase();
			if(!temp.equals("Y") || !temp.equals("N"))
			{
				System.err.println("INVALID INPUT");
				repeatTask();
			}
			if(temp.equals("Y")){
				return isRepeating = true;
				//CreateTask();
			}else{
				return isRepeating = false;
			}
		}
	}
	
	protected void isRepeatingSwitch()
	{
		if(isRepeating = true)
		{
			isRepeating = false;
		}else {
			isRepeating = true;
		}
	}
		
	protected boolean isCompletedCheck()
	{
		String temp;
		if(!isCompleted){
			return isCompleted = true;
		}else{
			
			System.out.println("MARK THE TASK AS INCOMPLETE?");
			System.out.print("Y/N : ");
			temp = sc.next();
			temp = temp.toUpperCase();
			
			if(!temp.equals("Y") || !temp.equals("N"))
			{
				System.err.println("INVALID INPUT");
				isCompletedCheck();
			}
			
			if(temp.equals("Y")){
				return isCompleted = false;
			}else{
				return isCompleted = true;
			}
		}
	}
	
	public String printStatus()
	{
		if(isCompleted = true)
		{
			return "COMPLETE";
			
		}else {
			return "INCOMPLETE";
		}
		
	}
}
     
        
 
