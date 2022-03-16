package com.uiFramework.KTCTC.Pages;




import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class TextBoxPage {
	CommonMethods cmObj;
	private WebDriver driver;
	JavaScriptHelper javaScriptHelper;
	By textBoxPageLink = By.xpath("//*[contains(text(),'Text Box')]");
	private Logger log = LoggerHelper.getLogger(TextBoxPage.class);
	// TextBox Page Locators
	By firstnameOnTextBox = By.id("userName");
	By emailOnTextBox = By.id("userEmail");
	By currentAddressOnTextBox = By.id("currentAddress");
	By permenantAddressOnTextBox = By.id("permanentAddress");
   
	// SubmitButton
	By submitbuttonOnTextBox = By.id("submit");
	By SavedEmail = By.id("email");
	By SavedfullName = By.xpath("//*[@id='email']/preceding-sibling::p[1]");
	By SavedCurrentAdress = By.xpath("//*[@id='email']/following-sibling::p[1]");
	By SavedPermenantAdress = By.xpath("//*[@id='email']/following-sibling::p[2]");
	By Link= By.xpath("//*[@id='item-5']//*[contains(text(),'Links')]");
	
	By bottomLine = By.xpath("//*[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]");
	public TextBoxPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void navigateToTextboxPage() 
	{
		javaScriptHelper= new JavaScriptHelper( driver);
		log.info("Navigating to TextBox Page");
		javaScriptHelper.scrollToElement(driver.findElement(Link));
		driver.findElement(textBoxPageLink).click();
		log.info("Navigated to Textbox Page Sucessusfully");
	}

	public void addDetailsOnTextBoxPage(String fullName,String email,String crtadress,String pmtadress ) 
	{    
	    cmObj=new CommonMethods();
		javaScriptHelper= new JavaScriptHelper( driver);
		log.info("Adding new detais in TextBox Page");
		WaitHelper wt= new WaitHelper(driver);
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(firstnameOnTextBox), 5, 200);
		driver.findElement(firstnameOnTextBox).sendKeys(fullName);
		driver.findElement(emailOnTextBox).sendKeys(email);
		driver.findElement(currentAddressOnTextBox).sendKeys(crtadress);
		driver.findElement(permenantAddressOnTextBox).sendKeys(pmtadress);
		javaScriptHelper.zoomInBy60Percentage();
		driver.findElement(submitbuttonOnTextBox).submit();
		log.info("New details added sucessfully");
		
		
	}
	
	public HashMap<String,String> getalldetailsOfAddedUser()
	{
		log.info("Getting all Details of Added User");
		HashMap<String, String>data=new HashMap<>();
		data.put("FullName", driver.findElement(By.xpath("//*[@id='email' and contains(text(),'@')]//preceding-sibling::p[1]")).getText());
		data.put("email", driver.findElement(By.id("email")).getText());
		data.put("crtadress", driver.findElement(By.xpath("//*[@id='email' and contains(text(),'@')]//following-sibling::p[1]")).getText());
		data.put("pmtadress", driver.findElement(By.xpath("//*[@id='email' and contains(text(),'@')]//following-sibling::p[2]")).getText());
		log.info("Getting all Details of Added User sucessfully");
		return data;
	}
}
