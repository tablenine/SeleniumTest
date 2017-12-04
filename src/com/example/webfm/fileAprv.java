package com.example.webfm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class fileAprv {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.web_fm_host+":"+Util.web_fm_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testFileAprv() throws Exception {
		Util.loginAprv(selenium);
		selenium.click("id=container1");
		selenium.click("id=01");
		Thread.sleep(1000);
		selenium.type("id=cause", "결재자 승인");
		selenium.click("id=causeModalConfirmButton");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}