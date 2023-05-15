package view;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;

	public class Gallary extends JFrame implements ActionListener{
		// declaring all the component
		JPanel panel_north;
		JLabel headerLabel;
		ImageIcon main_img;
		JPanel panel_south;
		JLabel lbl_img;
		JButton btnBack;

		// creating default constructor
		public Gallary() {
			// setting the title of the page
			this.setTitle("Image Gallery");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// getting screensize
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			// setting the size of the frame
			this.setSize(screenSize.width, 2400);

			// initializing all component
			panel_north = new JPanel();
			panel_north.setLayout(null);
			panel_north.setPreferredSize(new Dimension(screenSize.width, 150));
			panel_north.setBackground(Color.black);

			// create header panel

			headerLabel = new JLabel("Image Gallery");
			headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
			panel_north.add(headerLabel);
			this.add(panel_north, BorderLayout.NORTH);

			JLabel header = new JLabel("Hotel Luton Gallary");
			header.setBounds(540, 50, 600, 40);
			header.setFont(new Font("times new roman", Font.BOLD, 40));
			header.setForeground(Color.white);
			panel_north.add(header);

			panel_south = new JPanel();
			panel_south.setLayout(null);
			panel_south.setBackground(Color.black);
			panel_south.setBounds(0, 1050, screenSize.width, 300);

			// create center panel with 5 image JLabels
			JPanel panelCenter = new JPanel(null);
			panelCenter.setPreferredSize(new Dimension(900, 1370)); // set panel size for scrolling
			JLabel label1 = new JLabel(new ImageIcon("g.jpg"));
			label1.setBounds(100, 50, 400, 400);
			panelCenter.add(label1);
			panelCenter.add(panel_south);
			
		
			JLabel detailsLabel1 = new JLabel("Single Room");
			detailsLabel1.setBounds(100, 450, 400, 50);
			detailsLabel1.setHorizontalAlignment(JLabel.CENTER);
			detailsLabel1.setFont(new Font("times new roman", Font.BOLD, 25));
			panelCenter.add(detailsLabel1);

			JLabel label2 = new JLabel(new ImageIcon("double.jpg"));
			label2.setBounds(550, 50, 400, 400);
			panelCenter.add(label2);
			JLabel detailsLabel2 = new JLabel("Double Room");
			detailsLabel2.setBounds(550, 450, 400, 50);
			detailsLabel2.setHorizontalAlignment(JLabel.CENTER);
			detailsLabel2.setFont(new Font("times new roman", Font.BOLD, 25));
			panelCenter.add(detailsLabel2);

			JLabel label3 = new JLabel(new ImageIcon("twn.jpg"));
			label3.setBounds(1000, 50, 400, 400);
			panelCenter.add(label3);
			JLabel detailsLabel3 = new JLabel("Twin Room");
			detailsLabel3.setBounds(1000, 450, 400, 50);
			detailsLabel3.setHorizontalAlignment(JLabel.CENTER);
			detailsLabel3.setFont(new Font("times new roman", Font.BOLD, 25));
			panelCenter.add(detailsLabel3);

			JLabel label4 = new JLabel(new ImageIcon("gl.jpg"));
			label4.setBounds(100, 550, 400, 400);
			panelCenter.add(label4);
			JLabel detailsLabel4 = new JLabel("Indoor Swiming Pool");
			detailsLabel4.setBounds(100, 950, 400, 50);
			detailsLabel4.setFont(new Font("times new roman", Font.BOLD, 25));
			detailsLabel4.setHorizontalAlignment(JLabel.CENTER);
			panelCenter.add(detailsLabel4);

			JLabel label5 = new JLabel(new ImageIcon("M.jpg"));
			label5.setBounds(550, 550, 400, 400);
			panelCenter.add(label5);
			JLabel detailsLabel5 = new JLabel("");
			detailsLabel5.setBounds(550, 950, 400, 50);
			detailsLabel5.setFont(new Font("times new roman", Font.BOLD, 25));
			detailsLabel5.setHorizontalAlignment(JLabel.CENTER);
			panelCenter.add(detailsLabel5);
				
			JLabel label6 = new JLabel(new ImageIcon("bar.jpg"));
			label6.setBounds(1000, 550, 400, 400);
			panelCenter.add(label6);
			JLabel detailsLabel6 = new JLabel("");
			detailsLabel6.setBounds(1000, 950, 400, 50);
			detailsLabel6.setFont(new Font("times new roman", Font.BOLD, 25));
			detailsLabel6.setHorizontalAlignment(JLabel.CENTER);
			panelCenter.add(detailsLabel6);
			
			
		    JLabel lb3 = new JLabel();
			lb3.setText("Contact Us");
			lb3.setFont(new Font("Arial", Font.BOLD, 18));
			lb3.setBounds(688, 20, 150, 30);
			lb3.setFont(new Font("times new roman", Font.BOLD, 30));
			lb3.setForeground(Color.white);

			JLabel lb = new JLabel();
			lb.setText("www.lutonhotel/xp.com");
			lb.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			lb.setBounds(650, 80, 400, 30);
			lb.setHorizontalTextPosition(JLabel.CENTER);
			lb.setForeground(Color.white);

			JLabel lb1 = new JLabel();
			lb1.setText("Location: california,US");
			lb1.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			lb1.setBounds(650, 100, 410, 30);
			lb1.setForeground(Color.white);

			JLabel lb2 = new JLabel();
			lb2.setText("<html>Contact: 011293764298 <br> for more query send message in:<br>"
					+ "bedforequery@gmail.com ");
			lb2.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			lb2.setBounds(650, 130, 500, 90);
			lb2.setForeground(Color.white);
			
			btnBack=new JButton();
			btnBack.setText("Back");
			btnBack.setBounds(1350, 35, 115, 50);
			btnBack.setFont(new Font("Times New Roman", Font.BOLD, 23));
			btnBack.setBackground(Color.gray);// setting background color
			btnBack.setFocusable(false);
	        btnBack.addActionListener(this);
							
			// adding lable to the panel_south
	        panel_north.add(btnBack);
			panel_south.add(lb3);
			panel_south.add(lb2);
			panel_south.add(lb1);
			panel_south.add(lb);

			JScrollPane scrollPane = new JScrollPane(panelCenter);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			this.add(scrollPane, BorderLayout.CENTER);

			this.setVisible(true);
		}

		// calling constructor in main method
		public static void main(String[] args) {
			new Gallary();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnBack) {
				this.dispose();
				new  FirstPage();
			}
			
		}

	}