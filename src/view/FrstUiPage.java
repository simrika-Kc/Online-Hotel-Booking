package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class FrstUiPage extends JFrame implements ActionListener, MouseListener {

	JLabel lblHeading;
	JLabel lblDescribe;
	JLabel lblImage;
	JLabel lblImage1;
	JButton btnBook;
	JLabel lblContact;
	JLabel lblAbout;
	JLabel lblView;
	JButton btnShare;
	JLabel lblHome;
	ImageIcon image;
	ImageIcon image1;
	JPanel panelGray;
	JPanel panelNorth;
	JButton btnLogout;

	public FrstUiPage() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();// to get screen size window of any device
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);
		
		panelGray = new JPanel();
		panelGray.setBackground(Color.gray);
		panelGray.setLayout(null);
		panelGray.setBounds(0, 124, 1525, 820);

		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(1600, 124));
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		image = new ImageIcon("im.jpg");
		lblImage = new JLabel();
		lblImage.setIcon(image);
		lblImage.setBounds(-20, 0, 880, 705);

		lblHeading = new JLabel();
		lblHeading.setText("<html>Enjoy your quality life with friends and family<br>BE BEST, CHOOSE BEST.</html>");
		lblHeading.setBounds(900, 280, 500, 400);
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Times New Roman", Font.PLAIN, 21));

		lblDescribe = new JLabel();
		lblDescribe.setText("<html> Easy To Book <br> Hard To Say Goodbye!!</html>");
		lblDescribe.setBounds(900, 190, 600, 400);
		lblDescribe.setForeground(Color.BLACK);
		lblDescribe.setFont(new Font("Times New Roman", Font.PLAIN, 45));

		image1 = new ImageIcon("logo1.jpg");// inserting images
		lblImage1 = new JLabel();
		lblImage1.setIcon(image1);
		lblImage1.setBounds(10, 10, 150, 100);

		lblAbout = new JLabel();
		lblAbout.setText("About");
		lblAbout.setBounds(630, 30, 100, 50);
		lblAbout.setBackground(Color.white);
		lblAbout.setForeground(Color.BLACK);
		lblAbout.setFont(new Font("Times new roman", Font.BOLD, 25));
		lblAbout.addMouseListener(this);
		
		lblHome = new JLabel();
		lblHome.setText("Home");
		lblHome.setBounds(480, 30, 100, 50);
		lblHome.setBackground(Color.white);
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Times new roman", Font.BOLD, 25));

		lblContact = new JLabel();
		lblContact.setText("Gallary");
		lblContact.setBounds(765, 30, 130, 50);
		lblContact.setBackground(Color.white);
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Times new roman", Font.BOLD, 25));
		lblContact.addMouseListener(this);
		
		btnBook = new JButton();
		btnBook.setText("Book Now");
		btnBook.setBounds(1200, 30, 150, 40);
		btnBook.setBackground(Color.WHITE);
		btnBook.setBackground(Color.cyan);
		btnBook.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnBook.setFocusable(false);
		btnBook.addActionListener(this);

		lblView = new JLabel();
		lblView.setText("View your booking");
		lblView.setBounds(1365, 30, 230, 40);
		lblView.setBackground(Color.BLUE);
		lblView.setForeground(Color.WHITE);
		lblView.setFont(new Font("Times new roman", Font.BOLD, 18));
		lblView.setFocusable(false);
		lblView.addMouseListener(this);

		btnShare = new JButton();
		btnShare.setText("Best Experience Ever!!");
		btnShare.setForeground(Color.black);
		btnShare.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnShare.setBackground(Color.red);
		btnShare.setBounds(1250, 500, 220, 60);
		btnShare.setFocusable(false);

		btnLogout = new JButton();
		btnLogout.setText("Logout");
		btnLogout.setBounds(1330, 750, 180, 40);
		btnLogout.setBackground(Color.black);
		btnLogout.setForeground(Color.white);
		btnLogout.setFont(new Font("Times new roman", Font.BOLD, 30));
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);

		this.add(btnLogout);
		this.add(btnShare);
		this.add(btnBook);
		this.add(lblView);
		this.add(lblContact);
		this.add(lblHome);
		this.add(lblAbout);
		panelNorth.add(lblImage1);
		this.add(lblDescribe);
		this.add(lblHeading);
		panelGray.add(lblImage);
		this.add(panelGray, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new FrstUiPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBook) {
			new RoomPage();

		}
		if (e.getSource() == btnLogout) {
			this.dispose();
			new FirstPage();

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblView) {
			new Jtable();
		}
		if(e.getSource()==lblAbout) {
			this.dispose();
			new About();
		}
		if(e.getSource()==lblContact) {
			new Gallary();
		
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == lblView) {
		lblView.setForeground(Color.red);}
		if (e.getSource() == lblAbout) {
          lblAbout.setForeground(Color.red);}
		if (e.getSource() == lblContact) {
	          lblContact.setForeground(Color.red);}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == lblView) {
		lblView.setForeground(Color.blue);}
		if (e.getSource() == lblAbout) {
		lblAbout.setForeground(Color.black);
	}
		if (e.getSource() == lblContact) {
	          lblContact.setForeground(Color.red);}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblView) {
		lblView.setForeground(Color.red);}
		if (e.getSource() == lblAbout) {
		lblAbout.setForeground(Color.red);}
		if (e.getSource() == lblContact) {
	          lblContact.setForeground(Color.red);}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblView) {
		lblView.setForeground(Color.blue);}
		if (e.getSource() == lblAbout) {
		lblAbout.setForeground(Color.black);
		}	
		if (e.getSource() == lblContact) {
	          lblContact.setForeground(Color.black);}	
	}

}
