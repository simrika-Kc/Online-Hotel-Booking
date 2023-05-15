package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Customer;

public class Customerjdbc {
	// This method inserts a new customer into the database and returns a boolean
	// value based on the success of the operation
	public boolean insert(Customer customer) {
		boolean result = false;
		PreparedStatement prestat;
		// This is the SQL statement to insert a new customer into the database
		String sql = "INSERT INTO customers(customer_id, First_name, Location, Email, Mobile, Username, Password, Gender, Customer_type, Last_name,Company_Name,Card_Number,Card_type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// This creates a connection to the database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// This creates a prepared statement from the SQL statement with the given
			// values inserted
			prestat = connection.prepareStatement(sql);
			prestat.setInt(1, customer.getCustomer_id());
			prestat.setString(2, customer.getFirst_name());
			prestat.setString(3, customer.getLocation());
			prestat.setString(4, customer.getEmail());
			prestat.setString(5, customer.getMobile());
			prestat.setString(6, customer.getUsername());
			prestat.setString(7, customer.getPassword());
			prestat.setString(8, customer.getGender());
			prestat.setString(9, customer.getCustomer_type());
			prestat.setString(10, customer.getLast_name());
			prestat.setString(11, customer.getCard_Number());
			prestat.setString(12, customer.getCard_type());
			prestat.setString(13, customer.getCompany_name());

			// This executes the prepared statement to insert the customer into the database
			prestat.executeUpdate();
			// This closes the prepared statement and the database connection
			prestat.close();
			connection.close();
			// This sets the result to true, indicating that the operation was successful
			result = true;
		} catch (Exception ae) {
			// This prints out an error message if an exception is caught, indicating that
			// the operation was unsuccessful
			System.out.println("Error: " + ae.getMessage());
			result = false;
		}

		// This returns the result of the operation, either true or false
		return result;
	}

}
