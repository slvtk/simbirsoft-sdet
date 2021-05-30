package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By searchLocator = By.className("gb_ef");
    private final By searchSubmitLocator = By.cssSelector("button.gb_nf.gb_of > svg");
    private final By matchingMessagesLocator = By.className("ts");

    public InboxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public InboxPage fillSearchField(String searchQuery) {
        driver.findElement(searchLocator).sendKeys(searchQuery);
        wait.until(ExpectedConditions.elementToBeClickable(searchSubmitLocator)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getMatchingMessages() {
        return driver.findElements(matchingMessagesLocator).get(5).getText();
    }
}
