package Interfaces.Vietjet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import Cores.ElementCore.SelectWrapper;
import Cores.ElementCore.WebElementWrapper;
import Cores.Supporter.Utilities;
import DataObjects.AirTicket;
import TestData.Messages;

public class VietjetPage {
	
	// Locators
	
	private final By rdoReturn = By.xpath("//input[@value='RbRoundTrip']");
	private final By rdoOneWay = By.xpath("//input[@value='RbOneWay']");
	private final By spnOriginSelect = By.xpath("//span[@aria-labelledby='select2-selectOrigin-container']");
	private final By spnDestinationSelect = By.xpath("//span[@aria-labelledby='select2-selectDestination-container']");
	private final By txtSearch = By.xpath("//input[@class='select2-search__field']");
	private final By txtDepartDate = By.xpath("//input[contains(@id,'TxtDepartDate')]");
	private final By txtReturnDate = By.xpath("//input[contains(@id,'TxtReturnDate')]");
	private final By cbbMonth = By.xpath("//select[@class='ui-datepicker-month']");
	private final By txtCurrency = By.xpath("//input[contains(@id,'CbbCurrency')]");
	private final By txtAdults = By.xpath("//input[contains(@id,'CbbAdults')]");
	private final By btnSearch = By.xpath("//input[contains(@id,'BtSearch')]");
	private final By chkInfare = By.xpath("//input[contains(@id,'ChkInfare')]");
	private final By lblTravelOption = By.xpath("//h1[text()='Select Travel Options']");
	private final By lblCurrency = By.xpath("//span[contains(text(),'VND')]");
	private final By btnContinue = By.xpath("//a[contains(@href,'continue')]");
	private final By tblDepTable = By.xpath("//*[@id='toDepDiv']//table//table[@class='FlightsGrid']");
	private final By tblRetTable = By.xpath("//*[@id='toRetDiv']//table//table[@class='FlightsGrid']");
	private final By lblTiengViet = By.xpath("//h3[text()='Tổng đài đặt vé']");
	private final By lblChonGiaVe = By.xpath("//h1[text()='Chọn giá vé']");
	private final By lblLuaChuyenDi = By.xpath("//h1[text()='Lựa chọn chuyến đi']");
	private final By lblThongTinKhach = By.xpath("//h1[text()='Thông tin hành khách']"); 

	// Elements
	
	public WebElementWrapper getRdoReturn() {
		return WebElementWrapper.findElementWrapper(rdoReturn);
	}
	
	public WebElementWrapper getRdoOneWay() {
		return WebElementWrapper.findElementWrapper(rdoOneWay);
	}
	
	public WebElementWrapper getLblTiengViet() {
		return WebElementWrapper.findElementWrapper(lblTiengViet);
	}
	
	public WebElementWrapper getLblChonGiaVe() {
		return WebElementWrapper.findElementWrapper(lblChonGiaVe);
	}
	
	public WebElementWrapper getLblLuaChuyenDi() {
		return WebElementWrapper.findElementWrapper(lblLuaChuyenDi);
	}
	
	public WebElementWrapper getLblThongTinKhach() {
		return WebElementWrapper.findElementWrapper(lblThongTinKhach);
	}
	
	public WebElementWrapper getTblDepTable() {
		return WebElementWrapper.findElementWrapper(tblDepTable);
	}
	
	public WebElementWrapper getTblRetTable() {
		return WebElementWrapper.findElementWrapper(tblRetTable);
	}
	
	public WebElementWrapper getRdoDepFare(int row) {
		String xpathExpression = "//td[contains(@id,'gridTravelOptDep-" 
				+ Integer.toString(row) + "') and contains(@id,'Eco')]//input[@id='fare']";
		return WebElementWrapper.findElementHiddenWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getRdoLowestDepFare() {
		String xpathExpression = "//td[contains(@id,'gridTravelOptDep-" 
				+ getRowDepLowestPrice() + "') and contains(@id,'Eco')]";
		return WebElementWrapper.findElementHiddenWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getRdoRetFare(int row) {
		String xpathExpression = "//td[contains(@id,'gridTravelOptRet-" 
				+ Integer.toString(row) + "') and contains(@id,'Eco')]//input[@id='fare']";
		return WebElementWrapper.findElementHiddenWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getRdoLowestRetFare() {
		String xpathExpression = "//td[contains(@id,'gridTravelOptRet-" 
				+ getRowRetLowestPrice() + "') and contains(@id,'Eco')]";
		return WebElementWrapper.findElementHiddenWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getBtnContinue() {
		return WebElementWrapper.findElementWrapper(btnContinue);
	}
	
	public WebElementWrapper getLblDate(String date) {
		return WebElementWrapper.findElementWrapper(By.xpath("//b[contains(text(),'" + date + "')]"));
	}
	
	public WebElementWrapper getLblDatePas(String date) {
		return WebElementWrapper.findElementWrapper(By.xpath("//span[contains(text(),'" + date + "')]"));
	}
	
	public WebElementWrapper getLblPricePas(String price) {
		return WebElementWrapper.findElementWrapper(By.xpath("//span[contains(text(),'" + price + "')]"));
	}
	
	public WebElementWrapper getLblNoAdults(int num) {
		String xpath ="//*[@id='tblPaxCountsInfo']/tbody/tr/td[contains(text(),'" 
				+ Integer.toString(num) + "')]/span[contains(text(),'Adults')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}	
	
	public WebElementWrapper getLblNoVNAdults(int num) {
		String xpath ="//*[@id='tblPaxCountsInfo']/tbody/tr/td[contains(text(),'" 
				+ Integer.toString(num) + "')]/span[contains(text(),'Người lớn')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}	
	
	public WebElementWrapper getLblTravelOption() {
		return WebElementWrapper.findElementWrapper(lblTravelOption);
	}
	
	public WebElementWrapper getLblLocation(String location) {
		return WebElementWrapper.findElementWrapper(By.xpath("//td[contains(text(),'" + location + "')]"));
	}
	
	
	public WebElementWrapper getLblCurrency() {
		return WebElementWrapper.findElementWrapper(lblCurrency);
	}
	
	public WebElementWrapper getChkInfare() {
		return WebElementWrapper.findElementWrapper(chkInfare);
	}
	
	public WebElementWrapper getBtnSearch() {
		return WebElementWrapper.findElementWrapper(btnSearch);
	}
	
	public WebElementWrapper getSpnOriginSelect() {
		return WebElementWrapper.findElementWrapper(spnOriginSelect);
	}
	
	public WebElementWrapper getSpnDestinationSelect() {
		return WebElementWrapper.findElementWrapper(spnDestinationSelect);
	}
	
	public WebElementWrapper getTxtSearch() {
		return WebElementWrapper.findElementWrapper(txtSearch);
	}
	
	public WebElementWrapper getTxtCurrency() {
		return WebElementWrapper.findElementWrapper(txtCurrency);
	}
	
	public WebElementWrapper getTxtAdults() {
		return WebElementWrapper.findElementWrapper(txtAdults);
	}
	
	public WebElementWrapper getTxtDepartDate() {
		return WebElementWrapper.findElementWrapper(txtDepartDate);
	}
	
	public SelectWrapper getCbbMonth() {
		return SelectWrapper.findSelectElementWrapper(cbbMonth);
	}
	
	public WebElementWrapper getTxtReturnDate() {
		return WebElementWrapper.findElementWrapper(txtReturnDate);
	}
	
	public WebElementWrapper getLiLocation(String location) {
		String xpathExpression = "//li[contains(text(),'" + location + "')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpathExpression));
	}
	
	public WebElementWrapper getLnkDay(String day) {
		String xpathExpression = "//a[text()='" + day + "']";
		return WebElementWrapper.findElementWrapper(By.xpath(xpathExpression));
	}
	
	public void bookingAirTicket(AirTicket ticket) {
		try {
			if (!ticket.getReturnOrOneway().isEmpty()) {
				switch (ticket.getReturnOrOneway()) {
					case "return":
						getRdoReturn().click();
						break;
					case "oneway":
						getRdoOneWay().click();
						break;
				}
			}
			
			getSpnOriginSelect().click();
			getTxtSearch().enter(ticket.getOrigin());
			getLiLocation(ticket.getOrigin()).click();
			Utilities.wait(3);
			
			getSpnDestinationSelect().click();
			getTxtSearch().enter(ticket.getDestination());
			getLiLocation(ticket.getDestination()).click();
			
			String [] dateSplit = Utilities.splitDayMonthYear(ticket.getDepartDate());
			getTxtDepartDate().click();
			getCbbMonth().select(dateSplit[0]);
			getLnkDay(dateSplit[1]).click();
			
			String [] returnSplit = Utilities.splitDayMonthYear(ticket.getReturnDate());
			getTxtReturnDate().click();
			getCbbMonth().select(returnSplit[0]);
			getLnkDay(returnSplit[1]).click();;
			
			getTxtAdults().type(Integer.toString(ticket.getNoOfAdults()));
			getTxtAdults().type(Keys.ENTER);
			
			if (ticket.isCheckLowest()) {
				getChkInfare().click();
			}
			
			getBtnSearch().click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public long getDepFareByRow(int row) {
		try {
			String sFare = getRdoDepFare(row).getAttribute("value");
			String sFareNum = Utilities.removeNonDigits(sFare);
			return Long.parseLong(sFareNum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
			return 0;
		}
	}
	
	public long getRetFareByRow(int row) {
		try {
			String sFare = getRdoRetFare(row).getAttribute("value");
			String sFareNum = Utilities.removeNonDigits(sFare);
			return Long.parseLong(sFareNum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			Assert.fail(); e.printStackTrace();
			return 0;
		}
	}
	
	public int getRowDepLowestPrice() {
		long low = getDepFareByRow(1);;
		long temp = 0;
		int lowRow = 1;
		for(int i=2;i<=6;i++) {
			temp = getDepFareByRow(i);
			if(low > temp) {
				low = temp;
				lowRow = i;
			}
		}
		return lowRow;
	}
	
	public int getRowRetLowestPrice() {
		long low = getRetFareByRow(1);
		long temp = 0;
		int lowRow = 1;
		for(int i=2;i<=6;i++) {
			temp = getRetFareByRow(i);
			if(low > temp) {
				low = temp;
				lowRow = i;
			}
		}
		return lowRow;
	}
	
	public void selectLowestDepFare() {
		try {
			getRdoLowestDepFare().click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void selectLowestRetFare() {
		try {
			
			getRdoLowestRetFare().click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
}
