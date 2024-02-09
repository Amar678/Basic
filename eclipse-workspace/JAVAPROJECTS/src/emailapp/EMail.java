package emailapp;

import java.util.Scanner;

public class EMail {
	private String Firstname;
	private String Lastname;
	private String email;
	private String Password;
	private String Department;
	private int MailboxCapacity = 500;
	private String AlternateEmail;
	private int defaultPasswordLength = 10;
	private String CompanySuffix = "amarcompany.com";
	
	public EMail(String firstname, String lastname) {
		this.Firstname = firstname;
		this.Lastname = lastname;
		//System.out.println("Email Created: "+ this.Firstname+" "+ this.Lastname);
		this.Department = setDepartment();
		System.out.println(Department);
		this.Password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: "+ this.Password);
		//generate email
		email = Firstname.toLowerCase()+"."+Lastname.toLowerCase()+"@"+Department+"."+CompanySuffix;
		//System.out.println("Your Email is:"+ email);
		
	}
	private String setDepartment()
	{
		System.out.println("New Worker: "+Firstname+"\nDEPARTMENTS CODES\n1 for sales\n2 for Developement\n3 for Accounting\n0 for none\nenter the department code");
		Scanner s = new Scanner(System.in);
		int deptChoice = s.nextInt();
		if(deptChoice == 1)
		{
			return "sales";
		}
		else if(deptChoice == 2)
		{
			return "dev";
		}
		else if(deptChoice == 3)
		{
			return "Acc";
		}
		else
		{
			return "None";
		}
		
	}
	private String randomPassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i = 0; i<length; i++)
		{
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity)
	{
		this.MailboxCapacity = capacity;
		
	}
	public void setAlternateMail(String altMail)
	{
		this.AlternateEmail = altMail;
	}
	public void changePassword(String password)
	{
		this.Password = password;
	}
	public int getMailboxCapacity()
	{
		return MailboxCapacity;
	}
	public String getAlternateMail()
	{
		return AlternateEmail;
	}
	public String getPassword()
	{
		return Password;
	}
	public String showInfo()
	{
		return "DISPLAY NAME:"+ Firstname+" "+Lastname+"\n"+
		       "COMPANY EMAIL:"+ email+"\n"+
		       "MAILBOX CAPACITY:"+MailboxCapacity+"mb";
	}
}
