package practicecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		Actions actions=new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='Jobs']"))).build().perform();
		Thread.sleep(1000);
		actions.contextClick(driver.findElement(By.xpath("//div[text()='Jobs']"))).build().perform();
		Thread.sleep(5000);
	}

}
 