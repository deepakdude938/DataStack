package practicecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice {

	public static void main(String[] args) throws Throwable {
        
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		String title=	driver.getTitle();
		
		System.out.println(title);
		//total no of frames
		int size = driver.findElements(By.tagName("iframe")).size();//always use findElememnts
		System.out.println("total no of frames : "+size);
		driver.findElement(By.id("name")).sendKeys("Hello");
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		Select courseDD= new Select (driver.findElement(By.id("selectnav1")));
		courseDD.selectByValue("https://www.hyrtutorials.com/search/label/SQL");
		Thread.sleep(5000);
		
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).sendKeys("save world");
		Thread.sleep(5000);
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Deepika");
		Thread.sleep(5000);
		
		
	}

}
