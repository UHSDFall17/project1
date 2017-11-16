package com.group1.project1.anyDont;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class CreateTask {
	
	Scanner sc = new Scanner(System.in);
	private String note = null;
	private String description = null;
	private int year = 1;
	private int month;
	private int day;
	private int hour = 0;
	private int minute = 0;
	
	private String date;
	private String timeDue;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	private boolean isRepeating = false;
	private boolean isCompleted = false;
	
	
	public String getTask()
	{
		System.out.print("Enter the description of your task: ");
		String description = sc.nextLine();
		
		return description;
	}
	
	public String getDescription()
	{
		String note = sc.nextLine();
		return note;
	}
	
	public int getMonth()
	{
		System.out.print("Month(1-12): ");
		month = sc.nextInt();
		while(month < 1 || month > 12){
			System.err.println("Input month is not within the range");
			System.out.print("Month(1-12): ");
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
				System.out.print("Day(1-28): ");
				day = sc.nextInt();
				while(day < 1 || day > 28)
				{
						System.err.println("Input is out of range");
						System.out.print("Day(1-28): ");
						day = sc.nextInt();
				}
			}else {
				System.out.print("Day(1-29): ");
				day = sc.nextInt();
				while(day < 1 || day > 29)
				{
						System.err.println("Input is out of range");
						System.out.print("Day(1-29): ");
						day = sc.nextInt();
				}
			}
		}
		
		if(month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)
		{
			System.out.print("Day(1-31: ");
			day = sc.nextInt();
			while(day < 1 || day > 31)
			{
					System.err.println("Input is out of range");
					System.out.print("Day(1-31): ");
					day = sc.nextInt();
			}
		}
		
		if(month == 4||month == 6||month == 9||month == 11)
		{
			System.out.print("Day(1-30: ");
			day = sc.nextInt();
			while(day < 1 || day > 30)
			{
					System.err.println("Input is out of range");
					System.out.print("Day(1-30): ");
					day = sc.nextInt();
			}
		}
		
		return day;
	}
	
	public int getYear()
	{
		System.out.print("Year: ");
		year = sc.nextInt();
		while(year < 2017)
		{
			System.err.println("Year must be 2017 or after");
			System.out.print("Year: ");
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
		System.out.print("Hour(0-23): ");
		hour = sc.nextInt();
		while(hour < 0 || hour > 23)
		{
			System.err.println("Input is not within the range");
			System.out.print("Hour(0-23): ");
			hour = sc.nextInt();
		}
		
		return hour;
	}
	
	public int getMinute()
	{
		System.out.print("Minute(0-59): ");
		minute = sc.nextInt();
		while(minute < 0 || minute > 59)
		{
			System.err.println("Input is not within the range");
			System.out.print("Minute(0-23): ");
			minute = sc.nextInt();
		}
		
		return minute;
	}
	
	public void setDate(int year, int month, int day)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		Date taskDate = cal.getTime();
		date = sdf.format(taskDate);
	}
	
	public void setTime(int hour, int minute)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(hour, minute);
		Date taskTime = cal.getTime();
		timeDue = sdf2.format(taskTime);
	}
	
	protected boolean RepeatTask()
	{
		return isRepeating;
	}
		
	protected boolean CheckCompletion()
	{
		String temp;
		if(!isCompleted){
			return isCompleted = true;
		}else{
			
			System.out.println("Would you like to mark the task as incomplete? (Y/N)");
			temp = sc.next();
			
			while(!temp.equals("Y") || !temp.equals("N"))
			{
				System.out.println("Please enter Y or N");
				temp = sc.next();
			}
			
			if(temp.equals("Y")){
				return isCompleted = false;
			}else{
				return isCompleted = true;
			}
		}
	}

}
     
        
 
        
 