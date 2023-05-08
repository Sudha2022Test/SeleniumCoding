package pages;

import wrappers.GenericWrappers;

public class SignInPage extends GenericWrappers{

	public SignInPage enterID(String Uname) {
		enterByXpath(prop.getProperty("SignInPage.ID.XPath"),Uname);
		return this;
	}
	
	public SignInPage enterPswd(String Pswd) {
		enterByXpath(prop.getProperty("SignInPage.Password.XPath"),Pswd);
		return this; 
	}
	
	public SignInPage clickShow() {
		clickByXpath(prop.getProperty("SignInPage.Show.XPath"));
		return this; 
	}
	
	public SignInPage clickHide() {
		clickByXpath(prop.getProperty("SignInPage.Hide.XPath"));
		return this; 
	}
	
	public HomePage clickSubmit() {
		clickByXpath(prop.getProperty("SignInPage.Submit.XPath"));
		return new HomePage(); 
	}
	
	
	

}
