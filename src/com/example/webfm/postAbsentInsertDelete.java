package com.example.webfm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class postAbsentInsertDelete {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.web_fm_host+":"+Util.web_fm_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPostAbsentInsertDelete() throws Exception {
		Util.loginAprv(selenium);
		selenium.click("id=approvalAbsent");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=absentDeleteBtn");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=cause", "대리결재자 삭제");
		selenium.click("id=causeModalConfirmButton");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.click("id=1");
		selenium.click("id=absentInsertBtn");
		selenium.type("id=cause", "대리결재자 추가");
		selenium.click("id=causeModalConfirmButton");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
