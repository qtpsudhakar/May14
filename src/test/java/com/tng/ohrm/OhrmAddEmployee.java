package com.tng.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wd.util.DriverFactory;

public class OhrmAddEmployee{
	WebDriver driver;

	@Test
	public void login() {
		System.out.println("this is login method");
		
		System.out.println("this is a new change");
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");

		driver.findElement(By.cssSelector("input[name=\"txtPassword\"]")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
	}

	@BeforeClass
	public void openApplication() {
		// open browser
		driver = DriverFactory.getDriverFor("chrome");

		// page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Find Element timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://opensource.demo.orangehrmlive.com/");

	}

	@Test(dependsOnMethods="login")
	public void addEmployee() {
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='PIM']")));
		
		driver.findElement(By.xpath("//a[.='PIM']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Add Emp')]")).click();

		driver.findElement(By.id("firstName")).sendKeys("selenium");

		driver.findElement(By.id("lastName")).sendKeys("hq");

		driver.findElement(By.id("btnSave")).click();

	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}
}
