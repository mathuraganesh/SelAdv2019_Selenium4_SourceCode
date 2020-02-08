package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Customize {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().window().maximize();
		
		//driver.switchTo();
		
		driver.get("http://leafground.com");
		
		driver.navigate().back();



	}

}
