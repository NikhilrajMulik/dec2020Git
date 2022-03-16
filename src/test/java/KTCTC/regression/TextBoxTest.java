package KTCTC.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.TextBoxPage;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.testbase.TestBase;

public class TextBoxTest extends TestBase {
	TextBoxPage textBoxpage;
	
	By SavedEmail = By.id("email");
	By SavedfullName = By.xpath("//*[@id='email']/preceding-sibling::p[1]");
	By SavedCurrentAdress = By.xpath("//*[@id='email']/following-sibling::p[1]");
	By SavedPermenantAdress = By.xpath("//*[@id='email']/following-sibling::p[2]");
	String fname =cmObj.getcharacterString(5);
	String Email = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(4) + ".com";
	String currentadress= cmObj.getcharacterString(9);
	String permenantadress= cmObj.getcharacterString(8);
	
	
	
	
	@Test(priority=1)
	public void verifyUsercanNavigateToTextBoxPage()
	{
		textBoxpage= new TextBoxPage(driver);
		cmObj.navigateToReQuiredPage(driver, "Element");
		textBoxpage.navigateToTextboxPage();
		
	} 
	@Test(priority=2)
	public void addingDetailsOfUserOnTextBoxPage()
	{
	         textBoxpage.addDetailsOnTextBoxPage(fname,Email,currentadress,permenantadress);
		
	}
	@Test(priority=3)
	public void verifyAddedDetailsAreSucessfull() 
	{
		
		HashMap<String, String>data=textBoxpage.getalldetailsOfAddedUser();
		Assert.assertEquals(fname, data.get("FullName"));
		Assert.assertEquals(Email, data.get("email"));
		Assert.assertEquals(currentadress, data.get("crtadress"));
		Assert.assertEquals(permenantadress, data.get("pmtadress"));
		
		
	}
	
	
	

}
