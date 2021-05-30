package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By emailLocator = By.name("identifier");
    private final By passwordLocator = By.name("password");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage fillUsernameField(String username) {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(username);
        driver.findElement(emailLocator).sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(passwordLocator).sendKeys(Keys.ENTER);
        return this;
    }
}
