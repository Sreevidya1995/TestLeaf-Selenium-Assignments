package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPurchaseMobile {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("https://www.amazon.in/");
					
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);		

		//Search - oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		
		//Get the price of the first product
		String firstPrice = driver.findElement(By.xpath("(//div[@class='a-section']//span[@class='a-price'])[1]")).getText();
		System.out.println("Price of the first product is: "+firstPrice);
		Thread.sleep(5000);
		
		//Print the number of customer ratings for the first displayed product
		String countRatings = driver.findElement(By.xpath("(//a[@target='_blank']//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of customer ratings is: "+countRatings);
		Thread.sleep(5000);
		
		//Click the first text link of the first image
		driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline']//img)[1]")).click();
		Thread.sleep(8000);
		
		//Window Handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(5000);
		
		//Take a screen shot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/Amazon-Oneplus-9-Pro.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(5000);
		
		//Click 'Add to Cart' button
		driver.findElement(By.xpath("//div[@id='accordionRows']//input[@id='add-to-cart-button']")).click();  //Check
		Thread.sleep(5000);
		
		//Get the cart subtotal and verify if it is correct.
		String cartTotal = driver.findElement(By.xpath("//div[@id='attach-added-to-cart-message']//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart Subtotal is: "+cartTotal);
		Thread.sleep(10000);		
		
		//Close the browser
		driver.quit();

	}

}
