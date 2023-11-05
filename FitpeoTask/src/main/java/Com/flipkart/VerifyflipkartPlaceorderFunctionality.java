package Com.flipkart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyflipkartPlaceorderFunctionality {

	
	@Test
	public void placeOrder() throws InterruptedException {
		
		
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
//		  options.addArguments("--incognito");
	      WebDriver driver=new ChromeDriver(options);
	      System.out.println("Browser Launched");
	      
	      JavascriptExecutor jse=(JavascriptExecutor)driver;//Click action
	      Actions act=new Actions(driver);
	      WebDriverWait wait=new WebDriverWait(driver,30);
	      
	      //Browser Maximize 
	        driver.manage().window().maximize();
	        System.out.println("Browser Maximized");
	        
	        //URL opening    
	    	driver.get("https://www.flipkart.com/");  
		
	    	//Close Pop-Up
	    	WebElement loginPopup=driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
	    	  jse.executeScript("arguments[0].click();", loginPopup);
	    	  System.out.println("Close Login Pop-Up");
	    	  
	    	//Search Box
	    	  WebElement SearchBox=driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
	    	  jse.executeScript("arguments[0].click();", SearchBox);
	    	  SearchBox.sendKeys("iPhone");
	    	  System.out.println("Entered ipad in Search Box");
	    	  
	    	//click on Search Button
	    	  WebElement SearchButton=driver.findElement(By.xpath("//button[@type='submit']"));
	    	  jse.executeScript("arguments[0].click();", SearchButton);  
	    	  System.out.println("Clicked On Search Button");
	    	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    	  
	    	  //Price High to Low filter 
	    	  WebElement newestfirst=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]"));
	    	  wait.until(ExpectedConditions.visibilityOf(newestfirst));
	    	  jse.executeScript("arguments[0].click();", newestfirst); 
	    	  System.out.println("Selected Newest first filter option");
	    	  Thread.sleep(6000);
	    	  //Select one of the item
	   	  WebElement ipad=driver.findElement(By.xpath("(//img[@class='_396cs4'])[2]"));
	    	  jse.executeScript("arguments[0].click();", ipad);  
	    	  System.out.println("Selected an ipad"); 
	    	  
	    	  
	    	//Window handle
	    	 Set<String> handles=driver.getWindowHandles();
	    	Iterator it =handles.iterator(); 
	    	    String parentid=(String) it.next();
	    	    String childid=(String) it.next();

	    	    driver.switchTo().window(childid);
	    	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    	    
	    	    
	    	// Add To Cart
	    	    WebElement addToCart=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	    	    act.click(addToCart).build().perform();
	    	    System.out.println("Click on Add To Cart Button");
	    	    
	    	//Click on Place Order
	    	 WebElement PlaceOrder=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']"));
	    	   wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
	    	    act.click(PlaceOrder).build().perform();
	    	    System.out.println("Click on Place Order Button");   
	    	    
	    	    
	       //Email 
	    	    WebElement Email=driver.findElement(By.xpath("//input[@type='text']"));	 
	    	    wait.until(ExpectedConditions.visibilityOf(Email));
	    	    Email.sendKeys("bhushanp0711@gmail.com ");  
	    	    System.out.println("Entered Eamil id"); 
	    	    
	    	    
	    //Continue Button
	    	    WebElement Continue=driver.findElement(By.xpath("//button[@type='submit']"));
		    	   wait.until(ExpectedConditions.elementToBeClickable(Continue));
		    	    act.click(Continue).build().perform();
		    	    System.out.println("Click on Continue Button"); 
		    	    
		    	    
		    	    Thread.sleep(5000);   
		    	    
		  //Mobile 
		    	    WebElement MobileNumber=driver.findElement(By.xpath("//input[@type='text']"));	 
		    	    wait.until(ExpectedConditions.visibilityOf(MobileNumber));
		    	    jse.executeScript("arguments[0].click();", MobileNumber);
		    	    act.sendKeys(MobileNumber, "8530047964") ;
		    	    System.out.println("Entered Mobile Number"); 	    
		    	    Thread.sleep(5000);
		    	    
		    //Bhushan	    
		    	    
		    	    
	    	//Close 
		    driver.quit();	    
	    	    
	    	    
	    	    
	    	    
	    	    
	    	    
	    	 
	    	 
	    	  
	    	  
	
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	
		
	}
	
	
}
