package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealShopping {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
				
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
				
		//Load url --Snap deal
		driver.get("https://www.snapdeal.com/");
				
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Thread.sleep(5000);
		
		//Actions Class
		Actions builder = new Actions(driver);
		
		//Go to Mens Fashion
		WebElement menFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]/ancestor::li"));
		builder.moveToElement(menFashion).perform();
		Thread.sleep(3000);

		//Go to Sports Shoes
		driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Sports Shoes']")).click();
		Thread.sleep(3000);
		
		//Get the count of the sports shoes
		String countShoes = driver.findElement(By.xpath("//h1[@itemprop='name']/following-sibling::span")).getText();
		System.out.println("The count of the sports shoes displayed is: "+countShoes);
		Thread.sleep(3000);
		
		//Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);
		
		//Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@class='search-li' and @data-index='1']")).click();
		Thread.sleep(6000);
		
		//Check if the items displayed are sorted correctly
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println("The sorted order of items is: ");					//One item in the last is not sorted
		for (WebElement i : prices) {
			System.out.println(i.getText());
		}
		Thread.sleep(3000);
	
		//Select the price range (500-1200)
		WebElement startRange = driver.findElement(By.xpath("//input[@name='fromVal']"));
		startRange.clear();
		startRange.sendKeys("550");     
		Thread.sleep(3000);
		
		WebElement endRange =driver.findElement(By.xpath("//input[@name='toVal']"));
		endRange.clear();
		endRange.sendKeys("1200");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
				
		//Filter with color Navy 
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(3000);
		
		//Verify the all applied filters 
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
		System.out.println("The applied filters are: ");
		for (WebElement i : filters) {
			System.out.println(i.getText());
		}
		Thread.sleep(3000);
		
		//Mouse Hover on first resulting Training shoes
		WebElement shoeOfInterest = driver.findElement(By.xpath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']"));
		builder.moveToElement(shoeOfInterest).perform();
		Thread.sleep(3000);
		
		//Click QuickView button
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		Thread.sleep(5000);
		
		//Print the cost and the discount percentage
		WebElement cost = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[@class='payBlkBig']"));
		System.out.println("The Cost is : "+cost.getText());
		Thread.sleep(5000);
		WebElement percentage = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[@class='percent-desc ']"));
		System.out.println("The Percentage is : "+percentage.getText());
		Thread.sleep(5000);
		
		//Take the snapshot of the shoes.
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/shoes.png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000);
		
		//Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(5000);
		
		//Close the main window
		driver.close();
		

	}

}
