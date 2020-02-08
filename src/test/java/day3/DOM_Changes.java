package day3;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Event;
import org.openqa.selenium.json.JsonInput;

import com.google.common.collect.ImmutableMap;

public class DOM_Changes {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://leafground.com/pages/Edit.html");

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		// Enable DOM using dev tools
		devTools.send(new Command<>("DOM.enable", ImmutableMap.of()));

		// Listen to the DOM changes
		/*devTools.addListener(new Event<>("DOM.documentUpdated", 
				ConverterFunctions.map("",Object.class)), event ->
		{
			System.out.println(event);
		}
				);*/
		
		Object rootNode = devTools.send(new Command<>("DOM.getDocument", ImmutableMap.of(), ConverterFunctions.map("root", Object.class)));

		System.out.println(rootNode);
		
		HashMap<String, Object> rootNodes = (HashMap<String, Object>)rootNode;
		
		Long parentNode = (Long) rootNodes.get("nodeId");
		System.out.println("The parent node id is "+parentNode);
		
		// Event : DOM.attributeModified
		// nodeId -> Integer
		// name  -> String
		// value -> String
		
		// id -> email
		
		// Let me find the email node so that check attribute changed or not
		// query selector
		// parent node -> parentNode
		// selector -> input[id='email']
		Integer childNode = devTools.send(new Command<>("DOM.querySelector", 
				ImmutableMap.of("nodeId",parentNode,"selector", "input[id='email']"),
				ConverterFunctions.map("nodeId", Integer.class)));
		
				
		devTools.addListener(new Event<>("DOM.attributeModified", 
				ConverterFunctions.map("nodeId", Integer.class)), 
				handler -> {
					System.out.println(handler);
				});		
		
		

		Thread.sleep(500000);















	}

}
