package mypractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlePopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/popup.php");
		
		String parentHandle=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'popup.php')]")).click();
		
		Set<String> handels=driver.getWindowHandles();
		int size=handels.size();
		System.out.println(size);
		for(String deepak:handels) {
			String childHandle=deepak;
			if(!parentHandle.equalsIgnoreCase(childHandle)) {
				driver.switchTo().window(childHandle);
				driver.findElement(By.name("emailid"))
                .sendKeys("gaurav.3n@gmail.com");                			
                
                driver.findElement(By.name("btnLogin")).click();	
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentHandle);
		driver.quit();
	}

}
