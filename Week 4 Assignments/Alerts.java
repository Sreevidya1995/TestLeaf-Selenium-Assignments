package leafGroundAssignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("https://www.leafground.com/alert.xhtml");
					
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Alert (Simple Dialog)
		System.out.println("Alert (Simple Dialog)");
		driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following-sibling::button")).click();
		Thread.sleep(3000);
		
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println("Simple dialog alert: "+ text1);
		alert1.accept();
		
		String response1 = driver.findElement(By.id("simple_result")).getText();
		System.out.println(response1);
		Thread.sleep(3000);
		
		
		//Alert (Confirm Dialog)
		System.out.println("Alert (Confirm Dialog)");
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button")).click();
		Thread.sleep(3000);
		
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		System.out.println("Confirm dialog alert: "+ text2);
		alert2.dismiss();
		
		String response2 = driver.findElement(By.id("result")).getText();
		System.out.println(response2);
		Thread.sleep(3000);		
		
		
		//Alert (Prompt Dialog)
		System.out.println("Alert (Prompt Dialog)");
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button")).click();
		Thread.sleep(3000);
		
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println("Prompt dialog alert: "+ text3);
		alert3.sendKeys("Sreevidya");
		alert3.accept();
		
		String response3 = driver.findElement(By.id("confirm_result")).getText();
		System.out.println(response3);
		Thread.sleep(3000);		
		
		
		//Sweet Alert (Simple Dialog)
		System.out.println("Sweet Alert (Simple Dialog)");
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following-sibling::button")).click();
		Thread.sleep(3000);
		
		String text4 = driver.findElement(By.xpath("//span[text()='Dialog']//following::p")).getText();
		System.out.println("Sweet Simple alert: "+ text4);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		Thread.sleep(3000);		
		
		
		//Sweet Alert (Confirmation)
		System.out.println("Sweet Alert (Confirmation)");
		WebElement alertpop = driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following-sibling::button"));
		driver.executeScript("arguments[0].click()", alertpop);
		Thread.sleep(5000);
		
		String text5 = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']//span")).getText();
		System.out.println("Sweet Confirmation alert: "+ text5);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		Thread.sleep(3000);		
		
		
		//Sweet Modal Dialog
		System.out.println("Sweet Modal Dialog");
		WebElement alertpop2 = driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::button"));
		driver.executeScript("arguments[0].click()", alertpop2);
		Thread.sleep(3000);
		
		String text6 = driver.findElement(By.xpath("(//span[text()='Modal Dialog (Sweet Alert)']/following::p)[1]")).getText();
		System.out.println("Sweet Modal alert: "+ text6);
		driver.findElement(By.xpath("(//span[text()='Modal Dialog (Sweet Alert)']/following::span[@class='ui-icon ui-icon-closethick'])[1]")).click();
		Thread.sleep(3000);
		
		
		
		//Minimize and Maximize
		System.out.println("Minimize and Maximize");
		WebElement maxMin = driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following-sibling::button"));
		driver.executeScript("arguments[0].click()", maxMin);
		Thread.sleep(3000);
		
		String text7 = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']/p)[1]")).getText();
		System.out.println("Minimize and Maximize alert: "+ text7);
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Min and Max']/following::span[@class='ui-icon ui-icon-closethick'])[1]")).click();
		Thread.sleep(10000);
		
		System.out.println("Closing Window");
		driver.close();
	}

}
