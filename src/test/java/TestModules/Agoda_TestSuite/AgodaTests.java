package TestModules.Agoda_TestSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Actions.AgodaActions;
import Cores.Reporting.ExtentTestManager;
import DataObjects.Booking;
import TestData.Constant;
import TestData.Variables;
import TestModules.TestBase;


@Listeners(Cores.Reporting.TestListener.class)	

public class AgodaTests extends TestBase{
	
	@Test
	public void AgodaTestsTC_01() {
		AgodaActions actions = new AgodaActions(); 
		Variables var = new Variables();
		Booking booking = var.getBookingData();
		
		ExtentTestManager.logInfo("TC_01 - Search and sort hotel successfully.");
			
		ExtentTestManager.logInfo("Step1 Navigate to https://www.agoda.com/");
		actions.openAgoda();
		
		ExtentTestManager.logInfo("Step2 Search the hotel with the following information: "
				+ "-Place: Da Nang -Date: 3 days from next Friday "
				+ "-Number of people: Family Travelers -> 2 rooms and 4 adults");
		actions.searchHotel(booking);
		
		ExtentTestManager.logInfo("Search Result is displayed correctly with first 5 hotels(destination).");
		actions.checkDestination5Hotels(booking.getDestination());
		
		ExtentTestManager.logInfo("Step3 Sort hotels by lowest prices");
		actions.sortCheapestPrice();
		
		ExtentTestManager.logInfo("- 5 first hotels are sorted with the right order. "
				+ "-The hotel destination is still correct ");
		actions.checkCheapestPrice(200000);
		actions.checkDestination5Hotels(booking.getDestination());
	}
	
	@Test
	public void AgodaTestsTC_02() {
		AgodaActions actions = new AgodaActions(); 
		Variables var = new Variables();
		Booking booking = var.getBookingData();
		
		ExtentTestManager.logInfo("TC_02 - Search and filter hotel successfully.");
			
		ExtentTestManager.logInfo("Step1 Navigate to https://www.agoda.com/");
		actions.openAgoda();
		
		ExtentTestManager.logInfo("Step2 Search the hotel with the following information: "
				+ "-Place: Da Nang -Date: 3 days from next Friday "
				+ "-Number of people: Family Travelers -> 2 rooms and 4 adults");
		actions.searchHotel(booking);
		
		ExtentTestManager.logInfo("Search Result is displayed correctly with first 5 hotels(destination).");
		actions.checkDestination5Hotels(booking.getDestination());
		
		ExtentTestManager.logInfo("Step3 Filter the hotels with the following info: "
				+ "-Price: 500000-1000000VND "
				+ "-Star:3");
		actions.filterStarRatingAndPrice("500000", "1000000", 3);
		
		ExtentTestManager.logInfo("VP -The price and start filtered is highlighted"
				+ "-Search Result is displayed correctly with first 5 hotels(destination, price, star).");
		actions.checkDestination5Hotels(booking.getDestination());
		actions.checkStarRating5Hotels(3);
		actions.checkPriceRange5Hotels(500000, 1000000);
		
		ExtentTestManager.logInfo("Step4 Remove price filter");
		actions.removeFilterPrice();
		
		ExtentTestManager.logInfo("VP -The price slice is reset");
		actions.checkCheapestPrice(500000);
	}
	
	@Test
	public void AgodaTestsTC_03() {
		AgodaActions actions = new AgodaActions(); 
		Variables var = new Variables();
		Booking booking = var.getBookingData();
		
		ExtentTestManager.logInfo("TC_01 - Add hotel into Favourite successfully.");
			
		ExtentTestManager.logInfo("Step1 Navigate to https://www.agoda.com/");
		actions.openAgoda();
		
		ExtentTestManager.logInfo("Step2 Search the hotel with the following information: "
				+ "-Place: Da Nang -Date: 3 days from next Friday "
				+ "-Number of people: Family Travelers -> 2 rooms and 4 adults");
		actions.searchHotel(booking);
		
		ExtentTestManager.logInfo("Search Result is displayed correctly with first 5 hotels(destination).");
		actions.checkDestination5Hotels(booking.getDestination());
		
		ExtentTestManager.logInfo("Step3 Filter the non smoking hotels and choose the 5th hotel in the list");
		actions.filterMore(7); //non-smoking
		
		ExtentTestManager.logInfo("The hotel detailed page is displayed with correct info "
				+ "+Name "
				+ "+Destination "
				+ "+Have swimming pool -> should be non smoking ");
		actions.clickAndCheckHotelInfo(5, "Non-smoking");

		ExtentTestManager.logInfo("Step4 Move mouse to point of the hotel to show detailed review points");
		actions.moveToFirstHotelScore();
		
		ExtentTestManager.logInfo("-Detailed review popup appears and show the following information: "
				+ "Cleanliness, Facilities, Service, Location, Value for money");
		actions.checkPopUpCardInfo(Constant.PopInfoList);
		
		ExtentTestManager.logInfo("Step5 Choose the first hotel");	
		ExtentTestManager.logInfo("VP The hotel detailed page is displayed with correct info "
				+ "+Name "
				+ "+Destination "
				+ "+Non smoking hotel "
				+ "+Detailed review points are correct");
		actions.clickAndCheckHotelInfo(1, "Non-smoking");
	}
}
