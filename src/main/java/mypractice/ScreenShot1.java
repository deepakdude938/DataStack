package mypractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot1 {

	public static void main(String[] args) throws Throwable {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com/");
		
		Screenshot scr1=new AShot().takeScreenshot(driver);
		Screenshot scr2=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		 
		ImageIO.write(scr1.getImage(), "png", new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\ght.png"));
		
		ImageIO.write(scr2.getImage(), "png", new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\ght2.png"));
		 driver.quit();
		
	}

}
