package day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SwitchWindowAsTabOrWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Launch Firefox
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Launch the URL
		driver.get("http://leafground.com/pages/Window.html");
		
		// Switch to Window -> TAB
		driver.switchTo().newWindow(WindowType.WINDOW);
		int size = driver.getWindowHandles().size();
		System.out.println(size);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}

}
