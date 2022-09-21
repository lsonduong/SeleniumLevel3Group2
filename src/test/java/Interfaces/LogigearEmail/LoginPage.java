package Interfaces.LogigearEmail;

import org.openqa.selenium.By;

import Cores.ElementCore.WebElementWrapper;
import DataObjects.Account;

public class LoginPage {

	// Locators
	
	private final By rdoPublic = By.xpath("//input[@id='rdoPblc']");	
	private final By rdoPrivate = By.xpath("//input[@id='rdoPrvt']");	
	private final By txtUsername = By.xpath("//input[@id='username']");
	private final By txtPassword = By.xpath("//input[@id='password']");
	private final By btnSignIn = By.xpath("//input[@value='Sign in']");
	
	// Elements

	public WebElementWrapper getRdoPublic() {
		return WebElementWrapper.findElementWrapper(rdoPublic);
	}
	
	public WebElementWrapper getRdoPrivate() {
		return WebElementWrapper.findElementWrapper(rdoPrivate);
	}
	
	public WebElementWrapper getTxtUsername() {
		return WebElementWrapper.findElementWrapper(txtUsername);
	}

	public WebElementWrapper getTxtPassword() {
		return WebElementWrapper.findElementWrapper(txtPassword);
	}

	public WebElementWrapper getBtnSignIn() {
		return WebElementWrapper.findElementWrapper(btnSignIn);
	}
	
	public void login(Account acc) {
		try {
			getTxtUsername().enter(acc.getUsername());
			getTxtPassword().enter(acc.getPassword());
			getBtnSignIn().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
