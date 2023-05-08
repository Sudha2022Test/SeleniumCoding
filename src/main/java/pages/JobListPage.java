package pages;

import org.openqa.selenium.Keys;

import wrappers.GenericWrappers;

public class JobListPage extends GenericWrappers{
	
	public JobListPage enterCompany(String cmpny) {
		enterByXpath(prop.getProperty("JobListPage.Company.XPath"),cmpny);
		return this; 
	}
	
	public JobListPage waitForPageLoad(long time) {
		waitProperty(time);
		return this;
	}
	
	public JobListPage enterLocation(String loc) {
		enterByXpath(prop.getProperty("JobListPage.Location.XPath"),loc+Keys.ENTER);
		return this; 
	}

	
	public JobListPage clickEasyApply() {
		clickByXpath(prop.getProperty("JobListPage.EasyApply.XPath"));
		return this; 
	}
	
	
	public JobListPage clickNext() {
		clickByXpath(prop.getProperty("JobListPage.Next.XPath"));
		return this; 
	}
	
	public JobListPage clickNext2() {
		clickByXpath(prop.getProperty("JobListPage.Next2.XPath"));
		return this; 
	}
	
	public JobListPage enterServiceDelivery(String serviceDelivery) {
		enterByXpath(prop.getProperty("JobListPage.EnterServiceDelivery.XPath"),serviceDelivery);
		return this; 
	}
	
	public JobListPage enterWealthManagement(String wealthManagement) {
		enterByXpath(prop.getProperty("JobListPage.EnterWealthManagement.XPath"),wealthManagement);
		return this; 
	}
	
	public JobListPage enterDeliveryManagement(String deliveryManagement) {
		enterByXpath(prop.getProperty("JobListPage.EnterDeliveryManagement.XPath"),deliveryManagement);
		return this; 
	}
	
	public JobListPage clickReview() {
		clickByXpath(prop.getProperty("JobListPage.Review.XPath"));
		return this; 
	}

	
	public JobListPage clickClose() {
		clickByXpath(prop.getProperty("JobListPage.Close.XPath"));
		return this; 
	}
	
	public HomePage clickDiscard() {
		clickByXpath(prop.getProperty("JobListPage.Discard.XPath"));
		return new HomePage(); 
	}
	
	
	

	
}
