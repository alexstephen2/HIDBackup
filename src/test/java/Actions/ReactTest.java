package Actions;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utils.WebdriverFactory;
import cucumber.api.java.After;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;

public class ReactTest extends WebdriverFactory{

	Response Response;
	WebdriverFactory dr = new WebdriverFactory();
	
	String MainConlink;
	
	String T1;
	
	//public JavascriptExecutor js = (JavascriptExecutor) driver;
	
    @SuppressWarnings("deprecation")
	public void driverinit() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
       
		try {
			
			driver = dr.getWebdriver();
			
	        driver.get("https://reactjs.org/");
	        
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
	        driver.manage().window().maximize();
	        	              
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
    }
    
    public void docstab() {
    	
        //Locating element by link text and store in variable DocTab    
    	try {
    		
			Thread.sleep(1000);
 	       	WebElement DocsTab = driver.findElement(By.xpath("//a[text()='Docs']"));
 	        DocsTab.click();
	       

		} catch (InterruptedException e ){
		e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
    }
    
 public void MainConcepts() {
    	
        //Locating element by link text and store in variable DocTab    
    	try {
    		
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		
    		FileWriter fl = new FileWriter("src/test/resources/MainCOncepts.txt");
	        

 	        driver.findElement(By.xpath("//div[normalize-space()='Main Concepts']")).click();
 	        
 	        List<WebElement> Mainconceplinks = driver.findElements(By.xpath("//ul[@class='css-ts0qly']/child::li"));
 	        
 	       int LinkCOunt = Mainconceplinks.size();
 	       
 	      System.out.println("Count :"+LinkCOunt);
 	       
 	       for(int i=0;i<=LinkCOunt-1;i++) {
 	    	   
 	    		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Mainconceplinks.get(i)); 
 	    		
 	    		 MainConlink = Mainconceplinks.get(i).getText();
 	    		 
 	   		 fl.write(MainConlink+"\n");
 	    		
 	    	System.out.println(MainConlink);
 	       }
 	       
 	      fl.close();
 	 
 	    
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();}
	
    }
 

public void AdvanceLinks() {
 	
     //Locating element by link text and store in variable DocTab    
 	try {
 		
 		FileWriter fl = new FileWriter("src/test/resources/AdvancedGuides.txt");
	        
 		JavascriptExecutor js = (JavascriptExecutor) driver;
 		
	        driver.findElement(By.xpath("//div[normalize-space()='Advanced Guides']")).click();
	        
	        List<WebElement> Adguides = driver.findElements(By.xpath("//ul[@class='css-ts0qly']/child::li"));
	        
	       int LinkCOunt = Adguides.size();
	       
	      System.out.println("Count :"+LinkCOunt);
	       
	       for(int i=0;i<=LinkCOunt-1;i++) {
	    	   
	    		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Adguides.get(i)); 
	    		
	    		 MainConlink = Adguides.get(i).getText();
	    		 
	   		 fl.write(MainConlink+"\n");
	    		
	    	System.out.println(MainConlink);
	       }
	       
	      fl.close();
	 	    
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();}
	
 }

public void tutorials() {
	
    //Locating element by link text and store in variable Tutorials    
	try {
		
			Thread.sleep(1000);
	       	WebElement Tutorialtab = driver.findElement(By.xpath("//a[@class='css-hobwqm'][normalize-space()='Tutorial']"));
	       	Tutorialtab.click();
  

	} catch (InterruptedException e ){
	e.printStackTrace();
	} catch (NoSuchElementException e) {
		e.printStackTrace();
	} 
}

public void scrolltoTutor(String Texpected) {
	
	try {
		T1 = Texpected.toLowerCase();
		String T2 = T1.replace(" ", "-");
		
		String xpathval = "//h3[@id='"+T2+"']"+"|//h2[@id='"+T2+"']"; 
		
		//System.out.println(xpathval);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(100);
			
			WebElement TutorTopic = driver.findElement(By.xpath(xpathval));
		      
		      js.executeScript("arguments[0].scrollIntoView(true);", TutorTopic);
  
	} catch (InterruptedException e ){
	e.printStackTrace();
	} catch (NoSuchElementException e) {
		e.printStackTrace();
	} 
}

public void ScrollVerify() {
	
    //Locating element by link text and store in variable Tutorials    
	try {
		int cnt;
		String fontwght;
		String Tactual = null;
		
			Thread.sleep(1000);
	       	List<WebElement> IndexList = driver.findElements(By.xpath("//nav[@class='css-7stz2q css-1aai96l']//child::a"));
	       	
	       	cnt = IndexList.size();
	       	System.out.println("Size" + cnt);
	       	
		       for(int i=0;i<=cnt-1;i++) {
		    	   
		    	   fontwght = IndexList.get(i).getCssValue("font-weight");
		    		 
		   		 if(fontwght.equals("bold") || fontwght.equals("700")) {
		   			Tactual = IndexList.get(i).getText().toLowerCase();
		   			System.out.println("Expected Scrolled Page Text : "+T1);
		   			System.out.println("Actual Right Navigation BOLD Text: "+Tactual);
		   			Assert.assertTrue("The SCrolled TOpic and Right Navigation BOLD highlight is matching.", Tactual.contains(T1));	
			   		
		   			break;
		   		 }
		   	
		       }

	} catch (InterruptedException e ){
	e.printStackTrace();
	} catch (NoSuchElementException e) {
		e.printStackTrace();
	} 
}

public void APIGet() {
	
	try {
		//FileWriter fw = new FileWriter("src/test/resources/APiResponse.txt");
		
		Response = RestAssured.given().auth().none().when().get("https://coinmap.org/api/v1/venues/");
		String ResString = Response.asString();
		//fw.write(ResString);
		//System.out.println(Response.prettyPrint());
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}

	
}

public void APIVerify() {
	int Statuscd = Response.statusCode();
	
	Assert.assertTrue("Status Code Verification ", Statuscd == 200);
	
	System.out.println("Status Code : " + Statuscd);
	
}

public void APICategoryCnt() {
	
	JsonPath jsonpatheval = Response.jsonPath();
	
	List<String> allCat = jsonpatheval.getList("venues.category");
	
//	for(String Categoryval : allCat)
//	{
//		System.out.println("Category : " + Categoryval);
//	}
//	
	System.out.println("Count of ATM Category : " + Collections.frequency(allCat, "atm"));
	System.out.println("Count of Cafe Category : " + Collections.frequency(allCat, "cafe"));
	System.out.println("Count of Shopping Category : " + Collections.frequency(allCat, "shopping"));
	System.out.println("Count of Food Category : " + Collections.frequency(allCat, "food"));
	System.out.println("Count of Lodging Category : " + Collections.frequency(allCat, "lodging"));
	System.out.println("Count of Attraction Category : " + Collections.frequency(allCat, "attraction"));
	System.out.println("Count of Default Category : " + Collections.frequency(allCat, "default"));
	
}

public void APIFoodCategory() {
	
	JsonPath jsonpatheval = Response.jsonPath();
	
	//String allCat = jsonpatheval.get("venues[?(@.category=='food')].name").toString();
	
	String allcatsucces = jsonpatheval.get("venues.findAll { it.category == 'food' }.name").toString();
	
	String geo = jsonpatheval.get("venues.findAll { it.category == 'food' }.geolocation_degrees").toString();
	
//	for(String Categoryval : allcatsucces)
//	{
		System.out.println("Name : "+allcatsucces);
		
		System.out.println("Geo Location : "+geo);
//		}
		
//	}

}

 @After
 public void closedriver() {
 	
 	driver.close();
 	driver.quit();
 	
 }
 
}
