package com.testrunner;
import java.awt.image.CropImageFilter;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RunnerBaseClass extends BaseClass{

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		driver =browserLaunch("chrome");
		driver=getUrl("https://adactinhotelapp.com/");

		WebElement userId = driver.findElement(By.id("username"));
		inputValue(userId, "Bharath23");
		WebElement pwd = driver.findElement(By.id("password"));
		inputValue(pwd, "12345678");

		WebElement login = driver.findElement(By.id("login"));
		clickOnElement(login);
		WebElement location = driver.findElement(By.id("location"));
		dropDown("SelectByIndex", location, "2");

		WebElement hotel = driver.findElement(By.id("hotels"));
		dropDown("SelectByIndex", hotel, "2");

		WebElement room = driver.findElement(By.id("room_type"));
		dropDown("SelectByIndex", room, "1");
		WebElement search = driver.findElement(By.id("Submit"));

		clickOnElement(search);

		WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio']"));
		clickOnElement(radioButton);

		WebElement conti = driver.findElement(By.id("continue"));
		clickOnElement(conti);
		WebElement firstName = driver.findElement(By.id("first_name"));
		inputValue(firstName, "Bharath");
		WebElement lastName = driver.findElement(By.id("last_name"));
		inputValue(lastName, "R");
		WebElement address = driver.findElement(By.id("address"));
		inputValue(address, "No.150 mariamman kovil street");

		WebElement cc = driver.findElement(By.id("cc_num"));
		inputValue(cc, "1234567123456713");

		WebElement ccType = driver.findElement(By.id("cc_type"));
		dropDown("SelectByIndex", ccType, "3");

		WebElement month = driver.findElement(By.id("cc_exp_month"));
		dropDown("SelectByIndex", month, "4");
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		dropDown("SelectByValue", year, "2022");

		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		inputValue(cvv, "456");
		WebElement book = driver.findElement(By.id("book_now"));
		clickOnElement(book);

		WebElement logOut = driver.findElement(By.xpath("//a[text()='Logout']"));
		clickOnElement(logOut);
		/*
		 * WebDriverWait w = new WebDriverWait(driver, 30);
		 * w.until(ExpectedConditions.visibilityOf(logOut));
		 */
		takingScreenshot("C:\\Users\\karthi\\eclipse-workspace\\BaseClassPractice\\Screenshot\\adactin.png");
	}


}






