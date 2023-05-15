package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import model.CustomerGL;

public class JtableControll {

	public static DefaultTableModel booking() {
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/assisment";
		String userName = "root";
		String passWord = "";
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Booking_id", "customer_id", "Roomtype", "No_Of_Room", "Arrival_date",
				"Departure_date", "Booking_status", "Payment Status" }); // adding column in table
		// query to get data from customer, booking and room table using join
		String sqlQuery = "SELECT bookings.* ,bills.Payment_status FROM bookings JOIN bills ON bookings.Booking_id =bills.Booking_id WHERE bookings.Customer_id =?";

		try {

			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			stmt.setInt(1, CustomerGL.userId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				int Booking_id = rs.getInt("Booking_id");
				String Booking_status = rs.getString("Booking_status");
				String Roomtype = rs.getString("Room_type");
				int No_Of_Room = rs.getInt("No_Of_Room");
				String Arrival_date = rs.getString("Arrival_date");
				String Departure_date = rs.getString("Departure_date");
				String paymentstatus = rs.getString("Payment_status");

				tableModel.addRow(new Object[] { Booking_id, customer_id, Roomtype, No_Of_Room, Arrival_date,Departure_date, Booking_status, paymentstatus });
				
			}

			rs.close();
			conn.close();// closing connection
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}
		return tableModel; // returning the model
	}
}

/*package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import model.CustomerGL;
import view.Jtable;

public class JtableControll {
	DefaultTableModel tableModel;
Timer refress;
	// Constructor that initializes the tableModel variable with the provided
	// argument
	public JtableControll(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	// A method named loadData that is defined as public and returns void is
	// declared
	public void loadData() {
		try {
			// A connection to the database is established
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			// A SQL query is defined and a PreparedStatement is created
			String sql = "SELECT bookings.* ,bills.Payment_status FROM bookings JOIN bills ON bookings.Booking_id =bills.Booking_id WHERE bookings.Customer_id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			// The value of the parameter in the query is set using the CustomerGL.userId
			// variable
			pstat.setInt(1, CustomerGL.userId);
			// The query is executed and the result set is obtained
			ResultSet rs = pstat.executeQuery();
			// Rows are iterated over and added to the tableModel
			while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				int Booking_id = rs.getInt("Booking_id");
				String Booking_status = rs.getString("Booking_status");
				String Roomtype = rs.getString("Room_type");
				int No_Of_Room = rs.getInt("No_Of_Room");
				String Arrival_date = rs.getString("Arrival_date");
				String Departure_date = rs.getString("Departure_date");
				String paymentstatus = rs.getString("Payment_status");
				tableModel.addRow(new Object[] { Booking_id, customer_id, Roomtype, No_Of_Room, Arrival_date,Departure_date, Booking_status, paymentstatus });
			
				
			}
			// The result set, PreparedStatement and connection are closed
			rs.close();
			pstat.close();
			conn.close();
		}
		// An exception is caught if an error occurs and a message is printed to the
		// console
		catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
}*/