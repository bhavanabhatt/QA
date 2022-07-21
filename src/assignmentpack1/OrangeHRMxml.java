package assignmentpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMxml {
	WebDriver d;
	
	@BeforeTest
	public void setup() {
	    d = new FirefoxDriver();
	    System.setProperty("webdriver.gecko.driver", "C:\\web driver\\geckodriver.exe");
	    d.get("https://opensource-demo.orangehrmlive.com/");
	    d.manage().window().maximize();
	}
	
	@Test
	@Parameters({"username","password"})
	public void start(String username, String password) throws InterruptedException {
	    d.findElement(By.id("txtUsername")).sendKeys(username);
	    d.findElement(By.id("txtPassword")).sendKeys(password);
	    d.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		d.findElement(By.partialLinkText("Welcome")).click();
   		d.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/logout");
   		Thread.sleep(4000);
	}
	
	@AfterTest
	public void shut() {
		d.close();
	}

}
