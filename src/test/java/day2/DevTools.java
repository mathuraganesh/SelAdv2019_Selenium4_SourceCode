package day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;

import com.google.common.collect.ImmutableMap;

public class DevTools {

	public static void main(String[] args) {


		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch your browser
		ChromeDriver driver = new ChromeDriver();
	
		
		// DevTools
		org.openqa.selenium.devtools.DevTools devTools = driver.getDevTools();
		

		// Connection to DevTools
		devTools.createSession();
		
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//https://chromedevtools.github.io/devtools-protocol/tot/DOM
		// http://leaftaps.com/opentaps/control/main
		
		// send the request
		devTools.send(new Command<>("DOM.enable", ImmutableMap.of()));
		
		// Get the DOM document
		Object send = devTools.send(new Command<>("DOM.getDocument", 
				ImmutableMap.of("depth",-1,"pierce",true),
				ConverterFunctions.map("root",Object.class)));
				
		System.out.println(send);
		
		int node = devTools.send(new Command<>("DOM.querySelector", 
				ImmutableMap.of("nodeId",5,
						"selector","input[id='username']"),
				ConverterFunctions.map("nodeId",Integer.class)));
		
		System.out.println(node);
		
		// Stop the DevTools
		devTools.close();
		
		
		
		

	}

}
