package Interfaces.Vietjet;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.testng.Assert;

import Cores.ElementCore.WebElementWrapper;
import Cores.Supporter.Utilities;
import DataObjects.TicketPriceCard;
import TestData.Messages;

public class SelectFarePage {
	
	// Locators
	private final By btnNextDep = By.xpath("//a[contains(@href,'dn')]");
	private final By btnNextRet = By.xpath("//a[contains(@href,'rn')]");
	private final By celDayDepPrice = By.xpath("//table[@id='ctrValueViewerDepGrid']//td[contains(@id,'ctrValueViewerDep')]");
	private final By celDayRetPrice = By.xpath("//table[@id='ctrValueViewerRetGrid']//td[contains(@id,'ctrValueViewerRet')]");
	
	// Elements
	
	public WebElementWrapper getBtnNextDep() {
		return WebElementWrapper.findElementWrapper(btnNextDep);
	}
	
	public WebElementWrapper getBtnNextRet() {
		return WebElementWrapper.findElementWrapper(btnNextRet);
	}
	
	public WebElementWrapper getCelDayDepPrice() {
		return WebElementWrapper.findElementWrapper(celDayDepPrice);
	}
	
	public WebElementWrapper getCelDayRetPrice() {
		return WebElementWrapper.findElementWrapper(celDayRetPrice);
	}
	
	public WebElementWrapper getCelCalendarDepDay(int dayOfMonth) {
		String xpath = "//table[@id='ctrValueViewerDepGrid']//div[text()='" + Integer.toString(dayOfMonth) + "']/p";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getCelCalendarRetDay(int dayOfMonth) {
		String xpath = "//table[@id='ctrValueViewerRetGrid']//div[text()='" + Integer.toString(dayOfMonth) + "']/p";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getCelDateOnRetCalendar(String date) {
		String xpath = "//table[@id='ctrValueViewerRetGrid']//td[contains(@id,'ctrValueViewerRet" 
				+ date + "')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	// Methods
	
	public int getTotalDaysOfMonthOnDepCalendar() {
		String xpath = "//table[@id='ctrValueViewerDepGrid']//td[contains(@id,'ctrValueViewerDep')]";
		int days = WebElementWrapper.findElements(By.xpath(xpath)).size();
		return days;
	}
	
	public int getTotalDaysOfMonthOnRetCalendar() {
		String xpath = "//table[@id='ctrValueViewerRetGrid']//td[contains(@id,'ctrValueViewerRet')]";
		int days = WebElementWrapper.findElements(By.xpath(xpath)).size();
		return days;
	}
	
	public int getDepCalendarMonth() {
		String sdate = getCelDayDepPrice().getAttribute("id");
		LocalDate date = Utilities.convertStringtoDate(sdate, "yyyyMMdd");
		return date.getMonthValue();
	}
	
	public int getRetCalendarMonth() {
		String sdate = getCelDayRetPrice().getAttribute("id");
		LocalDate date = Utilities.convertStringtoDate(sdate, "yyyyMMdd");
		return date.getMonthValue();
	}
	
	public int getDepCalendarYear() {
		String sdate = getCelDayDepPrice().getAttribute("id");
		LocalDate date = Utilities.convertStringtoDate(sdate, "yyyyMMdd");
		return date.getYear();
	}
	
	public int getRetCalendarYear() {
		String sdate = getCelDayRetPrice().getAttribute("id");
		LocalDate date = Utilities.convertStringtoDate(sdate, "yyyyMMdd");
		return date.getYear();
	}
	
	public void selectCalendarNextMonths(int NoOfMonths) {
		try {
			for(int i = 0; i < NoOfMonths; i++) {
				getBtnNextDep().click();
				Utilities.wait(8);
			}
			getBtnNextRet().scrollToElement();
			for(int i = 0; i < NoOfMonths; i++) {
				getBtnNextRet().click();
				Utilities.wait(8);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public TicketPriceCard selectLowestPriceDepDay() {
		try {
			long temp = Long.parseLong(Utilities.removeNonDigits(getCelCalendarDepDay(1).getText()));

			long low = temp;  
			int dDep = 1;
			for(int i=2; i<=getTotalDaysOfMonthOnDepCalendar(); i++) {
				temp = Long.parseLong(Utilities.removeNonDigits(getCelCalendarDepDay(i).getText()));
				if(low > temp) {
					low = temp;
					dDep = i;
				}
			}
			
			getCelCalendarDepDay(dDep).click();
			
			int mDep = getDepCalendarMonth();
			int yDep = getDepCalendarYear();
			String sYear = Integer.toString(yDep);
			String sMonth;
			String sDay;
			if (dDep<10) {
				sDay = "0" + Integer.toString(dDep);
			} else {
				sDay = Integer.toString(dDep);
			}
			
			if (mDep<10) {
				sMonth = "0" + Integer.toString(mDep);
			} else {
				sMonth = Integer.toString(mDep);
			}
			
			String sDate = sYear + sMonth + sDay;
			String sPrice = getCelCalendarDepDay(dDep).getText();
			return new TicketPriceCard(sDate, low, sPrice);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
			return null;
		}
	}
}
