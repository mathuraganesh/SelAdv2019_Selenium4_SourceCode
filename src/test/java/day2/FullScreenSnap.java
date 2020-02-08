package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;

import com.google.common.collect.ImmutableMap;

public class FullScreenSnap {

	public static void main(String[] args) throws IOException {

		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch your browser
		ChromeDriver driver = new ChromeDriver();


		// DevTools
		org.openqa.selenium.devtools.DevTools devTools = driver.getDevTools();


		// Connection to DevTools
		devTools.createSession();

		// Load the URL
		driver.get("http://naukri.com");
		
		// Content Layout Size
		Object rect = devTools.send(new Command<>("Page.getLayoutMetrics", 
				ImmutableMap.of(),
				ConverterFunctions.map("contentSize", Object.class)));
		
		// Find -> Width and Height
		HashMap<String,Long> wH = (HashMap<String, Long>)rect;
		Long width = wH.get("width");
		Long height = wH.get("height");
		
		System.out.println(width);
		System.out.println(height);
		
		/*driver.getWindowHandles();*/
		
		// Set Metrics Device Override
		devTools.send(new Command<>("Emulation.setDeviceMetricsOverride", 
					ImmutableMap.of("width", width, "height", height,
							"deviceScaleFactor",1,"mobile",false)));
		
		
		// Capture Screenshot
		String snap = devTools.send(new Command<>("Page.captureScreenshot", 
				ImmutableMap.of("fromSurface", true),
				ConverterFunctions.map("data", String.class)));
		

		Base64 decoder = new Base64();
		byte[] imgBytes = decoder.decode(snap.toString());
		FileOutputStream osf = new FileOutputStream(new File("./fullsnap.png"));
		osf.write(imgBytes);
		osf.flush();
		osf.close();


	}

}
