package selenium.design;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;




public interface Element {
	
	
	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @see locateElement method in Browser Class
	 * @author Abdul Rahuman
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele);
	
	
	/**
	 * This method will clear and type the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @author Abdul Rahuman
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public void clearAndType(WebElement ele,String data);
	
	
	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown
	 * @see locateElement method in Browser Class 
	 * @author Abdul Rahuman
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingText(WebElement ele, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown
	 * @see locateElement method in Browser Class
	 * @author Abdul Rahuman
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value - The value to be selected (value) from the dropdown 
	 * @see locateElement method in Browser Class
	 * @author Abdul Rahuman
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Abdul Rahuman
	 * @see locateElement method in Browser Class
	 * @return true if the given object represents a String equivalent to this string, false otherwise
	 */
	
	public void addSnapToWord(String stepDef, String imageFile);
	
	
	public void moveToElementAndClick(WebElement moveToElement,WebElement eleTobeClicked);
}




