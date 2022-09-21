package Actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Cores.DriverCore.WebDriverManager;
import Cores.Supporter.Utilities;
import DataObjects.Booking;
import Interfaces.Agoda.AgodaPage;
import Interfaces.LogigearEmail.ComposeMailPage;
import TestData.Constant;
import TestData.Messages;

public class AgodaActions extends GeneralActions {
	
	AgodaPage agodaPage = new AgodaPage();
	
	public void openAgoda() {
		openWebPage(Constant.AgodaUrl);
	}
	
	public void searchHotel(Booking booking) {
		agodaPage.enterSearchInfo(booking);
		waitForPageReload();
	}
	
	public void checkDestination5Hotels(String city) {
		try {
			String temp = "";
			Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.build().perform();
			for (int i=0;i<5;i++) {
				temp = agodaPage.getSpnCityText(i).getText();
				Assert.assertTrue(temp.contains(city),"Search Result is correct: "+ i);
			}
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkStarRating5Hotels(int starRating) {
		try {
			String temp = "";
			Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.build().perform();
			for (int i=0;i<5;i++) {
				temp = agodaPage.getHotelStar(i);
				Assert.assertTrue(temp.contains(Integer.toString(starRating)),"Search Result is correct: "+ i);
			}
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkPriceRange5Hotels(long min, long max) {
		try {
			String temp = "";
			String num = "";
			long numParsed;
			boolean checker;
			Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.sendKeys(Keys.PAGE_DOWN);
			actions.build().perform();
			for (int i=0;i<5;i++) {
				temp = agodaPage.getHotelPrice(i);
				num = Utilities.removeNonDigits(temp);
				numParsed = Long.parseLong(num);
				if ((numParsed < max) && (numParsed > min)) {
					checker = true;
				} else {
					checker = false;
				}
				Assert.assertTrue(checker,"Search Result is correct: "+ i);
			}
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.sendKeys(Keys.PAGE_UP);
			actions.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void sortCheapestPrice() {
		agodaPage.clickSortCheapest();
		waitForPageReload();
	}
	
	public void checkCheapestPrice(long value) {
		String price = agodaPage.getHotelPrice();
		String num = Utilities.removeNonDigits(price);
		Assert.assertTrue(Long.parseLong(num) < value, "Cheapest Price Displayed");
	}
	
	public void filterStarRatingAndPrice(String priceMin, String priceMax, int starRating) {
		agodaPage.filterStarRating(starRating);
		waitForPageReload();
		Utilities.wait(2);
		agodaPage.filterPrice(priceMin, priceMax);
		waitForPageReload();
		Utilities.wait(2);
	}
	
	public void filterMore(int index) {
		agodaPage.filterMore(index);
		waitForPageReload();
		Utilities.wait(2);
	}
	
	public String clickOnAHotelAndGetName(int index) {
		String name = agodaPage.getHotelName(index);
		agodaPage.getLnkHotelResult(index).scrollToElement();
		agodaPage.getLnkHotelResult(index).click();
		waitForPageReload();
		Utilities.wait(2);
		return name;
	}
	
	public void removeFilterPrice() {
		agodaPage.closefilterPrice();
	}
	
	public void moveToFirstHotelScore() {
		try {
			agodaPage.getLnkHotelResult(1).scrollToElement();
			agodaPage.getSpnHotelReviewScore(1).moveToElement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void chooseFirstHotel() {
		try {
			agodaPage.getLnkHotelResult(1).scrollToElement();
			agodaPage.getLnkHotelResult(1).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void clickAndCheckHotelInfo(int hotelIndex, String moreFilter) {
		String mainWindow = WebDriverManager.getDriverInstance().getWindowHandle();	
		
		String destination = agodaPage.getSpnCityText(hotelIndex).getText();
		String name = clickOnAHotelAndGetName(hotelIndex);
		
		waitForPageReload();
		WebDriverManager.getDriverInstance().waitForNumberOfWindowsToBe(2);
        
        // To handle all new opened window.	
        Set<String> s1 = WebDriverManager.getDriverInstance().getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        
        		
        while(i1.hasNext())			
        {		
            String childWindow=i1.next();	
            if(!mainWindow.equalsIgnoreCase(childWindow))			
            {
                // Switching to Child window
            	WebDriverManager.getDriverInstance().switchTo().window(childWindow);		                
            	
        		Assert.assertEquals(agodaPage.getSpnCityText(hotelIndex).getText(), destination);
        		Assert.assertEquals(agodaPage.getLblHotelName(hotelIndex).getText(), name);
        		Assert.assertEquals(agodaPage.getSpnInfo(moreFilter), true);
            	
        		WebDriverManager.getDriverInstance().close();
        		
		        // Switching to Parent window i.e Main Window.
		        WebDriverManager.getDriverInstance().switchTo().window(mainWindow);	
            }
        }
	}
	
	public void checkPopUpCardInfo(String[] sArray) {
		for(int i=0;i<sArray.length;i++) {
			Assert.assertEquals(agodaPage.getSpnInfo(sArray[i]).isDisplayed(), true);
		}
	}
}
