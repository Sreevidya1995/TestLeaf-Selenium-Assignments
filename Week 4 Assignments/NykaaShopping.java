package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaShopping {
	
	
	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
						
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
						
		//Load url --NYKAA
		driver.get("https://www.nykaa.com/");
				
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Thread.sleep(5000);
				
		//Actions Class
		Actions builder = new Actions(driver);
		
		//Mouse over on Brands and Search L'Oreal Paris
		WebElement brandsHover = driver.findElement(By.xpath("//ul[contains(@class,'HeaderNav')]//a[text()='brands']"));
		builder.moveToElement(brandsHover).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@class='ss-content desktop-header']//a[text()=\"L'Oreal Paris\"]")).click();
		Thread.sleep(2000);
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("The L'Oreal Paris page has been launched successfully");
		
			Thread.sleep(2000);
		
			//Click sort By and select customer top rated
			driver.findElement(By.xpath("//button[@class=' css-n0ptfk']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']/div[@class='control-indicator radio ']")).click();
			Thread.sleep(2000);
		
			//Click Category and click Hair->Click haircare->Shampoo
			driver.findElement(By.xpath("//div[@id='first-filter']/div")).click();          					//Category
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Hair']/following-sibling::span")).click();				//Hair
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Hair Care']/following-sibling::span")).click();			//Haircare
			Thread.sleep(2000);
			WebElement shampoo = driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']"));			//Shampoo
			if(!shampoo.isSelected())
				{
				shampoo.click();
				Thread.sleep(1000);																			//If Shampoo already selected do not unselect
				}
			Thread.sleep(2000);
		
			//Click->Concern->Color Protection
			driver.findElement(By.xpath("//span[text()='Concern']/parent::div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Color Protection']/ancestor::label")).click();
			Thread.sleep(2000);
		
			//Check whether the Filter is applied with Shampoo
		
			List<WebElement> filters = driver.findElements(By.xpath("//div[@class='css-1emjbq5']/span"));
		
			for (WebElement each : filters) 
				{
				System.out.println(each.getText());
				if(each.getText().contains("Shampoo")) 
					{
					System.out.println("Filtered with shampoo");
					break;
					}
				}
			Thread.sleep(2000);
		
			//Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElement(By.xpath("//div[@class='css-d5z3ro']/a")).click();
			Thread.sleep(5000);
		
			//WindowHandling 
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows= new ArrayList<String>(windowHandles);
		 
			//GO to the new window and select size as 704ml
			driver.switchTo().window(windows.get(1));
			Thread.sleep(5000);
			WebElement size = driver.findElement(By.xpath("//select[@title = 'SIZE']"));
			Select select = new Select(size);
			select.selectByVisibleText("175ml");
			Thread.sleep(2000);
				
			//Print the MRP of the product
			String mrp = driver.findElement(By.xpath("//div[@class='css-f5j3vf']//span[text()='MRP:']/following-sibling::span")).getText();
			mrp=mrp.replaceAll("[^0-9]", "");
			System.out.println("The MRP is : "+mrp);
			Thread.sleep(4000);
		
			//Click on ADD to BAG
			driver.findElement(By.xpath("//div[@class='css-1x9oqpp']//span[text()='Add to Bag']")).click();
			Thread.sleep(4000);
		
			//Go to Shopping Bag 
			driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']/button")).click();
			Thread.sleep(8000);
		
			//Print the Grand Total amount
			driver.switchTo().frame(0);														//Need to switch to frame
			WebElement grandTotalEle = driver.findElement(By.xpath("//div[@class='first-col']//div[@class='value']"));
			String grandTotal = grandTotalEle.getText();
			grandTotal=grandTotal.replaceAll("[^0-9]", "");
			System.out.println("The Grand Total in cart is : "+grandTotal);
			Thread.sleep(2000);
		
			//Click Proceed
			driver.findElement(By.xpath("//span[text()='Proceed']/ancestor::button")).click();
			Thread.sleep(2000);
		
			//Click on Continue as Guest
			driver.findElement(By.xpath("//div[text()='Checkout as guest']/following-sibling::button")).click();
			Thread.sleep(8000);
		
			//Check if this grand total is the same in step 14
			String grandTotalFinal = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span")).getText();
			grandTotalFinal=grandTotalFinal.replaceAll("[^0-9]", "");
			System.out.println("The Grand Total in checkout page is : "+grandTotalFinal);
			Thread.sleep(2000);
			if(grandTotalFinal.equals(grandTotal))
				{
				System.out.println("The grand total is same even after checkout");
				}
			else
				{
				System.out.println("The grand total is not same after checkout");
				}
			Thread.sleep(10000);
			
		}
		else
		{
			System.out.println("The L'Oreal Paris page has not been launched");
		}
		
		//Close all windows
		driver.quit();

	}

}
