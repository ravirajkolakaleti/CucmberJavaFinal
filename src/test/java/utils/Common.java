package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Common {
	
	private WebDriver driver;

	public void setupBrowser ( String browser, String url) {
		// Opening the browser
		if (browser.equalsIgnoreCase("Chrome"))
		    driver = new ChromeDriver ();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else {
			System.out.println ("valid browser is not provided, hence quitting the automation");
			System.exit(0);
		}
		
		openUrl (url);
		
	}
		
		// Opening the URL
	
	public void openUrl(String url) {
		if (url!="")
			driver.get(url);
		else
			driver.get ("about:blank");
		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeTab () {
		driver.close();
	}
	
	public void quitBrowser () {
		driver.quit();
	}
}
