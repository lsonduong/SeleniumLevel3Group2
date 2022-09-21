package TestModules;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Cores.DriverCore.WebDriverManager;
import TestData.Messages;

public class TestBase {
	
	@BeforeMethod
	@Parameters({"DriverKey"}) 
	public void beforeMethod(@Optional("Chrome") String driverKey) {
		System.out.println("Running on " + driverKey);
		System.out.println(Messages.PreConMsg);
		System.out.println(Messages.ShowThreadIDMsg + Thread.currentThread().getId());
		try {
			WebDriverManager.startDriver(driverKey)
			.getWebDriver().manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(Messages.WebDriverFailMsg);
		}
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(Messages.PostConMsg);
		//WebDriverManager.stopDriver();
	}
}
