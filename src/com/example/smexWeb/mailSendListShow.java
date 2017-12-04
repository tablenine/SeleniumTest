package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class mailSendListShow {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testMailSend() throws Exception {
		Util.loginUser(selenium);
		selenium.click("id=sendListBtn");
		selenium.click("id=mailShowBtn");
		selenium.waitForPopUp("mailOpen", "30000");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

