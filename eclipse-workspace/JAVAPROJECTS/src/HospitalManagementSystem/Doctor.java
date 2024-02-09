package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
	private Connection connection;
		public Doctor(Connection connection)
		{
			this.connection = connection;
		}
		
		public void viewDoctor() {
		    String query = "SELECT * FROM doctors";
		    try (PreparedStatement pst = connection.prepareStatement(query);
		         ResultSet rs = pst.executeQuery()) {
		        
		        System.out.println("Doctors");
		        System.out.println("DoctorID\tName\t\tSpecialization");
		        System.out.println("-----------------------------------------");
		        
		        while (rs.next()) {
		            int id = rs.getInt("id");
		            String name = rs.getString("name"); 
		            String specialization = rs.getString("specialization");
		            System.out.printf("%s\t%-15s\t%s\t", id, name, specialization);

		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public boolean getDoctorbyId(int id) 
		{
			String query = "select * from doctors where id = ?";
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
