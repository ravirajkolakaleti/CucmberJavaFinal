package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchField;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        searchField.sendKeys(query);
        
    }
    
    public void searchSubmit() {
    	searchField.submit();
    }
}
