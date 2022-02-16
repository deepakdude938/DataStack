package practicecodes;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MScreenshot1 {

	public static void main(String[] args) throws Throwable {
       
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(5000);
		
		Screenshot screenshot1 = new AShot().takeScreenshot(driver);
		
		Screenshot screenshot2=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		
		  ImageIO.write(screenshot1.getImage(), "png", new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\param.png"));
		  ImageIO.write(screenshot2.getImage(), "png", new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\param2.png"));
          driver.close();  
	}

}
