package KTCTC.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.WebTablePage2;
import com.uiFramework.KTCTC.Pages.WebTablesPage;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.testbase.TestBase;
import com.uiFramwork.KTCTC.ObjectPages.WebTableObjectClass;

public class WebTablesTest2 extends TestBase {
	CommonMethods commonMethods;
	WebTablePage2 webTablePage2;
	WebTableObjectClass newUserData = new WebTableObjectClass();
	WebTableObjectClass updatedUserData = new WebTableObjectClass();

	String fname = cmObj.getcharacterString(5);
	String lname = cmObj.getcharacterString(5);
	String email = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(4) + ".com";
	String age = cmObj.getNumericString(2);
	String salary = cmObj.getNumericString(7);
	String department = cmObj.getcharacterString(5);
	String newfname = cmObj.getcharacterString(5);
	String newlname = cmObj.getcharacterString(5);
	String newemail = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(4) + ".com";
	String newage = cmObj.getNumericString(2);
	String newsalary = cmObj.getNumericString(7);
	String newdepartment = cmObj.getcharacterString(10);

	@Test(priority = 1)
	public void verifyUsercanNavigateToWebtablePage() {
		webTablePage2 = new WebTablePage2(driver);
		cmObj.navigateToReQuiredPage(driver, "Element");
		webTablePage2.navigateToWebTablePage(driver);

	}

	@Test(priority = 2)
	public void verifyUserCanbeAddedOnWebTablesPage() {
		webTablePage2.addNewUserOnWebTablePage(fname, lname, email, age, salary, department);
		boolean flag = webTablePage2.isProvidedEmailIdDisplayed(driver, email);
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyAllDetailsOfNewelyAddedUsers() {
		
		HashMap<String, String> details = webTablePage2.getallDetailsOfProvidedUser(email);

		Assert.assertEquals(fname, details.get("FirstName"));
		Assert.assertEquals(lname, details.get("LastName"));
		Assert.assertEquals(email, details.get("Email"));
		Assert.assertEquals(age, details.get("Age"));
		Assert.assertEquals(salary, details.get("Salary"));
		Assert.assertEquals(department, details.get("Department"));
		
	}

	@Test(priority = 4)
	public void verifyExistingUserCanbeEdited() {
		webTablePage2.editExistingUserWithProvidedDetails(driver, email, newfname, newlname, newemail, newage,
				newsalary, newdepartment);
		boolean flag = webTablePage2.isProvidedEmailIdDisplayed(driver, newemail);
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void verifyAllDetailsofEditedUser() {
		HashMap<String, String> details = webTablePage2.getallDetailsOfProvidedUser(newemail);

		Assert.assertEquals(newfname, details.get("FirstName"));
		Assert.assertEquals(newlname, details.get("LastName"));
		Assert.assertEquals(newemail, details.get("Email"));
		Assert.assertEquals(newage, details.get("Age"));
		Assert.assertEquals(newsalary, details.get("Salary"));
		Assert.assertEquals(newdepartment, details.get("Department"));

	}

	@Test(priority = 6)
	public void verifyExistingUserCanbeDeleted() {
		webTablePage2.deleteExistingUserWithProovidedDetails(driver, newemail);
		boolean flag = webTablePage2.isProvidedEmailIdDisplayed(driver, newemail);
		Assert.assertFalse(flag);

	}
}
