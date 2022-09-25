package leafGroundAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
								
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver();
					
		//Load url
		driver.get("https://www.leafground.com/window.xhtml");
					
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click and Confirm new Window Opens
		System.out.println("Click and Confirm new Window Opens");
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following::span[text()='Open']")).click();
		Thread.sleep(5000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> tabs = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(tabs.get(1));
		String title = driver.getTitle();
		Thread.sleep(3000);
		
		if(title.contains("Dashboard")) {
			System.out.println("A new Window has opened");
		} else {
			System.out.println("A new Window has not opened");
		}
		
		//OR 
		if(tabs.size()>1) {
			System.out.println("A new Window has opened");
		} else {
			System.out.println("A new Window has not opened");
		}
		
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		
		
		
		//Find the number of opened tabs
		System.out.println("Find the number of opened tabs");
		driver.findElement(By.xpath("//h5[text()='Find the number of opened tabs']/following::span[text()='Open Multiple']")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandle);
		
		int tabsOpen = windows.size();
		System.out.println("The number of windows launched are: "+(tabsOpen-1));
		Thread.sleep(3000);
		
		
		
		//Close all windows except Primary
		System.out.println("Close all windows except Primary");
		driver.findElement(By.xpath("//h5[text()='Close all windows except Primary']/following::span[text()='Close Windows']")).click();
		Thread.sleep(3000);
		
		Set<String> winHandle = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(winHandle);
		
		int openWindows =win.size();
		
		for(int i=openWindows-1; i>0 ; i--)
		{
			driver.switchTo().window(win.get(i));
			driver.close();
			Thread.sleep(2000);
		}
		
		driver.switchTo().window(win.get(0));
		Thread.sleep(3000);
		
		
		
		//Wait for 2 new tabs to open
		System.out.println("Wait for 2 new tabs to open");		
		driver.findElement(By.xpath("//h5[text()='Wait for 2 new tabs to open']/following::span[text()='Open with delay']")).click();
		Thread.sleep(8000);
		
		Set<String> windowhandling = driver.getWindowHandles();
		List<String> winhandling = new ArrayList<String>(windowhandling);
		
		int windowsOpen = winhandling.size();
		if((windowsOpen-1)==2) {
			System.out.println("The windows have been launched");
		}else {
			System.out.println("The windows have not been launched");
		}
		Thread.sleep(10000);
		
		driver.quit();
	}

}
