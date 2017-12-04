package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class pswdChange {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAdfasdf() throws Exception {
		Util.loginUser(selenium);
		selenium.waitForPageToLoad("30000");
		selenium.click("id=username");
		Thread.sleep(1000);
		selenium.click("id=pwchange");
		Thread.sleep(1000);
		selenium.type("id=pw", "qwe123!@#");
		selenium.type("id=pw1", "qwe123#@!");
		selenium.type("id=pw2", "qwe123#@!");
		Thread.sleep(1000);
		selenium.click("css=button.approval_con.ps_change");
		Thread.sleep(1000);
		selenium.click("id=alertModalCloseButton");
		Thread.sleep(1000);
		selenium.click("id=username");
		Thread.sleep(1000);
		selenium.click("id=logout");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=user_id", "user39");
		selenium.type("id=user_pw", "qwe123#@!");
		selenium.click("id=loginBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=username");
		Thread.sleep(1000);
		selenium.click("id=pwchange");
		Thread.sleep(1000);
		selenium.type("id=pw", "qwe123#@!");
		selenium.type("id=pw1", "qwe123!@#");
		selenium.type("id=pw2", "qwe123!@#");
		Thread.sleep(1000);
		selenium.click("css=button.approval_con.ps_change");
		Thread.sleep(1000);
		selenium.click("id=alertModalCloseButton");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}