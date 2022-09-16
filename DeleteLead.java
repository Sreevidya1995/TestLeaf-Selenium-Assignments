package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	/* Delete Lead:
	1	Launch the browser -http://leaftaps.com/opentaps/control/main
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Phone
	9	Enter phone number
	10	Click find leads button
	11	Capture lead ID of First Resulting lead
	12	Click First Resulting lead
	13	Click Delete
	14	Click Find leads
	15	Enter captured lead ID
	16	Click find leads button
	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	18	Close the browser (Do not log out)
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
		
		//Enter phone number
		driver.findElement(By.xpath("//a[@class='x-tab-right']/following::span[text()='Phone']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-plain-bwrap']/following::input[@name='phoneNumber']")).sendKeys("7502687078");
		Thread.sleep(3000);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext'])[1]")).getText();
		System.out.println(leadID);
		
		//Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		Thread.sleep(3000);	
		
		//Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(3000);	
		
		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following::input[@name='id']")).sendKeys(leadID);
		Thread.sleep(3000);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		Thread.sleep(2000);
		
		//Condition to verify
		String successfulDeletionmessage = "No records to display";
		
		if(message.equalsIgnoreCase(successfulDeletionmessage))
			{System.out.println("The Lead was successfully deleted");}
		else
			{System.out.println("The Lead was not deleted");}
		
		Thread.sleep(5000);
		
		//Close the browser (Do not log out)
		driver.close(); 

	}

}
