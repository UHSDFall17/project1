package groupProject;
//Created by James Rodgers
public class Student {
	private String username = "", schoolName = "";
	
	public Student(String username, String emailDomain){
		this.username=username;
		this.schoolName = getSchoolName(emailDomain);
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
	
	private String getSchoolName(String emailDomain)
	{
		String schoolName =  emailDomain.substring(0, emailDomain.indexOf("."));
		return schoolName.toUpperCase();
	}
}