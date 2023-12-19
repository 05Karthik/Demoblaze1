package Base;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Utilities.Utility;

public class Baseclass extends Utility{
	
	//Write code for starting and closing Browser
	
	@BeforeMethod
	public void startup() throws IOException {
		driver=initializeDriver();
	//send the url
		driver.get(prop.getProperty("url"));
	
		}
	
	@AfterMethod
	public void close() {
		driver.quit();
	
		}	
}
