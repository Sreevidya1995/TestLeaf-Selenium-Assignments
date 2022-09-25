package leafGroundAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("https://www.leafground.com/frame.xhtml");
					
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click Me (Inside frame)
		System.out.println("Click Me (Inside frame)");
		
		WebElement frame1 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.id("Click")).click();
		Thread.sleep(2000);
		String response1 = driver.findElement(By.id("Click")).getText();
		System.out.println(response1);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		
		
		
		//How many frames in this page?
		System.out.println("How many frames in this page?");
		List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
				
		int countFrames = frames.size();
		System.out.println("The number of frames in the page is: "+ countFrames);
		Thread.sleep(5000);
		
		
		
		
		//Click Me (Inside Nested frame)
		System.out.println("Click Me (Inside Nested frame)");
		WebElement frame3 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame3);
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.id("Click")).click();
		Thread.sleep(2000);
		String response2 = driver.findElement(By.id("Click")).getText();
		System.out.println(response2);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		
		//driver.close();
	}

}
