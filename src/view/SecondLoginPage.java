package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.CustomerControll;
import controller.LoginControll;
import model.Customer;
import model.CustomerGL;

public class SecondLoginPage extends JInternalFrame implements ActionListener, FocusListener {
	// declaring
	JTextField fieldUsername;
	JPasswordField fieldPassword;
	JLabel lblCreate;
	JLabel lblHeading;
	JButton btnLogin;
	JButton btnCreate;

	public SecondLoginPage() {

		// creating frame
		this.setSize(370, 440);
		this.setResizable(false);
		this.setLayout(null);

		lblHeading = new JLabel();
		lblHeading.setText("Log into Hotel Booking");
		lblHeading.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 20));
		lblHeading.setBounds(80, 5, 300, 100);

		fieldUsername = new JTextField();
		fieldUsername.setText("enter your username");
		fieldUsername.setBounds(10, 100, 300, 40);
		fieldUsername.addFocusListener(this);

		fieldPassword = new JPasswordField();
		fieldPassword.setText("enter your password");
		fieldPassword.setBounds(10, 160, 300, 40);
		fieldPassword.setEchoChar((char) 0);
		fieldPassword.addFocusListener(this);

		btnLogin = new JButton();
		btnLogin.setText("Log in");
		btnLogin.setBounds(10, 220, 300, 40);
		btnLogin.setBackground(Color.blue);
		btnLogin.setForeground(Color.white);
		btnLogin.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);

		lblCreate = new JLabel();
		lblCreate.setText("Don't have have an account?");
		lblCreate.setBounds(40, 250, 300, 100);
		lblCreate.setFont(new Font("Times new roman", Font.ITALIC, 20));

		btnCreate = new JButton();
		btnCreate.setText("Create new account");
		btnCreate.setBounds(50, 330, 200, 40);
		btnCreate.setBackground(Color.CYAN);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnCreate.setFocusable(false);
		btnCreate.addActionListener(this);

		this.add(lblHeading);
		this.add(fieldUsername);
		this.add(fieldPassword);
		this.add(btnLogin);
		this.add(lblCreate);
		this.add(btnCreate);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCreate) {
			this.dispose();
			new ThirdRegistrationPage();// entering into thirdregistration page after clicking in btnCreate

		} else if (e.getSource() == btnLogin) {
			if (fieldUsername.getText().isEmpty()) {
				// this will show alert message "Enter Your Username" when we leave username
				// field empty
				JOptionPane.showMessageDialog(this, "Enter Your Username and password");

			} else if (new String(fieldPassword.getPassword()).isEmpty()) {
				// this will show alert message "Enter Your password" when we leave password
				// field empty
				JOptionPane.showMessageDialog(this, "Enter your password");

			}

			else {
			
				// this code is to login only after matching username and password from database
				String Username = fieldUsername.getText();
				String Password = new String(fieldPassword.getPassword());

				System.out.println(Username + " " + Password);

				Customer customerInfo = new Customer();
				CustomerControll customerCon = new CustomerControll();
				customerInfo.setUsername(fieldUsername.getText());
				customerInfo.setPassword(new String(fieldPassword.getPassword()));

				customerCon.setCustomerInfo(customerInfo);
				customerCon.login();
				customerInfo = customerCon.getCustomerInfo();

				if (customerInfo.getCustomer_id() >= 1) {
					JOptionPane.showMessageDialog(this, "welcome");
					CustomerGL.userId = customerInfo.getCustomer_id();
					this.dispose();
					new FrstUiPage();
				} else

					JOptionPane.showMessageDialog(this, "Incorrect username and password");
			}
		}

	}

	@Override

	public void focusGained(FocusEvent e) {
		// fieldUsername will focus after clicking in the textfield area and it will
		// clear the text written in it
		if (e.getSource() == fieldUsername) {
			if (fieldUsername.getText().equals("enter your username")) {
				fieldUsername.setText("");
				fieldUsername.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == fieldPassword) {
			// fieldPassword will focus after clicking in the textfield area and it will
			// clear the text written in it
			if (new String(fieldPassword.getPassword()).equals("enter your password")) {
				fieldPassword.setText("");
				fieldPassword.setForeground(Color.BLACK);
				fieldPassword.setEchoChar('*');
			}

		}
	}

	@Override

	public void focusLost(FocusEvent e) {
		if (e.getSource() == fieldUsername) {
			// this code will set placeholder after removing mouse from usertextfield area
			// only if we left that textfield area empty
			if (fieldUsername.getText().isEmpty()) {
				fieldUsername.setText("enter your username");

			}
		}

		else if (e.getSource() == fieldPassword) {
			// this code will set placeholder after removing mouse from passwordtextfield
			// area only if we left that textfield area empty
			String password = new String(fieldPassword.getPassword());
			if (password.isEmpty()) {
				fieldPassword.setText("enter your password");

			}

		}
	}
}
