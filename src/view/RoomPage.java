package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RoomPage extends JFrame implements ActionListener {
	JLabel lblSingle;
	JLabel lblDouble;
	JLabel lblTwin;
	JLabel lblLogo;
	JLabel lblSingleText;
	JLabel lblDoubleText;
	JLabel lblTwinText;
	JLabel lblDescribe;
	ImageIcon imgSingle;
	ImageIcon imgDouble;
	ImageIcon imgTwin;
	JPanel panelNorth;
	JPanel panelGray;
	JPanel panelBlack;
	JPanel panelSouth;
	JPanel panelSouth1;
	ImageIcon imgLogo;
	JButton btnSingle;
	JButton btnDouble;
	JButton btnTwin;
	JButton btnLogout;

	public RoomPage() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		// adding image
		imgLogo = new ImageIcon("logo1.jpg");
		lblLogo = new JLabel();
		lblLogo.setIcon(imgLogo);
		lblLogo.setBounds(10, 10, 150, 100);

		lblSingleText = new JLabel();
		lblSingleText.setText("Single Room             $29");
		lblSingleText.setBounds(40, 400, 500, 400);
		lblSingleText.setForeground(Color.black);
		lblSingleText.setFont(new Font("Times New Roman", Font.PLAIN, 32));

		imgSingle = new ImageIcon("single.jpg");
		lblSingle = new JLabel();
		lblSingle.setIcon(imgSingle);
		lblSingle.setBounds(20, 40, 470, 400);

		lblDoubleText = new JLabel();
		lblDoubleText.setText("Double Room            $35");
		lblDoubleText.setBounds(540, 400, 500, 400);
		lblDoubleText.setForeground(Color.black);
		lblDoubleText.setFont(new Font("Times New Roman", Font.PLAIN, 32));

		imgDouble = new ImageIcon("double.jpg");
		lblDouble = new JLabel();
		lblDouble.setIcon(imgDouble);
		lblDouble.setBounds(520, 40, 470, 400);

		lblTwinText = new JLabel();
		lblTwinText.setText("Twin Room              $35");
		lblTwinText.setBounds(1060, 400, 500, 400);
		lblTwinText.setForeground(Color.black);
		lblTwinText.setFont(new Font("Times New Roman", Font.PLAIN, 32));

		imgTwin = new ImageIcon("twn.jpg");
		lblTwin = new JLabel();
		lblTwin.setIcon(imgTwin);
		lblTwin.setBounds(1020, 40, 475, 400);

		panelGray = new JPanel();
		panelGray.setBackground(Color.gray);
		panelGray.setLayout(null);
		panelGray.setBounds(0, 135, 1525, 7500);

		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(1600, 124));
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		btnSingle = new JButton();
		btnSingle.setText("Book");
		btnSingle.setBounds(370, 575, 120, 45);
		btnSingle.setBackground(Color.BLUE);
		btnSingle.setForeground(Color.WHITE);
		btnSingle.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnSingle.setFocusable(false);
		btnSingle.addActionListener(this);

		btnDouble = new JButton();
		btnDouble.setText("Book");
		btnDouble.setBounds(870, 575, 120, 45);
		btnDouble.setBackground(Color.BLUE);
		btnDouble.setForeground(Color.WHITE);
		btnDouble.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnDouble.setFocusable(false);
		btnDouble.addActionListener(this);

		btnTwin = new JButton();
		btnTwin.setText("Book");
		btnTwin.setBounds(1380, 575, 120, 45);
		btnTwin.setBackground(Color.BLUE);
		btnTwin.setForeground(Color.WHITE);
		btnTwin.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnTwin.setFocusable(false);
		btnTwin.addActionListener(this);

		btnLogout = new JButton();
		btnLogout.setText("Back");
		btnLogout.setBounds(1350, 30, 120, 35);
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setForeground(Color.black);
		btnLogout.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);

		lblDescribe = new JLabel();
		lblDescribe.setText("Unlock the door to your dream room with just a few clicks.");
		lblDescribe.setBounds(350, 590, 1090, 300);
		lblDescribe.setForeground(Color.white);
		lblDescribe.setFont(new Font("Times new roman", Font.ITALIC, 30));

		panelSouth = new JPanel();
		panelSouth.setBackground(Color.black);
		panelSouth.setLayout(null);
		panelSouth.setPreferredSize(new Dimension(1600, 144));
		panelSouth.setBorder(BorderFactory.createLineBorder(Color.red, 1));

		this.add(lblDescribe);
		this.add(panelSouth, BorderLayout.SOUTH);
		panelNorth.add(btnLogout);
		this.add(btnTwin);
		this.add(btnDouble);
		this.add(btnSingle);
		this.add(lblTwinText);
		this.add(lblDoubleText);
		this.add(lblSingleText);
		panelNorth.add(lblLogo);
		this.add(panelGray, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH);
		panelGray.add(lblDouble);
		panelGray.add(lblSingle);
		panelGray.add(lblTwin);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RoomPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogout) {
			this.dispose();
			new FrstUiPage();

		} else if (e.getSource() == btnSingle) {

			String single = "Single Room";

			int price = 3799;

			String singlePrice = Integer.toString(price);// changing string into integer

			BookingPage booking = new BookingPage();// making object of BookingPage
			booking.single(single, singlePrice);// calling single from bookingPage

		} else if (e.getSource() == btnDouble) {
			String doubleRoom = "Double Room";
			int price = 4585;
			String doublePrice = Integer.toString(price);// converting into integer
			BookingPage booking = new BookingPage();// making object of BookingPage
			booking.roomDouble(doubleRoom, doublePrice);// calling roomDouble from bookingPage

		} else if (e.getSource() == btnTwin) {
			String twin = "Twin Room";
			int price = 4585;
			String twinPrice = Integer.toString(price);// converting into integer
			BookingPage booking = new BookingPage();// making object of BookingPage
			booking.twin(twin, twinPrice);// calling twin from bookingPage
		}

	}
}
