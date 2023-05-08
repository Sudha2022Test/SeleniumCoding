package codingpom;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignInPage;
import wrappers.ProjectWrappers;

public class LinkedInPOM extends ProjectWrappers{
	
	@BeforeClass
	public void beforeClass() {
		testCaseName="LinkedIn Job Application";
		testCaseDescription="To verify if user is able to apply job via linked in application";
		author="Sudha";
		category="Smoke";
		browserName="Chrome";
		url="https://www.linkedin.com";
		sheetName="LinkedIn";
	}
	
	@Test(dataProvider="fetchData")
	public void JobApplication(String Username, String Password, String Company, String Location, String ServiceDel, String WealthMan, String DelManage) {
	
		 new SignInPage()
		.enterID(Username)
		.enterPswd(Password)
		.clickShow()
		.clickHide()
		.clickSubmit()
		.clickJob()
		.waitForPageLoad(3000)
		.enterCompany(Company)
		.waitForPageLoad(2000)
		.enterLocation(Location)
		.waitForPageLoad(3000)
		.clickEasyApply()
		.waitForPageLoad(3000)
		.clickNext()
		.waitForPageLoad(4000)
		.clickNext2()
		.waitForPageLoad(5000)
		.enterServiceDelivery(ServiceDel)
		.waitForPageLoad(3000)
		.enterWealthManagement(WealthMan)
		.waitForPageLoad(2000)
		.enterDeliveryManagement(DelManage)
		.waitForPageLoad(1000)
		.clickReview()
		.waitForPageLoad(1000)
		.clickClose()
		.clickDiscard()
		.clickIcon()
		.closeBrowser();
	
	}
}
