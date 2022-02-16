package ProjectCode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingProjectCode {

	public static void main(String[] args) {
           WebDriverManager.chromedriver().setup();
           
           WebDriver driver=new ChromeDriver();
           
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
           driver.get("https://bifrost.ds.appveen.com/author");
           
           
           //for log in
           driver.findElement(By.id("username")).sendKeys("deepak@appveen.com");
           driver.findElement(By.xpath("//span[text()='Next']")).click();
           
           
           //for password
           driver.findElement(By.id("password")).sendKeys("123123123");
           driver.findElement(By.xpath("//span[text()='Login']")).click();
           
           
           List<WebElement> list=driver.findElements(By.xpath("//span[@id='serviceManagerCardTitle']"));
           System.out.println("no of webelements:"+list.size());
           for(WebElement dip:list) {
        	   System.out.println("title of webelement:"+dip.getText());        
           }
           //for clicking dataformat from partners
           //driver.findElement(By.xpath("//span[text()='Partners']/ancestor::div[@id='partnerManager']/following-sibling::div[@id='dataFormat']")).click();
           
          //WebElement date= driver.findElement(By.xpath("(//span[text()='date'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='View']"));
	      //date.click();
	      
           
          //WebElement string_RichText= driver.findElement(By.xpath("(//span[text()='string_RichText'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='Edit']"));
         // string_RichText.click();
	      String xpath="//span[text()='string_RichText'] /ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::div[@class='toggler']";
	 WebElement string_RichText1= driver.findElement(By.xpath(xpath));
	 string_RichText1.click();
	 String xpath2="(//span[text()='string_RichText'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='Delete']";
	 WebElement string_RichText2= driver.findElement(By.xpath(xpath2));
	 string_RichText2.click();
	  driver.findElement(By.xpath("//button[@id='deleteModalYes']")).click();
	  
	 driver.findElement(By.xpath("//button[@class='add-new btn-min-width btn btn-primary ng-star-inserted']")).click();
	 
	}

}
