package pages;

import config.Configurations;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;
    @FindBy(name = "identifier")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage open(){
        webDriver.get(Configurations.LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage fillUsernameField(String username) {
        emailField.sendKeys(username + Keys.ENTER);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        passwordField.sendKeys(password + Keys.ENTER);
        return this;
    }

}
