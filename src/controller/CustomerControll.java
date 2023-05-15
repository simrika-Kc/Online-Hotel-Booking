package controller;

import model.Customer;

public class CustomerControll {

	// Define a private variable named customerInfo of type Customer
	private Customer customerInfo;

	// Define a default constructor for the class
	public CustomerControll() {
		// Initialize customerInfo to a new Customer object
		this.customerInfo = new Customer();
	}

	// Define a parameterized constructor for the class that takes a Customer object
	// as input
	public CustomerControll(Customer customerInfo) {
		super();
		// Set customerInfo to the input Customer object
		this.customerInfo = customerInfo;
	}

	// Define a getter for the customerInfo variable
	public Customer getCustomerInfo() {
		return customerInfo;
	}

	// Define a setter for the customerInfo variable
	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	// Define a method named login that allows a customer to login
	public void login() {
		// Set customerInfo to the result of the login method of a LoginControll object
		this.customerInfo = new LoginControll().login(this.customerInfo);
	}

}
