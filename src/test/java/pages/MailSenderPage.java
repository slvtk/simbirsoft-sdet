package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailSenderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By submitLocator = By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");
    private final By newEmailLocator = By.xpath("//div[@class='T-I T-I-KE L3']");
    private final By recipientLocator = By.name("to");
    private final By subjectLocator = By.name("subjectbox");
    private final By textLocator = By.xpath("//div[@class='Am Al editable LW-avf tS-tW']");

    public MailSenderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MailSenderPage newEmailForm() throws InterruptedException {
        driver.findElement(newEmailLocator).click();
        Thread.sleep(2000);
        return this;
    }

    public MailSenderPage fillRecipientField(String recipient) {
        driver.findElement(recipientLocator).click();
        driver.findElement(recipientLocator).clear();
        driver.findElement(recipientLocator).sendKeys(recipient);
        driver.findElement(recipientLocator).sendKeys(Keys.ENTER);
        return this;
    }

    public MailSenderPage fillSubjectField(String subject) {
        wait.until(ExpectedConditions.elementToBeClickable(subjectLocator)).click();
        driver.findElement(subjectLocator).click();
        driver.findElement(subjectLocator).clear();
        driver.findElement(subjectLocator).sendKeys(subject);
        return this;
    }

    public MailSenderPage fillTextField(String text) {
        driver.findElement(textLocator).click();
        driver.findElement(textLocator).clear();
        driver.findElement(textLocator).sendKeys(text);
        return this;
    }

    public MailSenderPage sendEmail() throws InterruptedException {
        driver.findElement(submitLocator).click();
        Thread.sleep(2000);
        return this;
    }
}
