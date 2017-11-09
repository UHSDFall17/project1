package com.group1.project1.anyDont;

import java.util.Scanner;
import java.util.Date;
import java.util.Calender;
import java.text.SimpleDateFormat;

public class CreateTask {
	
	Scanner sc = new Scanner(System.in);
	private String note;
	private String description;
	private int year;
	private int month;
	private int day;
	private String date;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	private bool isRepeating = false;
	private bool isCompleted = false;
	
	
	public string getTask()
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
		
	public int getDay(int month)
	{
		if(month = 2)
		{
			System.out.print("Day(1-28): ");
			day = sc.nextInt();
			while(day < 1 || day > 28)
			{
					System.err.println("Input is out of range");
					System.out.print("Day(1-28): ");
					day = sc.nextInt();
			}
		}else if(month = (1||3||5||7||8||10||12))
		{
			System.out.print("Day(1-31: ");
			day = sc.nextInt();
			while(day < 1 || day > 31
			{
					System.err.println("Input is out of range");
					System.out.print("Day(1-31): ");
					day = sc.nextInt();
			}
		}else	{
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
	
	public int setDate(int year, int month, int day)
	{
		Calender cal = Calender.getInstance();
		cal.set(year, month, day);
		Date taskDate = cal.getTime();
		date = sdf.format(taskDate);
	}

}
     
        
 