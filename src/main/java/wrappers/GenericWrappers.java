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

	
	

