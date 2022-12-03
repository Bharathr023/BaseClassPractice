package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver ;


	//1. Browser launch
	public static WebDriver browserLaunch(String type) {
		if (type.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();


		}else if (type.equalsIgnoreCase("Fire fox")) {
			WebDriverManager.firefoxdriver().setup();

		}
		driver.manage().window().maximize();
		return driver;

	}
	//2.close method
	public static void close() {
		driver.close();
	}

	//3.Quit
	public static void quit() {
		driver.close();
	}
	//4. Getting url
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;

	}
	//5. Click
	public static void clickOnElement(WebElement element) {
		element.click();

	}
	//6.SendKeys
	public static void inputValue(WebElement element, String value) {
		element.sendKeys(value);

	}
	//7.Navigate to Url
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	//8.Navigate Forward
	public static void navigateForward() {
		driver.navigate().forward();

	}
	//9.Navigate backward
	public static void navigateBackward() {
		driver.navigate().back();
	}
	//10.Refresh
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	//11.Read Data
	public static void readData(String path) throws IOException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			String value = cell.getStringCellValue();
		}
		else if (cellType.equals(CellType.NUMERIC)) {
			double cellValue = cell.getNumericCellValue();
			int value = (int) cellValue;

		}

	}
	//12.Takes Screenshot
	public static void takingScreenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
		FileHandler.copy(source, dest);

	}	
	//13.Is Enabled
	public static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();

	}
	//14.Is Displayed
	public static void isDisplayed(WebElement element){
		boolean displayed = element.isDisplayed();

	}
	//15.Is Selected
	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();

	}
	//16.Implicit wait
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	//17.GetText
	public static void getingText(WebElement element) {
		String text = element.getText();
	}
	//18.Drop Downs 
	public static void dropDown(String type, WebElement element, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("SelectByValue")) {
			s.selectByValue(value);
		}else if (type.equalsIgnoreCase("SelectByIndex")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		}else if (type.equalsIgnoreCase("SelectByVisibleText")) {
			s.selectByVisibleText(value);

		}

	}
	//19.Actions
	public static void mouseActions(String type, WebElement element) {
		Actions ac = new Actions(driver);
		if (type.equalsIgnoreCase("Click")) {
			ac.click(element).build().perform();
		}else if (type.equalsIgnoreCase("Rightclick")) {
			ac.contextClick(element).build().perform();
		}else if (type.equalsIgnoreCase("Double Click")) {
			ac.doubleClick(element).build().perform();

		}	

	}

	//Drag and Drop
	public static void dragAndDrop(Actions ac, WebElement element1, WebElement element2) {
		ac.dragAndDrop(element1, element2).build().perform();

	}
	//20.Get current url
	public static void getCurrentUrl() {
		driver.getCurrentUrl();

	}
	//21.Get Text
	public static void getText(WebElement element, String value) {
		String text = element.getText();
	}
	//22.Get Title
	public static void getTitle() {
		driver.getTitle();

	}
	//23.clear
	public static void clearData(WebElement element) {
		element.clear();

	}
	//24.quit
	public static void quitWindow() {
		driver.quit();
	}
	//25.
}







