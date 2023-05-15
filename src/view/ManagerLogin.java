package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerLogin extends JInternalFrame implements ActionListener {
	JPasswordField fieldCode;
	JButton btnEnter;
	// String manager="Manager10";

	public ManagerLogin() {
		this.setSize(175, 160);
		this.setResizable(false);
		this.setLayout(null);

		fieldCode = new JPasswordField();
		fieldCode.setText("Enter code to login");
		fieldCode.setBounds(20, 20, 105, 35);

		btnEnter = new JButton();
		btnEnter.setText("Enter");
		btnEnter.setBounds(20, 70, 95, 30);
		btnEnter.setBackground(Color.cyan);
		btnEnter.setForeground(Color.black);
		btnEnter.setFont(new Font("Times new roman", Font.BOLD, 17));
		btnEnter.setFocusable(false);
		btnEnter.addActionListener(this);

		this.add(btnEnter);
		this.add(fieldCode);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnter) {
			/*
			 * if(fieldCode.equals(manager)) { JOptionPane.showMessageDialog(null,
			 * "Welcome"); new ManagerPage(); } else
			 */
			JOptionPane.showMessageDialog(null, "welcome");

			new ManagerPage();
		}

	}
}
