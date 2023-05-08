package wrappers;


public interface Wrappers {
	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception 
	 * 
	 */
	public void invokeApp(String browser, String url);

	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param xpathValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 */
	
	public void enterByXpath(String xpathValue, String data);


	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 */
	
	public void clickByXpath(String xpathVal);
		
	/**
	 * This method will close the active browser
	 */
	public void closeBrowser();
	
	
	/**
	 * This method will close all the browsers
	 */
	public void closeAllBrowsers();
	
	/**
	 * This method will wait for the page to load
	 */
	public void waitProperty(long time);
	
	
 

}
