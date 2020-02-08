package day1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriverService.Builder;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromePort {


	public static void main(String[] args) {

		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch your browser
		Map<String, String> emptyMap = new HashMap<String, String>();

		Builder builder = new ChromeDriverService.Builder();
		Builder withEnvironment = builder.usingPort(9515).withEnvironment(emptyMap);
		ChromeDriverService service = withEnvironment.build();

		// Load the URL
		ChromeDriver driver = new ChromeDriver(service);

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://google.com");









	}
}
