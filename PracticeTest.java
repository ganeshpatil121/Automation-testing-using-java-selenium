package qsp;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.className("desktop-searchBar")).sendKeys("shirts");
		Thread.sleep(2000);
		driver.findElement(By.className("desktop-submit")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='HIGHLANDER Men Green Slim Fit Casual Shirt']")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			if(driver.getTitle().equals("Buy HIGHLANDER Men Green Slim Fit Casual Shirt - Shirts for Men 2256568 | Myntra")){
				driver.findElement(By.xpath("(//button[@class='size-buttons-size-button size-buttons-size-button-default'])[1]")).click();
				Thread.sleep(2000);			
				
				driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
				
				Thread.sleep(2000);
			
				driver.findElement(By.xpath("//a[@class='pdp-goToCart pdp-add-to-bag pdp-button pdp-flex pdp-center ']")).click();
				driver.navigate().refresh();
				driver.findElement(By.xpath("//div[@class='layout']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='REMOVE']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//button[text()='REMOVE'])[2]")).click();
                Thread.sleep(2000);

				
			}
		}
	}

}
