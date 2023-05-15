package model;

public class Customer {

	private int customer_id;
	private String First_name;
	private String Last_name;
	private String Location;
	private String Email;
	private String Mobile;
	private String Username;
	private String Password;
	private String Gender;
	private String Customer_type;
	private String Company_Name;
	private String Card_Number;
	private String Card_type;

	public Customer() {

		this.customer_id = 0;
		First_name = "";
		Last_name = "";
		Location = "";
		Email = "";
		Mobile = "";
		Username = "";
		Password = "";
		Gender = "";
		Customer_type = "";
		Company_Name = "";
		Card_Number = "";
		Card_type = "";
	}

	public Customer(int customer_id, String first_name, String last_name, String location, String email, String mobile,
			String username, String password, String gender, String customer_type, String company_name,
			String card_Number, String card_type) {
		super();
		this.customer_id = customer_id;
		First_name = first_name;
		Last_name = last_name;
		Location = location;
		Email = email;
		Mobile = mobile;
		Username = username;
		Password = password;
		Gender = gender;
		Customer_type = customer_type;
		Company_Name = company_name;
		Card_Number = card_Number;
		Card_type = card_type;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getCustomer_type() {
		return Customer_type;
	}

	public void setCustomer_type(String customer_type) {
		Customer_type = customer_type;
	}

	public String getCompany_name() {
		return Company_Name;
	}

	public void setCompany_name(String company_name) {
		Company_Name = company_name;
	}

	public String getCard_Number() {
		return Card_Number;
	}

	public void setCard_Number(String card_Number) {
		Card_Number = card_Number;
	}

	public String getCard_type() {
		return Card_type;
	}

	public void setCard_type(String card_type) {
		Card_type = card_type;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", First_name=" + First_name + ", Last_name=" + Last_name
				+ ", Location=" + Location + ", Email=" + Email + ", Mobile=" + Mobile + ", Username=" + Username
				+ ", Password=" + Password + ", Gender=" + Gender + ", Customer_type=" + Customer_type
				+ ", Company_Name=" + Company_Name + ", Card_Number=" + Card_Number + ", Card_type=" + Card_type + "]";
	}

}