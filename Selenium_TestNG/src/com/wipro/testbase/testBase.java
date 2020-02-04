package com.wipro.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testBase {
	
	
	public static WebDriver driver;
	public static Properties p= new Properties();
	
	@BeforeSuite
	public static void initialize() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//resources//driverFiles//chromedriver.exe");
		driver=new ChromeDriver();
		
		File f= new File(System.getProperty("user.dir")+"//resources//config//config.properties");
		
		FileInputStream fis= new FileInputStream(f);
		
		p.load(fis);
		
		driver.get(p.getProperty("appurl"));
		
		int t= Integer.parseInt(p.getProperty("implicit_wait"));
		
		driver.manage().timeouts().implicitlyWait(t,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
	public static void closeBrowser() {
		
		driver.close();
		
	}

}
