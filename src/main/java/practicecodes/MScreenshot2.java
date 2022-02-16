package practicecodes;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MScreenshot2 {

	

	public static void main(String... args) throws Throwable {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.opencart.com/");
		
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']"));
		
		Screenshot screenshot1= new AShot().takeScreenshot(driver, element);
		
		ImageIO.write(screenshot1.getImage(),"png",new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\aditya.png"));
		
		driver.quit();
	}

}
