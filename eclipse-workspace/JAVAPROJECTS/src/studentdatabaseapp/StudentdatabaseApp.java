package studentdatabaseapp;

import java.util.Scanner;

public class StudentdatabaseApp {

	public static void main(String[] args) {
		
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of students to enroll");
        int numOfStudents = s.nextInt();
        Student[] students = new Student[numOfStudents];
        for(int i=0;i<numOfStudents;i++)
        {
        	students[i] = new Student();
        	students[i].enroll();
        	students[i].payTution();
            
        }
        for(int i=0;i<numOfStudents;i++)
        {
        	System.out.println(students[i].toString());
        }
        
	}

}
