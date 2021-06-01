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
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement emailSubmit;
    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement newEmailButton;
    @FindBy(name = "to")
    private WebElement recipientEmailField;
    @FindBy(name = "subjectbox")
    private WebElement subjectEmailField;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
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
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recipientEmailField)).click();
        recipientEmailField.sendKeys(recipient + Keys.ENTER);
        return this;
    }

    public MailSenderPage fillSubjectField(String subject) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectEmailField)).click();
        subjectEmailField.sendKeys(subject);
        return this;
    }

    public MailSenderPage fillTextField(String text) {
        textEmailField.click();
        textEmailField.clear();
        textEmailField.sendKeys(text);
        return this;
    }

    public MailSenderPage submitEmail() {
        emailSubmit.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageSentIndicator));
        return this;
    }

    public MailSenderPage sendEmail(String recipient,
                                    String subject,
                                    String text) {
        return fillRecipientField(recipient)
                .fillSubjectField(subject)
                .fillTextField(text)
                .submitEmail();
    }
}
