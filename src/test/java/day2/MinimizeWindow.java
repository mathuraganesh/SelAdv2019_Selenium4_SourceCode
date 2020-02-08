package day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MinimizeWindow {
	
	/*
	 * Internal Architecture
	 * Minimize, Switching to a new tab
	 * Window -> Switch using the name
	 * Attach to the existing browser (PostMan + Code)
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://flipkart.com");
		
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
	}

}
