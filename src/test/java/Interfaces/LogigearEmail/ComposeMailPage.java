package Interfaces.LogigearEmail;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import Actions.GeneralActions;
import Cores.DriverCore.WebDriverManager;
import Cores.ElementCore.WebElementWrapper;
import DataObjects.Email;
import TestData.Messages;

public class ComposeMailPage {

	// Locators
	
	private final By divTo = By.xpath("//div[@id='divTo']");	
	private final By divCc = By.xpath("//div[@id='divCc']");	
	private final By txtSubject = By.xpath("//input[@id='txtSubj']");
	private final By divBody = By.xpath("//div[@id='divBdy']");
	private final By lnkSave = By.xpath("//a[@id='save']");
	private final By lnkAttach = By.xpath("//a[@id='attachfile']");
	private final By frmAttach = By.xpath("//iframe[@id='iFrameModalDlg']");
	private final By btnAttach = By.xpath("//button[@id='btnAttch']");
	private final By lnkSend = By.xpath("//a[@id='send']");
	private final By lnkInsert = By.xpath("//a[@id='insertimage']");
	
	// Elements
	
	public WebElementWrapper getDivTo() {
		return WebElementWrapper.findElementWrapper(divTo);
	}
	
	public WebElementWrapper getDivCc() {
		return WebElementWrapper.findElementWrapper(divCc);
	}
	
	public WebElementWrapper getTxtSubject() {
		return WebElementWrapper.findElementWrapper(txtSubject);
	}

	public WebElementWrapper getDivBody() {
		return WebElementWrapper.findElementWrapper(divBody);
	}

	public WebElementWrapper getLnkSave() {
		return WebElementWrapper.findElementWrapper(lnkSave);
	}
	
	public WebElementWrapper getLnkSend() {
		return WebElementWrapper.findElementWrapper(lnkSend);
	}
	
	public WebElementWrapper getLnkInsert() {
		return WebElementWrapper.findElementWrapper(lnkInsert);
	}
	
	public WebElementWrapper getFrmAttach() {
		return WebElementWrapper.findElementWrapper(frmAttach);
	}

	public WebElementWrapper getLnkAttach() {
		return WebElementWrapper.findElementWrapper(lnkAttach);
	}
	
	public WebElementWrapper getUplFile(int number) {
		String id = Integer.toString(number);
		
		By uplAttachFile = By.xpath("//input[@id='file" + id + "']");
		return WebElementWrapper.findElementWrapper(uplAttachFile);
	}

	public WebElementWrapper getBtnAttach() {
		return WebElementWrapper.findElementWrapper(btnAttach);
	}
	
	public void composeNewMail(Email email, String action) {
		
		getDivTo().typeIn(email.getTo());
    	getDivCc().typeIn(email.getCc());
    	getTxtSubject().enter(email.getSubject());
    	//getTxtSubject().sendKeys(Keys.TAB);
    	getDivBody().type(email.getBody());

    	if (email.getAttachments()!=null) {
    		addAttachment(email.getAttachments());
    	}
    	
    	if (email.getInlinePictures()!=null) {
    		addInlines(email.getInlinePictures());
    	}
    	
    	if(action.equalsIgnoreCase("save")) {
        	getLnkSave().click();
    		
    		// Closing the Child Window.
    		WebDriverManager.getDriverInstance().close();
    	} else if(action.equalsIgnoreCase("send")) {
    		getLnkSend().click();
    		WebDriverManager.getDriverInstance().waitForNumberOfWindowsToBe(1);
    	}
	}
	
	
	public void addAttachment (List<String> attachments) {
    	try {
			for (int i=0; i<attachments.size(); i++) {
				getLnkAttach().click();
				GeneralActions.waitForPageReload();
				
				WebDriverManager.getDriverInstance().switchTo()
					.frame(getFrmAttach().getRawWebElement());
				
				WebDriverManager.getDriverInstance().switchTo().frame(0);
				
				getUplFile(i+1).sendKeys(attachments.get(i));
				getBtnAttach().click();
				GeneralActions.waitForPageReload();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
	
	public void addInlines (List<String> inlines) {
		try {
			for (int i=0; i<inlines.size(); i++) {
				getLnkInsert().click();
				GeneralActions.waitForPageReload();
				
				WebDriverManager.getDriverInstance().switchTo()
					.frame(getFrmAttach().getRawWebElement());
				
				WebDriverManager.getDriverInstance().switchTo().frame(0);
				
				getUplFile(i+1).sendKeys(inlines.get(i));
				getBtnAttach().click();
				GeneralActions.waitForPageReload();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.FailMsg);
		}
	}
}
