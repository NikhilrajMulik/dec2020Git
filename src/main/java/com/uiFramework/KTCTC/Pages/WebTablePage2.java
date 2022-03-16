package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class WebTablePage2 {
	private Logger log = LoggerHelper.getLogger(WebTablesPage.class);
	private WebDriver driver;
	By addButtonOnWebTablePage= By.id("addNewRecordButton");
	By webTablePagelink= By.xpath("//*[@class='element-group']//*[contains(text(),'Web Tables')]");
	By Link= By.xpath("//*[@id='item-5']//*[contains(text(),'Links')]");
	// Registration forms Locator
	
	By firstnameOnRegistrationform= By.id("firstName");
	By lastnameOnRegistrationform= By.id("lastName");
	By emailOnRegistrationform= By.id("userEmail");
	By ageOnRegistrationform= By.id("age");
	By salaryOnRegistrtaionform= By.id("salary");
	By departmentOnRegistrationform= By.id("department");
	By submitButtonOnRegistrationform= By.id("submit");
	By advClose= By.id("close-fixedban");
	// Search Box
	
	By searchBoxOnWebtablePage= By.id("searchBox");
	
	// Edit button
	
	By editButtonOnWebTablePage= By.xpath("//*[contains(@id,'edit-record')]");
	
	//Delete button
	By deleteButtonWebTablePage= By.xpath("//*[contains(@id,'delete-record')]");
	
	
	public WebTablePage2(WebDriver driver){
		this.driver=driver;
	}
	public void navigateToWebTablePage(WebDriver driver)
	{
		log.info("Navigating to WebtablePage...");
		Actions scroll=new Actions(driver);
		scroll.moveToElement(driver.findElement(Link)).build().perform();
		driver.findElement(webTablePagelink).click();
		log.info("Navigation to webTablePage Successful");
	}
	
	public void addNewUserOnWebTablePage(String fname,String lname,String email,String age,String salary,String department)
	{
		Actions scroll=new Actions(driver);
		WaitHelper wt= new WaitHelper(driver);
		log.info("Adding new user on WebTablePage...");
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(addButtonOnWebTablePage), 5, 200);
		driver.findElement(addButtonOnWebTablePage).click();
		
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(firstnameOnRegistrationform), 5, 200);
		driver.findElement(advClose).click();
		driver.findElement(firstnameOnRegistrationform).sendKeys(fname);
		driver.findElement(lastnameOnRegistrationform).sendKeys(lname);
		driver.findElement(emailOnRegistrationform).sendKeys(email);
		driver.findElement(ageOnRegistrationform).sendKeys(age);
		driver.findElement(salaryOnRegistrtaionform).sendKeys(salary);
		driver.findElement(departmentOnRegistrationform).sendKeys(department);
		scroll.moveToElement(driver.findElement(submitButtonOnRegistrationform)).build().perform();
		driver.findElement(submitButtonOnRegistrationform).click();
		log.info("New User Added Sucessfully");
	}
	
	public void searchStringInSearchBox(WebDriver driver,String email)
	{
		log.info("Search String Provided in Search Box");
		driver.findElement(searchBoxOnWebtablePage).clear();
		driver.findElement(searchBoxOnWebtablePage).sendKeys(email);
		log.info("Searched provided string in search Box = "+email);
	}
	
	public boolean isProvidedEmailIdDisplayed(WebDriver driver,String email)
	{  
	    searchStringInSearchBox( driver, email);
		boolean flag=false;
		
	try {
		flag=driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]")).isDisplayed();
		log.info("Provided user is displayed on WebTablePage");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("Provided user is displayed on WebTablePage");
	}
	return flag;
	
	}
	
	public HashMap<String,String> getallDetailsOfProvidedUser(String email)
	{
		log.info("Getting all Details of Provided user...");
		HashMap<String,String> data= new HashMap<>();
		data.put("FirstName", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[3]")).getText());
		data.put("LastName", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[2]")).getText());
		data.put("Age", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[1]")).getText());
		data.put("Email", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]")).getText());
		data.put("Salary", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/following-sibling::div[1]")).getText());
		data.put("Department", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[2]")).getText());
		log.info("User Details are Provided Sucessfully...");
		return data;
		}
	
	public void editExistingUserWithProvidedDetails(WebDriver driver,String Existingemail,String fname,String lname,String email,String age,String salary,String department)
	{
		log.info("Editing Existing User with Provided details");
		searchStringInSearchBox( driver, Existingemail);
		driver.findElement(editButtonOnWebTablePage).click();
		WaitHelper wt= new WaitHelper(driver);
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(firstnameOnRegistrationform), 5, 200);
		driver.findElement(firstnameOnRegistrationform).clear();
		driver.findElement(firstnameOnRegistrationform).sendKeys(fname);
		driver.findElement(lastnameOnRegistrationform).clear();
		driver.findElement(lastnameOnRegistrationform).sendKeys(lname);
		driver.findElement(emailOnRegistrationform).clear();
		driver.findElement(emailOnRegistrationform).sendKeys(email);
		driver.findElement(ageOnRegistrationform).clear();
		driver.findElement(ageOnRegistrationform).sendKeys(age);
		driver.findElement(salaryOnRegistrtaionform).clear();
		driver.findElement(salaryOnRegistrtaionform).sendKeys(salary);
		driver.findElement(departmentOnRegistrationform).clear();
		driver.findElement(departmentOnRegistrationform).sendKeys(department);
		driver.findElement(submitButtonOnRegistrationform).click();
		log.info("User is edited sucessfully");
	 }
	
	public void deleteExistingUserWithProovidedDetails(WebDriver driver,String email)
	{
		log.info("Deleting User With Provided details..");
		searchStringInSearchBox(driver, email);
		driver.findElement(deleteButtonWebTablePage).click();
		log.info("User deleted Sucessfully...");
	}
	
	
}
