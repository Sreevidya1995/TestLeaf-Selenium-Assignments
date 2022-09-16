package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	/*http://leaftaps.com/opentaps/control/main
	* 1	Launch the browser
	* 2	Enter the username
	* 3	Enter the password
	* 4	Click Login
	* 5	Click crm/sfa link
	* 6	Click Leads link
	* 7	Click Find leads
	* 8	Enter first name
	* 9	Click Find leads button
	* 10 Click on first resulting lead
	* 11 Verify title of the page
	* 12 Click Edit
	* 13 Change the company name
	* 14 Click Update
	* 15 Confirm the changed name appears
	* 16 Close the browser (Do not log out)
	*/
	
	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
				
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
				
		//Load url
		driver.get("http://leaftaps.com/opentaps/control/main");
				
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
		
		//Clicking on Find leads
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);
		
		//Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		Thread.sleep(3000);		
		
		//Verify title of the page
		String currentPageTitle = driver.getTitle();
		System.out.println(currentPageTitle);
		Thread.sleep(2000);		
				
		//Click Edit
		driver.findElement(By.xpath("//div[@class='frameSectionHeader']/following::a[text()='Edit']")).click();
		Thread.sleep(2000);	
			
		//Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");
		Thread.sleep(2000);	
		
		//Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);	
		
		//Confirm the changed name appears
		String companyName = driver.findElement(By.xpath("//span[text()='Company Name']/following::span")).getText();
		System.out.println(companyName);
		Thread.sleep(2000);	
		
		//Close the browser (Do not log out)
		driver.close(); 
		
	}

}
