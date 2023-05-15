package view;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

import controller.Customerjdbc;
import controller.Managerjdbc;
import model.Customer;
import model.ManagerModel;

public class ThirdRegistrationPage extends JFrame implements ActionListener, FocusListener {

	JTextField fieldFirstName;
	JTextField fieldLastName;
	JTextField fieldAddress;
	JPasswordField fieldNewPassword;
	JPasswordField fieldConPassword;
	JTextField fieldCredit;
	JTextField fieldCreditType;
	JTextField fieldNote;
	JTextField fieldCompany;
	JTextField fieldUsername;
	JTextField fieldClient;
	JTextField fieldEmail;
	JTextField fieldMobile;
	JLabel lblCredit;
	JLabel lblCreditType;
	JLabel lblNote;
	JLabel lblType;
	JLabel lblHeading;
	JLabel lblGender;
	JLabel lblAddress;
	JLabel lblEmail;
	JLabel lblMobile;
	JButton btnRegister;
	JButton btnExit;
	JRadioButton btnMale;
	JRadioButton btnFemale;
	JRadioButton btnOthers;
	JComboBox combo;
	ButtonGroup btnGroup;
	String gender = "";
	ImageIcon image;
	JLabel lblImage;

	public ThirdRegistrationPage() {

		this.setSize(500, 700);
		this.setResizable(false);
		this.setLayout(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		lblHeading = new JLabel();
		lblHeading.setText("Create a new account");
		lblHeading.setBounds(100, -20, 300, 100);
		lblHeading.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 22));

		fieldFirstName = new JTextField();
		fieldFirstName.setText("Firstname");
		fieldFirstName.setBounds(5, 60, 195, 40);
		fieldFirstName.addFocusListener(this);

		fieldLastName = new JTextField();
		fieldLastName.setText("Lastname");
		fieldLastName.setBounds(225, 60, 195, 40);
		fieldLastName.addFocusListener(this);

		fieldUsername = new JTextField();
		fieldUsername.setText("Enter your new username");
		fieldUsername.setBounds(50, 110, 300, 40);
		fieldUsername.addFocusListener(this);

		fieldNewPassword = new JPasswordField();
		fieldNewPassword.setText("Enter your new password");
		fieldNewPassword.setBounds(50, 160, 300, 40);
		fieldNewPassword.addFocusListener(this);
		fieldNewPassword.setEchoChar((char) 0);

		fieldConPassword = new JPasswordField();
		fieldConPassword.setText("Confirm your password");
		fieldConPassword.setBounds(50, 215, 300, 40);
		fieldConPassword.addFocusListener(this);
		fieldConPassword.setEchoChar((char) 0);

		lblGender = new JLabel();
		lblGender.setText("Gender:");
		lblGender.setBounds(5, 220, 300, 100);
		lblGender.setFont(new Font("Times new roman", Font.BOLD, 17));

		btnMale = new JRadioButton("Male");
		btnMale.setBounds(10, 277, 100, 30);

		btnFemale = new JRadioButton("Female");
		btnFemale.setBounds(10, 301, 100, 30);

		btnOthers = new JRadioButton("Others");
		btnOthers.setBounds(10, 327, 100, 30);

		lblAddress = new JLabel();
		lblAddress.setText("Address:");
		lblAddress.setBounds(5, 370, 200, 40);
		lblAddress.setFont(new Font("Times new roman", Font.BOLD, 15));

		fieldAddress = new JTextField();
		fieldAddress.setText(null);
		fieldAddress.setBounds(90, 370, 150, 40);

		lblEmail = new JLabel();
		lblEmail.setText("Email:");
		lblEmail.setBounds(255, 370, 200, 40);
		lblEmail.setFont(new Font("Times new roman", Font.BOLD, 14));

		fieldEmail = new JTextField();
		// fieldEmail.setText(null);
		fieldEmail.setBounds(310, 370, 150, 40);

		lblType = new JLabel();
		lblType.setText("Client Type: ");
		lblType.setBounds(5, 390, 300, 100);
		lblType.setFont(new Font("Times new roman", Font.BOLD, 14));

		String type[] = { "Corporate", "Non_corporate" };
		combo = new JComboBox(type);
		combo.setBounds(90, 425, 150, 40);
		combo.addActionListener(this);

		lblMobile = new JLabel();
		lblMobile.setText("Mobile:");
		lblMobile.setBounds(255, 390, 300, 100);
		lblMobile.setFont(new Font("Times new roman", Font.BOLD, 14));

		fieldMobile = new JTextField();
		fieldMobile.setText("+977");
		fieldMobile.setBounds(310, 423, 150, 40);

		lblNote = new JLabel();
		lblNote.setText("Note:  Non_corporate client must fill the Credit details.");
		lblNote.setBounds(15, 445, 400, 100);
		lblNote.setFont(new Font("Times new roman", Font.ITALIC, 14));

		lblCredit = new JLabel();
		lblCredit.setText("Credit number:");
		lblCredit.setBounds(5, 505, 200, 50);
		lblCredit.setFont(new Font("Times new roman", Font.BOLD, 14));

		fieldCredit = new JTextField();
		fieldCredit.setText(null);
		fieldCredit.setBounds(108, 510, 150, 40);

		lblCreditType = new JLabel();
		lblCreditType.setText("Credit type:");
		lblCreditType.setBounds(270, 505, 200, 50);
		lblCreditType.setFont(new Font("Times new roman", Font.BOLD, 14));

		fieldCreditType = new JTextField();
		fieldCreditType.setText(null);
		fieldCreditType.setBounds(350, 510, 150, 40);

		btnRegister = new JButton();
		btnRegister.setText("Register");
		btnRegister.setBounds(220, 610, 120, 40);
		btnRegister.setBackground(Color.CYAN);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnRegister.addActionListener(this);

		btnExit = new JButton();
		btnExit.setText("Exit");
		btnExit.setBounds(355, 610, 120, 40);
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnExit.addActionListener(this);

		fieldCompany = new JTextField();
		fieldCompany.setText("Company Name");
		fieldCompany.setBounds(10, 565, 225, 40);
		fieldCompany.addFocusListener(this);
		// fieldCompany.setVisible(false);

		this.add(fieldCompany);
		this.add(lblHeading);
		this.add(fieldFirstName);
		this.add(fieldLastName);
		this.add(fieldUsername);
		this.add(fieldNewPassword);
		this.add(fieldConPassword);
		this.add(lblGender);
		this.add(btnMale);
		this.add(btnFemale);
		this.add(btnOthers);
		btnGroup = new ButtonGroup();
		btnGroup.add(btnMale);
		btnGroup.add(btnFemale);
		btnGroup.add(btnOthers);
		this.add(fieldAddress);
		this.add(lblAddress);
		this.add(lblType);
		this.add(combo);
		this.add(fieldEmail);
		this.add(lblEmail);
		this.add(lblNote);
		this.add(lblCreditType);
		this.add(fieldCreditType);
		this.add(lblCredit);
		this.add(fieldCredit);
		this.add(fieldMobile);
		this.add(lblMobile);
		this.add(btnRegister);
		this.add(btnExit);
		this.setVisible(true);

		btnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				gender = "Male";
			}
		});

		btnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				gender = "Female";

			}
		});
		btnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				gender = "Other";

			}
		});

	}

	public static void main(String[] args) {
		new ThirdRegistrationPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String combobox = (String) combo.getSelectedItem();

		if (combobox.equals("Corporate")) {
			fieldCompany.setVisible(true);

		}

		else if (combobox.equals("Non_corporate")) {
			fieldCompany.setVisible(false);

		}

		if (e.getSource() == btnExit) {
			this.dispose();

		} else if (e.getSource() == btnRegister) {
			String pass = new String(fieldNewPassword.getPassword());
			String conpass = new String(fieldConPassword.getPassword());
			// Validation

			if (fieldFirstName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your Firstname");

			} else if (fieldLastName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your Lastname");
			} else if (fieldUsername.getText().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Enter Your Username");
			} else if (new String(fieldNewPassword.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your password");
			} else if (new String(fieldConPassword.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your password");
			} else if (fieldCredit.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your creditinformation");
			} else if (fieldEmail.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your Email");
			} else if (fieldMobile.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your Number");
			} else if (fieldAddress.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter your Address");
			}

			if (pass.equals(conpass)) {

				Customer customer = new Customer();
				ManagerModel manager = new ManagerModel();

				// setting value of respective columns which is get by Customer class
				customer.setFirst_name(fieldFirstName.getText());
				customer.setLast_name(fieldLastName.getText());
				customer.setPassword(new String(fieldNewPassword.getPassword()));
				customer.setUsername(fieldUsername.getText());
				customer.setMobile(fieldMobile.getText());
				customer.setLocation(fieldAddress.getText());
				customer.setGender(gender);
				customer.setCard_Number(fieldCredit.getText());
				customer.setCard_type(fieldCreditType.getText());
				customer.setEmail(fieldEmail.getText());
				customer.setCustomer_type((String) combo.getSelectedItem());
				customer.setCompany_name(fieldCompany.getText());
				Customerjdbc jDbc = new Customerjdbc();// making object of controller's class
				boolean result = jDbc.insert(customer);

				manager.setFirst_name(fieldFirstName.getText());
				manager.setLast_name(fieldLastName.getText());
				manager.setPassword(new String(fieldNewPassword.getPassword()));
				manager.setUsername(fieldUsername.getText());
				manager.setLocation(fieldAddress.getText());
				manager.setEmail(fieldEmail.getText());

				Managerjdbc jdbc = new Managerjdbc();
				boolean res = jdbc.insert(manager);

				if (res == true) {
					// passing insert value from Customerjdbc class
					if (result == true) {// checking if the insertation is correct or not
						JOptionPane.showMessageDialog(this, "successfully recorded");
						this.dispose();
					}
				} else {

					JOptionPane.showMessageDialog(this, "sorry!");// Alert message

				}

			} else {
				JOptionPane.showMessageDialog(this, "Password did't match");
			}
		}
	}

	@Override
	// adding FocusGained
	public void focusGained(FocusEvent e) {

		if (e.getSource() == fieldUsername) {
			if (fieldUsername.getText().equals("Enter your new username")) {
				fieldUsername.setText("");
				fieldUsername.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == fieldNewPassword) {
			if (new String(fieldNewPassword.getPassword()).equals("Enter your new password")) {
				fieldNewPassword.setText("");
				fieldNewPassword.setEchoChar('*');
				fieldNewPassword.setForeground(Color.BLACK);
			}

		} else if (e.getSource() == fieldFirstName) {

			if (fieldFirstName.getText().equals("Firstname")) {
				fieldFirstName.setText("");

			}
		} else if (e.getSource() == fieldLastName) {

			if (fieldLastName.getText().equals("Lastname")) {
				fieldLastName.setText("");

			}
		} else if (e.getSource() == fieldConPassword) {
			if (new String(fieldConPassword.getPassword()).equals("Confirm your password")) {
				fieldConPassword.setText("");
				fieldConPassword.setEchoChar('*');

			}

		} else if (e.getSource() == fieldCompany) {
			if (fieldCompany.getText().equals("Company Name")) {
				fieldCompany.setText("");

			}
		}
	}

	@Override
	// adding focuslost
	public void focusLost(FocusEvent e) {

		if (e.getSource() == fieldUsername) {
			if (fieldUsername.getText().isEmpty()) {
				fieldUsername.setText("Enter your new username");

			}
		}

		else if (e.getSource() == fieldNewPassword) {

			String password = new String(fieldNewPassword.getPassword());
			if (password.isEmpty()) {
				fieldNewPassword.setText("Enter your new password");
				fieldNewPassword.setEchoChar((char) 0);
			}

		}

		if (e.getSource() == fieldFirstName) {
			if (fieldFirstName.getText().isEmpty()) {
				fieldFirstName.setText("Firstname");

			}
		}

		if (e.getSource() == fieldLastName) {
			if (fieldLastName.getText().isEmpty()) {
				fieldLastName.setText("Lastname");

			}
		} else if (e.getSource() == fieldConPassword) {

			String password = new String(fieldConPassword.getPassword());
			if (password.isEmpty()) {
				fieldConPassword.setText("Confirm your password");
				fieldConPassword.setEchoChar((char) 0);
			}

		}
		if (e.getSource() == fieldCompany) {
			if (fieldCompany.getText().isEmpty()) {
				fieldCompany.setText("Company Name");

			}
		}
	}
}