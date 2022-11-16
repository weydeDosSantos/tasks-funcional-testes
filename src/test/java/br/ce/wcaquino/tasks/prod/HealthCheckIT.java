package br.ce.wcaquino.tasks.prod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckIT {

	WebDriver driver = new ChromeDriver();

	
	@Test
	public void healthCheck() {
		try {
			driver.navigate().to("http://192.168.1.4:9999/tasks/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build"));
			
		}finally {
			driver.quit();
		}
	}
}
