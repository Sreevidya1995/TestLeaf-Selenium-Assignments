package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
					
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		//Frame 1
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frames Exercise");
		Thread.sleep(4000);
		
		//Frame 2
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		Thread.sleep(4000);
		
		driver.switchTo().defaultContent();
		
		//Frame 3
		WebElement frame = driver.findElement(By.xpath("(//iframe[@class=' ezlazyloaded'])[2]"));
		driver.switchTo().frame(frame);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		dropdown.click();
		Thread.sleep(4000);
		Select option = new Select(dropdown);
		option.selectByValue("avatar");
		Thread.sleep(8000);

		driver.close();
	}

}
