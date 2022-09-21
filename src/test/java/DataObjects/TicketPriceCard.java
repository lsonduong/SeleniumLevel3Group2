package DataObjects;

public class TicketPriceCard {
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public TicketPriceCard() {
	}
	public String getsPrice() {
		return sPrice;
	}
	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}
	
	public TicketPriceCard(String date, long price, String sPrice) {
		this.date = date;
		this.price = price;
		this.sPrice = sPrice;
	}

	private String date;
	private long price;
	private String sPrice;

}
