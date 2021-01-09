package selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import selenium.design.Browser;
import selenium.design.Element;

import java.io.*;
import org.openqa.selenium.*;

import utils.Reporter;

public class SeleniumBase extends Reporter implements Browser, Element{

	public static RemoteWebDriver driver;
	public WebDriverWait wait;
	public String DOWNLOAD_FOLDER_PATH="./downloads";
	public String propertyFile="./properties/data.properties";
	public SoftAssert softAssert = new SoftAssert();

	int i=1;
	
	
	
	public void typeAndEnter(WebElement ele,String value)
	{
		
		try {
			wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();
			ele.sendKeys(value);
			ele.sendKeys(Keys.ENTER);
			reportStep("The Data "+value+"Has enterred Successfully", "pass"); 
			softAssert.assertTrue(true, "Success");
		} 
		catch (Exception e) {
			reportStep("The Element "+ele+"is not interactable", "fail");
			throw new RuntimeException();
		} 
	}
	
	
	@Override
	public void click(WebElement ele) {
		String text="";
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" clicked", "pass"); 
			addSnapToWord("The Element "+text+" is clicked", takeScreenShot());
			softAssert.assertTrue(true, "Success");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+text+" could not be clicked", "fail");
			throw new RuntimeException();
		} 
	}
	


	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);			
			addSnapToWord("The input "+data+" has been entered sucessfully", takeScreenShot());
			reportStep("The Data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}

	}


	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		
	   
		new Select(ele)
		.selectByVisibleText(value);
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		
		new Select(ele)
		.selectByIndex(index);
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		
		new Select(ele)
		.selectByValue(value);
	}



	@Override
	public RemoteWebDriver startApp(String url) {
		 startApp("chrome", url);
		 return null;
		
	}

	@Override
	public RemoteWebDriver startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver.exe");
				String path=System.getProperty("user.dir")+"\\downloads";
				ChromeOptions options = new ChromeOptions();
				HashMap<String,Object> chromePrefs = new HashMap<>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory",path);	
				chromePrefs.put("plugins.always_open_pdf_externally", true);
				options.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(options);
                driver.get(url);
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
		
//			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			reportStep("The Browser Could not be Launched. Hence Failed", "fail");
			throw new RuntimeException();
		} 
		
		return null;

	}

	@Override
	public WebElement locateElement(String locatorType, String value) {
		
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return driver.findElementById(value);
			case "name": return driver.findElementByName(value);
			case "class": return driver.findElementByClassName(value);
			case "link": return driver.findElementByLinkText(value);
			case "xpath": return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
			throw new RuntimeException();
		}catch (Exception e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String value) {
		WebElement findElementById = driver.findElementById(value);
		return findElementById;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {
		try {
			switch(type.toLowerCase()) {
			case "id": return driver.findElementsById(value);
			case "name": return driver.findElementsByName(value);
			case "class": return driver.findElementsByClassName(value);
			case "link": return driver.findElementsByLinkText(value);
			case "xpath": return driver.findElementsByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:"+type+" Not Found with value: "+value);
			throw new RuntimeException();
		}
		return null;
	}


	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		String filePath="./reports/images/"+number+".jpg";
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	
	}
	
	
	public String takeScreenShot() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		String filePath="./reports/images/"+number+".jpg";
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile , new File(filePath));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return filePath;
		
	}
	
	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}
	
	
	public void addSnapToWord(String stepDef, String imageFile) {

		// # logic to be incorporated: If the file already exist, open the file
		// and append the images, if not, create the file and add the first pic
		XWPFDocument doc = null;
		// Below program is to display the System date and Time
		//String timeStamp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		File f = new File("./reports/AutomationScreenshots/" + testCaseName + ".docx");

		FileInputStream input = null;

		// Check for File Existence. If the file exist then Open the document
		// and append the pic
		try {
			if (f.exists()) {
				doc = new XWPFDocument(new FileInputStream(f));
				// To add a new Paragraph to the document
			} else {
				// Create a new DOcument and add the picture to it
				System.out.println("File is created");
				doc = new XWPFDocument();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XWPFParagraph title = doc.createParagraph();

		// To specify particular setting for the new Paragraph like font style,
		// colour, alignment
		XWPFRun run = title.createRun();
		//run.setText("Time in DD-MM-YYYY hh:mm:ss format: " + timeStamp + "\n");
		run.addBreak();
		run.setText(stepDef);

		run.setBold(true);
		title.setAlignment(ParagraphAlignment.CENTER);

		// Read the input picture from the file
		try {
			input = new FileInputStream(imageFile);

			// Add the picture to the paragraph
			run.addPicture(input, XWPFDocument.PICTURE_TYPE_JPEG, imageFile, Units.toEMU(480), Units.toEMU(280)); // width*height

			input.close();

			// Write the content to the file
			FileOutputStream fos = new FileOutputStream(
					"./reports/AutomationScreenshots/" + testCaseName + ".docx");
			doc.write(fos);
			doc.close();
			fos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


		

	@Override
	public void moveToElementAndClick(WebElement moveToElement,WebElement eleTobeClicked) {
		// TODO Auto-generated method stub
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(moveToElement));
		Actions action =new Actions(driver);
		action.moveToElement(moveToElement).build().perform();
		click(eleTobeClicked);
		
	}
	
	@Override
	public void scrollTillTheElement(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("Element not found", "fail");
		}

}
	
	public void ScrolDown(int x, int y) {
		// TODO Auto-generated method stub
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String script="window.scrollBy("+x+","+y+")";
			js.executeScript(script, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("Some internal error occured", "fail");
		}
	}
	
}
