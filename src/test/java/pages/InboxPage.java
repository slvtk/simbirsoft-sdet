package pages;

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
    @FindBy(css = "button.gb_nf.gb_of > svg")
    private WebElement searchAreaSubmit;
    @FindBy(xpath = "//div[@class='D E G-atb PY']/div[2]/div[2]/div/span/div[1]/span/span[2]")
    private WebElement matchingMessagesCounter;

    public InboxPage(WebDriver webDriver,
                     WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public InboxPage fillSearchField(String searchQuery) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchAreaField)).click();
        searchAreaField.sendKeys(searchQuery);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchAreaSubmit)).click();
        return this;
    }

    public String getMatchingMessages() {
        return matchingMessagesCounter.getText();
    }
}
