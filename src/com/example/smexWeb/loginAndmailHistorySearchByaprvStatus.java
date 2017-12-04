package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class loginAndmailHistorySearchByaprvStatus {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testLoginAndmailHistorySearchByaprvStatus() throws Exception {
		Util.loginUser(selenium);
		selenium.waitForPageToLoad("30000");
		selenium.click("id=fileHistory");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		selenium.click("id=chk1");
		Thread.sleep(1000);
		selenium.click("id=chk4");
		selenium.click("id=chk5");
		selenium.click("id=searchBtn");
		selenium.click("css=button.appro_reason01.reason");
		selenium.waitForPageToLoad("50000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}