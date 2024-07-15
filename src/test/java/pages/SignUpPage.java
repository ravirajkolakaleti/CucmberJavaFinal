package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;

    @FindBy(id = "sign-username")
    WebElement usernameField;

    @FindBy(id = "sign-password")
    WebElement passwordField;

    @FindBy(css = "button[onclick='register()']")
    WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
