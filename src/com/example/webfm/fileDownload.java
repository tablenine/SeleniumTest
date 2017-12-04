package com.example.webfm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class fileDownload {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.web_fm_host+":"+Util.web_fm_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testDownload() throws Exception {
		Util.loginUser(selenium);
		selenium.click("id=container1");
		selenium.click("css=button.downloadSelected");
		Thread.sleep(1000);
		selenium.click("id=confirmModalConfirmButton");
		Thread.sleep(5000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}