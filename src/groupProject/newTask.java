package com.group1.project1.anyDont;

import java.util.Scanner;


public class newTask {
	
	Scanner sc = new Scanner(System.in);
	
	public String getTask()
	{
		System.out.print("Enter your task: ");
		String taskname = sc.nextLine();
		
		return taskname;
	}
	
	public int getMonth()
	{
		int month;
		System.out.print("Month(1-12): ");
		month = sc.nextInt();
		while(month < 1 || month > 12){
			System.err.println("Input month is out of range");
			System.out.print("Month(1-12): ");
			month = sc.nextInt();
		}
		
		return month;
	}
		
	public int getDay(int month)
	{
		int day;
		if(month == 2)
		{
			System.out.print("Day(1-28): ");
			day = sc.nextInt();
			while(day < 1 || day > 28)
			{
					System.err.println("Input day is out of range");
					System.out.print("Day(1-28): ");
					day = sc.nextInt();
			}
		}else if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			System.out.print("Day(1-30): ");
			day = sc.nextInt();
			while(day < 1 || day > 30)
			{
					System.err.println("Input day is out of range");
					System.out.print("Day(1-31): ");
					day = sc.nextInt();
			}
		}else	{
			System.out.print("Day(1-31): ");
			day = sc.nextInt();
			while(day < 1 || day > 31)
			{
					System.err.println("Input day is out of range");
					System.out.print("Day(1-30): ");
					day = sc.nextInt();
			}
		}
		
		return day;
	}
	
	public int getYear()
	{
		int year;
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
	
	public String getDescription()
	{
		System.out.print("Describe your task: ");
		String description = sc.nextLine();
		
		return description;
	}
}
     
        
 
