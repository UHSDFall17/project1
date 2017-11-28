package groupProject;
//Created by James Rodgers
public class Student {
	private String username = "", schoolName = "";
	
	public Student(String username, String emailDomain){
		this.username=username;
		setSchoolName(emailDomain);
	}
	
	public Student(){
		this.username="UNKNOWN";
		this.schoolName = "UNKNOWN";
	}
	
	public void StudentGreetings()
	{
		System.out.println("Good Morning " + username + "                     " + schoolName);
		if(schoolName.equals("UH"))
		{
			System.out.println("GO COOGS!!!");
		}
		else if(schoolName.equals("UT"))
		{
			System.out.println("Hook 'em Horns");
		}
	}
	
	public void setSchoolName(String emailDomain)
	{
		this.schoolName =  emailDomain.substring(0, emailDomain.indexOf("."));
		this.schoolName = this.schoolName.toUpperCase();
	}
	
	public String getSchoolName()
	{
		return this.schoolName;
	}
}
