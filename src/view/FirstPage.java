package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstPage extends JFrame implements ActionListener {
	JPanel panelNorth;
	JPanel panelCenter;
	ImageIcon image;
	JLabel lblImage;
	JLabel lblWelcome;
	JLabel lblPoet;
	JButton btnLogin;
	JButton btnRegister;
	JButton btnManager;
	JButton btnGallary;
	

	public FirstPage() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();// to get screen size window of any device
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		this.setTitle("Home");

		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(50, 54, 55));
		panelNorth.setPreferredSize(new Dimension(1600, 74));

		image = new ImageIcon("rom.jpg");
		lblImage = new JLabel();
		lblImage.setIcon(image);
		lblImage.setBounds(100, 100, 1600, 750);

		lblWelcome = new JLabel();
		lblWelcome.setText("Welcome To Hotel Luton");
		lblWelcome.setBounds(550, 150, 500, 100);
		lblWelcome.setForeground(Color.black);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 45));

		lblPoet = new JLabel();
		lblPoet.setText("The Place Where You Looking TO_____");
		lblPoet.setBounds(580, 210, 500, 100);
		lblPoet.setForeground(Color.black);
		lblPoet.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		btnLogin = new JButton();
		btnLogin.setText("Login To Hotel ");
		btnLogin.setBounds(580, 340, 180, 40);
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);

		btnRegister = new JButton();
		btnRegister.setText("Register");
		btnRegister.setBounds(820, 340, 180, 40);
		btnRegister.setBackground(Color.magenta);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);

		btnManager = new JButton();
		btnManager.setText("Login as Manager");
		btnManager.setBounds(700, 430, 200, 40);
		btnManager.setBackground(Color.cyan);
		btnManager.setForeground(Color.black);
		btnManager.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnManager.setFocusable(false);
		btnManager.addActionListener(this);

		btnGallary = new JButton();
		btnGallary.setText("Gallery");
		btnGallary.setBounds(0, 20, 120, 40);
		btnGallary.setBackground(Color.white);
		btnGallary.setForeground(Color.black);
		btnGallary.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnGallary.setFocusable(false);
		btnGallary.addActionListener(this);
		
		
		this.add(btnGallary);
		lblImage.add(btnManager);
		lblImage.add(btnRegister);
		lblImage.add(btnLogin);
		lblImage.add(lblPoet);
		lblImage.add(lblWelcome);
		this.add(lblImage);
		this.add(panelNorth, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FirstPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			SecondLoginPage login = new SecondLoginPage();// making object of SecondLoginPage
			lblImage.add(login);// adding internalframe in lblImage from secondLoginPage
			login.setLocation(100, 210);

		}

		if (e.getSource() == btnRegister) {
			new ThirdRegistrationPage();
		}  
		if (e.getSource() == btnManager) {
			ManagerLogin manager = new ManagerLogin();
			lblImage.add(manager);
			manager.setLocation(920, 430);
		}
		if(e.getSource()==btnGallary) {
		this.dispose();
			new Gallary();
			
		}
	}
}
