package DataObjects;

public class AirTicket {
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public boolean isCheckLowest() {
		return checkLowest;
	}
	public void setCheckLowest(boolean checkLowest) {
		this.checkLowest = checkLowest;
	}
	public String getReturnOrOneway() {
		return returnOrOneway;
	}
	public void setReturnOrOneway(String returnOrOneway) {
		this.returnOrOneway = returnOrOneway;
	}
	
	public AirTicket(String destination, String origin, String departDate, String returnDate, String currency,
			int noOfAdults) {
		super();
		this.destination = destination;
		this.origin = origin;
		this.departDate = departDate;
		this.returnDate = returnDate;
		this.currency = currency;
		this.noOfAdults = noOfAdults;
	}

	public AirTicket() {
	}

	private String returnOrOneway;
	private String destination;
	private String origin;
	private String departDate;
	private String returnDate;
	private String currency;
	private int noOfAdults;
	private boolean checkLowest;
}
