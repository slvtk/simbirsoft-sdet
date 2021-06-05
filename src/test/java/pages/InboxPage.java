package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    private final WebDriverWait webDriverWait;
    @FindBy(className = "gb_ef")
    private WebElement searchAreaField;
    @FindBy(xpath = "(//*[@class='D E G-atb PY']//*[@class='ts'])[3]")
    private WebElement matchingMessagesCounter;

    public InboxPage(WebDriver webDriver,
                     WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public InboxPage fillSearchField(String searchQuery) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchAreaField))
                .sendKeys(searchQuery + Keys.ENTER);
        return this;
    }

    public String getMatchingMessages() {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(matchingMessagesCounter))
                .getText();
    }
}
