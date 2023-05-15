package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerPage extends JFrame implements ActionListener {
	JLabel lblDescribe;
	ImageIcon image;
	JLabel lblImage;
	JPanel panelNorth;
	JButton btnClick;
    JButton btnLogout;

	public ManagerPage() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();// to get screen size window of any device
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);

		image = new ImageIcon("hello.jpg");
		lblImage = new JLabel();
		lblImage.setIcon(image);
		lblImage.setBounds(100, 100, 1600, 750);

		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(10, 14, 35));
		panelNorth.setPreferredSize(new Dimension(1600, 74));

		lblDescribe = new JLabel();
		lblDescribe.setText("Welcome To Manager Page");
		lblDescribe.setBounds(530, 10, 600, 100);
		lblDescribe.setForeground(Color.black);
		lblDescribe.setFont(new Font("Times New Roman", Font.BOLD, 45));

		btnClick = new JButton();
		btnClick.setText("Go to View");
		btnClick.setBounds(650, 150, 300, 40);
		btnClick.setBackground(Color.black);
		btnClick.setForeground(Color.white);
		btnClick.setFont(new Font("Times new roman", Font.BOLD, 20));
		btnClick.setFocusable(false);
		btnClick.addActionListener(this);


		btnLogout = new JButton();
		btnLogout.setText("Logout");
		btnLogout.setBounds(1330, 20, 180, 40);
		btnLogout.setBackground(Color.black);
		btnLogout.setForeground(Color.white);
		btnLogout.setFont(new Font("Times new roman", Font.BOLD, 30));
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		
		this.add(btnLogout);
		lblImage.add(btnClick);
		lblImage.add(lblDescribe);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(lblImage);
		this.setVisible(true);
	}

	public static void main(String args[]) {

		new ManagerPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClick) {
			new Manager();
		}
		if(e.getSource()==btnLogout) {
			this.dispose();
			new FirstPage();
		}

	}
}