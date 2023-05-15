package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Booking;

public class AssignRoomjdbc {

	public boolean updateRoom(Booking booking) { // The Booking class is called from the model
		PreparedStatement prestat;
		boolean result = false;
		String sql = "UPDATE bookings SET Room_id=? WHERE Booking_id=?;"; // query to update the "Room_id"
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			prestat = connection.prepareStatement(sql);
			prestat.setInt(1, booking.getRoom_id()); // Setting the first parameter (room ID) in the SQL query to the
														// room ID of the specified booking
			prestat.setInt(2, booking.getBooking_id()); // Setting the second parameter (booking ID) in the SQL query to
														// the booking ID of the specified booking

			// Executing the SQL query to update the "Room_id" column of the "bookings"
			// table
			prestat.executeUpdate();
			connection.close(); // Closing the connection to the database

			result = true; // Setting the result flag to true
		} catch (Exception e) {
			result = false; // Setting the result flag to false if an exception occurs
		}
		return result; // Returning the result flag
	}

	// Method for accepting a booking
	public boolean acceptBooking(Booking booking) { // The Booking class is called from the model
		PreparedStatement prestat;
		boolean result = false;
		String sql = "UPDATE bookings SET Booking_status=? WHERE Booking_id=?;"; // SQL query to update the
																					// "Booking_status" column of the
																					// "bookings" table with "Accepted"
																					// for a specific booking ID
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");// connecting
																														// to
																														// database
			prestat = connection.prepareStatement(sql);
			prestat.setString(1, "Accepted"); // Setting the first parameter (booking status) in the SQL query to
												// "Accepted"
			prestat.setInt(2, booking.getBooking_id()); // Setting the second parameter (booking ID) in the SQL query to
														// the booking ID of the specified booking

			// Executing the SQL query to update the "Booking_status" column of the
			// "bookings" table
			prestat.executeUpdate();
			connection.close(); // Closing the connection to the database

			result = true; // Setting the result flag to true
		} catch (Exception e) {
			result = false; // Setting the result flag to false if an exception occurs
		}
		return result; // Returning the result flag
	}
}
