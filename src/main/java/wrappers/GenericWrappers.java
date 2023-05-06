package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
	
	RemoteWebDriver driver;
	
	int i=1;
	
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
			System.out.println("The browser " +browser+ " is launched with the given url " +url+ " successfully");
	}  
		
		  catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser " +browser+ " is not launched due to conflict in browser and webdriver version");
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			System.err.println("The browser " +browser+ " is not launched as the url does not contain http/https");
		} catch (WebDriverException e) {
			//TODO: handle exception
			System.err.println("The browser " +browser+ " is not launched due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
	try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The element with id " +idValue+ " is entered with data " +data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element id " +idValue+ " is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element id " +idValue+ " is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element id " +idValue+ " is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element id " +idValue+ " is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id " +idValue+ " is not entered with data " +data+ " in the application due to unknown error");
		} finally {
			takeSnap();
		}
	}
	
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
	try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The element with xpath " +xpathValue+ " is entered with data " +data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element xpath " +xpathValue+ " is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath " +xpathValue+ " is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath " +xpathValue+ " is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath " +xpathValue+ " is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath " +xpathValue+ " is not enetered with data " +data+ " in the application due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element link " +name+ " is clicked in the application");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element link " +name+ " is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element link " +name+ " is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element link " +name+ " cannot be clicked in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element link " +name+ " is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element link " +name+ " is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element link " +name+ " in the application is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
	}

		public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
	try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element xpath " +xpathVal+ " is clicked in the application");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element xpath " +xpathVal+ " is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element xpath " +xpathVal+ " is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element xpath " +xpathVal+ " cannot be clicked in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element xpath " +xpathVal+ " is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element xpath " +xpathVal+ " is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element xpath " +xpathVal+ " in the application is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
				
		try {
			File temp =	driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/snap"+i+".png");
			FileUtils.copyFile(temp, dest);
			System.out.println("The snapshot is taken successfully and stored in a file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Screenshot not taken due to unknown error");
		} catch (Throwable e) {
			// TODO: handle exception
			System.err.println("Screenshot not taken due to java error");
		}
		
		i++;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
	try {
			driver.close();
			System.out.println("Current browser is closed");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser is not closed due to the session not created error");
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			System.err.println("The browser is not closed due to invalid argument");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Could not close the current browser due to unknown error");
		} 
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
	try {
			driver.quit();
			System.out.println("All the tabs of the browser is closed");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser is not closed due to the session not created error");
		} catch (InvalidArgumentException e) {
			//TODO: handle exception
			System.err.println("The browser is not closed due to invalid argument");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Could not close the tabs of the browser due to unknown error");
		} 
	}

	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
			System.out.println("Sleep time is set for the browser");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Sleep time got interrupted");
		}
	}

	
}

	