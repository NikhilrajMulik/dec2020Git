package KTCTC.regression;

import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.PracticeForm;
import com.uiFramework.KTCTC.testbase.TestBase;

public class PracticeFormTest extends TestBase {
	PracticeForm practiceForm;
	
	@Test
	public void verifyUserCanNavigateToPracticeForm()
	{
		practiceForm=new PracticeForm(driver);
		cmObj.navigateToReQuiredPage(driver, "Forms");
		practiceForm.navigateToPracticeFormPage();
	}

	public void verifyUserCanbeaddedOnPracticeForm()
	{
		
	}
	
	
	
}  
