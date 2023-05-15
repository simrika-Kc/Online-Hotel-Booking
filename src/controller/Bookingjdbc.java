package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Bill;
import model.Booking;

public class Bookingjdbc {

	// Define a method to insert a booking and bill record into the database
	public boolean insert(Booking booking, Bill bill) {
		// Declare a PreparedStatement object and a boolean variable named result
		PreparedStatement prestat;
		boolean result = false;

		// Define the SQL query to insert a booking record into the database
		String sql = "INSERT INTO bookings(Booking_id, Arrival_date, Departure_date, Room_type, Customer_id, Manager_id, No_Of_Room,Booking_status) VALUES(?,?,?,?,?,?,?,?)";
		try {
			// Establish a database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// Create a PreparedStatement object for the SQL query and specify that you want
			// to retrieve generated keys
			prestat = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// Set the parameter values for the PreparedStatement object
			prestat.setInt(1, booking.getBooking_id());
			prestat.setString(2, booking.getArrival_date());
			prestat.setString(3, booking.getDeparture_date());
			prestat.setString(4, booking.getRoomtype());
			prestat.setInt(5, booking.getCustomer_id());
			prestat.setInt(6, booking.getManager_id());
			prestat.setInt(7, booking.getNo_Of_Room());
			prestat.setString(8, "Requested");

			// Execute the SQL query using the PreparedStatement object
			prestat.executeUpdate();
			// Retrieve the generated keys
			ResultSet res = prestat.getGeneratedKeys();
			int bookingid = 0;
			if (res.next()) {
				bookingid = res.getInt(1);
			}

			// Define the SQL query to insert a bill record into the database
			String insertbill = "INSERT INTO bills(invoiceNo,Total_charge,Booking_id,Payment_status) VALUES (?,?,?,?)";
			// Create a PreparedStatement object for the SQL query
			PreparedStatement preparedstatement = connection.prepareStatement(insertbill);
			// Set the parameter values for the PreparedStatement object
			preparedstatement.setInt(1, bill.getInvoiceNo());
			preparedstatement.setString(2, bill.getTotal_charge());
			preparedstatement.setInt(3, bookingid);
			preparedstatement.setString(4, bill.getPayment_status());

			// Execute the SQL query using the PreparedStatement object
			preparedstatement.executeUpdate();

			// Close the PreparedStatement objects, connection, and result set
			prestat.close();
			preparedstatement.close();
			connection.close();

			// Set result to true
			result = true;
		}
		// Catch any exceptions thrown
		catch (Exception ae) {
			System.out.println("Error: " + ae.getMessage());
			result = false;
		}

		// Return the result
		return result;
	}

	public boolean update(Booking booking) {
		// declare a PreparedStatement and a boolean variable to store the result
		PreparedStatement prestat;
		boolean result = false;
		// declare a String variable to store the SQL query to update a booking
		String sql = "UPDATE bookings SET Arrival_date=?,Departure_date=?,No_Of_Room=? WHERE Booking_id=?;";

		// establish a connection to the database and execute the update query
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			prestat = connection.prepareStatement(sql);
			prestat.setString(1, booking.getArrival_date()); // set the arrival date parameter in the query
			prestat.setString(2, booking.getDeparture_date()); // set the departure date parameter in the query
			prestat.setInt(3, booking.getNo_Of_Room()); // set the number of rooms parameter in the query
			prestat.setInt(4, booking.getBooking_id()); // set the booking ID parameter in the query

			prestat.executeUpdate(); // execute the update query
			connection.close(); // close the database connection

			result = true; // set the result to true if the query was successful
		} catch (Exception e) {
			result = false; // set the result to false if there was an exception
		}

		return result; // return the result
	}

	public boolean delete(Booking booking) {
		// declare a PreparedStatement and a boolean variable to store the result
		PreparedStatement prestat;
		boolean result = false;
		// declare a String variable to store the SQL query to delete a booking
		String sql = "DELETE FROM bookings WHERE Booking_id=?";

		// establish a connection to the database and execute the delete query
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			prestat = connection.prepareStatement(sql);
			prestat.setInt(1, booking.getBooking_id()); // set the booking ID parameter in the query

			prestat.executeUpdate(); // execute the delete query
			connection.close(); // close the database connection

			result = true; // set the result to true if the query was successful
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage()); // print an error message if there was an exception
			result = false; // set the result to false if there was an exception
		}

		return result; // return the result
	}
}
