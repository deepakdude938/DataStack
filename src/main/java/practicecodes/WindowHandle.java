package practicecodes;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws Throwable {
         WebDriverManager.chromedriver().setup();
         
         WebDriver driver = new ChromeDriver();
         
         driver.manage().window().maximize();
         
         //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);        
         driver.get("https://www.naukri.com/");
         
         String parentHandle = driver.getWindowHandle();
         
         System.out.println("parent handle : "+parentHandle);
         
         driver.findElement(By.xpath("//div[text()='Jobs']")).click();
         
         Set<String> handels=driver.getWindowHandles();
         System.out.println("window handels:"+handels);
         
         for(String deepak:handels) {
        	 System.out.println(deepak);
        	 if(!deepak.equals(parentHandle)) {
        		 
        		 driver.switchTo().window(deepak);
        		 driver.findElement(By.xpath("//input[@placeholder='Skills, Designations, Companies']")).sendKeys("yadagiri");
        		 Thread.sleep(5000);
        		 driver.close();
        	 }
        	 
        	 
         }
         driver.switchTo().window(parentHandle);
         driver.findElement(By.xpath("//input[@placeholder='Enter skills / designations / companies']")).sendKeys("Reddy");
         Thread.sleep(5000);
     	driver.quit();
	}

}
