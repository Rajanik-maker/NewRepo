package TestPackage;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;

public class DataProTest {
  @Test(dataProvider = "dp")
  public void f(String UN, String PW) 
  {
	  WebDriver w=new EdgeDriver();
	  w.get("https://www.saucedemo.com/v1/");
	  w.findElement(By.xpath("//input[@id='user-name']")).sendKeys(UN);
	  w.findElement(By.xpath("//input[@id='password']")).sendKeys(PW);
	//  w.findElement(By.xpath("//input[@id='login-button']")).click();
	  System.out.println("User name is " +UN);
	  System.out.println("Password is :" +PW);
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "standard_user", "secret_sauce" },
      new Object[] { "locked_out_user", "secret_sauce" },
    };
  }
}
