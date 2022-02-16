package practicecodes;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample {

	public static void main(String[] args) {
          WebDriver driver=new ChromeDriver();
          Alert alert=driver.switchTo().alert();
          alert.accept();
          alert.dismiss();
          String alertmassage=alert.getText();
          
          WebElement l=driver.findElement(By.tagName("select"));
          
          Select s= new Select(l);
          List<WebElement>list=s.getOptions();
          for(WebElement c:list){
        	  System.out.println(c.getText()+"="+c.getAttribute("population"));
        	  if(c.getAttribute("khand").equals("Asia")) {
        	  System.out.println(c.getText()+"is from Asia");
        	  
        	  }
        	  
          }
          
          
	}

}
