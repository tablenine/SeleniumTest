package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class AbsentrejectMail {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAprvMail() throws Exception {
		Util.loginAbsent(selenium);
		selenium.click("id=approvalMail");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=mailShowBtn");
		selenium.waitForPopUp("mailOpen", "30000");
		selenium.selectWindow("name=mailOpen");
		selenium.type("id=aprv_cause", "대리결재자가 반려처리합니다.");
		selenium.click("id=mailModalReturnBtn");
		Thread.sleep(1000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}