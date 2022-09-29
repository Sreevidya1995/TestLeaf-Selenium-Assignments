package leafGroundAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAction {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
				
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
				
		//Load url --INPUT TEXTBOX
		driver.get("https://www.leafground.com/drag.xhtml");
				
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(10000);
		
		//Action class
		Actions builder= new Actions(driver);
		
		
		//Draggable 
		WebElement drag = driver.findElement(By.xpath("(//div[@class='card']//span[@class='ui-panel-title'])[1]"));
		builder.dragAndDropBy(drag, 200 , 0).perform();
		Thread.sleep(5000);
		
		
		
		//Droppable
		WebElement dragNDrop = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='form:drop']"));
		builder.dragAndDrop(dragNDrop,target).perform();
		String responseMsg = driver.findElement(By.xpath("//div[@id='form:drop']//p[@class='ui-widget-header']")).getText();
		System.out.println(responseMsg);
		Thread.sleep(5000);
		
		
		
		//Draggable Columns
		WebElement srcColumn = driver.findElement(By.xpath("//span[@class='ui-column-title' and text()='Quantity']/parent::th"));
		WebElement targetColumn = driver.findElement(By.xpath("//span[@class='ui-column-title' and text()='Category']/parent::th"));
		builder.dragAndDrop(srcColumn, targetColumn).perform();
		Thread.sleep(2000);
		String resp1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(resp1);
		Thread.sleep(5000);
		
		
		
		//Draggable Rows
		WebElement srcRow = driver.findElement(By.xpath("(//h5[text()='Draggable Rows']/following::tbody/tr)[10]"));
		WebElement targetRow = driver.findElement(By.xpath("(//h5[text()='Draggable Rows']/following::tbody/tr)[1]"));
		builder.dragAndDrop(srcRow, targetRow).perform();
		Thread.sleep(2000);
		String resp2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(resp2);
		Thread.sleep(5000);		
		
		
		
		//Resize Image
		WebElement sideExtend = driver.findElement(By.xpath("//div[@class='ui-wrapper']/div[@class='ui-resizable-handle ui-resizable-e']"));
		builder.dragAndDropBy(sideExtend, 200, 0).perform();
		Thread.sleep(2000);
		String msg1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(msg1);
		Thread.sleep(3000);		
		
		WebElement verticalExtend = driver.findElement(By.xpath("//div[@class='ui-wrapper']/div[@class='ui-resizable-handle ui-resizable-s']"));
		builder.dragAndDropBy(verticalExtend, 0, -5).perform();
		Thread.sleep(2000);
		String msg2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(msg2);
		Thread.sleep(3000);			
		
		
		
		//Range Slider
		String pt1Before = driver.findElement(By.xpath("(//h4[text()='Range Slider']/following::input)[1]")).getAttribute("value");
		System.out.println("Before moving the left slider "+pt1Before);
		
		WebElement leftPoint = driver.findElement(By.xpath("(//div[@class='ui-slider-range ui-corner-all ui-widget-header']/following-sibling::span)[1]"));
		builder.dragAndDropBy(leftPoint, -10, 0).perform();
		String pt1After = driver.findElement(By.xpath("(//h4[text()='Range Slider']/following::input)[1]")).getAttribute("value");
		System.out.println("After moving the left slider "+pt1After);
		Thread.sleep(3000);	
		
		String pt2Before = driver.findElement(By.xpath("(//h4[text()='Range Slider']/following::input)[2]")).getAttribute("value");
		System.out.println("Before moving the right slider "+pt2Before);
		
		WebElement rightPoint = driver.findElement(By.xpath("(//div[@class='ui-slider-range ui-corner-all ui-widget-header']/following-sibling::span)[2]"));
		builder.dragAndDropBy(rightPoint, 10, 0).perform();
		String pt2After = driver.findElement(By.xpath("(//h4[text()='Range Slider']/following::input)[2]")).getAttribute("value");
		System.out.println("After moving the right slider "+pt2After);
		Thread.sleep(3000);	
		
		
		
		//Progress Bar
		WebElement start = driver.findElement(By.xpath("//span[text()='Start']"));
		builder.click(start).perform();
		Thread.sleep(10000);	
		String progress = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(progress);
		Thread.sleep(5000);	
		
	}

}
