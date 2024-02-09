package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

public class Patient {
	private Connection connection;
	private Scanner scanner;
		public Patient(Connection connection, Scanner scanner)
		{
			this.connection = connection;
			this.scanner = scanner;
		}
		
		public void addPatient()
		{
			System.out.println("Enter patient name");
			String name = scanner.next();
			System.out.println("Enter patient age");
			int age = scanner.nextInt();
			System.out.println("Enter the patient gender");
			String gender = scanner.next();
			
			 try {
				 String query = "Insert into patients(name, age, gender) values(?,?,?)";
				 PreparedStatement pst = connection.prepareStatement(query);
				 pst.setString(1, name);
				 pst.setInt(2, age);
				 pst.setString(3, gender);
				 int affectedrows = pst.executeUpdate();
				 if(affectedrows>0)
				 {
					 System.out.println("Patient Added Successfully");
				 }
				 else
				 {
					 System.out.println("Failed to add patient");
				 }
				 
			 }catch(SQLException e)
			 { 
				 e.printStackTrace();
			 }
		}
		public void viewPatient() {
		    String query = "SELECT * FROM patients";
		    try (PreparedStatement pst = connection.prepareStatement(query);
		         ResultSet rs = pst.executeQuery()) {
		        
		        System.out.println("Patients");
		        System.out.println("PatientID\tName\t\tAge\tGender");
		        System.out.println("-----------------------------------------");
		        
		        while (rs.next()) {
		            int id = rs.getInt("id");
		            String name = rs.getString("name");
		            int age = rs.getInt("age");
		            String gender = rs.getString("gender");
		            
		            System.out.printf("%d\t%-15s\t%d\t%s%n", id, name, age, gender);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public boolean getPatientbyId(int id) 
		{
			String query = "select * from patients where id = ?";
			try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				return true;
			}else
			{
				return false;
			}
			}catch(SQLException e)
			{
				e.printStackTrace();
				
			}
			return false;
		}
}
		