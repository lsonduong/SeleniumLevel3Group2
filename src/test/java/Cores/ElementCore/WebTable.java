package Cores.ElementCore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable extends WebElementWrapper{

	public WebTable(WebElement element) {
		super(element);
	}
	
	public static WebElement getTableCell(String identification, int row_index, int column_index) {
		String xpath = "";
		if (row_index == 1) {
			xpath = String.format("//table[@%s]/tbody/tr[%d]/th[%d]", identification, row_index, column_index);
		} else {
			xpath = String.format("//table[@%s]/tbody/tr[%d]/td[%d]", identification, row_index, column_index);
    	}

		By tableCell = By.xpath(xpath);
        return findElement(tableCell);
    }
	
	public static String getXpathTableCellContaining(String identification, String value, boolean convertNonBreakSpace) {
		String[] listChar = value.split(" ");
		System.out.println(listChar.length);
		
		if (convertNonBreakSpace) {
			value.replaceAll(" ", " ");
		}
		String xpath = String.format("//table[@%s]/tbody/tr/td[", identification);
		String addin = "";
		
		for (int i = 0; i < listChar.length; i++) {
			if (i < (listChar.length-1)) {
				addin = String.format("contains(.,'%s') and ", listChar[i]);
			} else {
				addin = String.format("contains(.,'%s')]", listChar[i]);
			}
			xpath = String.format("%s%s", xpath, addin);
		}
		
		return xpath;
    }
	
	public static WebElement getTableCellContaining(String identification, String value, boolean convertNonBreakSpace) {
		String xpath = getXpathTableCellContaining(identification, value, convertNonBreakSpace);
		
		By tableCell = By.xpath(xpath);
        return findElement(tableCell);
	}
	
	public static int getTotalCellContaining(String identification, String value, boolean convertNonBreakSpace) {
		String xpath = getXpathTableCellContaining(identification, value, convertNonBreakSpace);
		
		By tableCell = By.xpath(xpath);
        return findElements(tableCell).size();
    }
	
	public static String getTableCellValue(String identification, int row_index, int column_index) {
        return getTableCell(identification, row_index, column_index).getText();
    }
	
	public static void clickTableCell(String identification, int row_index, int column_index) {
        getTableCell(identification, row_index, column_index).click();
    }
	
	public static String getTableCellXpath(String identification, int row_index, int column_index) {
		return String.format("//table[@%s]/tbody/tr[%d]/td[%d]", identification, row_index, column_index);
	}
	
	public static int getTableRowCount(String identification) {
		String xpath = String.format("//table[@%s]/tbody/tr", identification);
		return findElements(By.xpath(xpath)).size();
	}
	
	public static List<String> getTableCellsValueByColumnIndex(String identification, int column_index) {
		List<String> cellValues = new ArrayList<String>();
		int rowCount = getTableRowCount(identification);
		
		for (int i = 1; i < rowCount; i++) {	
			cellValues.add(getTableCellValue(identification, i, column_index).trim().replaceAll("[^a-zA-Z0-9]+", " "));
		}
		return cellValues;
	}
}
