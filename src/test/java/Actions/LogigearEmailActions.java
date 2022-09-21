package Actions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Cores.DriverCore.WebDriverManager;
import Cores.Reporting.ExtentTestManager;
import Cores.Supporter.Utilities;
import DataObjects.Account;
import DataObjects.Email;
import Interfaces.LogigearEmail.ComposeMailPage;
import Interfaces.LogigearEmail.LoginPage;
import Interfaces.LogigearEmail.MailBoxPage;
import TestData.Constant;
import TestData.Messages;

public class LogigearEmailActions extends GeneralActions {

	MailBoxPage mailBoxPage = new MailBoxPage();
	
	public void login(Account account) {
		try {
			new LoginPage().login(account);
			waitForPageReload();
			//if (getIfElementExist(By.xpath(Constant.DismissAllXapth))) {
			//	mailBoxPage.getLnkDismissAll().click();
			//}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void openLgMail() {
		openWebPage(Constant.LgMailUrl);
	}
	
	public void composeMail (Email email, String action) {
		try {		
	        String mainWindow = WebDriverManager.getDriverInstance().getWindowHandle();		
			
			mailBoxPage.getlnkNew().click();
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
	            	
	            	new ComposeMailPage().composeNewMail(email, action);
	            	
			        // Switching to Parent window i.e Main Window.
			        WebDriverManager.getDriverInstance().switchTo().window(mainWindow);	
	            }
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void composeNewMailAndSave(Email email) {
		try {		
			composeMail(email, "save");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void composeNewMailAndSend(Email email) {
		try {		
			composeMail(email, "send");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkMailInDrafts(Email email, String attachFileName) {
		try {
			mailBoxPage.getLnkDrafts().click();
			mailBoxPage.getDivMailSubject(email.getSubject()).click();
			waitForPageReload();
			Assert.assertEquals(mailBoxPage.getSpnMailTo(email.getTo()).isDisplayed(),true);
			try {
				Assert.assertEquals(mailBoxPage.getSpnMailContent(email.getBody()).isDisplayed(),true);
			} catch (Exception e) {
				Assert.assertEquals(mailBoxPage.getDivMailContent(email.getBody()).isDisplayed(),true);
			}
			if (attachFileName != "") {
				Assert.assertEquals(mailBoxPage.getLnkAttachment(attachFileName).isDisplayed(),true);
			}
			ExtentTestManager.getTest().log(LogStatus.PASS,"Mail saved in Draft with correct info");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkMailInBox(Email email, String insertFileName) {
		try {
			mailBoxPage.getLnkInbox().click();
			mailBoxPage.getDivMailSubject(email.getSubject()).click();
			waitForPageReload();
			Assert.assertEquals(mailBoxPage.getSpnMailTo(email.getTo()).isDisplayed(),true);
			Assert.assertEquals(mailBoxPage.getSpnMailContent(email.getBody()).isDisplayed(),true);
			if (insertFileName != "") {
				Assert.assertEquals(mailBoxPage.getLnkInsert(insertFileName).isDisplayed(),true);
			}
			ExtentTestManager.getTest().log(LogStatus.PASS,"Mail sent with correct info");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void checkDownloadImage(String imageName, String filepath) {
		try {
			
			File tempFile = new File(filepath);
			boolean exists = tempFile.exists();
			
			if (exists) {
				tempFile.delete();
			}
			
			Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
			actions.contextClick(mailBoxPage.getLnkInsert(imageName).getRawWebElement()).build().perform();
			Utilities.wait(3);
			actions.sendKeys("v").build().perform();
			Utilities.wait(3);
			GeneralActions.copyStringToClipboard(filepath);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_V);
			Utilities.wait(3);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER); 

			Utilities.wait(3);
			File newFile = new File(filepath);
			exists = newFile.exists();
			Assert.assertEquals(true, exists);
			ExtentTestManager.getTest().log(LogStatus.PASS,"Image Downloaded succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void SaveImageFile(String imageName) {		
		try {
		     String logoSRC = mailBoxPage.getLnkInsert(imageName).getAttribute("src");
		     
		     URL imageURL = new URL(logoSRC);
		     BufferedImage saveImage = ImageIO.read(imageURL);
		     
		     ImageIO.write(saveImage, "jpg", new File(Constant.ImageDownload));
		} catch (Exception e) {
		     e.printStackTrace();
		     Assert.fail(Messages.FailMsg);
		}	
	}
}
