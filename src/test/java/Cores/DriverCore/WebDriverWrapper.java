package Cores.DriverCore;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.Constant;

public class WebDriverWrapper implements WebDriver{

	private WebDriver _webDriver;
	
	public WebDriverWrapper() {
	}
	
	public WebDriverWrapper(WebDriver webDriver) {
		_webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return _webDriver;
	}
	
	public void setWebDriver(WebDriver webDriver) {
		_webDriver = webDriver;
	}


	public void get(String url) {
		try {
			_webDriver.get(url);
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public String getCurrentUrl() {
		String result = "";
		try {
			result = _webDriver.getCurrentUrl();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return result;
	}

	public String getTitle() {
		String result = "";
		try {
			result = _webDriver.getTitle();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return result;
	}
	
	public Options manage() {
		_webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return null;
	}

	public List<WebElement> findElements(By by) {	
		return _webDriver.findElements(by);
	}

	public WebElement findElement(By by) {
		return _webDriver.findElement(by);
	}

	public String getPageSource() {
		String result = "";
		try {
			result = _webDriver.getPageSource();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return result;
	}

	public void close() {
		try {
			_webDriver.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public void quit() {
		try {
			_webDriver.quit();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public Set<String> getWindowHandles() {
		try {
			return _webDriver.getWindowHandles();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	public String getWindowHandle() {
		String result = "";
		try {
			result = _webDriver.getWindowHandle();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return result;
	}

	public TargetLocator switchTo() {
		try {
			return _webDriver.switchTo();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	public Navigation navigate(String url) {
		try {
			_webDriver.navigate().to(url);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
        }
		return null;
	}

    public  void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(_webDriver, Constant.TIMEOUT);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = _webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        	System.out.println("Exception: " + e);
        }
    }
    
    public String getAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(_webDriver, Constant.TIMEOUT);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = _webDriver.switchTo().alert();
            String result = alert.getText();
            alert.accept();
            return result;
        } catch (Exception e) {
        	System.out.println("Exception: " + e);
        }
        return "";
    }

    public void clickButtonOnAlert(String buttonToClick) {
        try {
            WebDriverWait wait = new WebDriverWait(_webDriver, Constant.TIMEOUT);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = _webDriver.switchTo().alert();
            if (buttonToClick == "OK")
            		alert.accept();
            else if (buttonToClick == "Cancel")
            		alert.dismiss();
        } catch (Exception e) {
        	System.out.println("Exception: " + e);
        }
    }
    
	public Navigation navigate() {
		try {
			_webDriver.navigate();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}
	
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver _webDriver) {
                        return ((JavascriptExecutor) _webDriver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(_webDriver, 60);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Page not Reload OR Timeout waiting for Page Load Request to complete.");
        }
    }
    
    public void waitForNumberOfWindowsToBe(int number) {
        try {
            WebDriverWait wait = new WebDriverWait(_webDriver, Constant.TIMEOUT);
            wait.until(ExpectedConditions.numberOfWindowsToBe(number));
            
        } catch (Exception e) {
        	System.out.println("Exception: " + e);
        }
    }
}
