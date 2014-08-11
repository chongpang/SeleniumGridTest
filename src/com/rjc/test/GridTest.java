package com.rjc.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parameterized.class)
public class GridTest {
	private RemoteWebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private DesiredCapabilities capabilities;

    @Parameters
    public static List<String[]> parameters() {
            List<String[]> browsers = new ArrayList<String[]>();
            browsers.add(new String[] { Platform.WINDOWS.toString(), "firefox", "31" });
            //browsers.add(new String[] { Platform.MAC.toString(), "safari", "6" });
            browsers.add(new String[] { Platform.WINDOWS.toString(), "chrome", "36" });
            browsers.add(new String[] { Platform.WINDOWS.toString(), "internet explorer", "11" });
            return browsers;
    }
    
    public GridTest(String platform, String browser, String version) {
        capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.valueOf(platform));
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
    }
	@Before
	public void setUp() throws Exception {
		driver = new RemoteWebDriver(capabilities);
		baseUrl = "http://www.istu.co/";
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Test
	public void testCalc() throws Exception {
		
		driver.get(baseUrl + "/");
		
		driver.findElement(By.name("num1")).clear();
		driver.findElement(By.name("num1")).sendKeys("3");
		driver.findElement(By.name("num2")).clear();
		driver.findElement(By.name("num2")).sendKeys("4");
		
		Thread.sleep(2000); //
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		assertEquals("7", driver.findElement(By.id("answer")).getText());
		
		Thread.sleep(2000); //
		
		driver.findElement(By.id("back")).click();
		driver.findElement(By.name("num1")).clear();
		driver.findElement(By.name("num1")).sendKeys("12");
		driver.findElement(By.name("num2")).clear();
		driver.findElement(By.name("num2")).sendKeys("9");
		
		Thread.sleep(1000); // 
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		assertEquals("21", driver.findElement(By.id("answer")).getText());
		
		Thread.sleep(1000); //
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
