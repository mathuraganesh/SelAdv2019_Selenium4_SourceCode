package day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;


public class StoreDebuggerAddress {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Launch the URL
		driver.get("http://leaftaps.com/opentaps");
		
		// Get the Google ChromeOptions
		Object capability = driver.getCapabilities().getCapability("goog:chromeOptions");
		Map<String,String> chromeOptions = (Map<String,String>)capability;
		
		// Debugger Address
		String address = chromeOptions.get("debuggerAddress");
		System.out.println(address);

		//  Write to a property file
		OutputStream output = new FileOutputStream("./config.properties");

		// Set the Debugger Address
		Properties prop = new Properties();
		prop.setProperty("debugger", address); 	// set the properties value
		prop.store(output, null);
		
		


	}

}
