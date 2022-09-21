package DataObjects;

public class Booking {
	
	private String destination;
	private String dateIn;
	private String dateOut;
	private String occupantType;
	private int noOfRooms;
	private int noOfAdults;
	private int noOfChilds;
	
	public Booking() {
		
	}
	
	public Booking(String destination, String dateIn, String dateOut, String occupantType, int noOfRooms,
			int noOfAdults, int noOfChilds) {
		this.destination = destination;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.occupantType = occupantType;
		this.noOfRooms = noOfRooms;
		this.noOfAdults = noOfAdults;
		this.noOfChilds = noOfChilds;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDateIn() {
		return dateIn;
	}
	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}
	public String getDateOut() {
		return dateOut;
	}
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	public String getOccupantType() {
		return occupantType;
	}
	public void setOccupantType(String occupantType) {
		this.occupantType = occupantType;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChilds() {
		return noOfChilds;
	}
	public void setNoOfChilds(int noOfChilds) {
		this.noOfChilds = noOfChilds;
	}
}
