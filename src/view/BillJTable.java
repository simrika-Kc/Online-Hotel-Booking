package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.BillJTableControll;
import controller.ManagerJTable;
import model.BookingGL;

public class BillJTable extends JFrame implements ActionListener {
	ImageIcon imgLogo;
	JLabel lblLogo;
	JPanel panelNorth;
	JTable tableManagerBill;
	DefaultTableModel tableModelBill;
	JScrollPane scrollBill;
	JPanel panelCenter;
	JButton btnBill;
	JPanel panelGreen;
	Timer refress;
	JButton btnBack;

	public BillJTable() {
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

		tableManagerBill = new JTable();
		tableModelBill = new DefaultTableModel();
		tableManagerBill.setModel(tableModelBill);
		Object[] columns = { "Invoice No", "Booking Id", "Bill Date", "Total Charge" };

		tableModelBill.setColumnIdentifiers(columns);
		tableManagerBill.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableManagerBill.setModel(tableModelBill);
		tableManagerBill.setFillsViewportHeight(true);
		scrollBill = new JScrollPane(tableManagerBill);
		scrollBill.setViewportView(tableManagerBill);
		scrollBill.setBounds(5, 10, 580, 520);
		// Set up scroll pane policies and table selection mode
		scrollBill.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBill.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		tableManagerBill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableManagerBill.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int Value = tableManagerBill.getSelectedRow();
					if (Value != -1) {
						String Booking_id = tableManagerBill.getValueAt(Value, 1).toString();
						String totalCharge = tableManagerBill.getValueAt(Value, 3).toString();
						BookingGL.billBookingID = Integer.parseInt(Booking_id);

						BookingGL.totalCharge = Integer.parseInt(totalCharge);
					}
				}
			}
		});
		BillJTableControll bill = new BillJTableControll();
		tableModelBill = bill.loadDataBill();
		tableManagerBill.setModel(tableModelBill);

		panelCenter = new JPanel();
		panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

		btnBill = new JButton();
		btnBill.setText("Generate Bills");
		btnBill.setBounds(650, 210, 250, 40);
		btnBill.setBackground(Color.green);
		btnBill.setForeground(Color.black);
		btnBill.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnBill.setFocusable(false);
		btnBill.addActionListener(this);

		panelGreen = new JPanel();
		panelGreen.setLayout(null);
		panelGreen.setBackground(Color.green);
		panelGreen.setBounds(0, 0, 585, 528);

		btnBack=new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(810, 35, 115, 50);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnBack.setBackground(Color.gray);// setting background color
		btnBack.setFocusable(false);
        btnBack.addActionListener(this);
						
		
		panelNorth.add(btnBack);
		this.add(btnBill);
		panelGreen.add(scrollBill);
		panelCenter.add(panelGreen);
		this.add(panelCenter, BorderLayout.CENTER);
		panelNorth.add(lblLogo);
		this.add(panelNorth, BorderLayout.NORTH);
		this.setVisible(true);

		refress = new Timer(1500, e -> {

			tableModelBill = bill.loadDataBill();
			tableManagerBill.setModel(tableModelBill);

		});

		refress.start();

	}

	public static void main(String argd[]) {
		new BillJTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBill) {

			GenerateBill bill = new GenerateBill();// making object of GenerateBill class
			panelCenter.add(bill);
			bill.setLocation(600, 250);

		}
if(e.getSource()==btnBack) {
	this.dispose();
	new Manager();
}
	}
}
