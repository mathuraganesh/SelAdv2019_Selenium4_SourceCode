package day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ManageCalendar {

	public static void main(String[] args) throws IOException {

		//  Write to a property file
		InputStream input = new FileInputStream("./config.properties");

		Properties prop = new Properties();
		prop.load(input);

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", prop.getProperty("debugger"));

		ChromeDriver driver = new ChromeDriver(options);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElementById("createContactForm_birthDate-button").click();
		driver.executeScript("_dynarch_popupCalendar.setDate(new Date(\"2021/12/25\"))");
		driver.findElementByXPath("//td[contains(@class,'selected')]").click();

//		new GwtDateTimePicker(g_form.getControl("incident.resolved_at"), 'yyyy-MM-dd', true)._selectDate(2021,1,11,true)
//		driver.switchTo().frame("gsft_main");
//		try {
//			driver.executeScript(
//					"var dt = new GwtDateTimePicker(g_form.getControl(\"incident.resolved_at\"), 'yyyy-MM-dd', true); "
//					+ "dt._selectDate(2021,1,11,true);");
//		} catch (Exception e) {
//			driver.executeScript("var dt = new GwtDateTimePicker(g_form.getControl(\"incident.resolved_at\"), 'yyyy-MM-dd', true); dt._selectDate(2021,1,11,true);");
//		}

	}

}
