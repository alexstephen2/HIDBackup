package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverFactory {
	
public WebDriver driver ;
	

public WebDriver getWebdriver() {
	System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe"); 
    WebDriver driver = new ChromeDriver();
    return driver;
}

}
