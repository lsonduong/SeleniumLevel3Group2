package Cores.ElementCore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cores.DriverCore.WebDriverManager;
import TestData.Constant;

public class WebElementWrapper {

    private final WebElement element;

    public WebElementWrapper(final WebElement inputElement) {
        this.element = inputElement;
    }
    
    public WebElementWrapper getWebElement() {
    	return new WebElementWrapper(element);
    }
    
    public WebElement getRawWebElement() {
    	return element;
    }
    
    public void click() {
        element.click();
    }
    
	public void scrollToElement() {
		WebDriver driver = WebDriverManager.getDriverInstance().getWebDriver();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
    
    public boolean isClickable() {
        try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    public void sendKeys(CharSequence... keysToSend) {
        try {
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void enter(String input) {
    	try {
			clear();
			sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void typeIn(String input) {
    	sendKeys(input);
    }
    
    public int getLeft() {
    	try {
			//Used points class to get x and y coordinates of element.
			  Point classname = element.getLocation();
			  return classname.getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return 0;
    }

    public int getTop() {
  	  	try {
			//Used points class to get x and y coordinates of element.
			  Point classname = element.getLocation();
			  return classname.getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  	return 0;
    }
    
    public int getWidth() {
    	try {
  			  return element.getSize().getWidth();
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	return 0;
    }
    
    public int getHeight() {
  	  	try {
			  return element.getSize().getHeight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  	return 0;
    }
    
    public Point getCentralPoint() {
    	int cordx = getLeft() + getWidth()/2;
    	int cordy = getTop() + getHeight()/2;
    	return new Point(cordx, cordy);
    }
    
    public void clickElement() {
    	Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
    	actions.moveToElement(element).click();
    	actions.perform();
    }
    
    public void moveToElement() {
    	Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
    	actions.moveToElement(element);
    	actions.perform();
    }
    
    public void type(String input) {
    	Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
    	clickElement();
    	actions.sendKeys(input);
    	actions.perform();
    }
    
    public void type(Keys key) {
    	Actions actions = new Actions(WebDriverManager.getDriverInstance().getWebDriver());
    	clickElement();
    	actions.sendKeys(key);
    	actions.perform();
    }

	public void clear() {
		element.clear();
	}

	public String getTagName() {
		return element.getTagName();
	}

	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	public boolean isSelected() {
		return element.isSelected();
	}

	public boolean isEnabled() {
		return element.isEnabled();
	}

	public String getText() {
		return element.getText();
	}

	public static List<WebElement> findElements(By by) {
		return WebDriverManager.getDriverInstance().findElements(by);
	}

	public static WebElement findElementDefault(By by) {
		return WebDriverManager.getDriverInstance().findElement(by);
	}
	
	public static WebElement findElement(By by) {
		int timeout = Constant.TIMEOUT;
		return findElement(by, timeout);
	}
	
	public static WebElementWrapper findElementWrapper(By by) {
		int timeout = Constant.TIMEOUT;
		return new WebElementWrapper(findElement(by, timeout));
	}
	
	public static WebElementWrapper findElementHiddenWrapper(By by) {
		int timeout = Constant.TIMEOUT;
		return new WebElementWrapper(findElementHidden(by, timeout));
	}
	
	public static List<WebElementWrapper> findElementsWrapper(By by) {
		 List<WebElementWrapper>  result = new ArrayList<WebElementWrapper>();
		 List<WebElement> eList = WebDriverManager.getDriverInstance().findElements(by);
		 for (int i=0; i < eList.size(); i++) {
			 result.add(new WebElementWrapper(eList.get(i)));
		 }
		 return result;
	}
	
	public static WebElement findElement(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriverInstance().getWebDriver(), timeout);
		while (true) {
			long timeOUt = System.currentTimeMillis() + timeout * 1000;
			try {
				return wait.until(ExpectedConditions
						.visibilityOf(wait.until(ExpectedConditions.presenceOfElementLocated(by))));
			} catch (Exception e) {
				// System.out.println(nse);
				long timeWait = System.currentTimeMillis();
				if (timeWait > timeOUt)
					break;

			}
		}
		return null;
	}
	
	public static WebElement findElementHidden(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriverInstance().getWebDriver(), timeout);
		while (true) {
			long timeOUt = System.currentTimeMillis() + timeout * 1000;
			try {
				return wait.until(ExpectedConditions.presenceOfElementLocated(by));
			} catch (Exception e) {
				// System.out.println(nse);
				long timeWait = System.currentTimeMillis();
				if (timeWait > timeOUt)
					break;

			}
		}
		return null;
	}

	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	public Point getLocation() {
		return element.getLocation();
	}

	public Dimension getSize() {
		return element.getSize();
	}

	public Rectangle getRect() {
		return element.getRect();
	}

	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}
	
	public void setCheckboxValue(boolean onOff) {
		if (element.isSelected() != onOff)
			element.click();
	}

	public <File> File getScreenshotAs(OutputType<File> target) throws WebDriverException {
		File screenshot = element.getScreenshotAs(target);
		return screenshot;
	}

	public void submit() {
		element.submit();
	}
	
	public void hover() {
		Actions actionBuilder = new Actions(WebDriverManager.getDriverInstance().getWebDriver()); 
		actionBuilder.moveToElement(element).build().perform();
	}
}
