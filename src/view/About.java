package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener {
	JPanel panelNorth;
	JPanel panelGray;
	ImageIcon image;
	ImageIcon image1;
	JLabel imageLabel;
	JLabel lblImage1;
	JLabel lblDescription;
	JButton btnBack;
	JLabel lblSubheading;
	JButton btnExperience;

	public About() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screensize.width, screensize.height);// to make fitted over all type of screen
		this.setResizable(false);

		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(1600, 124));
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black, 2));// setting border line

		// adding panael
		panelGray = new JPanel();
		panelGray.setBackground(Color.gray);
		panelGray.setLayout(null);
		panelGray.setBounds(0, 124, 1525, 820);

		// adding image
		ImageIcon image = new ImageIcon("rom.jpg");
		imageLabel = new JLabel();
		imageLabel.setIcon(image);
		imageLabel.setBounds(25, 0, 1500, 800);

		lblSubheading = new JLabel();
		lblSubheading.setText("Luton Hotel");
		lblSubheading.setBounds(670, 50, 300, 100);
		lblSubheading.setFont(new Font("Times New Roman", Font.BOLD, 45));

		lblDescription = new JLabel();
		// adding text using html
		lblDescription.setText(
				"<html>It is a large independently run hotel.It offers variety of <br>accomodation i.e single rooms,double rooms, twin rooms <br>which offer suite facilities, a telephone with an outside line <br>and a mini-bar.Rooms service is also available. Services not<br> offered by the hotel itself can be ordered by guests through<br> the  hotel receptionist and charged to their room.</html>");
		lblDescription.setBounds(540, 80, 800, 600);
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDescription.setForeground(Color.black);

		btnBack = new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(1350, 35, 115, 50);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnBack.setBackground(Color.gray);// setting background color
		btnBack.setFocusable(false);
        btnBack.addActionListener(this);
		
		image1 = new ImageIcon("logo1.jpg");
		lblImage1 = new JLabel();
		lblImage1.setIcon(image1);
		lblImage1.setBounds(10, 10, 150, 100);

		btnExperience = new JButton();
		btnExperience.setText("Best experience ever!!");
		btnExperience.setBounds(920, 520, 230, 40);
		btnExperience.setBackground(Color.red);
		btnExperience.setForeground(Color.black);
		btnExperience.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnExperience.setFocusable(false);

		this.add(btnExperience);
		panelNorth.add(btnBack);
		this.add(lblDescription);
		this.add(panelGray, BorderLayout.CENTER);

		panelGray.add(lblSubheading);
		panelNorth.add(lblImage1);
		panelGray.add(imageLabel);
		add(panelNorth, BorderLayout.NORTH);// keeping this panel in north side
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new About();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnBack) {
			this.dispose();
			new FrstUiPage();
		}

	}

}
