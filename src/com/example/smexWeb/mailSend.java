package com.example.smexWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.util.Util;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class mailSend {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Util.makeDriver();
		String baseUrl = "https://"+Util.smex_web_host+":"+Util.smex_web_port+"/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testMailSend() throws Exception {
		Util.loginUser(selenium);
		selenium.click("id=sendMail");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=sendBtn");
		selenium.waitForPopUp("mailSend", "30000");
		selenium.selectWindow("name=mailSend");
		selenium.type("id=mailSubject", "메일 발송 테스트");
		selenium.type("css=input.ui-widget-content.ui-autocomplete-input", "tablenine@naver.com");
		selenium.click("id=ccUserBtn");
		selenium.type("xpath=(//input[@type='text'])[3]", "tablenine@sqisoft.com");
		selenium.click("id=bcUserBtn");
		selenium.click("css=#mceu_3 > button[type=\"button\"]");
		selenium.type("xpath=(//input[@type='text'])[4]", "tablenine@daum.net");
		selenium.click("css=#user31_anchor > i.jstree-icon.jstree-checkbox");
		selenium.type("name=file", "C:\\Users/SQI소프트/Desktop/05_홍성표책임_JMeter 정확히 알고 제대로 활용하자_P46.pdf");
		selenium.click("id=sendBtn");
		selenium.waitForPopUp("mail", "30000");
		selenium.selectWindow("name=mail");
		selenium.type("id=file_cause", "요청합니다.");
		selenium.selectWindow("name=mail");
		Thread.sleep(1000);
		selenium.click("id=okBtn");
		selenium.selectWindow(null);
		selenium.click("id=alertReloadModalCloseButton");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
