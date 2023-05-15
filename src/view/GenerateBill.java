package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.BillJTableControll;
import controller.Bookingjdbc;
import controller.GenerateBillJdbc;
import controller.Roomjdbc;
import model.Bill;
import model.BookingGL;

public class GenerateBill extends JInternalFrame implements ActionListener {

	JTextField fieldBooking;
	JTextField fieldVat;
	JLabel lblBooking;
	JLabel lblHeading;
	JLabel lblVat;
	JButton btnCreate;
	JLabel lblCharge;
	JTextField fieldCharge;
	JButton btnGenerate;
	float vatPercent;
	float total_Charge;

	public GenerateBill() {

		// creating frame
		this.setSize(330, 260);
		this.setResizable(false);
		this.setLayout(null);

		lblHeading = new JLabel();
		lblHeading.setText("Bills");
		lblHeading.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 25));
		lblHeading.setBounds(130, -20, 100, 100);

		lblBooking = new JLabel();
		lblBooking.setText("Id:");
		lblBooking.setFont(new Font("Times new roman", Font.PLAIN, 20));
		lblBooking.setBounds(5, 50, 50, 30);

		fieldBooking = new JTextField();
		fieldBooking.setText(Integer.toString(BookingGL.billBookingID));
		fieldBooking.setBounds(30, 50, 100, 40);
		fieldBooking.setFont(new Font("Times new roman", Font.PLAIN, 20));

		lblVat = new JLabel();
		lblVat.setText("VAT %:");
		lblVat.setFont(new Font("Times new roman", Font.PLAIN, 20));
		lblVat.setBounds(5, 70, 100, 100);

		fieldVat = new JTextField("13");
		fieldVat.setBounds(60, 105, 100, 30);
		fieldVat.setFont(new Font("Times new roman", Font.BOLD, 20));
		fieldVat.setFont(new Font("Times new roman", Font.PLAIN, 20));

		lblCharge = new JLabel();
		lblCharge.setText("Room charge:");
		lblCharge.setFont(new Font("Times new roman", Font.PLAIN, 20));
		lblCharge.setBounds(5, 155, 150, 30);

		fieldCharge = new JTextField(Integer.toString(BookingGL.totalCharge));
		fieldCharge.setBounds(120, 155, 100, 40);
		fieldCharge.setFont(new Font("Times new roman", Font.PLAIN, 20));

		btnGenerate = new JButton();
		btnGenerate.setText("Generate");
		btnGenerate.setBounds(180, 60, 100, 40);
		btnGenerate.setBackground(Color.cyan);
		btnGenerate.setForeground(Color.black);
		btnGenerate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGenerate.setFocusable(false);
		btnGenerate.addActionListener(this);

		float vat = 13;

		float total = Float.parseFloat(fieldCharge.getText());
		total_Charge = (int) (total + ((13.0f / 100.0f) * total));

		this.add(btnGenerate);
		this.add(fieldCharge);
		this.add(lblCharge);
		this.add(fieldVat);
		this.add(lblVat);
		this.add(fieldBooking);
		this.add(lblBooking);
		this.add(lblHeading);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnGenerate) {

			System.out.println(total_Charge);
			// making object of Bill class from model
			Bill charge = new Bill();
			charge.setTotal_charge(Float.toString(total_Charge));
			GenerateBillJdbc bill = new GenerateBillJdbc();
			boolean result = bill.generateBill(charge);
			if (result == true) {
				JOptionPane.showMessageDialog(this, "bill generated");
			} else {
				JOptionPane.showMessageDialog(this, "sorry!");

			}
		}

	}
}
