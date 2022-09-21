package Cores.ElementCore;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestData.Constant;

public class SelectWrapper extends WebElementWrapper{
	
	private final Select select = new Select(super.getRawWebElement());
	
	public SelectWrapper(WebElement inputElement) {
		super(inputElement);
	}

	public static SelectWrapper findSelectElementWrapper(By by) {
		int timeout = Constant.TIMEOUT;
		return findSelectElementWrapper(by, timeout);
	}
	
	public static SelectWrapper findSelectElementWrapper(By by, int timeout) {
		return new SelectWrapper(WebElementWrapper.findElement(by, timeout));
	}
	
	public static Select findSelectElement(By by) {
		int timeout = Constant.TIMEOUT;
		return findSelectElement(by, timeout);
	}
	
	public static Select findSelectElement(By by, int timeout) {
		return new Select(WebElementWrapper.findElement(by, timeout));
	}
	
	public void selectByValue(String value) {
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public void select(String value) {
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getCbbListItems() {
		List<WebElement> listOptionElements = select.getOptions();
		List<String> listOptions = new ArrayList<String>();
		for (int i = 0; i < listOptionElements.size(); i++) {
			listOptions.add(listOptionElements.get(i).getText());	
		}
		return listOptions;
	}
		
}
