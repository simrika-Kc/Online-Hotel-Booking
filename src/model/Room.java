package model;

public class Room {
	private int Room_Id;
	private String Room_type;
	private String Room_Charge;
	private String Room_status;

	public Room() {

		Room_Id = 0;
		Room_type = "";
		Room_Charge = "";
		Room_status = "";
	}

	public Room(int room_Id, String room_type, String room_Charge, String room_status) {
		super();
		Room_Id = room_Id;
		Room_type = room_type;
		Room_Charge = room_Charge;
		Room_status = room_status;
	}

	public int getRoom_Id() {
		return Room_Id;
	}

	public void setRoom_Id(int room_Id) {
		Room_Id = room_Id;
	}

	public String getRoom_type() {
		return Room_type;
	}

	public void setRoom_type(String room_type) {
		Room_type = room_type;
	}

	public String getRoom_Charge() {
		return Room_Charge;
	}

	public void setRoom_Charge(String room_Charge) {
		Room_Charge = room_Charge;
	}

	public String getRoom_status() {
		return Room_status;
	}

	public void setRoom_status(String room_status) {
		Room_status = room_status;
	}

	@Override
	public String toString() {
		return "Room [Room_Id=" + Room_Id + ", Room_type=" + Room_type + ", Room_Charge=" + Room_Charge
				+ ", Room_status=" + Room_status + "]";
	}

}