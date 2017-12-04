package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class aprvHistorySearch {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAprvHistorySearch() throws Exception {
		Util.loginAprv(selenium);
		selenium.waitForPageToLoad("30000");
		selenium.click("id=approvalList");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.select("id=send_state", "label=발송실패");
		selenium.click("css=#send_state > option[value=\"2\"]");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=send_state", "label=발송성공");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=send_state", "label=발송안함");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.overSelect");
		selenium.click("id=chk1");
		selenium.waitForPageToLoad("10000");
		selenium.click("id=chk2");
		selenium.click("id=searchBtn");
		selenium.click("css=button.appro_reason01.reason");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
