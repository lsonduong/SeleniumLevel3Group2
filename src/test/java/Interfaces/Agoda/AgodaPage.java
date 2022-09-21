package Interfaces.Agoda;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import Actions.GeneralActions;
import Cores.ElementCore.WebElementWrapper;
import Cores.Supporter.Utilities;
import DataObjects.Booking;
import TestData.Messages;

public class AgodaPage {
	
	// Locators
	private final By btnSearch = By.xpath("//button[@data-element-name='search-button']");	
	private final By txtSearch = By.xpath("//input[@data-selenium='textInput']");
	private final By divOccupant = By.xpath("//div(@data-selenium='occupancyBox']");
	private final By divCheckIn = By.xpath("//div[@data-selenium='checkInText']");
	private final By divCheckOut = By.xpath("//div[@data-selenium='checkOutText']");
	private final By svgPlusRoom = By.xpath("//span[@data-element-name='occupancy-selector-panel-rooms' "
			+ "and @data-selenium='plus']/*[name()='svg']");
	private final By svgPlusAdult = By.xpath("//span[@data-element-name='occupancy-selector-panel-adult' "
			+ "and @data-selenium='plus']/*[name()='svg']");
	private final By svgPlusChild = By.xpath("//span[@data-element-name='occupancy-selector-panel-children' "
			+ "and @data-selenium='plus']/*[name()='svg']");
	private final By spnPrevious = By.xpath("//span[@data-selenium='calendar-previous-month-button']");
	private final By spnNext = By.xpath("//span[@data-selenium='calendar-next-month-button']");
	private final By spnCheapestSort = By.xpath("//span[text()='Cheapest price']");
	private final By spnLowestPrice = By.xpath("//span[text()='Lowest price first']");
	private final By spnPrice = By.xpath("//span[@data-selenium='display-price']");
	private final By divStarsFilter = By.xpath("//div[@data-element-value='StarRating']");
	private final By divBudgetFilter = By.xpath("//div[@data-element-value='PriceFilterRange']");
	private final By txtMin = By.xpath("//input[@id='price_box_0']");
	private final By txtMax = By.xpath("//input[@id='price_box_1']");
	private final By iPriceFilterClose = By.xpath("//i[@data-element-name='search-filter-type-pricefilterrange-close']");
	private final By spnBest = By.xpath("//span[text()='Best match']");
	private final By spnMore = By.xpath("//span[text()='More']");
	
	// Elements

	public WebElementWrapper getBtnSearch() {
		return WebElementWrapper.findElementWrapper(btnSearch);
	}
	
	public WebElementWrapper getSpnBest() {
		return WebElementWrapper.findElementWrapper(spnBest);
	}
	
	public WebElementWrapper getSpnMore() {
		return WebElementWrapper.findElementWrapper(spnMore);
	}
	
	public WebElementWrapper getSpnMoreFilter(int index) {
		String xpath = "//span[@data-element-name='search-filter-hotelfacilities' "
				+ "and @data-element-index='" + Integer.toString(index) + "']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getIPriceFilterClose() {
		return WebElementWrapper.findElementWrapper(iPriceFilterClose);
	}
	
	public WebElementWrapper getTxtMin() {
		return WebElementWrapper.findElementWrapper(txtMin);
	}
	
	public WebElementWrapper getTxtMax() {
		return WebElementWrapper.findElementWrapper(txtMax);
	}
	
	public WebElementWrapper getSpnStarRating(int starRating) {
		String xpathExpression = "//span[@data-element-name='search-filter-starrating' "
				+ "and @data-element-value='" + Integer.toString(starRating) 
				+ "']/span/span[@class='checkbox-icon']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getDivBudgetFilter() {
		return WebElementWrapper.findElementWrapper(divBudgetFilter);
	}
	
	public WebElementWrapper getDivStarsFilter() {
		return WebElementWrapper.findElementWrapper(divStarsFilter);
	}
	
	public WebElementWrapper getSpnPrice() {
		return WebElementWrapper.findElementWrapper(spnPrice);
	}
	
	public WebElementWrapper getSpnCheapestSort() {
		if (GeneralActions.getIfElementExist(spnCheapestSort)) {
			return WebElementWrapper.findElementWrapper(spnCheapestSort);
		} else {
			return WebElementWrapper.findElementWrapper(spnLowestPrice);
		}
	}
	
	public WebElementWrapper getSpnPrevious() {
		return WebElementWrapper.findElementWrapper(spnPrevious);
	}
	
	public WebElementWrapper getSpnNext() {
		return WebElementWrapper.findElementWrapper(spnNext);
	}
	
	public WebElementWrapper getTxtSearch() {
		return WebElementWrapper.findElementWrapper(txtSearch);
	}
	
	public WebElementWrapper getDivOccupant() {
		return WebElementWrapper.findElementWrapper(divOccupant);
	}
	
	public WebElementWrapper getDivCheckIn() {
		return WebElementWrapper.findElementWrapper(divCheckIn);
	}
	
	public WebElementWrapper getDivCheckOut() {
		return WebElementWrapper.findElementWrapper(divCheckOut);
	}
	
	public WebElementWrapper getSvgPlusRoom() {
		return WebElementWrapper.findElementWrapper(svgPlusRoom);
	}
	
	public WebElementWrapper getSvgPlusAdult() {
		return WebElementWrapper.findElementWrapper(svgPlusAdult);
	}
	
	public WebElementWrapper getSvgPlusChild() {
		return WebElementWrapper.findElementWrapper(svgPlusChild);
	}
	
	public WebElementWrapper getSpnSuggestion(String city) {
		return WebElementWrapper.findElementWrapper(By.xpath("//span[contains(text(),'" + city + "')]"));
	}
	
	public WebElementWrapper getSpnInfo(String str) {
		return WebElementWrapper.findElementWrapper(By.xpath("//span[(text()='" + str + "']"));
	}
	
	public WebElementWrapper getDivDate(String date) {
		return WebElementWrapper.findElementWrapper(By.xpath("//div[@aria-label='" + date + "']"));
	}
	
	public WebElementWrapper getDivContains(String contain) {
		return WebElementWrapper.findElementWrapper(By.xpath("//div[contains(text(),'" + contain + "')]"));
	}
	
	public WebElementWrapper getLnkHotelResult(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	} 
	
	public WebElementWrapper getLblHotelName(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']//h3[@data-selenium='hotel-name']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	} 
	
	public WebElementWrapper getSpnCityText(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']//span[@data-selenium='area-city-text']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
			
	public WebElementWrapper getIHotelRating(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']//i[@data-selenium='hotel-star-rating']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getSpnHotelPrice(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']//span[@data-selenium='display-price']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getSpnHotelReviewScore(int number) {
		String xpath ="//a[contains(@id,'hotel-') and contains(@id,'-container') and @data-element-index='" 
				+ Integer.toString(number) + "']//div[@class='property-card-content']//span[@class='ReviewScore-Number']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public void enterSearchInfo(Booking booking) {
		
		try {
			getTxtSearch().enter(booking.getDestination());
			Utilities.wait(1);
			getSpnSuggestion(booking.getDestination()).click();
			
			try {
				getDivDate(booking.getDateIn()).click();
			} catch (Exception e) {
				getSpnPrevious().click();
				getDivDate(booking.getDateIn()).click();
			}
			
			try {
				getDivDate(booking.getDateOut()).click();
			} catch (Exception e) {
				getSpnNext().click();
				getDivDate(booking.getDateOut()).click();
			}
			
			getDivContains(booking.getOccupantType()).click();
			Utilities.wait(1);
			for (int i=1; i<booking.getNoOfRooms(); i++) {
				getSvgPlusRoom().click();
				Utilities.wait(2);
			}
			
			for (int i=2; i<booking.getNoOfAdults(); i++) {
				getSvgPlusAdult().click();
				Utilities.wait(2);
			}
			
			getBtnSearch().click();
			GeneralActions.waitForPageReload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHotelUrl(int number) {
		return getLnkHotelResult(number).getAttribute("href");
	}
	
	public String getHotelStar(int number) {
		return getIHotelRating(number).getAttribute("title");
	}
	
	public void clickSortCheapest() {
		getSpnCheapestSort().click();
	}
	
	public String getHotelPrice() {
		return getSpnPrice().getText();
	}
	
	public String getHotelPrice(int number) {
		return getSpnHotelPrice(number).getText();
	}
	
	public void filterStarRating(int starRating) {
		try {
			Utilities.wait(2);
			getDivStarsFilter().clickElement();
			Utilities.wait(2);
			getSpnStarRating(starRating).clickElement();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void filterPrice(String priceMin, String priceMax) {
		try {
			Utilities.wait(2);
			getDivBudgetFilter().clickElement();
			Utilities.wait(2);
			getTxtMin().enter(priceMin);
			getTxtMax().enter(priceMax);
			getTxtMax().sendKeys(Keys.ENTER);
			getDivBudgetFilter().clickElement();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void closefilterPrice() {
		try {
			Utilities.wait(2);
			getIPriceFilterClose().click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void filterMore(int index) {
		try {
			Utilities.wait(2);
			getSpnMore().clickElement();
			Utilities.wait(2);
			getSpnMoreFilter(index).click();
			getSpnMore().clickElement();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public String getHotelName(int index) {
		try {
			return getLblHotelName(index).getText();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
			return null;
		}
	}
}
