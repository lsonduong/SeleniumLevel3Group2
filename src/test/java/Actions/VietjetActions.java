package Actions;

import java.time.LocalDate;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Cores.DriverCore.WebDriverManager;
import Cores.Supporter.Utilities;
import DataObjects.AirTicket;
import DataObjects.TicketPriceCard;
import Interfaces.Vietjet.SelectFarePage;
import Interfaces.Vietjet.VietjetPage;
import TestData.Constant;
import TestData.Messages;

public class VietjetActions extends GeneralActions {
	
	VietjetPage vietjetPage = new VietjetPage();
	SelectFarePage selectFarePage = new SelectFarePage();
	
	public void openVietjetUS() {
		openWebPage(Constant.VietjetUSUrl);
	}
	
	public void openVietjetVN() {
		openWebPage(Constant.VietjetVNUrl);
	}

	public void bookAirTicket(AirTicket ticket) {
		vietjetPage.bookingAirTicket(ticket);
		waitForPageReload();
	}
	
	public void checkTravelOptionPageDisplayed() {
		try {
			boolean eDisplay = vietjetPage.getLblTravelOption().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkChonGiaVePageDisplayed() {
		try {
			boolean eDisplay = vietjetPage.getLblChonGiaVe().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkLuaChonChuyenDiPageDisplayed() {
		try {
			boolean eDisplay = vietjetPage.getLblLuaChuyenDi().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkThongTinHanhKhachPageDisplayed() {
		try {
			boolean eDisplay = vietjetPage.getLblThongTinKhach().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkVNDCurrency() {
		try {
			boolean eDisplay = vietjetPage.getLblCurrency().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkDateCorrect(String date) {
		try {
			boolean eDisplay = vietjetPage.getLblDate(date).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkDatePasCorrect(String date) {
		try {
			boolean eDisplay = vietjetPage.getLblDatePas(date).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkPricePasCorrect(String price) {
		try {
			boolean eDisplay = vietjetPage.getLblPricePas(price).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkAdultPassengersNumber(int num) {
		try {
			boolean eDisplay = vietjetPage.getLblNoAdults(num).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkAdultVNPassengersNumber(int num) {
		try {
			boolean eDisplay = vietjetPage.getLblNoVNAdults(num).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkLocation(String location) {
		try {
			boolean eDisplay = vietjetPage.getLblLocation(location).isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void selectLowestPricesAndContinue() {
		try {
			Utilities.wait(3);
			vietjetPage.selectLowestDepFare();
			Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
			vietjetPage.getLblTravelOption().click();
			for (int i=0;i<=20;i++) {
				actions.sendKeys(Keys.ARROW_DOWN);
				actions.build().perform();
			}
			vietjetPage.selectLowestRetFare();
			vietjetPage.getLblTravelOption().click();
			vietjetPage.getBtnContinue().click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkPageInVietnamese() {
		try {
			boolean eDisplay = vietjetPage.getLblTiengViet().isDisplayed();
			Assert.assertTrue(eDisplay,Messages.PassMsg);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void moveCalendarNext3Month() {
		selectFarePage.selectCalendarNextMonths(3);
	}
	
	public TicketPriceCard selectCheapestDepatureTicketNoDaysTripAndContinue(int daysOfTrip) {
		try {
			TicketPriceCard ticPrice = selectFarePage.selectLowestPriceDepDay();
			LocalDate cheapDay = Utilities.convertStringtoDate(ticPrice.getDate(), "yyyyMMdd");
			LocalDate retDay = cheapDay.plusDays(daysOfTrip);
			String sRetday = Utilities.convertDateToString(retDay, "yyyyMMdd");
			selectFarePage.getCelDateOnRetCalendar(sRetday).scrollToElement();
			selectFarePage.getCelDateOnRetCalendar(sRetday).click();
			vietjetPage.getBtnContinue().scrollToElement();
			vietjetPage.getBtnContinue().click();
			waitForPageReload();
			String newPatternedDate = Utilities.convertStringDateToAnotherPattern(ticPrice.getDate(),"yyyyMMdd","dd/MM/yyyy");
			ticPrice.setDate(newPatternedDate);
			return ticPrice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
			return null;
		}
	}
}
