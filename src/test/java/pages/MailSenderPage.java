package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailSenderPage {
    private final WebDriverWait webDriverWait;
    @FindBy(className = "aoO")
    private WebElement emailSubmit;
    @FindBy(className = "z0")
    private WebElement newEmailButton;
    @FindBy(name = "to")
    private WebElement recipientEmailField;
    @FindBy(name = "subjectbox")
    private WebElement subjectEmailField;
    @FindBy(className = "editable")
    private WebElement textEmailField;
    @FindBy(id = "link_vsm")
    private WebElement messageSentIndicator;

    public MailSenderPage(WebDriver webDriver,
                          WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public MailSenderPage newEmailForm() {
        newEmailButton.click();
        return this;
    }

    public MailSenderPage fillRecipientField(String recipient) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recipientEmailField))
                .sendKeys(recipient + Keys.ENTER);
        return this;
    }

    public MailSenderPage fillSubjectField(String subject) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectEmailField))
                .sendKeys(subject);
        return this;
    }

    public MailSenderPage fillTextField(String text) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(textEmailField))
                .sendKeys(text);
        return this;
    }

    public MailSenderPage sendEmail() {
        emailSubmit.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageSentIndicator));
        return this;
    }
}
