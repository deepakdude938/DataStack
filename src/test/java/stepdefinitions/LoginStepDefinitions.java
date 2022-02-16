package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
	
    static WebDriver driver;
 
	@Given("Launch browser {string}")
	public void launch_browser(String browser) throws Throwable {
		if(browser.equals("chrome")) {
   		 
   		 WebDriverManager.chromedriver().setup();
   		   		
   		 driver= new ChromeDriver();    		 
   	 }
   	 else if(browser.equals("firefox")) {
   		 WebDriverManager.firefoxdriver().setup();
   		 driver= new FirefoxDriver();    		     
   	     
   	 }
   	 else if (browser.equals("safari")) {
   		
   		
   	 }
   	 else {
   		 System.out.println("Please pass currect browser value");
   	 }
		Thread.sleep(5000);
		
	}

	@When("user enters url {string}")
	public void user_enters_url(String url) throws Throwable {
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   driver.get(url);
	   Thread.sleep(15000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    System.out.println("Page title :"+driver.getTitle());
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
	  
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   driver.findElement(By.id("username")).sendKeys("deepak@appveen.com");
	}
	
	@When("user clicks on Next button")
	public void user_clicks_on_Next_button() {
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
     
    
	@When("user enters password {string}")
	public void user_enters_password(String password ) {
	   
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {
	   driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	@Then("user gets title of the home page")
	public void user_gets_title_of_the_home_page() {
		String dataservice="Author";
	  System.out.println("page title is:"+driver.getTitle());
	   List<WebElement> list=driver.findElements(By.xpath("//span[@id='serviceManagerCardTitle']"));
       System.out.println("no of webelements:"+list.size());
       for(WebElement dip:list) {
    	   System.out.println("title of webelement:"+dip.getText());        
       }
       //for clicking dataformat from partners
       //driver.findElement(By.xpath("//span[text()='Partners']/ancestor::div[@id='partnerManager']/following-sibling::div[@id='dataFormat']")).click();
       
      WebElement date= driver.findElement(By.xpath("(//span[text()='"+dataservice+"'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='View']"));
      date.click();
     
       
//      WebElement element= driver.findElement(By.xpath("(//span[text()='string_RichText'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='Edit']"));
//      element.click();

	}
}
