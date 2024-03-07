package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	
	static Properties p;
	int i=0;
	
	@BeforeAll
	public static void setup() throws IOException {
		
		p = BaseClass.getProperties();
		driver = BaseClass.initilizeBrowser();
		driver.get(p.getProperty("baseUrl"));
		
		driver.manage().window().maximize();
		
	}
	
	 @AfterAll
	 public static void tearDown() {
	        		
	     driver.quit();
	       
	  }
	 
	
	 
	 @AfterStep
		public void addScreenshot(Scenario scenario) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(fileContent, "image/png", "screenshot");
	 }
	 
}
	


