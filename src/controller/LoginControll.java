package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Customer;

public class LoginControll {

	// Define a method named login which takes a Customer object as input and
	// returns a Customer object as output
	public Customer login(Customer customerInfo) {
		// Declare necessary variables
		PreparedStatement prestat;
		String sql = "SELECT * FROM customers WHERE Username=? AND Password=?";
		Connection conn;
		ResultSet res;
		String url = "jdbc:mysql://localhost:3306/assisment";
		String username = "root";
		String password = "";

		try {
			// Get a connection to the database using the specified URL, username, and
			// password
			conn = DriverManager.getConnection(url, username, password);
			// Prepare a statement using the specified SQL query
			prestat = conn.prepareStatement(sql);
			// Set the values of the parameters in the prepared statement
			prestat.setString(1, customerInfo.getUsername());
			prestat.setString(2, customerInfo.getPassword());
			// Execute the query and get the result set
			res = prestat.executeQuery();
			// Retrieve the customer information from the result set and store it in the
			// customerInfo object
			while (res.next()) {
				customerInfo.setCustomer_id(res.getInt("customer_id"));
				customerInfo.setCustomer_type(res.getString("Customer_type"));
				customerInfo.setEmail(res.getString("Email"));
				customerInfo.setFirst_name(res.getString("First_name"));
				customerInfo.setGender(res.getString("Gender"));
				customerInfo.setLast_name(res.getString("Last_name"));
				customerInfo.setLocation(res.getString("Location"));
				customerInfo.setMobile(res.getString("Mobile"));
				customerInfo.setUsername(res.getString("Username"));
				customerInfo.setPassword(res.getString("Password"));

			}

		} catch (Exception ae) {
			// by print the error message
			System.out.println("Error: " + ae.getMessage());

		}
		// Return the customerInfo object
		return customerInfo;

	}

}
