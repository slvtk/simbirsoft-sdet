package pages;

import config.Configurations;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    @FindBy(name = "identifier")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;

    public LoginPage(WebDriver webDriver,
                     WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage open() {
        webDriver.get(Configurations.LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage fillUsernameField(String username) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailField))
                .sendKeys(username + Keys.ENTER);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordField))
                .sendKeys(password + Keys.ENTER);
        return this;
    }
}
