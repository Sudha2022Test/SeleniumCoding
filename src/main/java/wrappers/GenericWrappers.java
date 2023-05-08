package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;

public class GenericWrappers extends Reporting implements Wrappers {
	
	public static RemoteWebDriver driver;
	
	public static Properties prop;
	
	public void loadObjects() {
		
		try {
			 prop = new Properties();
			 prop.load(new FileInputStream("./src/test/java/object.properties"));
			//System.out.println(prop.getProperty("CreateFBAccountPage.CreateAccount.XPath"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void unLoadObjects() {
		prop=null;
	}
	
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		
	try {
			if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println("The browser " +browser+ " is launched with the given url " +url+ " successfully");
			reportStep("The browser " +browser+ " is launched with the given url " +url+ " successfully", "Pass");
		}  
		  catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser " +browser+ " is not launched due to conflict in browser and webdriver version");
			reportStep("The browser " +browser+ " is not launched due to conflict in browser and webdriver version", "Fail");
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			//System.err.println("The browser " +browser+ " is not launched as the url does not contain http/https");
			reportStep("The browser " +browser+ " is not launched as the url does not contain http/https", "Fail");
		} catch (WebDriverException e) {
			//TODO: handle exception
			//System.err.println("The browser " +browser+ " is not launched due to unknown error");
			reportStep("The browser " +browser+ " is not launched due to unknown error", "Fail");
		} 
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
	try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element with id " +idValue+ " is entered with data " +data);
			reportStep("The element with id " +idValue+ " is entered with data " +data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element id " +idValue+ " is not found in the DOM");
			reportStep("The element id " +idValue+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +idValue+ " is not visible in the application");
			reportStep("The element id " +idValue+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +idValue+ " is not interactable in the application");
			reportStep("The element id " +idValue+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +idValue+ " is not stable in the application");
			reportStep("The element id " +idValue+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with id " +idValue+ " is not entered with data " +data+ " in the application due to unknown error");
			reportStep("The element with id " +idValue+ " is not entered with data " +data+ " in the application due to unknown error", "Fail");
		} 
	
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
	try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The element with name " +nameValue+ " is entered with data " +data);
			reportStep("The element with name " +nameValue+ " is entered with data " +data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element name " +nameValue+ " is not found in the DOM");
			reportStep("The element name " +nameValue+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element name " +nameValue+ " is not visible in the application");
			reportStep("The element name " +nameValue+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element name " +nameValue+ " is not interactable in the application");
			reportStep("The element name " +nameValue+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element name " +nameValue+ " is not stable in the application");
			reportStep("The element name " +nameValue+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with name " +nameValue+ " is not entered with data" +data+ "in the application due to unknown error");
			reportStep("The element with name " +nameValue+ " is not entered with data" +data+ "in the application due to unknown error", "Fail");
		} 
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
	try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The element with xpath " +xpathValue+ " is entered with data " +data);
			reportStep("The element with xpath " +xpathValue+ " is entered with data " +data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpathValue+ " is not found in the DOM");
			reportStep("The element xpath " +xpathValue+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with xpath " +xpathValue+ " is not visible in the application");
			reportStep("The element with xpath " +xpathValue+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath " +xpathValue+ " is not interactable in the application");
			reportStep("The element with xpath " +xpathValue+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with xpath " +xpathValue+ " is not stable in the application");
			reportStep("The element with xpath " +xpathValue+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with xpath " +xpathValue+ " is not enetered with data " +data+ " in the application due to unknown error");
			reportStep("The element with xpath " +xpathValue+ " is not entered with data " +data+ " in the application due to unknown error", "Fail");
		} 
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
	try {
			String actualText = driver.getTitle();
			if(actualText.equals(title)) {
				//System.out.println("The title of the page " +actualText+ " is equal with the expected title " +title);
				reportStep("The title of the page " +actualText+ " is equal with the expected title " +title, "Pass");
		} else {
			//System.err.println("The title of the page " +actualText+ " is not equal with the expected title " +title);
			reportStep("The title of the page " +actualText+ " is not equal with the expected title " +title, "Fail");
		}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The title of the page " +title+ " is not verified due to unknown error");
			reportStep("The title of the page " +title+ " is not verified due to unknown error", "Fail");
		} 
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
	
		try {
			String actualText = driver.findElementById(id).getText();
			if(actualText.equals(text)) {
				//System.out.println("The element id " +id+ " having the text " +actualText+ " is equal with the given text " +text);
				reportStep("The element id " +id+ " having the text " +actualText+ " is equal with the given text ", "Pass");
		} else {
			//System.err.println("The element id " +id+ " having the text " +actualText+ " is not equal with the given text " +text);
			reportStep("The element id " +id+ " having the text " +actualText+ " is not equal with the given text " +text, "Fail");
		}
		} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
			//System.err.println("The element id " +id+ " is not found in the DOM");
			reportStep("The element id " +id+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +id+ " is not visible in the application");
			reportStep("The element id " +id+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +id+ " is not interactable in the application");
			reportStep("The element id " +id+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +id+ " is not stable in the application");
			reportStep("The element id " +id+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with id " +id+ " could not be verified with the text " +text+ " in the application due to unknown error");
			reportStep("The element with id " +id+ " could not be verified with the text " +text+ " in the application due to unknown error", "Fail");
		} 
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
	try {
			String actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.equals(text)) {
				//System.out.println("The element xpath " +xpath+ " having the text " +actualText+ " is equal with the given text " +text);
				reportStep("The element xpath " +xpath+ " having the text " +actualText+ " is equal with the given text " +text, "Pass");
		} else {
				//System.err.println("The element xpath " +xpath+ " having the text " +actualText+ " is not equal with the given text " +text);
				reportStep("The element xpath " +xpath+ " having the text " +actualText+ " is not equal with the given text " +text, "Fail");
		}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpath+ " is not found in the DOM");
			reportStep("The element xpath " +xpath+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpath+ " is not visible in the application");
			reportStep("The element xpath " +xpath+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpath+ " is not interactable in the application");
			reportStep("The element xpath " +xpath+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpath+ " is not stable in the application");
			reportStep("The element xpath " +xpath+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with xpath " +xpath+ " could not be verified with the text " +text+ " in the application due to unknown error");
			reportStep("The element with xpath " +xpath+ " could not be verified with the text " +text+ " in the application due to unknown error", "Fail");
		} 
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	try {
			String actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.contains(text)) {
				//System.out.println("The element xpath " +xpath+ " having the text " +actualText+  " contains the given text " +text);
				reportStep("The element xpath " +xpath+ " having the text " +actualText+  " contains the given text " +text, "Pass");
		} else {
			//System.err.println("The element xpath " +xpath+ " having the text " +actualText+  " does not contain the given text " +text);
			reportStep("The element xpath " +xpath+ " having the text " +actualText+  " does not contain the given text " +text, "Fail");
		}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpath+  " is not found in the DOM");
			reportStep("The element xpath " +xpath+  " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpath+  " is not visible in the application");
			reportStep("The element xpath " +xpath+  " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpath+  " is not interactable in the application");
			reportStep("The element xpath " +xpath+  " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpath+  " is not stable in the application");
			reportStep("The element xpath " +xpath+  " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element with xpath " +xpath+  "could not be verified with the text " +text+  "in the application due to unknown error");
			reportStep("The element with xpath " +xpath+  "could not be verified with the text " +text+  "in the application due to unknown error", "Fail");
		} 
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementById(id).click();
			//System.out.println("The element id " +id+  " is clicked in the application");
			reportStep("The element id " +id+  " is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element id " +id+  " is not found in the DOM");
			reportStep("The element id " +id+  " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +id+  " is not visible in the application");
			reportStep("The element id " +id+  " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element id " +id+  " cannot be clicked in the application");
			reportStep("The element id " +id+  " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +id+  " is not interactable in the application");
			reportStep("The element id " +id+  " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +id+  " is not stable in the application");
			reportStep("The element id " +id+  " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element id " +id+  " in the application is not clicked due to unknown error");
			reportStep("The element id " +id+  " in the application is not clicked due to unknown error", "Fail");
		} 
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByClassName(classVal).click();
			//System.out.println("The element class name " +classVal+ " is clicked in the application");
			reportStep("The element class name " +classVal+ " is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element class name " +classVal+ " is not found in the DOM");
			reportStep("The element class name " +classVal+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element class name " +classVal+ " is not visible in the application");
			reportStep("The element class name " +classVal+ " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element class name " +classVal+ " cannot be clicked in the application");
			reportStep("The element class name " +classVal+ " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element class name " +classVal+ " is not interactable in the application");
			reportStep("The element class name " +classVal+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element class name " +classVal+ " is not stable in the application");
			reportStep("The element class name " +classVal+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element class name " +classVal+ " in the application is not clicked due to unknown error");
			reportStep("The element class name " +classVal+ " in the application is not clicked due to unknown error", "Fail");
		} 
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element name "+name+" is clicked in the application");
			reportStep("The element name "+name+" is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element name " +name+ " is not found in the DOM");
			reportStep("The element name " +name+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element name " +name+ " is not visible in the application");
			reportStep("The element name " +name+ " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element name " +name+ " cannot be clicked in the application");
			reportStep("The element name " +name+ " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element name " +name+ " is not interactable in the application");
			reportStep("The element name " +name+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element name " +name+ " is not stable in the application");
			reportStep("The element name " +name+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element name " +name+ " in the application is not clicked due to unknown error");
			reportStep("The element name " +name+ " in the application is not clicked due to unknown error", "Fail");
		} 
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element link " +name+ " is clicked in the application");
			reportStep("The element link " +name+ " is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element link " +name+ " is not found in the DOM");
			reportStep("The element link " +name+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element link " +name+ " is not visible in the application");
			reportStep("The element link " +name+ " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element link " +name+ " cannot be clicked in the application");
			reportStep("The element link " +name+ " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element link " +name+ " is not interactable in the application");
			reportStep("The element link " +name+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element link " +name+ " is not stable in the application");
			reportStep("The element link " +name+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element link " +name+ " in the application is not clicked due to unknown error");
			reportStep("The element link " +name+ " in the application is not clicked due to unknown error", "Fail");
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element link " +name+ " is clicked in the application");
			reportStep("The element link " +name+ " is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element link " +name+ " is not found in the DOM");
			reportStep("The element link " +name+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element link " +name+ " is not visible in the application");
			reportStep("The element link " +name+ " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element link " +name+ " cannot be clicked in the application");
			reportStep("The element link " +name+ " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element link " +name+ " is not interactable in the application");
			reportStep("The element link " +name+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element link " +name+ " is not stable in the application");
			reportStep("The element link " +name+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element link " +name+ " in the application is not clicked due to unknown error");
			reportStep("The element link " +name+ " in the application is not clicked due to unknown error", "Fail");
		} 
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element xpath " +xpathVal+ " is clicked in the application");
			reportStep("The element xpath " +xpathVal+ " is clicked in the application", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpathVal+ " is not found in the DOM");
			reportStep("The element xpath " +xpathVal+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not visible in the application");
			reportStep("The element xpath " +xpathVal+ " is not visible in the application", "Fail");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element xpath " +xpathVal+ " cannot be clicked in the application");
			reportStep("The element xpath " +xpathVal+ " cannot be clicked in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not interactable in the application");
			reportStep("The element xpath " +xpathVal+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not stable in the application");
			reportStep("The element xpath " +xpathVal+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element xpath " +xpathVal+ " in the application is not clicked due to unknown error");
			reportStep("The element xpath " +xpathVal+ " in the application is not clicked due to unknown error", "Fail");
		} 
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element xpath " +xpathVal+ " is clicked in the application");
			reportStep("The element xpath " +xpathVal+ " is clicked in the application", "Pass",false);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpathVal+ " is not found in the DOM");
			reportStep("The element xpath " +xpathVal+ " is not found in the DOM", "Fail",false);
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not visible in the application");
			reportStep("The element xpath " +xpathVal+ " is not visible in the application", "Fail",false);
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element xpath " +xpathVal+ " cannot be clicked in the application");
			reportStep("The element xpath " +xpathVal+ " cannot be clicked in the application", "Fail",false);
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not interactable in the application");
			reportStep("The element xpath " +xpathVal+ " is not interactable in the application", "Fail",false);
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not stable in the application");
			reportStep("The element xpath " +xpathVal+ " is not stable in the application", "Fail",false);
		} catch (WebDriverException e) {
			//System.err.println("The element xpath " +xpathVal+ " in the application is not clicked due to unknown error");
			reportStep("The element xpath " +xpathVal+ " in the application is not clicked due to unknown error", "Fail",false);
		} 
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String getText = null;
	try {
			getText = driver.findElementById(idVal).getText();
			//System.out.println("The element id " +idVal+ " has the mentioned text " +getText);
			reportStep("The element id " +idVal+ " has the mentioned text " +getText, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element id " +idVal+ " is not found in the DOM");
			reportStep("The element id " +idVal+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +idVal+ " is not visible in the application");
			reportStep("The element id " +idVal+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +idVal+ " is not interactable in the application");
			reportStep("The element id " +idVal+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +idVal+ " is not stable in the application");
			reportStep("The element id " +idVal+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element id " +idVal+ " is not found due to unknown error");
			reportStep("The element id " +idVal+ " is not found due to unknown error", "Fail");
		} 
		
		return getText;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String getText = null;
	try {
			getText = driver.findElementByXPath(xpathVal).getText();
			//System.out.println("The element xpath " +xpathVal+ " has the mentioned text " +getText);
			reportStep("The element xpath " +xpathVal+ " has the mentioned text " +getText, "Pass");
		}  catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpathVal+ " is not found in the DOM");
			reportStep("The element xpath " +xpathVal+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not visible in the application");
			reportStep("The element xpath " +xpathVal+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not interactable in the application");
			reportStep("The element xpath " +xpathVal+ " is not interactable in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not stable in the application");
			reportStep("The element xpath " +xpathVal+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not found due to unknown error");
			reportStep("The element xpath " +xpathVal+ " is not found due to unknown error", "Fail");
		} 
		return getText;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
	try {
			WebElement element = driver.findElementById(id);
			Select sc = new Select(element);
			sc.selectByVisibleText(value);
			//System.out.println("The element id " +id+ " has the following value " +value+ " selected in the dropdown");
			reportStep("The element id " +id+ " has the following value " +value+ " selected in the dropdown", "Pass");
		}  catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element id " +id+ " is not found in the DOM");
			reportStep("The element id " +id+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +id+ " is not visible in the application");
			reportStep("The element id " +id+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +id+ " is not interactable in the application");
			reportStep("The element id " +id+ " is not interactable in the application", "Fail");
		} catch (ElementNotSelectableException e) {
			//System.err.println("The element id " +id+ " cannot be selected in the application");
			reportStep("The element id " +id+ " cannot be selected in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +id+ " is not stable in the application");
			reportStep("The element id " +id+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element id " +id+ " is not found due to unknown error");
			reportStep("The element id " +id+ " is not found due to unknown error", "Fail");
		} 
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
	try {
			WebElement element = driver.findElementById(id);
			Select sc = new Select(element);
			sc.selectByIndex(value);
			//System.out.println("The element id " +id+ " has the following index value " +value+ " selected in the dropdown");
			reportStep("The element id " +id+ " has the following index value " +value+ " selected in the dropdown", "Pass");
		}  catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
			System.err.println("The element id " +id+ " is not found in the DOM");
			reportStep("Cannot switch to parent window due to unknown error", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element id " +id+ " is not visible in the application");
			reportStep("The element id " +id+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element id " +id+ " is not interactable in the application");
			reportStep("The element id " +id+ " is not interactable in the application", "Fail");
		} catch (ElementNotSelectableException e) {
			//System.err.println("The element id " +id+  " cannot be selected in the application");
			reportStep("The element id " +id+  " cannot be selected in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element id " +id+  " is not stable in the application");
			reportStep("The element id " +id+  " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element id " +id+ " is not found due to unknown error");
			reportStep("The element id " +id+ " is not found due to unknown error", "Fail");
		} 
}
	

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
	try {
		Set<String> allWinAfterClick =	driver.getWindowHandles();
		for(String eachID : allWinAfterClick) {
			driver.switchTo().window(eachID);
		break;
		}
			//System.out.println("Reference is currently pointed to ParentWindow");
			reportStep("Reference is currently pointed to ParentWindow", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("Cannot switch to parent Window as there is no such window");
			reportStep("Cannot switch to parent Window as there is no such window", "Fail");
		} catch (SessionNotCreatedException e) {
			//System.err.println("Cannot switch to parent window as the session is not created");
			reportStep("Cannot switch to parent window as the session is not created", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("Cannot switch to parent window due to unknown error");
			reportStep("Cannot switch to parent window due to unknown error", "Fail");
		} 
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
	try {
		Set<String> allWinAfterClick =	driver.getWindowHandles();
		for(String eachID : allWinAfterClick){
			driver.switchTo().window(eachID);
		}

			//System.out.println("Reference is currently pointed to Last window");
		    reportStep("Reference is currently pointed to Last window", "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("Cannot switch to last window as there is no such window");
			reportStep("Cannot switch to last window as there is no such window", "Fail");
		} catch (SessionNotCreatedException e) {
			//System.err.println("Cannot switch to last window as the session is not created");
			reportStep("Cannot switch to last window as the session is not created", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("Cannot switch to last window due to unknown error");
			reportStep("Cannot switch to last window due to unknown error", "Fail");
		} 
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
	try {
			driver.switchTo().alert().accept();
			//System.out.println("The alert is accepted");
			reportStep("The alert is accepted", "Pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("Alert is not present to accept");
			reportStep("Alert is not present to accept", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("Alert cannot be accepted due to unknown error");
			reportStep("Alert cannot be accepted due to unknown error", "Fail");
		} 
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
	try {
			driver.switchTo().alert().dismiss();
			//System.out.println("The alert is dismissed");
			reportStep("The alert is dismissed", "Pass");
		} catch (NoAlertPresentException e) {
		// TODO Auto-generated catch block
			//System.err.println("Alert is not present to dismiss");
			reportStep("Alert is not present to dismiss", "Fail");
		} catch (NoSuchFrameException e) {
			//System.err.println("No frames are there to dismiss the alert");
			reportStep("No frames are there to dismiss the alert", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("Alert cannot be dismissed due to unknown error");
			reportStep("Alert cannot be dismissed due to unknown error", "Fail");
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText = null;
	try {
			alertText = driver.switchTo().alert().getText();
			//System.out.println("The alert text is " +alertText);
			reportStep("The alert text is " +alertText, "Pass",false);
			
			} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
				//System.err.println("Alert is not present to get the text");
				reportStep("Alert is not present to get the text", "Fail",false);
			} catch (NoSuchFrameException e) {
				//System.err.println("No frames are there to get the alert text");
				reportStep("No frames are there to get the alert text", "Fail",false);
			} catch (WebDriverException e) {
				//System.err.println("Not able to get the alert text due to unknown error");
				reportStep("Not able to get the alert text due to unknown error", "Fail",false);
			} 
		return alertText;
		
	}

	public long takeSnap() {
		// TODO Auto-generated method stub
			
		long number = 0;
		
		try {
			
			number = (long) (Math.floor(Math.random()*100000000)+100000);
			
			File temp =	driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./reports/screenshots/"+number+".png");
			FileUtils.copyFile(temp, dest);
			//System.out.println("The snapshot is taken successfully and stored in a file");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.err.println("Screenshot not taken due to unknown error");
			reportStep("Screenshot not taken due to unknown error", "Fail", false);
		} catch (Throwable e) {
			// TODO: handle exception
			//System.err.println("Screenshot not taken due to java error");
			reportStep("Screenshot not taken due to java error", "Fail", false);
		}
		return number;
	
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
	try {
			driver.close();
			//System.out.println("Current browser is closed");
			reportStep("Current browser is closed", "Pass", false);
			
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser is not closed due to the session not created error");
			reportStep("The browser is not closed due to the session not created error", "Fail", false);
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			//System.err.println("The browser is not closed due to invalid argument");
			reportStep("The browser is not closed due to invalid argument", "Fail", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("Could not close the current browser due to unknown error");
			reportStep("Could not close the current browser due to unknown error", "Fail", false);
		} 
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
	try {
			driver.quit();
			//System.out.println("All the tabs of the browser is closed");
			reportStep("All the tabs of the browser is closed", "Pass", false);
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser is not closed due to the session not created error");
			reportStep("The browser is not closed due to the session not created error", "Fail", false);
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			//System.err.println("The browser is not closed due to invalid argument");
			reportStep("The browser is not closed due to invalid argument", "Fail", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("Could not close the tabs of the browser due to unknown error");
			reportStep("Could not close the tabs of the browser due to unknown error", "Fail", false);
		} 
	}

	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
			//System.out.println("Sleep time is set for the browser");
			reportStep("Sleep time is set for the browser", "Pass");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//System.err.println("Sleep time got interrupted");
			reportStep("Sleep time got interrupted", "Fail");
		}
	}

	public void selectVisibileTextXPath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element = driver.findElementByXPath(xpathVal);
			Select sc = new Select(element);
			sc.selectByVisibleText(value);
			//System.out.println("The element xpath " +xpathVal+ " has the following value " +value+ " selected in the dropdown");
			reportStep("The element xpath " +xpathVal+ " has the following value " +value+ " selected in the dropdown", "Pass");
		}  catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element xpath " +xpathVal+ " is not found in the DOM");
			reportStep("The element xpath " +xpathVal+ " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not visible in the application");
			reportStep("The element xpath " +xpathVal+ " is not visible in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not interactable in the application");
			reportStep("The element xpath " +xpathVal+ " is not interactable in the application", "Fail");
		} catch (ElementNotSelectableException e) {
			//System.err.println("The element xpath " +xpathVal+ " cannot be selected in the application");
			reportStep("The element xpath " +xpathVal+ " cannot be selected in the application", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not stable in the application");
			reportStep("The element xpath " +xpathVal+ " is not stable in the application", "Fail");
		} catch (WebDriverException e) {
			//System.err.println("The element xpath " +xpathVal+ " is not found due to unknown error");
			reportStep("The element xpath " +xpathVal+ " is not found due to unknown error", "Fail");
		} 
		
	}
		
		
	/*	public void selectValueById(String id, String value) {
			// TODO Auto-generated method stub
			try {
				WebElement element = driver.findElementByXPath(id);
				Select sc = new Select(element);
				sc.selectByValue(value);
				System.out.println("The element id " +id+ " has the following value " +value+ " selected in the dropdown");
			}  catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.err.println("The element id " +id+ " is not found in the DOM");
			} catch (ElementNotVisibleException e) {
				System.err.println("The element id " +id+ " is not visible in the application");
			} catch (ElementNotInteractableException e) {
				System.err.println("The element id " +id+ " is not interactable in the application");
			} catch (ElementNotSelectableException e) {
				System.err.println("The element id " +id+ " cannot be selected in the application");
			} catch (StaleElementReferenceException e) {
				System.err.println("The element id " +id+ " is not stable in the application");
			} catch (WebDriverException e) {
				System.err.println("The element id " +id+ " is not found due to unknown error");
			} finally {
				takeSnap();
			}
	
	}*/

		public void switchtoFrameByXpath(String xPathVal) {
			// TODO Auto-generated method stub
			
			try {
				WebElement myFrame = driver.findElementByXPath("//*[@id=\"iframeResult\"]");
				driver.switchTo().frame(myFrame);
				//System.out.println("Switched to frame "+myFrame);
				reportStep("Switched to frame "+myFrame, "Pass");
			} catch (NoSuchFrameException e) {
				// TODO Auto-generated catch block
				//System.err.println("There is no such frame");
				reportStep("There is no such frame", "Fail");
			} catch (WebDriverException e) {
				// TODO: handle exception
				//System.err.println("Frame is not available due to unknown error");
				reportStep("Frame is not available due to unknown error", "Fail");
			}
			}
			
		

		public void defaultContent() {
			// TODO Auto-generated method stub
			
			try {
				driver.switchTo().defaultContent();
				//System.out.println("Switched to default content");
				reportStep("Switched to default content", "Pass");
			} catch (NoSuchFrameException e) {
				// TODO Auto-generated catch block
				//System.err.println("There is no such frame");
				reportStep("There is no such frame", "Fail");
			} catch (WebDriverException e) {
				// TODO: handle exception
				//System.err.println("Frame is not available due to unknown error");
				reportStep("Frame is not available due to unknown error", "Fail");
			}
			
		}

		public void refresh() {
			// TODO Auto-generated method stub
			try {
				driver.navigate().refresh();
				//System.out.println("Page is refreshed");
				reportStep("Page is refreshed", "Pass");
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//System.err.println("Page cannot be refreshed due to unknown error");
				reportStep("Page cannot be refreshed due to unknown error", "Fail");
			}
			
		}


		public void switchtoFrameId(int index) {
			// TODO Auto-generated method stub
			try {
				driver.switchTo().frame(index);
				//System.out.println("Frame switching has happened");
				reportStep("Frame switching has happened", "Pass");
			} catch (NoSuchFrameException e) {
				// TODO Auto-generated catch block
				//System.err.println("Frame is not available to get switched");
				reportStep("Frame is not available to get switched", "Fail");
			} catch (WebDriverException e) {
				// TODO: handle exception
				//System.err.println("Frame cannot be switched due to unknown error");
				reportStep("Frame cannot be switched due to unknown error", "Fail");
			}
		}

		public void enterAlertText(String data) {
			// TODO Auto-generated method stub
			try {
				driver.switchTo().alert().sendKeys(data);
				//System.out.println("Data is entered in the alert");
				//reportStep("Data is entered in the alert", "Pass");
			} catch (NoAlertPresentException e) {
				// TODO Auto-generated catch block
				//System.err.println("Alert is not present to enter the value");
				//reportStep("Alert is not present to enter the value", "Fail");
			} catch (WebDriverException e) {
				// TODO: handle exception
				//System.err.println("Alert is not present due to unknown error");
				//reportStep("Alert is not present due to unknown error", "Fail");
			}
		}
		
		public void pageDown(){
		
			try {
				driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);
				//System.out.println("Page down");
				reportStep("Page down", "Pass");
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//System.err.println("Unable to page down due to unknown error");
				reportStep("Unable to page down due to unknown error", "Fail");
			}

		
		}

		
		public void mouseHoverByXPath(String xpathval) {
			// TODO Auto-generated method stub
			
			try {
				WebElement element = driver.findElementByXPath(xpathval);
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
				//System.out.println("Mouse hovering on the element "+xpathval);
				reportStep("Mouse hovering on the element "+xpathval, "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				//System.err.println("The element xpath " +xpathval+ " is not found in the DOM");
				reportStep("The element xpath " +xpathval+ " is not found in the DOM", "Fail");
			} catch (ElementNotVisibleException e) {
				//System.err.println("The element xpath " +xpathval+ " is not visible in the application");
				reportStep("The element xpath " +xpathval+ " is not visible in the application", "Fail");
			} catch (ElementNotInteractableException e) {
				//System.err.println("The element xpath " +xpathval+ " is not interactable in the application");
				reportStep("The element xpath " +xpathval+ " is not interactable in the application", "Fail");
			} catch (ElementNotSelectableException e) {
				//System.err.println("The element xpath " +xpathval+ " cannot be selected in the application");
				reportStep("The element xpath " +xpathval+ " cannot be selected in the application", "Fail");
			} catch (StaleElementReferenceException e) {
				//System.err.println("The element xpath " +xpathval+ " is not stable in the application");
				reportStep("The element xpath " +xpathval+ " is not stable in the application", "Fail");
			} catch (WebDriverException e) {
				//System.err.println("The element xpath " +xpathval+ " is not found due to unknown error");
				reportStep("The element xpath " +xpathval+ " is not found due to unknown error", "Fail");
			} 
			
			
		}
		public String replaceString(String xpath,String source,String dest) {
			String replaceXpath=null;
			
			try {
				
				if(xpath.contains(source)) {
					replaceXpath= xpath.replace(source, dest);
					reportStep("Xpath is" +replaceXpath+ " is replaced with " +dest, "Pass");
				}
     
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				//System.err.println("The element xpath " +xpathval+ " is not found in the DOM");
				reportStep("The element xpath " +replaceXpath+ " is not found in the DOM", "Fail");
			} catch (ElementNotVisibleException e) {
				//System.err.println("The element xpath " +xpathval+ " is not visible in the application");
				reportStep("The element xpath " +replaceXpath+ " is not visible in the application", "Fail");
			} catch (ElementNotInteractableException e) {
				//System.err.println("The element xpath " +xpathval+ " is not interactable in the application");
				reportStep("The element xpath " +replaceXpath+ " is not interactable in the application", "Fail");
			} catch (ElementNotSelectableException e) {
				//System.err.println("The element xpath " +xpathval+ " cannot be selected in the application");
				reportStep("The element xpath " +replaceXpath+ " cannot be selected in the application", "Fail");
			} catch (StaleElementReferenceException e) {
				//System.err.println("The element xpath " +xpathval+ " is not stable in the application");
				reportStep("The element xpath " +replaceXpath+ " is not stable in the application", "Fail");
			} catch (WebDriverException e) {
				//System.err.println("The element xpath " +xpathval+ " is not found due to unknown error");
				reportStep("The element xpath " +replaceXpath+ " is not found due to unknown error", "Fail");
			} 
			driver.findElementByXPath(replaceXpath).click();
		
		 return replaceXpath;

		}
	}

