package assignmentpack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class OrangeHRM {
	WebDriver drv ;
	String baseURL=("https://opensource-demo.orangehrmlive.com/");
	
	@BeforeTest
 public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\web driver\\chromedriver.exe");
	    drv= new ChromeDriver();
		drv.get(baseURL);
		drv.manage().window().maximize();
		
	}
	@AfterTest
	 public void Shutdown() {
		 drv.close();
	 } 
 
	@Test(dataProvider="DP")
	public void accountCreation(String usrName, String PassWord) throws InterruptedException {
		
			    WebElement Username = drv.findElement(By.id("txtUsername"));
				Username.sendKeys(usrName);
				WebElement Pd = drv.findElement(By.name("txtPassword"));
			    Pd.sendKeys(PassWord);
			    WebElement Login = drv.findElement(By.name("Submit"));
	            Login.click();
	            
	        String actualurl=drv.getCurrentUrl();
	   		System.out.println(actualurl);
	   		String expectedurl="https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
	   		if(actualurl.equalsIgnoreCase(expectedurl)) {
	   			  System.out.println("The login is Failed");
	   		}
	   		else {
	   			System.out.println("The Login is Successfull");
	   		}
	   		
	   	     drv.findElement(By.partialLinkText("Admin")).click();
	   		Thread.sleep(1000);
	   		drv.findElement(By.partialLinkText("Leave")).click();
	   		Thread.sleep(1000);

	   		drv.findElement(By.partialLinkText("Recruitment")).click();
	   		Thread.sleep(4000);
	   	
     		drv.findElement(By.partialLinkText("PIM")).click();
     		drv.findElement(By.partialLinkText("Add Employee")).click();
     		drv.findElement(By.name("firstName")).sendKeys("xyz");
     		drv.findElement(By.name("lastName")).sendKeys("x");
     		drv.findElement(By.id("chkLogin")).click();
     		drv.findElement(By.name("user_name")).sendKeys("xyz");
     		drv.findElement(By.name("user_password")).sendKeys("xyz@123");
     		drv.findElement(By.name("re_password")).sendKeys("xyz@123");
     		drv.findElement(By.id("btnSave")).click();
	   		drv.findElement(By.partialLinkText("Welcome")).click();
	   		drv.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/logout");
	   		Thread.sleep(4000);
	   		}    
	    

		
	@DataProvider(name="DP")
	public Object[][] dataObject(){
		
		return new Object[][] {
			{"Vidya","567"},{"bhavana","bhavana@123"},{"Admin","admin123"},{"Admin","admin123"}
		};
		

	
	}
}