package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import controller.Bookingjdbc;
import controller.Roomjdbc;
import model.Bill;
import model.Booking;
import model.CustomerGL;
import model.Room;

public class BookingPage extends JFrame implements ActionListener {
	// declare
	JLabel lblHeading;
	JLabel lblCheckin;
	JLabel lblCheckout;
	JLabel lblAdults;
	JLabel lblChild;
	JLabel lblRooms;
	JSpinner spinner;
	JDateChooser checkinField;
	JDateChooser checkoutField;
	JLabel lblRoom;
	JButton btnBook;
	JButton btnBack;
	ImageIcon image;
	JLabel lblImage;
	JLabel lblNote;
	static JTextField fieldRoom;
	SpinnerNumberModel spinnerNumber;
	JLabel roomPrice;
	static JTextField fieldPrice;
	int numberOfRooms;

	public BookingPage() {

		this.setSize(500, 400);
		this.setLayout(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);// remove cross button from frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		lblHeading = new JLabel();
		lblHeading.setText("Hotel Booking");
		lblHeading.setBounds(150, -20, 230, 100);// setting place for this lblheading
		lblHeading.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 35));
		lblHeading.setForeground(Color.white);// changing textcolor

		lblCheckin = new JLabel();
		lblCheckin.setText("Check_in:");
		lblCheckin.setBounds(0, 60, 150, 60);
		lblCheckin.setFont(new Font("Times new roman", Font.BOLD, 25));
		lblCheckin.setForeground(Color.white);// changing textcolor

		Date newDate = new Date();
		checkinField = new JDateChooser();
		checkinField.setMinSelectableDate(newDate);
		checkinField.setBounds(105, 70, 130, 35);
		checkinField.setDateFormatString("yyyy-MM-dd");

		lblCheckout = new JLabel();
		lblCheckout.setText("Check_out:");// setting text
		lblCheckout.setBounds(265, 180, 160, 60);
		lblCheckout.setFont(new Font("Times new roman", Font.BOLD, 25));// changing font of text
		lblCheckout.setForeground(Color.white);

		checkoutField = new JDateChooser();// for choosing date like calender
		checkoutField.setBounds(385, 195, 110, 35);
		checkoutField.setMinSelectableDate(newDate);
		checkoutField.setDateFormatString("yyyy-MM-dd");

		lblRooms = new JLabel();
		lblRooms.setText("Room_type:");
		lblRooms.setBounds(0, 180, 150, 60);
		lblRooms.setFont(new Font("Times new roman", Font.BOLD, 25));
		lblRooms.setForeground(Color.white);

		fieldRoom = new JTextField();
		fieldRoom.setBounds(125, 195, 120, 35);
		fieldRoom.setEditable(false);

		lblRoom = new JLabel();
		lblRoom.setText("No.Of Room:");
		lblRoom.setBounds(285, 70, 160, 35);
		lblRoom.setFont(new Font("Times new roman", Font.BOLD, 25));
		lblRoom.setForeground(Color.white);

		spinnerNumber = new SpinnerNumberModel(0, 0, 10, 1);// number will start from zero and max will be upto 10
		spinner = new JSpinner(spinnerNumber);
		spinner.setBounds(425, 70, 50, 35);

		roomPrice = new JLabel();
		roomPrice.setText("Room Charge:");
		roomPrice.setBounds(130, 120, 200, 60);
		roomPrice.setFont(new Font("Times new roman", Font.BOLD, 25));
		roomPrice.setForeground(Color.white);

		fieldPrice = new JTextField();
		fieldPrice.setText("");
		fieldPrice.setBounds(290, 135, 80, 35);
		fieldPrice.setEditable(false);

		btnBook = new JButton();
		btnBook.setText("Book");
		btnBook.setBounds(260, 340, 100, 40);
		btnBook.setBackground(Color.blue);
		btnBook.setForeground(Color.white);
		btnBook.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnBook.setFocusable(false);
		btnBook.addActionListener(this);

		btnBack = new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(375, 340, 100, 40);
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);

		image = new ImageIcon("Book.jpg");// inserting image
		lblImage = new JLabel();
		lblImage.setIcon(image);
		lblImage.setBounds(0, 0, 500, 330);

		lblNote = new JLabel();
		lblNote.setText("Note: Room charge is in dollar.");
		lblNote.setBounds(225, 80, 300, 200);
		lblNote.setFont(new Font("Times new roman", Font.ITALIC, 17));
		lblNote.setForeground(Color.white);

		lblImage.add(lblNote);
		this.add(lblImage);
		this.add(btnBack);
		this.add(btnBook);
		lblImage.add(fieldPrice);
		lblImage.add(roomPrice);
		lblImage.add(spinner);
		lblImage.add(lblRoom);
		lblImage.add(lblRooms);
		lblImage.add(fieldRoom);
		lblImage.add(checkinField);
		lblImage.add(lblHeading);
		lblImage.add(lblCheckin);
		lblImage.add(lblCheckout);
		lblImage.add(checkoutField);

		this.setVisible(true);

	}

	public static void single(String single, String singlePrice) {
		// making room price and room type same and unchangable for single room
		fieldRoom.setText(single);
		fieldPrice.setText(singlePrice);
	}

	public static void roomDouble(String roomdouble, String doublePrice) {
		// making room price and room type same and unchangable for double room
		fieldRoom.setText(roomdouble);
		fieldPrice.setText(doublePrice);
	}

	public static void twin(String twin, String twinPrice) {
		// making room price and room type same and unchangable for twin room
		fieldRoom.setText(twin);
		fieldPrice.setText(twinPrice);
	}

	public static void main(String[] args) {
		new BookingPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack) {
			this.dispose();
		} else if (e.getSource() == btnBook) {
			String dateIn = ((JTextField) checkinField.getDateEditor().getUiComponent()).getText();
			if (dateIn.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter checkin date");
			}
			numberOfRooms = (int) spinner.getValue();

			String dateOut = ((JTextField) checkoutField.getDateEditor().getUiComponent()).getText();
			if (dateOut.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter checkout date");
			}

			if (numberOfRooms == 0) {
				JOptionPane.showMessageDialog(this, "Please enter the number of rooms you want.");
			}

			else {
				// selecting date in the form of yyyy-MM-dd
				String dateIn1 = ((JTextField) checkinField.getDateEditor().getUiComponent()).getText();
				String dateOut1 = ((JTextField) checkoutField.getDateEditor().getUiComponent()).getText();
				String totalCharge = Integer.toString((numberOfRooms)* Integer.parseInt(fieldPrice.getText()));
				
				Booking booking = new Booking();
				Bill bill = new Bill();
				Room room = new Room();
				booking.setArrival_date(dateIn1);
				booking.setDeparture_date(dateOut1);
				booking.setNo_Of_Room((Integer) spinnerNumber.getValue());// this will show the choosing number in the
																			// corner
				booking.setRoomtype(fieldRoom.getText());

				room.setRoom_Charge(fieldPrice.getText());
				room.setRoom_type(fieldRoom.getText());
				booking.setCustomer_id(CustomerGL.userId);
				
				bill.setTotal_charge(totalCharge);
				
				Bookingjdbc bookingjDbc = new Bookingjdbc();// making object of Bookingjdbc from controllers
				boolean result = bookingjDbc.insert(booking, bill);

				Roomjdbc roomjdbc = new Roomjdbc();
				boolean res = roomjdbc.insertroom(room);

				if (result == true) {

					if (res == true) {
						JOptionPane.showMessageDialog(this, "Requested");
						this.dispose();
					}
				} else {

					JOptionPane.showMessageDialog(this, "sorry!");

				}
			}

		}
	}
}
