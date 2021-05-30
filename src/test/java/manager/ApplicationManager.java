package manager;

import config.Configurations;
import helpers.InboxHelper;
import helpers.LoginHelper;
import helpers.MailSenderHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InboxPage;
import pages.LoginPage;
import pages.MailSenderPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final InboxHelper inboxHelper;
    private final MailSenderHelper mailSenderHelper;
    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private ApplicationManager() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(Configurations.BROWSER);
        capabilities.setPlatform(Platform.WINDOWS);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL(Configurations.HUB_URL), chromeOptions);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
            driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
            driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

            wait = new WebDriverWait(driver, 10);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginHelper = new LoginHelper(this, new LoginPage(driver));
        inboxHelper = new InboxHelper(this, new InboxPage(driver, wait));
        mailSenderHelper = new MailSenderHelper(this, new MailSenderPage(driver, wait));
        navigationHelper = new NavigationHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public InboxHelper getInboxHelper() {
        return inboxHelper;
    }

    public MailSenderHelper getMailSenderHelper() {
        return mailSenderHelper;
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }
}
