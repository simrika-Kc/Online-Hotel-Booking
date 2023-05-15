package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.AssignRoomControll;
import controller.AssignRoomjdbc;
import controller.Roomjdbc;
import model.Booking;
import model.BookingGL;
import model.Room;

public class AssignRoom extends JInternalFrame implements ActionListener {

	JLabel lblAssign;
	JLabel lblRoom;
	JTextField roomNo;
	SpinnerNumberModel spinnerNumber;
	JButton btnAssign;

	public AssignRoom() {

		this.setSize(320, 230);
		this.setResizable(false);
		this.setLayout(null);

		lblAssign = new JLabel();
		lblAssign.setText("Assign RoomNo");
		lblAssign.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 20));
		lblAssign.setBounds(80, 5, 200, 40);

		lblRoom = new JLabel();
		lblRoom.setText("RoomNo:");
		lblRoom.setFont(new Font("Times new roman", Font.PLAIN, 20));
		lblRoom.setBounds(5, 43, 100, 100);

		roomNo = new JTextField();
		roomNo.setBounds(95, 70, 100, 40);
		roomNo.setFont(new Font("Times new roman", Font.BOLD, 20));

		btnAssign = new JButton();
		btnAssign.setText("Assign");
		btnAssign.setBounds(160, 130, 100, 40);
		btnAssign.setBackground(Color.CYAN);
		btnAssign.setForeground(Color.black);
		btnAssign.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnAssign.setFocusable(false);
		btnAssign.addActionListener(this);

		this.add(btnAssign);
		this.add(roomNo);
		this.add(lblRoom);
		this.add(lblAssign);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAssign) {
			// Get the room number input by the user and create a Room object with it
			Room room = new Room();
			room.setRoom_Id(Integer.parseInt(roomNo.getText()));

			// Call a controller to assign the room to the customer
			AssignRoomControll control = new AssignRoomControll();
			control.assign(room);

			// Check if the room type matches the customer's request and if the room is
			// available
			if (BookingGL.roomtype.equals(BookingGL.roomType)) {
				if (BookingGL.roomStatus.equals("Available")) {

					// If the room is available, assign it to the customer and update the database
					Booking booking = new Booking();
					booking.setBooking_id(BookingGL.managerBookingID);
					booking.setRoom_id(Integer.parseInt(roomNo.getText()));

					AssignRoomjdbc book = new AssignRoomjdbc();
					boolean result = book.updateRoom(booking);
					if (result == true) {
						JOptionPane.showMessageDialog(this, "Successfully assign");
						this.dispose();
						room.setRoom_status("Booked");
						room.setRoom_Id(Integer.parseInt(roomNo.getText()));
						Roomjdbc available = new Roomjdbc();
						boolean res = available.updateroom(room);
						if (res == true) {
						}
					} else {
						JOptionPane.showMessageDialog(this, "Not assigned");
					}
				} else {
					JOptionPane.showMessageDialog(null, "This room is already assigned");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry, the room you assigned is not according to the customer's request");
			}
		}
	}
}