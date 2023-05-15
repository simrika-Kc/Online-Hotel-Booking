package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import model.BookingGL;
import model.CustomerGL;

public class ManagerJTable {
	
	public static  DefaultTableModel loadData() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Booking_id", "Roomtype", "No_Of_Room", "Arrival_date", "Departure_date",
				"Booking_status ", "RoomNo" });
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			String sql = "SELECT * FROM bookings";
			PreparedStatement pstat = conn.prepareStatement(sql);
		
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int Booking_id = rs.getInt("Booking_id");
				String Booking_status = rs.getString("Booking_status");
				String Roomtype = rs.getString("Room_type");
				int No_Of_Room = rs.getInt("No_Of_Room");
				String Arrival_date = rs.getString("Arrival_date");
				String Departure_date = rs.getString("Departure_date");
				String RoomNo = rs.getString("Room_id");
				// Adds a new row of data to the tableModel with the values in the variables.
				tableModel.addRow(new Object[] { Booking_id, Roomtype, No_Of_Room, Arrival_date, Departure_date,
						Booking_status, RoomNo });
			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return tableModel;
	}

	// Method to load available room data into the table.
	public static DefaultTableModel loadData1() {
		DefaultTableModel tableModel1 = new DefaultTableModel();
		tableModel1.setColumnIdentifiers(new String[] {"Room_No", "Room_type", "Room_status "});
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assisment", "root", "");
			String sql = "SELECT * FROM rooms ";
			PreparedStatement pstat = conn.prepareStatement(sql);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String Room_status = rs.getString("Room_status");
				String Roomtype = rs.getString("Room_type");
				String RoomNo = rs.getString("Room_id");
				// //Adds a new row of data to the tableModel with the values in the variables.
				tableModel1.addRow(new Object[] { RoomNo, Roomtype, Room_status });

			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return tableModel1;

	}
}
