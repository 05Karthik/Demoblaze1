package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static WebDriver driver;
	public Properties prop;
	
	//To develop a function to select browser
	public WebDriver initializeDriver() throws IOException {
		//use the property
		prop=new Properties();
		//path to property
		String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties";
		//create file input stream object
		FileInputStream fis=new FileInputStream(proppath);
		prop.load(fis); // we get data from data.properties
		
		//create a code for browser selection
		String choicebrowser="chrome";
		if(choicebrowser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(choicebrowser.equals("fiefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(choicebrowser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("Invalid Browser Selection");
			System.exit(1);
		}	
		//To Window maximize and delete cookies
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
		//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		return driver;
		
	}


	//Add fuctionality to take screenshot
		public String TakeScreenshot(String testname,WebDriver driver) throws IOException {
		File srcscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to get screenshot
		String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		//copy the file
		FileUtils.copyFile(srcscreenshot, new File(screenshotfilepath));		
		return screenshotfilepath;
		
		}	
		
	//Switch to window
		public static void SwitchWindow() {
			String parentwindow=driver.getWindowHandle();
			Set<String> windowhandles=driver.getWindowHandles();
			windowhandles.size();
	//through windows		
			for(String childwindow:windowhandles) {
				if(!childwindow.contentEquals(parentwindow)) {
					driver.switchTo().window(childwindow);
				}
			}
	
		}
		
	//Function to wait for an element to be Clickable
		public static WebElement waitforElementTobeClickable(By locator,int timeoutinseconds) {
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeoutinseconds));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
		
}		