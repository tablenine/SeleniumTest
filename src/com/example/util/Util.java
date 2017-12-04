package com.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.Selenium;

public class Util {
	public static String smex_web_host = "192.168.1.59";
	public static int smex_web_port = 1443;
	
	public static String web_fm_host = "192.168.1.59";
	public static int web_fm_port = 443;
	
	public static void loginUser(Selenium selenium) {
		selenium.open("/user/logout.sqi");
		selenium.type("name=user_id", "user01");
		selenium.type("id=user_pw", "qwe123!@#");
		selenium.click("id=loginBtn");
		selenium.waitForPageToLoad("20000");
	}
	
	public static void loginAprv(Selenium selenium) {
		selenium.open("/user/logout.sqi");
		selenium.type("name=user_id", "user11");
		selenium.type("id=user_pw", "qwe123!@#");
		selenium.click("id=loginBtn");
		selenium.waitForPageToLoad("20000");
	}
	
	public static void loginAbsent(Selenium selenium) {
		selenium.open("/user/logout.sqi");
		selenium.type("name=user_id", "user2");
		selenium.type("id=user_pw", "qwe123!@#");
		selenium.click("id=loginBtn");
		selenium.waitForPageToLoad("20000");
	}

	public static WebDriver makeDriver() {
		WebDriver driver;
		//chrome
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		
		//internetExploer
//		System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
//		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
//		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		driver = new InternetExplorerDriver(cap);
		return driver;
	}
}
