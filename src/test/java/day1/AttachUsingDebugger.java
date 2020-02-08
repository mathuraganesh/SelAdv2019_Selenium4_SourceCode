package day1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class AttachUsingDebugger {

	@Test
	public void run() throws InterruptedException, IOException {

		//  Write to a property file
		InputStream input = new FileInputStream("./config.properties");

		Properties prop = new Properties();
		prop.load(input);
		String property = prop.getProperty("debugger");
		System.out.println(property);
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", prop.getProperty("debugger"));

		ChromeDriver driver = new ChromeDriver(options);
		//driver.findElementById("createLeadForm_companyName").sendKeys("Test");
		driver.executeScript("_dynarch_popupCalendar.setDate(new Date(\"2010/04/05\"))");
		driver.findElementByClassName("selected").click();


	}

}
