package com.webapp.automation.src;

import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private static WebDriver driver = null;
	private static WebElement element = null;
	
	private static String pageTitle = "//*[@id='header']/h1";	
	private static String userName = "userId";
	private static String password = "userPassWord";
	private static String applicationDropdown = "//select/option[@value='HOME']";
	private static String locator = "//div[contains(text, '')]";
	
	private static String searchLocator = "//*[@id='query']";
	private static String submitLocator = "//button[@type='submit']";
	private static String sortLocator = "//select[@id='sort']/option[@value='lowestPrice']";
	private static String todaysDeal = "//li[@class='deals-nav deals-nav--daily']/a/span";
	private static String linkDetails = "//a/span[@class='hidden-tablet']"; 
//	private static String linkValue = "//ul[@class='arrow-nav']/li[1]/div/div[3]/ul/li[1]/a";
	private static String linkValue = "//*[@id='header-main']/section[1]/div/nav/ul/li[1]/div/div[3]/ul/li[1]/a";

	public static WebElement clickOnElement(String locator){
		
		int numOfAttemps =0;
		boolean isFound =false;
		do{
			numOfAttemps++;
			try{
				if (numOfAttemps == 10)
					break;
				
				if(driver.findElement(By.xpath(locator)).isDisplayed() && driver.findElement(By.xpath(locator)).isEnabled()==true){
					element = driver.findElement(By.xpath(locator));

					isFound=true;
					break;
				}
				Thread.sleep(1000);	
			}catch(Exception e){
				System.out.println("Element not found");
			}
		} while(!isFound || numOfAttemps<10);
		System.out.println("numofAttemps:"+numOfAttemps+":isFound:"+isFound);
		return element;
	}
	
	public static void launchPage(){
		
		System.setProperty("webdriver.gecko.driver","/Users/exilant/Downloads/geckodriver");

		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://exis.exilant.com/SSO/index.htm");
         
        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageTitle))));
        
        assertTrue(driver.getTitle().contains("EXIS HOME"));
        
        System.out.println("Page launched successfully");
        
        try{
        	Thread.sleep(5000);
        } catch(Exception e){
        	System.out.println(e.toString());
        }
        
//        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("loginPage"));
        
        driver.switchTo().frame("loginPage");
        System.out.println("Frame entered successfully");
//        driver.findElement(By.xpath("//*[@id='userId']")).sendKeys("Sowmya");
        
        driver.findElement(By.id("userId")).sendKeys("Sowmya");
        System.out.println("UserName entered successfully");
//        driver.close();
	}
	
	public static void launchChewy(){
		
		System.setProperty("webdriver.gecko.driver","/Users/exilant/Downloads/geckodriver");

		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.chewy.com");
         
        WebDriverWait wait= new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath())));
              
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        
//        System.out.println("Page launched successfully " + driver.getTitle().toString());        
        assertTrue(driver.getTitle().contains("Dog and Cat Food, Treats, and Supplies | Free Shipping at Chewy.com"));   
	}
	
	public static void searchItem(String searchText){
		element = clickOnElement(searchLocator);
		element.sendKeys(searchText);
		element = clickOnElement(submitLocator);
		element.submit();
	}
	
	public static void searchbyPrice(){
		element = clickOnElement(sortLocator);
		element.click();
	}
	
	public static void clickButton(String buttonName){
		element = clickOnElement(todaysDeal);
		element.click();
	}

	public static void clickOnLink() {
		Actions actions = new Actions(driver);
		element = clickOnElement(linkDetails);

		actions.moveToElement(element).click().build().perform();
		try{
		Thread.sleep(2000);
		} catch(Exception e){
		System.out.println(e.toString());
		}
		element = clickOnElement(linkValue);
		actions.moveToElement(element).click().build().perform();

		
//		try{
//			Thread.sleep(2000);
//			} catch(Exception e){
//			System.out.println(e.toString());
//			}
				
		}
}


