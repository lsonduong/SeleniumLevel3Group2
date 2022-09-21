package TestData;

import Cores.Supporter.Utilities;
import DataObjects.AirTicket;
import DataObjects.Booking;

public class Variables {
	
	public Booking getBookingData() {
		Booking book = new Booking();
		book.setDateIn(Utilities.getNextFriday());
		book.setDateOut(Utilities.getNextFridayPlusThree());
		book.setDestination("Da Nang");
		book.setOccupantType("Family travelers");
		book.setNoOfRooms(2);
		book.setNoOfAdults(4);
		book.setNoOfChilds(0);
		return book;
	}
	
	public AirTicket getTicketData(boolean checkLowest) {
		AirTicket tic = new AirTicket();
		tic.setReturnOrOneway("return");
		tic.setDepartDate(Utilities.getNextDay());
		tic.setReturnDate(Utilities.getNextDayPlusTree());
		tic.setCurrency("VND");
		tic.setNoOfAdults(2);
		tic.setOrigin("Ho Chi Minh");
		tic.setDestination("Ha Noi");
		tic.setCheckLowest(checkLowest);
		return tic;
	}
	
	public AirTicket getTicketDataVN(boolean checkLowest) {
		AirTicket tic = new AirTicket();
		tic.setReturnOrOneway("return");
		tic.setDepartDate(Utilities.getNextDay());
		tic.setReturnDate(Utilities.getNextDayPlusTree());
		tic.setCurrency("VND");
		tic.setNoOfAdults(2);
		tic.setOrigin("SGN");
		tic.setDestination("HAN");
		tic.setCheckLowest(checkLowest);
		return tic;
	}
	
	public final String DepartDate = Utilities.getNextDay(Constant.VietjetBPattern);
	public final String ReturnDate = Utilities.getNextDayPlusTree(Constant.VietjetBPattern);
	public final String VNDepart = "Ho Chi Minh";
	public final String VNReturn = "Ha Noi";
}
