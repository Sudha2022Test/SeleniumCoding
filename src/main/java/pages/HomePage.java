package pages;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	
	public JobListPage clickJob() {
		clickByXpath(prop.getProperty("HomePage.Job.XPath"));
		return new JobListPage(); 
	}
	
	public JobListPage waitForPageLoad(long time) {
		waitProperty(time);
		return new JobListPage();
	}
	
	public HomePage clickIcon() {
		clickByXpath(prop.getProperty("HomePage.Icon.XPath"));
		return this; 
	}
			

}
