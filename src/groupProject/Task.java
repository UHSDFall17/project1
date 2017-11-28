package groupProject;

import java.util.*;
import java.text.SimpleDateFormat;

public class Task {
	
	Scanner sc = new Scanner(System.in);;
	private String note;
	private String description;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private String date;
	private SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy h:mma");
	// private boolean isRepeating = false;
	private boolean isCompleted;
	private String status;
	private ArrayList<String> subtasks = new ArrayList<String>();
	
	protected Task()
	{
		description = "untitled";
		note = "";
		date = "";
		isCompleted = false;
		status = "Incompleted"; 
	}
	
	protected Task(String setDescription, String setNote, String setDate, String setStatus)
	{
		description = setDescription;
		note = setNote;
		date = setDate;
		status = setStatus;
		if(status.equals("Incompleted"))
		{
			isCompleted = false;
		} else {
			isCompleted = true;
		}
	}
	
	protected String getDescription()
	{
		System.out.print("I want to: ");
		description = sc.nextLine();
		
		return description;
	}
	
	protected String description()
	{
		return description;
	}
	
	protected String getNote()
	{
		System.out.print("Enter your note: ");
		note = sc.nextLine();
		return note;
	}
	
	protected String note()
	{
		return note;
	}
	
	protected void addMonth()
	{
		System.out.print("Month(1-12): ");
		int month = sc.nextInt();
		while(month < 1 || month > 12)
		{
			System.err.println("INVALID MONTH");
			System.out.println("Month(1-12): ");
			month = sc.nextInt();
		}
		setMonth(month);
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	protected int month()
	{
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
					System.err.println("INPUT DAY IS OUT OF RANGE");
					System.out.println("ENTER DAY(1-28): ");
					day = sc.nextInt();
				}
			}else {
				System.out.print("DAY(1-29): ");
				day = sc.nextInt();
				while(day < 1 || day > 29)
				{
					System.err.println("INPUT DAY IS OUT OF RANGE");
					System.out.println("DAY(1-29): ");
					day = sc.nextInt();
				}
			}
		}
		
		if(month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)
		{
			System.out.print("Day(1-31): ");
			day = sc.nextInt();
			while(day < 1 || day > 31)
			{
				System.err.println("INPUT DAY IS OUT OF RANGE");
				System.out.println("Day(1-31): ");
				day = sc.nextInt();
			}
		}
		
		if(month == 4||month == 6||month == 9||month == 11)
		{
			System.out.print("DAY(1-30): ");
			day = sc.nextInt();
			while(day < 1 || day > 30)
			{
				System.err.println("INPUT DAY IS OUT OF RANGE");
				System.out.println("Day(1-30): ");
				day = sc.nextInt();
			}
		}
		
		return day;
	}
	
	protected int day()
	{
		return day;
	}	
	
	protected void addYear()
	{
		System.out.print("Year: ");
		int year = sc.nextInt();
		while(year < 2017)
		{
			System.err.println("YEAR CANNOT BE LESS THAN 2017");
			System.out.println("Year: ");
			year= sc.nextInt();
		}
		setYear(year);
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	protected int year()
	{
		return year;
	}	
	
	protected boolean isLeapYear(int year)
	{
		if(year % 4 == 0) 
			return true;
		else
			return false;
	}
	
	protected void addHour()
	{
		System.out.print("Hour(0-23): ");
		int hour = sc.nextInt();
		while(hour < 0 || hour > 23)
		{
			System.err.println("INVALID INPUT");
			System.out.println("Enter Hour(0-23): ");
			hour = sc.nextInt();
		}
		setHour(hour);
	}
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	public int getHour()
	{
		return this.hour;
	}
	
	protected int hour()
	{
		return hour;
	}	
	
	protected void addMinute()
	{
		System.out.print("Minute(0-59): ");
		int minute = sc.nextInt();
		while(minute < 0 || minute > 59)
		{
			System.err.println("INVALID INPUT");
			System.out.println("Minute(0-23): ");
			minute = sc.nextInt();
		}
		
		setMinute(minute);
	}
	
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
	
	public int getMinute()
	{
		return this.minute;
	}
	
	protected int minute()
	{
		return minute;
	}	
	
	protected void setTime()
	{
		addYear();
		addMonth();
		getDay(year, month);
		addHour();
		getMinute();
		setDate(year, month, day, hour, minute);
	}
	
	protected void setDate(int year, int month, int day, int hour, int minute)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day, hour, minute);
		Date taskDate = cal.getTime();
		date = sdf.format(taskDate);
	}
	
	
	protected String date()
	{
		return date;
	}
	
	/*
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
	}*/
	
	protected boolean markCompleted()
	{
		if(isCompleted == false) {
			isCompleted = true;
			status = "Completed";
		} else {
			isCompleted = false;
			status = "Incompleted";
		}
		return isCompleted;
	} 
	
	protected String status()
	{
		return status;
	}
	
	protected void addSubtask()
	{
		System.out.print("Describe your subtask: ");
		String temp = sc.nextLine();
		
		subtasks.add(temp);
		System.out.println("Subtask Created");
	}
	
	protected void displaySubtask()
	{
		String output;
		if(subtasks.isEmpty() == true) {
			System.out.println("There is no subtask");
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
		System.out.print("Index of the subtask you wish to remove: ");
		int i = sc.nextInt();
		
		try {
			subtasks.remove(i-1);
			System.out.println("Subtask Removed");
			
			for(int x = i-1; x <= subtasks.size(); x++){
				subtasks.set(x, subtasks.get(x+1));
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("INDEX IS OUT OF RANGE");
		}
	}
}  