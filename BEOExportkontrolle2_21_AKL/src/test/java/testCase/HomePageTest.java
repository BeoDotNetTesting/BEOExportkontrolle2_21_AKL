package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.GeneralUtilities;

public class HomePageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	GeneralUtilities gu;
  @Test//(groups= "Low")
  public void verifyCreateFirme() throws Exception {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.sendUserName(logIndata(1));
	  lp.sendPassword(logIndata(4));
	  lp.clickLoginButton();
	  hp.clickOnAddToButton();	 
	  hp.sendCustomerNumber();	  
	  hp.sendCompanyName();	 
	  hp.clickOnDifferentLocations();	
	  hp.sendNotes();	 
	  hp.selectOptionFromDifferentLocation();	  
	  hp.clickSaveButton();
	  hp.clickReturnButton();
	  Thread.sleep(500);
	  String actual=hp.getTextFromTable();	 
	  String expected="ELCOME";
	  Assert.assertEquals(actual, expected,Constant.hp_errorverifyCreateFirme ); 
  }
  @Test//(groups= "Low")
  public void verifyLogOut() throws Exception {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.sendUserName(logIndata(1));
	  lp.sendPassword(logIndata(4));
	  lp.clickLoginButton();
	  Thread.sleep(100);
	  hp.clickLogOutButton();
	  String actual=lp.getRegisterText();	 
	  String expected="Anmelden";
	  Assert.assertEquals(actual, expected, "::Register text not as expected");
  }
}
