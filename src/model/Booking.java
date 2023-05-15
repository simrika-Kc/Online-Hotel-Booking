package model;

public class Booking {
	private int Booking_id;
	private String Arrival_date;
	private String Departure_date;
	private String Roomtype;
	private int Customer_id;
	private int Manager_id;
	private int No_Of_Room;
	private String Booking_status;
	private int Room_id;

	public Booking() {
		super();
		Booking_id = 0;
		Arrival_date = "";
		Departure_date = "";
		Roomtype = "";
		Customer_id = 0;
		Manager_id = 0;
		No_Of_Room = 0;
		Booking_status = "";
		Room_id = 0;
	}

	public Booking(int booking_id, String arrival_date, String departure_date, String roomtype, int customer_id,
			int manager_id, int no_Of_Room, String booking_status, int room_id) {
		super();
		Booking_id = booking_id;
		Arrival_date = arrival_date;
		Departure_date = departure_date;
		Roomtype = roomtype;
		Customer_id = customer_id;
		Manager_id = manager_id;
		No_Of_Room = no_Of_Room;
		Booking_status = booking_status;
		Room_id = room_id;
	}

	public int getBooking_id() {
		return Booking_id;
	}

	public void setBooking_id(int booking_id) {
		Booking_id = booking_id;
	}

	public String getArrival_date() {
		return Arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		Arrival_date = arrival_date;
	}

	public String getDeparture_date() {
		return Departure_date;
	}

	public void setDeparture_date(String departure_date) {
		Departure_date = departure_date;
	}

	public String getRoomtype() {
		return Roomtype;
	}

	public void setRoomtype(String roomtype) {
		Roomtype = roomtype;
	}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public int getManager_id() {
		return Manager_id;
	}

	public void setManager_id(int manager_id) {
		Manager_id = manager_id;
	}

	public int getNo_Of_Room() {
		return No_Of_Room;
	}

	public void setNo_Of_Room(int no_Of_Room) {
		No_Of_Room = no_Of_Room;
	}

	public String getBooking_status() {
		return Booking_status;
	}

	public void setBooking_status(String booking_status) {
		Booking_status = booking_status;
	}

	public int getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(int room_id) {
		Room_id = room_id;
	}

	@Override
	public String toString() {
		return "Booking [Booking_id=" + Booking_id + ", Arrival_date=" + Arrival_date + ", Departure_date="
				+ Departure_date + ", Roomtype=" + Roomtype + ", Customer_id=" + Customer_id + ", Manager_id="
				+ Manager_id + ", No_Of_Room=" + No_Of_Room + ", Booking_status=" + Booking_status + ", Room_id="
				+ Room_id + "]";
	}

}
