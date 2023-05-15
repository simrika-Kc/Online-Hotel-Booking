package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Booking;
import model.Room;

public class Roomjdbc {
	// Define a public boolean method called insertroom that takes a Room object as
	// parameter
	public boolean insertroom(Room room) {

		// Declare and initialize variables
		PreparedStatement prestat;
		boolean result = false;
		String sql = "INSERT INTO rooms( Room_type,Room_charge,Room_status) VALUES(?,?,?)";

		// Try block to establish connection and execute SQL query
		try {
			// Establish database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// Prepare SQL statement
			prestat = connection.prepareStatement(sql);
			// Set values for the parameters in the prepared statement
			prestat.setString(1, room.getRoom_type());
			prestat.setString(2, room.getRoom_Charge());
			prestat.setString(3, "Available");
			// Execute update query
			prestat.executeUpdate();
			// Close database connection
			connection.close();
			result = true;
		}

		// Catch block to handle exceptions
		catch (Exception ae) {
			// Print error message
			System.out.println("Error: " + ae.getMessage());
			// Set result to false
			result = false;
		}

		// Return the result
		return result;
	}

	// Define a public boolean method called updateroom that takes a Room object as
	// parameter
	public boolean updateroom(Room room) {

		// Declare and initialize variables
		PreparedStatement prestat;
		boolean result = false;
		String sql = "UPDATE rooms SET Room_Status=? WHERE Room_id=?";

		// Try block to establish connection and execute SQL query
		try {
			// Establish database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// Prepare SQL statement
			prestat = connection.prepareStatement(sql);
			// Set values for the parameters in the prepared statement
			prestat.setString(1, "Booked");
			prestat.setInt(2, room.getRoom_Id());
			// Execute update query
			prestat.executeUpdate();
			// Close database connection
			connection.close();
			result = true;
		}

		// Catch block to handle exceptions
		catch (Exception ae) {
			// Print error message
			System.out.println("Error: " + ae.getMessage());
			// Set result to false
			result = false;
		}

		// Return the result
		return result;
	}

}
