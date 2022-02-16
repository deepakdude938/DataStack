package practicecodes;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MScreenshot {

	public static void main(String[] args) throws Throwable {
      
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(5000);
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file
		File file = scrShot.getScreenshotAs(OutputType.FILE);
		 
		//Move image file to new destination
		File deepak = new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\scr.png");
		
		//Copy file at destination from file to deepak
		FileUtils.copyFile(file, deepak);
		Thread.sleep(5000);
		driver.quit();
	}

}
