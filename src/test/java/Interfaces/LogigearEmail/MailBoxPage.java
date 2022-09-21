package Interfaces.LogigearEmail;

import org.openqa.selenium.By;

import Cores.ElementCore.WebElementWrapper;

public class MailBoxPage {

	// Locators
	
	private final By lnkNew = By.xpath("//*[@id=\"newmsgc\"]/span[text() = 'New']");	
	private final By lnkDrafts = By.xpath("//span[text()='Drafts']");
	private final By lnkInbox = By.xpath("//span[text()='Inbox']");
	private final By lnkDismissAll = By.xpath("//a[@id='divBtnDismissall']");
	
	// Elements
	
	public WebElementWrapper getlnkNew() {
		return WebElementWrapper.findElementWrapper(lnkNew);
	}
	
	public WebElementWrapper getLnkDrafts() {
		return WebElementWrapper.findElementWrapper(lnkDrafts);
	}
	
	public WebElementWrapper getLnkInbox() {
		return WebElementWrapper.findElementWrapper(lnkInbox);
	}
	
	public WebElementWrapper getLnkDismissAll() {
		return WebElementWrapper.findElementWrapper(lnkDismissAll);
	}
	
	public WebElementWrapper getDivMailSubject(String subject) {
		String xpath = "//div[@id='divSubject' and contains(text(),'"+ subject +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getSpnMailTo(String to) {
		String xpath = "//span[contains(@title,'"+ to +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getDivMailContent(String body) {
		String xpath = "//div[contains(text(),'"+ body +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getSpnMailContent(String body) {
		String xpath = "//span[contains(text(),'"+ body +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getLnkAttachment(String attachFileName) {
		String xpath = "//a[contains(@title,'"+ attachFileName +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
	
	public WebElementWrapper getLnkInsert(String insertFileName) {
		String xpath = "//img[contains(@src,'"+ insertFileName +"')]";
		return WebElementWrapper.findElementWrapper(By.xpath(xpath));
	}
}
