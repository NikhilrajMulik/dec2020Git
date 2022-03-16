package com.uiFramework.KTCTC.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class PracticeForm {
	CommonMethods cmObj;
	private WebDriver driver;
	JavaScriptHelper javaScriptHelper;
	private Logger log = LoggerHelper.getLogger(TextBoxPage.class);
  By practiceFormLink= By.xpath("//*[@id='item-0']//span[contains(text(),'Practice Form')]");
 
  // ParcticeForm Locators
  By fname= By.id("firstName");
  By lname= By.id("lastName");
  By email= By.id("userEmail");
  By maleradioButton= By.xpath("//*[@class='custom-control custom-radio custom-control-inline']/label[@for='gender-radio-1']");
  By femaleradioButton= By.xpath("//*[@class='custom-control custom-radio custom-control-inline']/label[@for='gender-radio-2']");
  By otherradioButton= By.xpath("//*[@class='custom-control custom-radio custom-control-inline']/label[@for='gender-radio-3']");
  By phoneNumber= By.id("userNumber");
  By dateBox= By.id("dateOfBirthInput");
By selectYear= By.xpath("//*[@class='react-datepicker__year-select']");
By selectmonth= By.xpath("//*[@class='react-datepicker__month-select']");
By dateClick = By.xpath("//*[@class='react-datepicker__day react-datepicker__day--002']");
By subject= By.id("subjectsInput");
By sportCheckbox= By.xpath("//*[@class='custom-control custom-checkbox custom-control-inline']//label[@for='hobbies-checkbox-1']");
By readingCheckbox= By.xpath("//*[@class='custom-control custom-checkbox custom-control-inline']//label[@for='hobbies-checkbox-2']");
By musicCheckbox= By.xpath("//*[@class='custom-control custom-checkbox custom-control-inline']//label[@for='hobbies-checkbox-3']");	
By picture= By.id("uploadPicture");
By currentaddress= By.id("currentAddress");
By selectState= By.id("react-select-3-input");
By selectCity= By.id("react-select-4-input");
By submitButton= By.id("submit");
By moveTointerctions= By.xpath("//*[@class='element-group']//*[contains(text(),'Interactions')]");

public PracticeForm (WebDriver driver)
{
	this.driver=driver;
	

}

public void navigateToPracticeFormPage()
{
	log.info("Navigating to Practice Form Page" );
	//javaScriptHelper.zoomInBy60Percentage();
	//javaScriptHelper.scrollToElement(driver.findElement(moveTointerctions));
	driver.findElement(practiceFormLink).click();
	log.info("Navigation Sucessful");
System.out.println(" ");
}







}









