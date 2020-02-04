package com.wipro.testcases;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.wipro.testbase.testBase;

public class TC_01_Login extends testBase
{
	
	@Test
	public void login()
	{
		driver.findElement(By.xpath("//a[@href=\'http://spezicoe.wipro.com:81/opencart1/index.php?route=account/account\']")).click();
		driver.findElement(By.xpath("//a[@href=\'http://spezicoe.wipro.com:81/opencart1/index.php?route=account/login']")).click();
		driver.findElement(By.name("email")).sendKeys("vishwanath@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Opencart*123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
}