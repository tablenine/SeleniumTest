package com.example.webfm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class aprvListSearch {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.web_fm_host+":"+Util.web_fm_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAprvListSearch() throws Exception {
		Util.loginAprv(selenium);
		selenium.click("id=approvalList");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.click("id=chk1");
		selenium.click("id=chk2");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.click("id=chk2");
		selenium.click("id=chk3");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.click("id=chk3");
		selenium.click("id=chk4");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.click("id=chk4");
		selenium.click("id=chk5");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.click("id=chk1");
		selenium.click("css=div.overSelect");
		selenium.click("css=div.overSelect");
		Thread.sleep(1000);
		selenium.type("id=searchText", "테스트39");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
