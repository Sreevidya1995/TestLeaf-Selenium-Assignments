package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTableAssignment {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
								
		//Load url --
		driver.get("https://html.com/tags/table/");
						
		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Thread.sleep(5000);
				
		//Get the count of number of rows  
		//--> If all rows including header and footer then use 
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table//tr"));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		int rowSize = rows.size();
		System.out.println("The count of the number of rows is : "+ rowSize);
		
		//Get the count of number of columns
		List<WebElement> cols = driver.findElements(By.xpath("//div[@class='render']/table/thead//th"));
		int colSize = cols.size();
		System.out.println("The count of the number of columns is : "+ colSize);
		
	}

}
