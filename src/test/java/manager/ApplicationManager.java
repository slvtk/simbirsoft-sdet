package manager;

import config.Configurations;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InboxPage;
import pages.LoginPage;
import pages.MailSenderPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private static final ThreadLocal<ApplicationManager> appManager = new ThreadLocal<>();
    private WebDriver webDriver;
    private InboxPage inboxPage;
    private LoginPage loginPage;
    private MailSenderPage mailSenderPage;

    private ApplicationManager() {
        //Try with InputStreamReader for property file(with encoding)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/resources/config.properties"), StandardCharsets.UTF_8)) {
            //Initializing with properties from file
            Properties properties = new Properties();
            properties.load(reader);
            Configurations.init(properties);
            //WebDriver and WebDriverWait setUp
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(Configurations.BROWSER);
            desiredCapabilities.setPlatform(Platform.LINUX);
            //We can switch our browsers + in config.properties
            Capabilities capabilities = new ChromeOptions();
            capabilities.merge(desiredCapabilities);
            webDriver = new RemoteWebDriver(new URL(Configurations.HUB_URL), capabilities);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);

            inboxPage = new InboxPage(webDriver, webDriverWait);
            loginPage = new LoginPage(webDriver, webDriverWait);
            mailSenderPage = new MailSenderPage(webDriver, webDriverWait);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InboxPage getInboxPage() {
        return inboxPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public MailSenderPage getMailSenderPage() {
        return mailSenderPage;
    }

    public void stop() {
        webDriver.quit();
    }

    public static ApplicationManager getInstance() {
        if (appManager.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            appManager.set(newInstance);
        }
        return appManager.get();
    }
}
