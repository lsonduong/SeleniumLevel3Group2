package Cores.DriverCore;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Cores.Supporter.Utilities;
import TestData.Constant;

public class WebDriverManager {

    private static HashMap<Long, WebDriverWrapper> driverMap = new HashMap<>();

    public static WebDriverWrapper getDriverInstance() {
        return driverMap.get(Thread.currentThread().getId());
    }

    public static WebDriverWrapper startDriver(String webBrowser) throws Exception {
        if (webBrowser.equalsIgnoreCase(Constant.ChromeDriverKey)) {
    		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + Constant.ChromeDriverPath);
        	WebDriverWrapper driver = new WebDriverWrapper(new ChromeDriver());
        	driverMap.put(Thread.currentThread().getId(), driver);
        } 
        else if (webBrowser.equalsIgnoreCase(Constant.ChromeDriverRemoteKey)) {
        	System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + Constant.ChromeDriverPath);
    		DesiredCapabilities desiredCaps = DesiredCapabilities.chrome();
        	WebDriverWrapper driver = new WebDriverWrapper(new RemoteWebDriver(new URL(Constant.HUB_URL), desiredCaps));
        	driverMap.put(Thread.currentThread().getId(), driver);
        }
        else if (webBrowser.equalsIgnoreCase(Constant.FirefoxDriverKey)) {
        	System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + Constant.FirefoxDriverPath);
        	WebDriverWrapper driver = new WebDriverWrapper(new FirefoxDriver());
        	driverMap.put(Thread.currentThread().getId(), driver);
        }
        else if (webBrowser.equalsIgnoreCase(Constant.FirefoxDriverRemoteKey)) {
        	System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + Constant.FirefoxDriverPath);
    		DesiredCapabilities desiredCaps = DesiredCapabilities.chrome();
        	WebDriverWrapper driver = new WebDriverWrapper(new RemoteWebDriver(new URL(Constant.HUB_URL), desiredCaps));
        	driverMap.put(Thread.currentThread().getId(), driver);
        }
        
        return getDriverInstance();
    }

    public static void stopDriver() {
        WebDriverWrapper driver = driverMap.get(Thread.currentThread().getId());
        driverMap.remove(Thread.currentThread().getId());
        if (driver != null) {
            driver.quit();
            driver.setWebDriver(null);
            driver = null;
        }
    }
}

