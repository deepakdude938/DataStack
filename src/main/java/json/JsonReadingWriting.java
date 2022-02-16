package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsonReadingWriting {
    // static String name;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	 	    driver.manage().window().maximize();
	 	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	   driver.get("https://qa.ds.appveen.com/author/#/app/vTest/sm");
	 	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("test_ui_appadmin@appveen.com",Keys.ENTER);
		    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Veen@99%win",Keys.ENTER);
		    driver.findElement(By.xpath("//span[text()='New Data Service']")).click();
		    driver.findElement(By.xpath("//input[@placeholder='Untitled Service']")).sendKeys("unreachable");
		    driver.findElement(By.xpath("//button[text()='Create']")).click();
		    driver.findElement(By.xpath("//span[text()='New Attribute']"));
       FileReader reader = new  FileReader("D:\\MaheshWorkSpace\\MaheshMavenProject\\jsonfile\\string_Text.json");
       JSONParser parser = new JSONParser();
       JSONObject obj=(JSONObject)parser.parse(reader);
       JSONArray arr=   (JSONArray)obj.get("definition");
       for(int i=1;i<arr.size();i++) {
    	   
    	   JSONObject d= (JSONObject)arr.get(i);
    	   JSONObject prop= (JSONObject)d.get("properties"); 
    	   String name=(String)prop.get("name");
    	   Boolean reqd=(Boolean)prop.get("required");
    	   driver.findElement(By.xpath("//span[text()='New Attribute']")).click();
    	     		  
    	   driver.findElement(By.xpath("(//input[@placeholder='Untitled Attribute'])["+i+"]")).sendKeys(name);
    	   if(reqd==true)
    		   driver.findElement(By.xpath("(//span[@class='checkmark'][1]")).click();
    	   
    	  
    	   //driver.findElement(By.xpath("//span[text()='New Attribute']")).click();
    	   
//    	   driver.findElement(By.xpath("//span[text()='New Attribute']")).click();
//    	   driver.findElement(By.xpath("//input[@placeholder='Untitled Attribute']")).sendKeys(name);
    	   
    	     	  
    	     	  
       }
       
     
       Thread.sleep(5000);
     driver.close();  
	}

}
