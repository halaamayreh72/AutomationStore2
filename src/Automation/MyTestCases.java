package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends MyData

{
	WebDriver driver = new EdgeDriver();
	String theURL ="https://automationteststore.com/";
    String SignUpPage ="https://automationteststore.com/index.php?rt=account/create";
	
	@BeforeTest
	public void MySetup ()
	
	{
          driver.get(theURL);
        // Set an implicit wait time (wait up to 5 seconds when locating elements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        
		     
     }
		
		
		
	
	
	
	
	@Test (priority=1 , enabled = false)
	public void SignUp() throws InterruptedException
	
	{
		 driver.navigate().to(SignUpPage);
		 WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
		 WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		 WebElement Email = driver.findElement(By.id("AccountFrm_email"));
         WebElement TelephoneNumber = driver.findElement(By.id("AccountFrm_telephone"));
         WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
		 WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));
		 WebElement theCountry = driver.findElement(By.id("AccountFrm_country_id"));
		 WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
		 WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));
		 WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement TheAgreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement SubscribeYes = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement SubscribeNo = driver.findElement(By.name("newsletter"));
		if (WantToSubscribe=true) 
			 
		 {
			SubscribeYes.click();
		 }else {SubscribeNo.click();}
		Thread.sleep(2000);
		
		WebElement Continue = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));


		 Select mySelectElementForCountry = new Select(theCountry);
		 mySelectElementForCountry.selectByIndex(108);
          Thread.sleep(2000);
		 Select mySelectElementForState = new Select(TheState);
		 mySelectElementForState.selectByIndex(TheSelectIndex); 
		 
		 List <WebElement> AlltheStates = TheState.findElements(By.tagName("option"));
		 String theCity = AlltheStates.get(TheSelectIndex).getText();
		 WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		 
		 //actions
		 FirstName.sendKeys(TheFirstName);
		 LastName.sendKeys(TheLastNames);
		 Email.sendKeys(TheEmail);
		 TelephoneNumber.sendKeys(telephoneNumber);
		 TheFax.sendKeys(theFax);
		 AddressOne.sendKeys(theAdressOne);
		 TheCityInput.sendKeys(theCity);
		 ThePostalCode.sendKeys(PostalCode);
		 LoginName.sendKeys(LOGINNAME);
		 ThePassword.sendKeys(Password);
		 TheConfirmPassword.sendKeys(Password);
		 TheAgreeBox.click();
		 Thread.sleep(2000);
		 Continue.click();
		 
		
		 String ActualTextForSignUp = driver.findElement(By.className("maintext")).getText();
		 
		 Assert.assertEquals(ActualTextForSignUp, ExpectedTextForSignUp);

		
	}

    @Test(priority=2 , enabled = false)
    public void Logout() throws InterruptedException
    { 
    	
    	Thread.sleep(2000);
    	WebElement TheLogout = driver.findElement(By.linkText("Logoff"));
    	TheLogout.click();
    	
    	Boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMsg);
    	Assert.assertEquals(ActualValueForLogout, true);
    }

    @Test(priority=3,enabled = false)
    public void Login() 
    
    {
    	
    	WebElement Login = driver.findElement(By.linkText("Login or register"));
    	Login.click();
    	
    	WebElement LoginNameInupt = driver.findElement(By.cssSelector("#loginFrm_loginname"));
    	
    	LoginNameInupt.sendKeys(TheFirstName);
    	
  	WebElement Loginpassword = driver.findElement(By.cssSelector("#loginFrm_password"));
  	WebElement TheLogin = driver.findElement(By.cssSelector("button[title='Login']"));

    	LoginNameInupt.sendKeys(LOGINNAME);
    	Loginpassword.sendKeys(Password);
    	TheLogin.click();
    	
    	
    }
    
    
    @Test (priority=3)
    public void Additems() 
    
    {
        driver.navigate().to("https://automationteststore.com/");
        
        List <WebElement> AllItems = driver.findElements(By.className("prdocutname"));
        int RandomItemAdd = rand.nextInt(AllItems.size());

        AllItems.get(RandomItemAdd).click();
        
        
      //  if (driver.getCurrentUrl().contains("product_id=116"))
      //  {
      // 	WebElement AvailableOption = driver.findElement(By.id("option344747"));
     // 	AvailableOption.click();
     // }
        
        
        while (driver.getPageSource().contains("Out of Stock") || driver.getCurrentUrl().contains("product_id=116"))
        
        {
        	driver.navigate().back();
            List <WebElement> AlternativeItems = driver.findElements(By.className("prdocutname"));
            int AlternativeItem = rand.nextInt(AllItems.size());

            AlternativeItems.get(AlternativeItem);

        	
        }
        
        
    	WebElement AddButton = driver.findElement(By.cssSelector(".cart"));
    	AddButton.click();
    }
    
    @AfterTest
    public void AfterMyTest() 
    {
    	
     // driver.close();
    }
        
 

}
