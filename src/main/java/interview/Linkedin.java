package interview;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataInputProvider;
import wrappers.GenericWrappers;


public class Linkedin extends GenericWrappers{
	

	
	@Test(dataProvider= "fetchData", dataProviderClass = DataInputProvider.class)
	
	public void JobApplication(String Username, String Password, String Company, String Location) throws InterruptedException {
		// TODO Auto-generated method stub
		
		invokeApp("chrome", "https://linkedin.com/");
		
	    clickByLink("Sign in");
		
		waitProperty(3000);
		
		enterById("username",Username);
		
		enterById("password",Password);
		
		clickByXpath("//*[@id=\"password-visibility-toggle\"]");
		
		clickByXpath("//*[@id=\"password-visibility-toggle\"]");
		
		clickByXpath("//*[@id=\"organic-div\"]/form/div[3]/button");
		
		waitProperty(2000);
		
		clickByXpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a");	
		
		waitProperty(1000);
		
		enterByXpath("//input[@class='jobs-search-box__text-input jobs-search-box__keyboard-text-input']",Company);
		
		waitProperty(2000);
		
		enterByXpath("//input[@class='jobs-search-box__text-input']",Location+Keys.ENTER);
		
		waitProperty(3000);
		
		clickByXpath("//span[text()='Easy Apply']");
		
		waitProperty(1000);
		
		clickByXpath("//span[text()='Next']");
		
		waitProperty(2000);
		
		clickByXpath("//span[text()='Review']");
		
		waitProperty(2000);
		
		clickByXpath("//button[@class='artdeco-modal__dismiss artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--2 artdeco-button--tertiary ember-view']");
		
		clickByXpath("//span[text()='Discard']");
		
		waitProperty(2000);
		
		clickByXpath("//button[@class='global-nav__primary-link global-nav__primary-link-me-menu-trigger artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view']");
		
		waitProperty(1000);
		
		closeBrowser();
		

	}

}
