package mypractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws Throwable {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		TakesScreenshot scrshot=((TakesScreenshot)driver);
		File file=scrshot.getScreenshotAs(OutputType.FILE);
		File deepak=new File("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\kk.png");
		FileUtils.copyFile(file, deepak);
		Thread.sleep(5000);
		driver.quit();
	}

}
