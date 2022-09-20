package week3.day2;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioWithList {
	public static void main(String[] args) throws InterruptedException {
		
		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
				
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
				
		//Load url
		driver.get("https://www.ajio.com/");
				
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("Bags", Keys.ENTER);
		Thread.sleep(3000);
		
		// To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(5000);
		
		// Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for ='Men - Fashion Bags']")).click();
		Thread.sleep(5000);
		
		// Print the count of the items Found. 
		String itemsCount = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println("The count of the items found: " + itemsCount);
		Thread.sleep(3000);
		
		// Get the list of brand of the products displayed in the page and print the list.
		
		List<WebElement> bagBrands = driver.findElements(By.xpath("//div[@class='brand']"));
		
		// int brandsSize = bagBrands.size();
		// System.out.println(brandsSize);
		
		Set<String> brands = new LinkedHashSet<String>();  //Declare string since the brand names will be duplicated in list
				
		for (WebElement webElement : bagBrands) {
			brands.add(webElement.getText());				//Add List items to Set
		}
		
		for (String item : brands) {						//Printing Brand Names
			System.out.println(item);
		}
		
		
		// Get the list of names of the bags and print it
		List<WebElement> bagNames = driver.findElements(By.className("nameCls"));    
		
		for (WebElement eachItem : bagNames) {
			System.out.println(eachItem.getText());
		}
		
	}

}
