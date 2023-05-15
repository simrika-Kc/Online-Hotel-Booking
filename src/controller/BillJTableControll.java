package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import model.Bill;
import model.BookingGL;
import model.Room;

public class BillJTableControll {
	


	public DefaultTableModel loadDataBill() {
		DefaultTableModel tableModelBill = new DefaultTableModel();
		try {
			tableModelBill.setColumnIdentifiers(new String[] {"Invoice No", "Booking Id", "Bill Date", "Total Charge"});
			// connecting to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");

			// Defining SQL query to select all data from the "bills" table
			String sql = "SELECT * FROM bills";

			// Creating a PreparedStatement object to execute the SQL query
			PreparedStatement pstat = conn.prepareStatement(sql);

			// Executing the query and retrieving the result set
			ResultSet rs = pstat.executeQuery();

			// Looping through the result set and adding each row to the table model
			while (rs.next()) {
				int invoiceNo = rs.getInt("invoiceNo"); // Getting the value of the "invoiceNo" column for the row
				int Booking_id = rs.getInt("Booking_id"); // Getting the value of the "Booking_id" column for the row
				String Bill_date = rs.getString("Bill_date"); // Getting the value of the "Bill_date" column for the row
				String Total_charge = rs.getString("Total_charge"); // Getting the value of the "Total_charge" column
																	// for the row
				String Payment_status = rs.getString("Payment_status"); // Getting the value of the "Payment_status"
																		// column for the row
				tableModelBill.addRow(new Object[] { invoiceNo, Booking_id, Bill_date, Total_charge, Payment_status }); // Adding
																														// a
																														// new
																														// row
																														// to
																														// the
																														// table
																														// model
																														// with
																														// the
																														// retrieved
																														// values
			}

			// Closing the result set, statement, and connection
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			// If an exception occurs it prints an error message
			System.out.println("Error : " + ex.getMessage());
		}
		return tableModelBill;
	}
}
