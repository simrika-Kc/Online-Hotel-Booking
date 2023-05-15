package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Bill;
import model.BookingGL;

public class GenerateBillJdbc {
	// This method generates a bill for a booking by updating the total charge in
	// the bills table
	public boolean generateBill(Bill bill) {
		PreparedStatement prestat;
		boolean result = false;
		String sql = "UPDATE bills SET Total_charge=? WHERE Booking_id=?";
		try {
			// Establishing connection to the database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// Preparing the SQL statement with placeholders
			prestat = connection.prepareStatement(sql);
			// Setting the values for the placeholders
			prestat.setString(1, bill.getTotal_charge());
			prestat.setInt(2, BookingGL.billBookingID);
			// Executing the update statement
			prestat.executeUpdate();
			// Closing the connection to the database
			connection.close();
			result = true;
		} catch (Exception ae) {
			// Handling any exceptions and printing error message
			System.out.println("Error: " + ae.getMessage());
			result = false;
		}

		return result;
	}
}