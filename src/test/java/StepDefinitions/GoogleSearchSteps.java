package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleHomePage;
import pages.LoginPage;
import pages.SignUpPage;


public class GoogleSearchSteps {
	

	WebDriver driver;
	GoogleHomePage googleHomePage;
	LoginPage loginPage;
	SignUpPage signUpPage; 
	
	@Given("browser is open and go to {string}")
	public void browser_is_open_and_go_to(String url) {
	    
System.out.println("Starting - browser is open");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/kolak/eclipse-workspace/CucmberJavaFinal/src/test/resources/drivers/chromedriver-win64_v126.0.6478.61.exe");
		driver = new ChromeDriver();
		
		driver.navigate().to(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
	
		
		System.out.println("Ending - browser is open");
	}


	@And("user is on google search page")
	public void user_is_on_google_search_page() throws InterruptedException {
		
		googleHomePage = new GoogleHomePage(driver);
		
		System.out.println(driver.getTitle());
//		driver.navigate().to("https://google.com");
		
		Thread.sleep(3000);
		
	}

@When ("^user enter text in the google search text box$")
	
	public void user_enter_text_in_the_google_search__text_box (){
		
		driver.findElement(By.name("q")).sendKeys("demoblaze.com");
		
	}
	
	

	@And("hits Enter")
	public void hits_enter() throws InterruptedException {
		
		googleHomePage.searchSubmit();
		
				
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
	}

	@Then("Search Results page displays")
	public void search_results_page_displays() throws InterruptedException {
		
		boolean str = driver.getPageSource().contains("Demo Blaze");
		
		System.out.println("The Demo Blaze website exists  - " +str);
		
		
	}
	
	
	@And("quit browser")
	public void quit_browser() {
		
		driver.quit();
		
	}
	
	

	@Then("click on the Demoblaze link in the search results")
	public void click_on_the_demoblaze_link_in_the_search_results() throws InterruptedException {
		
		driver.findElement(By.tagName("h3")).click();
		
		Thread.sleep(02000);
	    
	}

	@Then("I should be navigated to {string}")
	public void i_should_be_navigated_to(String string) {
		
		String expectedUrl = ("https://www.demoblaze.com/");
		
		
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	    
	}

	@When("I click on Sign Up link")
	public void i_click_on_sign_up_link() {
		
		driver.findElement(By.id("signin2")).click();
	    
	}

	@When("^I sign up with (.*) and (.*)$")
	public void i_sign_up_with_username_and_password(String username, String password) throws InterruptedException {
		
		signUpPage = new SignUpPage(driver);
		
		signUpPage.enterUsername(username);
		signUpPage.enterPassword(password);
		
		Thread.sleep(3000);
		
		signUpPage.clickSignUpButton();
		
	
		Thread.sleep(3000);
	    
	}

	@Then("I should be signed up successfully")
	public void i_should_be_signed_up_successfully() {
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
	   
	}

	@When("I click on Login link")
	public void I_click_on_Login_link() {
		
		driver.findElement(By.id("login2")).click();
		
}
	@And("^I login with (.*) and (.*)$")
	
	public void i_login_with_username_and_password(String loginusername, String loginpassword) throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		
		loginPage.enterLoginUsername(loginusername);
		loginPage.enterLoginPassword(loginpassword);
		
		Thread.sleep(3000);
		
		loginPage.clickLoginButton();
		
	//	driver.findElement(By.id("loginusername")).sendKeys(username);
		
	//	driver.findElement(By.id("loginpassword")).sendKeys(password);
		
	//	driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
		
		
	}
	
	@Then("I should be logged in successfully")
	
	public void I_should_be_logged_in_successfully() {
		
		System.out.println("User successfully login into the demoblaze website");
	}
	
}


