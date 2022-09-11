package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	
	/*
	 * Duplicate Lead
          1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on Leads Button
		  6. Click on Create Lead 
		  7. Enter CompanyName Field Using id Locator
		  8. Enter FirstName Field Using id Locator
		  9. Enter LastName Field Using id Locator
		  10. Enter FirstName(Local) Field Using id Locator
		  11. Enter Department Field Using any Locator of Your Choice
		  12. Enter Description Field Using any Locator of your choice 
		  13. Enter your email in the E-mail address Field using the locator of your choice
		  14. Select State/Province as NewYork Using Visible Text
		  15. Click on Create Button
          16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
          17. Click on Duplicate button
          18. Clear the CompanyName Field using .clear() And Enter new CompanyName
          19.Clear the FirstName Field using .clear() And Enter new FirstName
          20.Click on Create Lead Button
          21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
	 */

	public static void main(String[] args) {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
						
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
						
		//Load url
		driver.get("http://leaftaps.com/opentaps/control/login");
						
		//Maximize window
		driver.manage().window().maximize();
						
		//storing value in variable and entering data
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");
				
		//directly entering data
		driver.findElement(By.id("password")).sendKeys("crmsfa");
						
		//clicking on login
		driver.findElement(By.className("decorativeSubmit")).click();
				
		driver.findElement(By.linkText("CRM/SFA")).click();
				
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		//Entering details in text box
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sreevidya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Hariharan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Sreevi");
		driver.findElement(By.name("departmentName")).sendKeys("Banking and Finance");
		driver.findElement(By.name("description")).sendKeys("Test Leaf Selenium Assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sreevidya.hari95@gmail.com");
		
		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(dropdown);
		state.selectByVisibleText("New York");
		
		//Click on submit
		driver.findElement(By.name("submitButton")).click();
		
		//View title of resulting page
		String pageTitle1 = driver.getTitle();
		System.out.println(pageTitle1);
		
		//Create Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Edit the existing details
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC Corporate Ltd");		
		
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nithyashri");
		
		//Click on submit
		driver.findElement(By.className("smallSubmit")).click();
		
		//View title of resulting page
		String pageTitle2 = driver.getTitle();
		System.out.println(pageTitle2);
		
		driver.close(); 
		
	}

}
