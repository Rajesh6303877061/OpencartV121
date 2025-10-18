package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void verify_account_registartion()
	{
	
		try {
		logger.info("****Starting TC001_AccountRegistrationTest ");
		logger.debug("This is a debug log message");
		//We are taking help from page object classes.
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("****Clicked on myaccount link ");
		hp.clickRegister();
		logger.info("****Clicked on register link ");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		/*regpage.setFirstName("John");
		regpage.setLastName("David");
		regpage.setEmail("abcjohndavi1235@gmail.com");
		regpage.setTelephone("4567891230");
		//String password =
		regpage.setPassword("abc123456");
		regpage.setConfirmPassword("abc123456");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		*/
		
		logger.info("****Providing customer details");
		//Generating dynamically
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		String password =randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("****Validating expected message");
		String confmsg=regpage.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		if (confmsg.equals("Your Account Has Been Created!"))
				{
			Assert.assertTrue(true);
				}
		
		else
		{
			Assert.assertTrue(false);
			logger.error("Test got failed...");
			logger.debug("Debug logs...");
		}
		
	} 
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("****Finished TC001_AccountRegistrationTest ");
	}
     
	
	

}
