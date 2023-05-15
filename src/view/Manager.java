package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.AssignRoomjdbc;
import controller.Bookingjdbc;
import controller.JtableControll;
import controller.ManagerJTable;
import model.Booking;
import model.BookingGL;
import model.CustomerGL;
import model.Room;

public class Manager extends JFrame implements ActionListener {

	ImageIcon imgLogo;
	JLabel lblLogo;
	JPanel panelNorth;
	JTable tableManager;
	DefaultTableModel tableModel;
	JScrollPane scroll;
	JTable tableManager1;
	DefaultTableModel tableModel1;
	JScrollPane scroll1;
	JPanel panelCenter;
	JButton btnAvailable;
	JButton btnAssign;
	JPanel panelMagenta;
	JPanel panelYellow;
	JButton btnBill;
	JButton btnLogout;
	JLabel lblLogin;
	Timer refress;
	Timer refress1;

	public Manager() {
		this.setSize(950, 700);
		this.setResizable(false);
		//this.setUndecorated(true);
		//this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		imgLogo = new ImageIcon("logo1.jpg");
		lblLogo = new JLabel();
		lblLogo.setIcon(imgLogo);
		lblLogo.setBounds(10, 10, 150, 100);

		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(1600, 124));
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		tableManager = new JTable();
		tableModel = new DefaultTableModel();
		tableManager.setModel(tableModel);
		Object[] columnNames = { "Booking_id", "Roomtype", "No_Of_Room", "Arrival_date", "Departure_date",
				"Booking_status ", "RoomNo" };
		tableModel.setColumnIdentifiers(columnNames);
		tableManager.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableManager.setModel(tableModel);
		tableManager.setFillsViewportHeight(true);
		scroll = new JScrollPane(tableManager);
		scroll.setViewportView(tableManager);
		scroll.setBounds(5, 10, 600, 520);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		tableManager.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableManager.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int Value = tableManager.getSelectedRow();
					int Value1 = tableManager.getSelectedRow();

					if (Value != -1) {
						if (Value != -1) {
							String Booking_id = tableManager.getValueAt(Value, 0).toString();
							String Room_Type = tableManager.getValueAt(Value, 1).toString();
							BookingGL.managerBookingID = Integer.parseInt(Booking_id);
							BookingGL.roomtype = Room_Type;
							System.out.println(BookingGL.roomtype);
						}
					}
				}
			}
		});

		tableModel = ManagerJTable.loadData();
		tableManager.setModel(tableModel);

		panelCenter = new JPanel();
		panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

		btnAvailable = new JButton();
		btnAvailable.setText("Check Available room");
		btnAvailable.setBounds(650, 60, 230, 40);
		btnAvailable.setBackground(Color.ORANGE);
		btnAvailable.setForeground(Color.black);
		btnAvailable.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAvailable.setFocusable(false);
		btnAvailable.addActionListener(this);

		btnAssign = new JButton();
		btnAssign.setText("Accept Booking");
		btnAssign.setBounds(650, 128, 230, 40);
		btnAssign.setBackground(Color.magenta);
		btnAssign.setForeground(Color.black);
		btnAssign.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnAssign.setFocusable(false);
		btnAssign.addActionListener(this);

		btnBill = new JButton();
		btnBill.setText("Generate Bills");
		btnBill.setBounds(650, 200, 230, 40);
		btnBill.setBackground(Color.GREEN);
		btnBill.setForeground(Color.black);
		btnBill.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBill.setFocusable(false);
		btnBill.addActionListener(this);

		panelYellow = new JPanel();
		panelYellow.setLayout(null);
		panelYellow.setBackground(Color.yellow);
		panelYellow.setBounds(0, 0, 605, 523);

		panelMagenta = new JPanel();
		panelMagenta.setLayout(null);
		panelMagenta.setBackground(Color.magenta);
		panelMagenta.setBounds(0, 0, 605, 523);

		tableManager1 = new JTable();
		tableModel1 = new DefaultTableModel();
		tableManager1.setModel(tableModel1);

		Object[] column = { "Room_No", "Room_type", "Room_status " };
		tableModel1.setColumnIdentifiers(column);
		tableManager1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableManager1.setModel(tableModel1);
		tableManager1.setFillsViewportHeight(true);
		scroll1 = new JScrollPane(tableManager1);
		scroll1.setViewportView(tableManager1);
		scroll1.setBounds(5, 10, 600, 520);

		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		tableManager1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableModel1 = ManagerJTable.loadData1();
		tableManager1.setModel(tableModel1);

		btnLogout = new JButton();
		btnLogout.setText("Back");
		btnLogout.setBounds(730, 40, 130, 40);
		btnLogout.setBackground(Color.lightGray);
		btnLogout.setForeground(Color.black);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);

		lblLogin = new JLabel();
		lblLogin.setText("Logged in as manager");
		lblLogin.setBounds(300, 20, 300, 100);
		lblLogin.setForeground(Color.black);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));

		panelNorth.add(lblLogin);
		panelNorth.add(btnLogout);
		panelYellow.add(scroll1);
		panelCenter.add(btnBill);
		panelCenter.add(btnAssign);
		panelCenter.add(btnAvailable);
		this.add(panelCenter, BorderLayout.CENTER);
		panelMagenta.add(scroll);
		panelCenter.add(panelMagenta);
		panelCenter.add(panelYellow);
		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(lblLogo);
		this.setVisible(true);

		refress = new Timer(1500, e -> {

			tableModel = ManagerJTable.loadData();
			tableManager.setModel(tableModel);

		});

		refress.start();

	}

	@Override
	public void dispose() {
		refress.stop();
		// refress1.stop();
		super.dispose();

	}
	
		
	

	public static void main(String[] args) {
		new Manager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAssign) {
			panelMagenta.setVisible(true);
			panelYellow.setVisible(false);
			// for accepting requested rooom
			Booking bookingAccept = new Booking();
			bookingAccept.setBooking_status("Accepted");
			bookingAccept.setBooking_id(BookingGL.managerBookingID);
			AssignRoomjdbc accept = new AssignRoomjdbc();
			boolean res = accept.acceptBooking(bookingAccept);
			if (res == true) {
				JOptionPane.showMessageDialog(this, "Booking accepted");
				AssignRoom assign = new AssignRoom();// making object of SecondLoginPage
				panelCenter.add(assign);// adding internalframe in lblImage from secondLoginPage in this page
				assign.setLocation(608, 300);

			} else {
				JOptionPane.showMessageDialog(this, "denied");
			}

		}

		if (e.getSource() == btnBill) {
			new BillJTable();
			this.dispose();
		}

		if (e.getSource() == btnAvailable) {

			panelYellow.setVisible(true);
			panelMagenta.setVisible(false);

			tableModel1 = ManagerJTable.loadData1();
			tableManager1.setModel(tableModel1);

		}
		if (e.getSource() == btnLogout) {
			this.dispose();
			new ManagerPage();
		}
	}
}