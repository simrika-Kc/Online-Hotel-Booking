package model;

public class ManagerModel {
	private int Manager_id;
	private String First_name;
	private String Last_name;
	private String Email;
	private String DOB;
	private String Username;
	private String Password;
	private String Location;
	private String Salary;

	public ManagerModel() {
		Manager_id = 0;
		First_name = "";
		Last_name = "";
		Email = "";
		DOB = "";
		Username = "";
		Password = "";
		Location = "";
		Salary = "";
	}

	public ManagerModel(int manager_id, String first_name, String last_name, String email, String dOB, String username,
			String password, String location, String salary) {
		super();
		Manager_id = manager_id;
		First_name = first_name;
		Last_name = last_name;
		Email = email;
		DOB = dOB;
		Username = username;
		Password = password;
		Location = location;
		Salary = salary;
	}

	public int getManager_id() {
		return Manager_id;
	}

	public void setManager_id(int manager_id) {
		Manager_id = manager_id;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
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

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Manager [Manager_id=" + Manager_id + ", First_name=" + First_name + ", Last_name=" + Last_name
				+ ", Email=" + Email + ", DOB=" + DOB + ", Username=" + Username + ", Password=" + Password
				+ ", Location=" + Location + ", Salary=" + Salary + "]";
	}

}
