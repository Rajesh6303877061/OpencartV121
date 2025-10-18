package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass {
	
	//@Test(dataProvider="LoginData") //If it is present in the same class we can mention like this but data provider is present in the different class.
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven") //Getting dataProvider from different class.
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		
		logger.info("**** Starting TC_003_LoginDDT  ****");
		
		try {
		//Home page
				HomePage hp=new HomePage(driver);
				hp.clickMyaccount();
			     hp.clickLogin(); //Login link under MyAccount
				
				
				//Login page
				LoginPage lp=new LoginPage(driver);
				
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin(); //Login button
				
				//My Account Page
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageExists();
				
				if(exp.equalsIgnoreCase("valid"))
				{
					if(targetPage==true)
					{
						Assert.assertTrue(true);
						macc.clickLogout();
						
					}
					
					else
					{
						Assert.assertTrue(false);
					}
					
					if(exp.equalsIgnoreCase("valid"))
					{
						if(targetPage==true)
						{
							macc.clickLogout();
						}
							Assert.assertTrue(false);
							
							
						}
						
						else
						{
							Assert.assertTrue(true);
						}
					
				}
				
		}catch(Exception e)
		{
			Assert.fail();
		}
				Thread.sleep(3000);
				logger.info("**** Finished TC_003_LoginDDT  ****");
				
				
	}

}
