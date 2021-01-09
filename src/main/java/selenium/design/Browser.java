package selenium.design;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {
	
	/**
	 * This method will launch the Chrome browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @param url - This will load the specified url  
	 * @author Abdul Rahuman
	 * @return 
	 * @throws MalformedURLException 
	 */	
	public RemoteWebDriver startApp(String url);
	
	/**
	 * This method will launch the Any browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @param browser - This will load the specified browser
	 * @param url - This will load the specified url  
	 * @author Abdul Rahuman
	 * @return 
	 * @throws MalformedURLException 
	 */
	public RemoteWebDriver startApp(String browser, String url);
	/**
	 * This method will locate the element using any given locator
	 * @param locatorType  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Abdul Rahuman
	 * @throws NoSuchElementException
	 * @return The first matching element on the current context.
	 */
	public WebElement locateElement(String locatorType, String value);	
	
	/**
	 * This method will locate the element using id
	 * @param locValue - The locator value by which the element to be found
	 * @author Abdul Rahuman
	 * @throws NoSuchElementException
	 * @return The first matching element on the current context.
	 */
	public WebElement locateElement(String value);
	
	/**
	 * This method will locates all matching element using any given locator
	 * @param locatorType  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Abdul Rahuman
	 * @return A list of all WebElements, or an empty list if nothing matches.
	 */
	public List<WebElement> locateElements(String type, String value);	
	
	
	/**
	 * This method will close the active browser
	 * @author Abdul Rahuman
	 */
	public void close();
	
	/**
	 * This method will close all the browsers
	 * @author Abdul Rahuman
	 */
	public void quit();
	
	
	/**
	 * This method will scroll down till it finds the element
	 * @author Abdul Rahuman
	 */
	
	public void scrollTillTheElement(WebElement ele);
	

	
}
