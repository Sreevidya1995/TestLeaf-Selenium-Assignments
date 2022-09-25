package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	/* Pseudo Code
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 2. Enter UserName and Password Using Id Locator
	 * 3. Click on Login Button using Class Locator
	 * 4. Click on CRM/SFA Link
	 * 5. Click on contacts Button
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 7. Click on Widget of From Contact
	 * 8. Click on First Resulting Contact
	 * 9. Click on Widget of To Contact
	 * 10. Click on Second Resulting Contact
	 * 11. Click on Merge button using Xpath Locator
	 * 12. Accept the Alert
	 * 13. Verify the title of the page
	 */

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
						
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("http://leaftaps.com/opentaps/control/login");
				
		//Maximize window
		driver.manage().window().maximize();
		
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						
		//Entering Username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Thread.sleep(5000);
						
		//Entering Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(5000);
						
		//clicking on login
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(5000);
				
		//Click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);				

		//Click on contacts Button
		driver.findElement(By.xpath("//div[@class='frameSectionHeader']//a[text()='Contacts']")).click();
		Thread.sleep(3000);	
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(3000);	
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		Thread.sleep(3000);	
		
		//Window handling
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')]//a[@class='linktext'])[1]")).click();
		Thread.sleep(3000);			
		
		driver.switchTo().window(windows1.get(0));
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		Thread.sleep(3000);	
		
		//Window handling
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(1));
		
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')]//a[@class='linktext'])[2]")).click();
		Thread.sleep(3000);	
		
		driver.switchTo().window(windows1.get(0));
		
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(3000);	
		
		//Accept the Alert
		Alert alertConfirmation = driver.switchTo().alert();
		alertConfirmation.accept();
		Thread.sleep(5000);	
		
		//Verify the title of the page
		String titleVerification = driver.getTitle();
		System.out.println(titleVerification);
		Thread.sleep(10000);	
		
		driver.close();
	}

}
