package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	// Step 1: Download and set the path 
	// Step 2: Launch the chromebrowser
	// Step 3: Load the URL https://en-gb.facebook.com/
	// Step 4: Maximize the window
	// Step 5: Add implicit wait
	// Step 6: Click on Create New Account button
	// Step 7: Enter the first name
	// Step 8: Enter the last name
	// Step 9: Enter the mobile number
	// Step 10: Enter the password
	// Step 11: Handle all the three drop downs
	// Step 12: Select the radio button "Female" 
	//( A normal click will do for this step) 

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		//Load url
		driver.get("https://en-gb.facebook.com/");
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		//Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Sreenidhi");
		
		Thread.sleep(3000);
		
		//Enter the Last name
		driver.findElement(By.name("lastname")).sendKeys("Venkat");
		
		Thread.sleep(3000);
		
		//Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("8056270457");
		
		Thread.sleep(3000);
		
		//Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("Lockit@2020");	
		
		Thread.sleep(3000);
		
		//Handle all the three drop downs
		WebElement dayDropdown = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select day = new Select(dayDropdown);
		day.selectByVisibleText("10");
		
		Thread.sleep(3000);
		
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select month = new Select(monthDropdown);
		month.selectByVisibleText("Sep");
		
		Thread.sleep(3000);
		
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select year = new Select(yearDropdown);
		year.selectByValue("1995");
		
		Thread.sleep(3000);
				
		//Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']")).click();		

	}

}
