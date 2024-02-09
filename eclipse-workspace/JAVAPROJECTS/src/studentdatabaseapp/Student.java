package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses = "";
	private int tutionBalance = 0;
	private static int costOfCourse = 600;
	private static int Id = 1000;
	public Student() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the student first name");
		this.firstName = s.nextLine();
		System.out.println("Enter the student last name");
		this.lastName = s.nextLine();
		System.out.println("Enter the class level:\n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior ");
		this.gradeYear = s.nextInt();
		  setstudentId();

	}
	private void setstudentId()
	{
		Id++;
		this.studentId =  gradeYear+ ""+ Id;
	}
	public void enroll()
	{
		do
		{
		System.out.println("Enter course to enroll or Q to quit");
		Scanner s = new Scanner(System.in);
		String course = s.nextLine();
		if(!course.equals("Q"))
		{
			courses = courses + "\n " + course;
			tutionBalance = tutionBalance + costOfCourse;
		}
		else
		{
			break;
		}
		
	  }while(1 != 0);
		
		
	}
	public void viewBalance()
	{
		System.out.println("Your balance is: "+tutionBalance);
	}
	public void payTution()
	{
		viewBalance();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the amount to be paid for your tution fee:");
		int amount = s.nextInt();
		tutionBalance = tutionBalance - amount;
		System.out.println("Thank you for the payment of "+amount);
	}
	public String toString()
	{
		return("Name : "+ firstName+" "+lastName+
				"\nGrade level: "+gradeYear+
				"\nStudent Id : "+studentId+
				"\ncourses Enrolled : " + courses+
				"\nBalance : $"+tutionBalance);
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	static int courseno;
//	static int tution_fee;
//	static int total_courses;
//	public static void main(String args[])
//	{
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the no of students to be added to the database");
//		int n = s.nextInt();
//		String[] Arrayname = new String[n];
//		int[] Arrayyear = new int[n];
//		String[] Arraycourse = new String[5];
//
//		for(int i = 0; i<n; i++)
//		{
//			tution_fee = 0;
//			System.out.println("Enter the  student"+i+ "details");
//			System.out.println("Name:");
//			System.out.println("Year:");
//			String name = s.next();
//			int year = s.nextInt();
//			System.out.println("Enter the total courses to be enrolled for student "+i);
//			total_courses = s.nextInt();
//			
//			Arrayname[i] = name;
//			Arrayyear[i] = year;
//			for(int j = 0;j<total_courses; j++)
//			{
//				
//			 System.out.println("Choose the courses:\n0 History 101\n1 "+"Mathematics 101\n2 "+"English 101\n3 "+"Chemistry 101\n4 "+"Computer Science 101");
//			if(courseno == 0){Arraycourse[i] = "History 101";}
//		    else if(courseno == 1) {Arraycourse[i] = "Mathematics 101";}
//		    else if(courseno == 2) {Arraycourse[i] = "English 101";}
//		    else if(courseno == 3) {Arraycourse[i] = "Chemistry 101";}
//		    else if(courseno == 1) {Arraycourse[i] = "Computer Science 101";}
//		    System.out.println("Enter the course no to be enrolled");
//			courseno = s.nextInt();
//			   tution_fee +=600;
//			}
//		}
//		for(int i = 0; i<n; i++)
//		{
//			System.out.println("Name of the student "+i+" is " +Arrayname[i]);
//			System.out.println("Year of the student "+i+" is " +Arrayyear[i]);
//			System.out.println("You choose "+Arraycourse[i]);
//			System.out.println("Student "+i+" tution fee is: "+tution_fee);
//		}
//		
//		s.close();
//	}
//	

