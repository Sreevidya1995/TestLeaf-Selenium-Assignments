package week4.day2;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
						
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
						
		//Load url --NYKAA
		driver.get("https://www.chittorgarh.com/");
				
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Thread.sleep(5000);
		
		//Click on stock market
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		Thread.sleep(3000);
		
		//Click on NSE bulk Deals
		driver.findElement(By.xpath("//div[@class='row ch-bar-block']//a[text()='NSE Bulk Deals']")).click();
		Thread.sleep(3000);		
		
		
		
		
		//Get all the Security names
		List<WebElement> securityNames = driver.findElements(By.xpath("//table[contains(@class,'table-bordered table')]/tbody/tr/td[3]"));
		int rowSize = securityNames.size();
		Thread.sleep(2000);	
		
		List<String> names =new LinkedList<String>();
		for(int i=1; i<=rowSize; i++)
			{
			names.add(driver.findElement(By.xpath("//table[contains(@class,'table-bordered table')]/tbody/tr[" + i + "]/td[3]")).getText());
			}
		
		int namesSize = names.size();	
		System.out.println("The number of security names is : "+ namesSize);
		Thread.sleep(2000);
		
		
		
		
		//Ensure whether there are duplicate Security names
		Map<String,Integer> map = new TreeMap<String,Integer>(); 		 // Declaring Tree Map
		
		for (String eachItem : names) {
			map.put(eachItem, map.getOrDefault(eachItem, 0)+1);			// Adding the array items to the map along with the count of duplicates
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for (Entry<String, Integer> eachItem : entrySet) {
		System.out.println(eachItem.getKey()+"-->"+eachItem.getValue());   // Print the map as per format
		}
		
		for (Entry<String, Integer> eachItem : entrySet) {
			if(eachItem.getValue()>1)
				{
				System.out.println("There are duplicate security names");
				break;
				}
			else
				{
				System.out.println("There are no duplicate security names");								
				}
		}
		

	}

}
