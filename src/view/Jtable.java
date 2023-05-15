package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.Bookingjdbc;
import controller.JtableControll;
import model.Booking;
import model.BookingGL;
import model.Room;

public class Jtable extends JFrame implements ActionListener, ListSelectionListener {
	JPanel panelNorth;
	JPanel panelCenter;
	JPanel panelWhite;
	ImageIcon imgLogo;
	JLabel lblLogo;
	JButton btnAdd;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnBack;
	JTable tableAdd;
	DefaultTableModel tableModel;
	JScrollPane scroll;
	JLabel lblRoomNo;
	SpinnerNumberModel spinnerNumber;
	JSpinner spinner;
	JLabel lblRoomType;
	JTextField fieldRoomNo;
	JComboBox combo;
	JDateChooser checkinField;
	JDateChooser checkoutField;
	JLabel lblCheckin;
	JLabel lblCheckout;
	Timer refresh;

	public Jtable() {
		this.setSize(1100, 700);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		imgLogo = new ImageIcon("logo1.jpg");
		lblLogo = new JLabel();
		lblLogo.setIcon(imgLogo);
		lblLogo.setBounds(10, 10, 150, 100);

		panelCenter = new JPanel();
		panelCenter.setBackground(Color.lightGray);
		panelCenter.setLayout(null);
		// panelCenter.setBounds(0, 135, 1525, 800);

		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(1600, 124));
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		panelWhite = new JPanel();
		panelWhite.setBackground(Color.white);
		panelWhite.setBounds(10, 10, 1050, 350);
		panelWhite.setLayout(null);
		panelWhite.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

		btnUpdate = new JButton();
		btnUpdate.setText("Update booking");
		btnUpdate.setBounds(285, 610, 200, 40);
		btnUpdate.setBackground(Color.cyan);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setFocusable(false);
		btnUpdate.addActionListener(this);

		btnDelete = new JButton();
		btnDelete.setText("Delete booking");
		btnDelete.setBounds(520, 610, 200, 40);
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.white);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(this);

		btnBack = new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(950, 40, 105, 40);
		btnBack.setBackground(Color.red);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);

		tableAdd = new JTable();
		tableModel = new DefaultTableModel();
		tableAdd.setModel(tableModel);
		Object[] columnNames = { "Booking_id", "customer_id", "Roomtype", "No_Of_Room", "Arrival_date",
				"Departure_date", "Booking_status", "Payment Status" };
		tableModel.setColumnIdentifiers(columnNames);
		tableAdd.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableAdd.setModel(tableModel);
		tableAdd.setFillsViewportHeight(true);
		scroll = new JScrollPane(tableAdd);
		scroll.setViewportView(tableAdd);
		scroll.setBounds(10, 10, 1000, 300);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		tableAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableAdd.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int Value = tableAdd.getSelectedRow();
					if (Value != -1) {
						String booking_id = tableAdd.getValueAt(Value, 0).toString();

						BookingGL.bookingId = Integer.parseInt(booking_id);

						// System.out.println(BookingGL.bookingId);

					}
				}
			}
		});

		// JtableControll controller = new JtableControll();
		tableModel = JtableControll.booking();
		tableAdd.setModel(tableModel);

		lblRoomNo = new JLabel();
		lblRoomNo.setText("Number of room :");
		lblRoomNo.setBounds(65, 180, 200, 435);
		lblRoomNo.setFont(new Font("Times new roman", Font.BOLD, 20));
		lblRoomNo.setForeground(Color.black);

		spinnerNumber = new SpinnerNumberModel(0, 0, 10, 1);// number will start from zero and max will be upto 10
		spinner = new JSpinner(spinnerNumber);
		spinner.setBounds(230, 383, 60, 35);
		spinner.setFont(new Font("Times new roman", Font.BOLD, 20));

		lblRoomType = new JLabel();
		lblRoomType.setText("room type :");
		lblRoomType.setBounds(305, 380, 150, 35);
		lblRoomType.setFont(new Font("Times new roman", Font.BOLD, 20));
		lblRoomType.setForeground(Color.black);

		String type[] = { "Single ", "Double", "Twin" };
		combo = new JComboBox(type);
		combo.setFont(new Font("Times new roman", Font.BOLD, 20));
		combo.setBounds(410, 382, 100, 40);
		combo.addActionListener(this);

		lblCheckin = new JLabel();
		lblCheckin.setText("Check_in:");
		lblCheckin.setBounds(530, 370, 150, 60);
		lblCheckin.setFont(new Font("Times new roman", Font.BOLD, 20));
		lblCheckin.setForeground(Color.black);// changing textcolor

		Date newDate = new Date();
		checkinField = new JDateChooser();
		checkinField.setMinSelectableDate(newDate);
		checkinField.setBounds(625, 382, 130, 35);
		checkinField.setDateFormatString("yyyy-MM-dd");

		lblCheckout = new JLabel();
		lblCheckout.setText("Check_out:");// setting text
		lblCheckout.setBounds(775, 368, 160, 60);
		lblCheckout.setFont(new Font("Times new roman", Font.BOLD, 20));// changing font of text
		lblCheckout.setForeground(Color.black);

		checkoutField = new JDateChooser();// for choosing date like calender
		checkoutField.setBounds(875, 380, 110, 35);
		checkoutField.setMinSelectableDate(newDate);
		checkoutField.setDateFormatString("yyyy-MM-dd");

		panelCenter.add(checkinField);
		panelCenter.add(lblCheckin);
		panelCenter.add(lblCheckout);
		panelCenter.add(checkoutField);
		panelCenter.add(combo);
		panelCenter.add(lblRoomType);
		panelCenter.add(spinner);
		panelCenter.add(lblRoomNo);
		panelWhite.add(scroll);
		this.add(btnBack);
		this.add(btnDelete);
		this.add(btnUpdate);
		panelCenter.add(panelWhite);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(lblLogo);
		this.setVisible(true);

		refresh = new Timer(1500, e -> {
			tableModel = JtableControll.booking();
			tableAdd.setModel(tableModel);
		});
		refresh.start();
	}

	@Override
	public void dispose() {
		refresh.stop();
		super.dispose();
	}

	public static void main(String args[]) {
		new Jtable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack) {
			this.dispose();
		} else if (e.getSource() == btnDelete) {
			Booking booking = new Booking();
			booking.setBooking_id(BookingGL.bookingId);
			Bookingjdbc book = new Bookingjdbc();
			boolean result = book.delete(booking);
			if (result == true) {
				JOptionPane.showMessageDialog(this, "Successfully deleted");

			} else {
				JOptionPane.showMessageDialog(this, "Not Deleted");
			}
		} else if (e.getSource() == btnUpdate) {

			Room room = new Room();
			int roomCost = 0;

			String selectedRoom = (String) combo.getSelectedItem();
			if (selectedRoom.equals("Single")) {
				roomCost = 29;
			} else if (selectedRoom.equals("Double")) {
				roomCost = 35;
			} else if (selectedRoom.equals("Twin")) {
				roomCost = 35;
			}

			Booking booking = new Booking();
			String dateIn = ((JTextField) checkinField.getDateEditor().getUiComponent()).getText();
			String dateOut = ((JTextField) checkoutField.getDateEditor().getUiComponent()).getText();
			booking.setArrival_date(dateIn);
			booking.setDeparture_date(dateOut);
			booking.setRoomtype(selectedRoom);

			booking.setBooking_id(BookingGL.bookingId);
			booking.setNo_Of_Room((Integer) spinner.getValue());
			Bookingjdbc book = new Bookingjdbc();
			boolean result = book.update(booking);
			if (result == true) {
				JOptionPane.showMessageDialog(this, "successfully updated");
			} else {
				JOptionPane.showMessageDialog(this, "sorry,couldn't update");
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
