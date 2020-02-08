package day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickException {

	public static void main(String[] args) {

		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		// Launch your browser
	    ChromeDriver driver = new ChromeDriver();
				
		// Load the URL
	    driver.get("https://raphaelfabeni.com/css-loader/");
	    
	    // Click on the one of the loader element
	    driver.findElementById("loader-default-half").click();
	    
	    WebElement ele = driver.findElementById("loader-bar-rounded");
	    
	    // Enabled, Visible
	    boolean displayed = ele.isDisplayed();
	    boolean enabled = ele.isEnabled();
	    
	    System.out.println(displayed +" - "+ enabled);
	    
	    // Click Another
	    driver.findElementById("loader-bar-rounded").click();

		
	}

}
