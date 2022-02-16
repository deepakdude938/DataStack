package practicecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;

public class AlertDemo {
	
	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
	          
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("727650");
		driver.findElement(By.xpath("//input[@name='cusid']")).getText();
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		
		Alert alert=driver.switchTo().alert();
		String alertmassage=driver.switchTo().alert().getText();
		System.out.println(alertmassage);
		Thread.sleep(5000);
		
		alert.accept();
		
		
		
      }
}
	