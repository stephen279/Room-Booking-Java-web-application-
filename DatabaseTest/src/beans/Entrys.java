package beans;
   // bean for RoomEntry
public class Entrys {

	private String userName = "";
	private String costumerName = "";
	private String location = "";
	private String roomSize = "";
	private String roomPrice = "";
	private String contact = "";
	private String message = "Problem with your Entry";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Entrys() {
		// need this constructor for bean
	}

	public Entrys(String userName, String costumerName, String location,
			String roomSize, String roomPrice, String contact) {
		System.out.println("inside Entry constructor");
		// Constructor
		this.userName = userName;
		this.costumerName = costumerName;
		this.location = location;
		this.roomSize = roomSize;
		this.roomPrice = roomPrice;
		this.contact = contact;

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCostumerName() {
		return costumerName;
	}

	public void setCostumerName(String costumerName) {
		this.costumerName = costumerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Boolean validate() {
		if (!"admin".equals(userName)) {
			// if(userName != "admin"){

			message = "Sorry you need Administration rights to Enter a room";
			return false;
		}

		if (userName.length() < 1) {

			message = "userName field empty";
			return false;
		}

		if (costumerName.length() < 1) {

			message = "costumerName field empty";
			return false;

		}

		if (location.length() < 1) {

			message = "location field empty";
			return false;

		}

		if (roomPrice.length() < 1) {

			message = "roomprice field empty";
			return false;

		}

		if (roomSize.length() < 1) {

			message = "roomSize field  empty";
			return false;

		}

		if (contact.length() < 1) {

			message = "contact field empty";
			return false;

		}

		return true; // if everything validate ok return true
	}

}
