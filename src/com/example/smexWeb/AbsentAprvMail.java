package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class AbsentAprvMail {
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
		selenium.waitForPageToLoad("50000");
		selenium.click("id=sendListBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=sendSumnailBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=mailShowBtn");
		selenium.waitForPopUp("mailOpen", "30000");
		selenium.selectWindow("name=mailOpen");
		selenium.type("id=aprv_cause", "대리결재자 결재 승인처리되었습니다.");
		selenium.click("id=mailModalAcceptBtn");
		Thread.sleep(1000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}