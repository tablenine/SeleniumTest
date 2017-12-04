package com.example.webfm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class fileUpload {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.web_fm_host+":"+Util.web_fm_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testFileUploadFail() throws Exception {
		Util.loginUser(selenium);
		selenium.open("/download/download.sqi");
		selenium.type("name=file", "C:\\Users/SQI소프트/Desktop/HDB_6.5.1_SNMP.pdf");
		selenium.click("id=uploadButton");
		Thread.sleep(1000);
		//selenium.click("id=user11_anchor");
		selenium.type("id=aprvFileCause", "ssss");
		selenium.click("id=modalUploadButton");
		Thread.sleep(5000);
		selenium.click("css=input.modal_close.uploadbtn_exit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}