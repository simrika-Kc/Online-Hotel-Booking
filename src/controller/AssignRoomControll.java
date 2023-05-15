package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookingGL;
import model.Room;

public class AssignRoomControll {
	public static boolean assign(Room room) {
		PreparedStatement prestat;
		String sql = "SELECT * FROM rooms WHERE Room_Id=?";
		Connection conn;
		ResultSet res;
		String url = "jdbc:mysql://localhost:3306/assisment";
		String username = "root";
		String password = "";
		boolean result = false;
		try {

			// connecting to a database
			conn = DriverManager.getConnection(url, username, password);
			// Prepare a statement
			prestat = conn.prepareStatement(sql);
			// Set the values of the parameters in the prepared statement

			prestat.setInt(1, room.getRoom_Id());
			// Execute the query and get the result set
			res = prestat.executeQuery();
			// Retrieve the customer information from the result set and store it in the
			// customerInfo object

			while (res.next()) {
				String roomType = res.getString("Room_type");
				String roomStatus = res.getString("Room_status");
				BookingGL.roomType = roomType;
				BookingGL.roomStatus = roomStatus;

			}
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());

		}
		return result;
	}
}