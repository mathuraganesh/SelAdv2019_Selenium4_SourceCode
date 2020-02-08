package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import static org.openqa.selenium.By.id;


public class LearnLocators {

	public static void main(String[] args) {

		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch your browser
		ChromeDriver driver = new ChromeDriver();
		
		// 
		driver.get("http://leafground.com/pages/sorttable.html");

		// Find the new way
//		WebElement thisElement = driver.findElement(RelativeLocator.withTagName("button").above(By.xpath("//*[text()='Get Position']")));
		/*WebElement thisElement = driver.findElement(
				RelativeLocator.withTagName("button").
				below(By.xpath("//*[text()='Get Position']")));*/
		
/*		driver.findElement(id(""));
*/		
		
		/*driver.findElement(RelativeBy.);
		*/
		/*List<WebElement> allBelowElements = driver.findElements(
				RelativeLocator.withTagName("*").
				below(By.xpath("//*[text()='Get Position']")));
		
		// Print the text of the element
		for (WebElement thisElement : allBelowElements) {
			System.out.println(thisElement.getText());
		}
		*/
		
	
		/*List<WebElement> belowElements = driver.findElements(RelativeLocator
				.withTagName("input")
				.above(By.xpath("//label[text()='Clear the text']")));
		
		System.out.println(belowElements.size());
		for (WebElement ele : belowElements) {
			System.out.println(ele.getAttribute("name"));
			ele.clear();
		}*/
		
		/*List<WebElement> elements = driver.findElements(RelativeLocator
				.withTagName("td")
				.toRightOf(By.xpath("//td[text()='100%']")));
		
		
		System.out.println(elements.size());
		for (WebElement ele : elements) {
			System.out.println(ele.getText());
		}*/
		
		
		
		List<WebElement> belowElements = driver.findElements(RelativeLocator
				.withTagName("td")
				.toRightOf(By.xpath("//td[text()='1001']")));
		
		System.out.println(belowElements.size());
		
		
		
		
		for (WebElement ele : belowElements) {
			System.out.println(ele.getText());
			
		}	
		
		

	}

	

}
