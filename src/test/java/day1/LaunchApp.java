package day1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LaunchApp {
	
	@Test
	public void startApplication() {
		
		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		// Launch your browser
	    ChromeDriver driver = new ChromeDriver();
				
		// Load the URL
	    driver.get("http://google.com");
	    driver.executeScript("window.name = 'Google'");
	    
	    // Open a new window
	    driver.switchTo().newWindow(WindowType.TAB);
	    driver.get("http://facebook.com");
	    driver.executeScript("window.name = 'FB'");
	    
	    // Switch based on the window name
	    driver.switchTo().window("Google");
	    String title = driver.getTitle();
	    System.out.println(title);
	    
	    
	    
	    
		
		
	}

}
