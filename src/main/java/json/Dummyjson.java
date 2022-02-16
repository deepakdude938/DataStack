package json;

import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummyjson {
	
	boolean  flag ;
	 static WebDriver driver;
	static String dataservice;
	 
	@Given("User navigate to Author login page")
	public void user_navigate_to_Author_login_page() throws Throwable {
	    	 WebDriverManager.chromedriver().setup();
	 	    driver=new ChromeDriver();
	 	    driver.manage().window().maximize();
	 	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	    driver.get("https://qa.ds.appveen.com/author/#/auth");
	 	    //Thread.sleep(10000);
	   	}

	@Given("User enters {string} and {string} in Author login page")
	public void user_enters_and_in_Author_login_page(String username, String password) {
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username,Keys.ENTER);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password,Keys.ENTER);
	  
	}

	@Given("Verify User has Logged in successfully in Author Url")
	public void verify_User_has_Logged_in_successfully_in_Author_Url() {
	    
	}
	@Given("User search data  service {string}")
	public void user_search_data_service(String dataservice) {
		Dummyjson.dataservice=dataservice;
	}
	@Given("User get data service {string} then delete it  else create it")
	public void user_get_data_service_then_delete_it_else_create_it(String bln) throws Throwable {
	    bln=bln+dataservice;
	   List<WebElement>list=driver.findElements(By.id("serviceManagerCardTitle"));
	// a=0,b=0;
	   for(WebElement exist:list) {
		   if((exist.getText()).equals(bln)) {
			  flag=true;
			   
			 break;
		   }
		 
	   }
	   if(flag) {
		   System.out.println(bln+ " is exist");
		   String xpath="//span[text()='"+bln+"'] /ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::div[@class='toggler']";
		   WebElement user= driver.findElement(By.xpath(xpath));
		   user.click();
//		   String xpath2="(//span[text()='user'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='Delete']";
//		   WebElement user2= driver.findElement(By.xpath(xpath2));
//		   user2.click();
		   Thread.sleep(5000);
	   }
	   	  
	   else if(flag==false){
		   System.out.println(bln+ " is not exist");
	       driver.findElement(By.xpath("//span[text()='New Data Service']")).click();
	       driver.findElement(By.xpath("//input[@placeholder='Untitled Service']")).sendKeys(bln);
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
		    	   driver.findElement(By.xpath("//span[text()='New Attribute']")).click();
		    	     		  
		    	   driver.findElement(By.xpath("(//input[@placeholder='Untitled Attribute'])["+i+"]")).sendKeys(name);
		    	    	  
		    	     	  
		       }
	   	   }
	  Thread.sleep(5000);
	  driver.close();


	
	}
	

}
