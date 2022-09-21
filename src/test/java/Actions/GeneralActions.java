package Actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import Cores.DriverCore.WebDriverManager;
import Cores.ElementCore.WebElementWrapper;
import TestData.Constant;

public class GeneralActions {
	
	public static String getAlertMessage() {
		while (true) {
			long timeOut = System.currentTimeMillis() + Constant.TIMEOUT * 1000;
			try {
				return WebDriverManager.getDriverInstance().getAlert();
			} catch (Exception e) {
				long timeWait = System.currentTimeMillis();
				if (timeWait > timeOut)
					break;
			}
		}
		return WebDriverManager.getDriverInstance().getAlert();
	}
	
	public static boolean checkAlertMessage(String messsage) {
		if (getAlertMessage().trim().equals(messsage)) {
			return true;
		}
		return false;
	}
	
	public static void clickButtonOnAlert(String buttonName) {
		WebDriverManager.getDriverInstance().clickButtonOnAlert(buttonName);
		waitForPageReload();
	}
	
	public static void waitForPageReload() {
		WebDriverManager.getDriverInstance().waitForPageLoaded();
	}
	
	public static void close() {
		WebDriverManager.getDriverInstance().quit();
	}
	
	public static boolean getIfElementExist(By inputXpath) {
		try {
			int count = WebElementWrapper.findElementsWrapper(inputXpath).size();
			if (count > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void openWebPage(String webUrl) {
		System.out.println("Open web page " + webUrl + " on thread: " + Thread.currentThread().getId());
		WebDriverManager.getDriverInstance().navigate(webUrl);
	}
	
	public static void closeChildWindows() {
        String mainWindow = WebDriverManager.getDriverInstance().getWindowHandle();		
		
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
            	// Closing the Child Window.
            	WebDriverManager.getDriverInstance().close();
            }		
        }		
        // Switching to Parent window i.e Main Window.
        WebDriverManager.getDriverInstance().switchTo().window(mainWindow);	
	}
	
	public static void copyStringToClipboard(String str) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clipboard.setContents(strSel, null);
	}
}
