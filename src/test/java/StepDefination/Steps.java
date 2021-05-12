package StepDefination;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {

	static WebDriver driver;
	
	@Given("^Open the Chrome and launch the application$")				
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
        		
			System.setProperty("webdriver.chrome.driver ", "/opt/homebrew/bin/chromedriver");			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("–no-sandbox");
			options.addArguments("–disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/v4");
			
		
    }		

    @When("^Enter the Username and Password$")					
    public void enter_the_UsernameandPassword() throws Throwable 							
    {		
       				
    	driver.findElement(By.name("uid")).sendKeys("mngr47659");							
        driver.findElement(By.name("password")).sendKeys("123456@");
    	
    }		

    @Then("^Reset the credential$")					
    public void Reset_the_credential() throws Throwable 							
    {    		
        			
    	driver.findElement(By.name("btnReset")).click();
    }		
    
    @Then("^User should see the correct title of Home Page$")					
    public void Submit_the_credential() throws Throwable 							
    {    		
        			
    	driver.findElement(By.name("btnLogin")).click();
    	String title = driver.getTitle();
    	assertEquals("Guru99 Bank Manager HomePage",title);
    }	
    
    @When("User logs in using Username as \"(.*)\" and Password \"(.*)\"$")
    public void user_logs_in_using_username_as_user1_and_password_password1(String username, String password) throws InterruptedException {
       
    	Thread.sleep(2000);
    	driver.findElement(By.name("uid")).sendKeys(username);	
    	System.out.println(username);
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println(password);
    }

    @Then("error message Alert will be popup")
    public void error_message_alert_will_be_popup() {
    	
    	driver.findElement(By.name("btnLogin")).click();
    	String getText = driver.switchTo().alert().getText();
    	
    }
    
    @Then("Click on OK button")
    public void click_on_ok_button() {
    	
    	driver.switchTo().alert().accept();
        
    }
    	
}
