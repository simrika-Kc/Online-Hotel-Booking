package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.ManagerModel;

public class Managerjdbc {
	// The insert method takes a ManagerModel object as a parameter and returns a
	// boolean value.
	public boolean insert(ManagerModel manager) {
		boolean result = false;
		PreparedStatement prestat;
		String sql = "INSERT INTO managers(Manager_id, First_name, Location, Email, Username, Password, Last_name) VALUES(?,?,?,?,?,?,?)";

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			prestat = connection.prepareStatement(sql);
			// The values of the ManagerModel object properties are set to the corresponding
			// columns in the managers table using the prestat object.
			prestat.setInt(1, manager.getManager_id());
			prestat.setString(2, manager.getFirst_name());
			prestat.setString(4, manager.getEmail());
			prestat.setString(3, manager.getLocation());
			prestat.setString(5, manager.getUsername());
			prestat.setString(6, manager.getPassword());
			prestat.setString(7, manager.getLast_name());

			prestat.executeUpdate();
			prestat.close();
			connection.close();
			result = true;
		}

		catch (Exception ae) {
			System.out.println("Error:" + ae.getMessage());
			result = false;
		}
		return result;
	}
}