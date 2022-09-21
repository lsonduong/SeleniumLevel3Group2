package TestModules.Vietjet_TestSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Actions.VietjetActions;
import Cores.Reporting.ExtentTestManager;
import Cores.Supporter.Utilities;
import DataObjects.AirTicket;
import DataObjects.TicketPriceCard;
import TestData.Variables;
import TestModules.TestBase;

@Listeners(Cores.Reporting.TestListener.class)	

public class VietjetTests extends TestBase{

	@Test
	public void VietjetTestsTC_01() {
		VietjetActions actions = new VietjetActions();
		Variables var = new Variables();
		AirTicket ticket = var.getTicketData(false);

		ExtentTestManager.logInfo("TC_01 - Search and choose tickets on a specific day successfully.");
		ExtentTestManager.logInfo("Step1 Navigate to https://www.vietjetair.com/Sites/Web/en-US/Home");
		actions.openVietjetUS();
		
		ExtentTestManager.logInfo("Step2 Search the ticket with the following information: "
				+ "-Choose \"Return\" flight from Ho Chi Minh to Ha Noi "
				+ "-The flight will take off tomorrow and return after 3 days "
				+ "-Currency: VND "
				+ "-Number of adult: 2");
		actions.bookAirTicket(ticket);
		
		ExtentTestManager.logInfo("VP - Select Travel Options page is displayed. "
				+ "-The ticket price is displayed in VND "
				+ "-The flights dates are displayed correctly "
				+ "-The departure and arrival places are correct. "
				+ "-Number of passenger is correct");
		actions.checkTravelOptionPageDisplayed();
		actions.checkVNDCurrency();
		actions.checkDateCorrect(var.DepartDate);
		actions.checkDateCorrect(var.ReturnDate);
		actions.checkAdultPassengersNumber(2);
		actions.checkLocation(ticket.getOrigin());
		actions.checkLocation(ticket.getDestination());

		ExtentTestManager.logInfo("Step3 Choose the cheapest tickets and click \"Continue\" button");
		actions.selectLowestPricesAndContinue();
		
		ExtentTestManager.logInfo("VP -Passenger Information page is displayed "
				+ "-Tickets information is correct");
		actions.checkVNDCurrency();
		actions.checkDatePasCorrect(var.DepartDate);
		actions.checkDatePasCorrect(var.ReturnDate);
		actions.checkAdultPassengersNumber(2);
		actions.checkLocation(ticket.getOrigin());
		actions.checkLocation(ticket.getDestination());
	}
	
	@Test
	public void VietjetTestsTC_02() {
		VietjetActions actions = new VietjetActions();
		Variables var = new Variables();
		AirTicket ticket = var.getTicketDataVN(true);

		ExtentTestManager.logInfo("TC_01 - Search and choose tickets on a specific day successfully.");	
		ExtentTestManager.logInfo("Step1 Navigate to https://www.vietjetair.com/Sites/Web/vi-VN/Home");
		actions.openVietjetVN();
		
		ExtentTestManager.logInfo("VP The home page is displayed in Vietnamese");
		actions.checkPageInVietnamese();
		
		ExtentTestManager.logInfo("Step2 Search the ticket with the following information: "
				+ "-Choose \"Khứ hồi\" flight from Ho Chi Minh to Ha Noi "
				+ "-Select \"Tìm giá vé rẻ nhất?\" option"
				+ "-Currency: VND "
				+ "-Number of adult: 2");
		actions.bookAirTicket(ticket);
		
		ExtentTestManager.logInfo("VP -\"Chọn giá vé\" page is displayed "
				+ "-The flight information is correct");
		actions.checkChonGiaVePageDisplayed();
		actions.checkVNDCurrency();
		actions.checkAdultVNPassengersNumber(2);
		actions.checkLocation(var.VNDepart);
		actions.checkLocation(var.VNReturn);
		
		ExtentTestManager.logInfo("Step3 Choose the cheapest tickets in next 3 months and click \"Tiếp tục\" button");
		actions.moveCalendarNext3Month();
		TicketPriceCard tpc = actions.selectCheapestDepatureTicketNoDaysTripAndContinue(3);
		
		ExtentTestManager.logInfo("VP -\"Lựa chọn chuyến đi\" page is displayed "
				+ "-Ticket information is correct");
		actions.checkLuaChonChuyenDiPageDisplayed();
		actions.checkVNDCurrency();
		actions.checkDatePasCorrect(tpc.getDate());
		actions.checkDatePasCorrect(Utilities.getStringDatePlusTree(tpc.getDate(),"dd/MM/yyyy"));
		actions.checkAdultPassengersNumber(2);
		actions.checkLocation(var.VNDepart);
		actions.checkLocation(var.VNReturn);
		
		
		ExtentTestManager.logInfo("Step4 Choose the cheapest tickets and click \"Continue\" button");
		actions.selectLowestPricesAndContinue();
		
		ExtentTestManager.logInfo("VP Passgenger Information page displays. Ticket informaton is correct");
		actions.checkThongTinHanhKhachPageDisplayed();
		actions.checkVNDCurrency();
		actions.checkDatePasCorrect(tpc.getDate());
		actions.checkDatePasCorrect(Utilities.getStringDatePlusTree(tpc.getDate(),"dd/MM/yyyy"));
		actions.checkPricePasCorrect(tpc.getsPrice());
		actions.checkAdultPassengersNumber(2);
		actions.checkLocation(var.VNDepart);
		actions.checkLocation(var.VNReturn);
	}
}