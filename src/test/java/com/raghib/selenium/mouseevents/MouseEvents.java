package com.raghib.selenium.mouseevents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.raghib.selenium.BaseClass;

public class MouseEvents extends BaseClass {
	
	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	public static String url = "https://www.carmax.com/";
	
	//ALL WEBELEMENT
	public static WebElement elementMoreMenu;
	public static WebElement elementFAQ; 
	
	//ALL LOCATORS
	public static By menuXPath = By.xpath("//span[text()='More']");
	public static By faqXPath = By.xpath("//a[@class='header-link' and text()='FAQ & support']");
	
	public static void main(String[] args) {
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		
		elementMoreMenu = driver.findElement(menuXPath);
				
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(elementMoreMenu).build().perform();
		
		elementFAQ = driver.findElement(faqXPath);
		//Below both code is working.
		//actionObj.click(elementFAQ).build().perform();
		actionObj.click(elementFAQ).perform();
		
		//BaseClass.quitDriver();
	}
}