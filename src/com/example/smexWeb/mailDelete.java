package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class mailDelete {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testFileDelete() throws Exception {
		Util.loginUser(selenium);
		selenium.open("/send/sendMail.sqi");
		selenium.click("id=container1");
		selenium.click("css=button.deleteSelected");
		Thread.sleep(1000);
		selenium.click("id=confirmModalConfirmButton");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=alertReloadModalCloseButton");
		selenium.waitForPageToLoad("30000");
		/*//전체삭제 테스트
		selenium.click("id=check_all");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=button.deleteSelected");
		Thread.sleep(1000);
		selenium.click("id=confirmModalConfirmButton");
		selenium.waitForPageToLoad("30000"); */
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
