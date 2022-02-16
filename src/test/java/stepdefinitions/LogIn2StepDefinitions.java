package stepdefinitions;

import java.io.FileNotFoundException;
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

public class LogIn2StepDefinitions {

	boolean flag;
	static WebDriver driver;
	static String dataservice;
	static String group;
	static List<WebElement> groupList;

	@Given("User navigate to Author login page")
	public void user_navigate_to_Author_login_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://qa.ds.appveen.com/author/#/auth");
		// Thread.sleep(10000);
	}

	@Given("User enters {string} and {string} in Author login page")
	public void user_enters_and_in_Author_login_page(String username, String password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username, Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password, Keys.ENTER);

	}

	@Given("Verify User has Logged in successfully in Author Url")
	public void verify_User_has_Logged_in_successfully_in_Author_Url() {

	}

	@Given("User search data  service {string}")
	public void user_search_data_service(String dataservice) {
		this.dataservice = dataservice;
	}

	@Given("User get data service then delete it and create it")
	public void user_get_data_service_then_delete_it_and_create_it() throws Throwable {
		List<WebElement> list = driver.findElements(By.id("serviceManagerCardTitle"));
		for (WebElement exist : list) {
			if ((exist.getText()).equals(dataservice)) {
				flag = true;
				String xpath = "//span[text()='" + dataservice
						+ "'] /ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::div[@class='toggler']";
				WebElement string = driver.findElement(By.xpath(xpath));
				string.click();
				Thread.sleep(5000);
				String xpath2 = "(//span[text()='" + dataservice
						+ "'])/ancestor::div[@class='card-header bg-white border-0 p-2']/following-sibling::div[@class='card-body pt-2']/following-sibling::div[@class='card-footer p-0 ng-star-inserted']/descendant::span[text()='Delete']";
				WebElement string1 = driver.findElement(By.xpath(xpath2));
				string1.click();
				driver.findElement(By.xpath("//button[@id='deleteModalYes']")).click();
				Thread.sleep(5000);
				create(dataservice);
				driver.findElement(By.xpath("//span[text()='Save & Deploy']")).click();
				driver.findElement(By.xpath("//span[text()='Groups']")).click();
				
			}
		}
		

	}

	@Given("User not get data service then create it")
	public void user_not_get_data_service_then_create_it() throws Throwable {
		create(dataservice);
		driver.findElement(By.xpath("//span[text()='Save & Deploy']")).click();
		driver.findElement(By.xpath("//span[text()='Groups']")).click();
		

	}

	@Then("Group {string} does not exist")
	public void group_does_not_exist(String group) {
		this.group = group;
		
		List<WebElement> groupList = driver
				.findElements(By.xpath("//div[@class='group-card text-center m-3 hover ng-star-inserted']"));
		this.groupList = groupList;
		for (WebElement grp : groupList) {
			if (!((grp.getText())).equals(group)) {
				flag = false;
				System.out.println("Group" + group + "is not prsesnt");
				break;
			}
		}

	}

	@Then("Create new group {string}")
	public void create_new_group(String group) {
		driver.findElement(By.xpath("//span[text()='New Group']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Untitled Service']")).sendKeys(group);
		driver.findElement(By.xpath("//button[text()='Create']")).click();

	}

	@Then("Group {string} does exist")
	public void group_does_exist(String group) {

		driver.findElement(By.xpath("//span[text()='Groups']")).click();
		List<WebElement> ilist = driver
				.findElements(By.xpath("//div[@class='group-card text-center m-3 hover ng-star-inserted']"));
		for (WebElement present : ilist) {
			if ((present.getText()).equals(group)) {
				flag = true;
				System.out.println("Group" + group + "is prsesnt");
				break;
			}
		}
	}

	@Then("Delet group {string} then create")
	public void delet_group_then_create(String group) {
	
		driver.findElement(By.xpath("//div[text()='" + group + "']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Delete Group']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']"));
		// driver.findElement(By.xpath("//span[text()='Back']")).click();
		driver.findElement(By.xpath("//span[text()='New Group']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Untitled Service']")).sendKeys(group);
		driver.findElement(By.xpath("//button[text()='Create']")).click();

	}

	@Then("Assign appcenter permissions for {string} dataservice to {string}")
	public void assign_appcenter_permissions_for_dataservice_to(String dataservice, String user) {

	}

	public static void create(String dataserive) throws Throwable {
		driver.findElement(By.xpath("//span[text()='New Data Service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Untitled Service']")).sendKeys(dataservice);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		FileReader reader = new FileReader("D:\\MaheshWorkSpace\\MaheshMavenProject\\jsonfile\\string_Text.json");
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(reader);
		JSONArray arr = (JSONArray) obj.get("definition");
		for (int i = 1; i < arr.size(); i++) {

			JSONObject d = (JSONObject) arr.get(i);
			JSONObject prop = (JSONObject) d.get("properties");
			String name = (String) prop.get("name");
			// Boolean reqd=(Boolean)prop.get("required");
			driver.findElement(By.xpath("//span[text()='New Attribute']")).click();

			driver.findElement(By.xpath("(//input[@placeholder='Untitled Attribute'])[" + i + "]")).sendKeys(name);

			if (prop.containsKey("required")) {
				Boolean reqd = (Boolean) prop.get("required");
				if (reqd == true)
					driver.findElement(By.xpath("//div[text()='Required']/following-sibling::label//span")).click();
			}
			if (prop.containsKey("createOnly")) {
				Boolean reqd = (Boolean) prop.get("createOnly");
				if (reqd == true)
					driver.findElement(By.xpath("//div[text()='Create Only']/following-sibling::label//span")).click();
			}
			if (prop.containsKey("unique")) {
				Boolean reqd = (Boolean) prop.get("unique");
				if (reqd == true)
					driver.findElement(By.xpath("//div[text()='Unique']/following-sibling::label//span")).click();
			}
			if (prop.containsKey("label")) {

				String label = (String) prop.get("label");
				driver.findElement(By.xpath("//input[@id='label']")).sendKeys(label);

			}
			if (prop.containsKey("errorMessage")) {
				String error = (String) prop.get("errorMessage");
				driver.findElement(By.xpath("//input[@id='errorMessage']")).sendKeys(error);
			}
			if (prop.containsKey("default")) {
				String def = (String) prop.get("default");
				driver.findElement(By.xpath("//input[@formcontrolname='default']")).sendKeys(def);
			}
			if (prop.containsKey("pattern")) {
				String pattern = (String) prop.get("pattern");
				driver.findElement(By.xpath("//input[@formcontrolname='pattern']")).sendKeys(pattern);
			}
			if (prop.containsKey("minlength")) {
				String minlength = (String) prop.get("minlength");
				driver.findElement(By.xpath("//input[@placeholder='Minimum length']")).sendKeys(minlength);
			}
			if (prop.containsKey("maxlength")) {
				String maxlength = (String) prop.get("maxlength");
				driver.findElement(By.xpath("//input[@placeholder='Maximum length']")).sendKeys(maxlength);
			}
			if (prop.containsKey("_description")) {
				String description = (String) prop.get("_description");
				driver.findElement(By.xpath("//textarea[@formcontrolname='_description']")).sendKeys(description);
			}
			if (prop.containsKey("pattern")) {
				String pattern = (String) prop.get("pattern");
				driver.findElement(By.xpath("//input[@formcontrolname='pattern']")).sendKeys(pattern);
			}
		}
	}
}
