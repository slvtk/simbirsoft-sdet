package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver driver;

    public HelperBase(ApplicationManager applicationManager) {
        this.driver = applicationManager.getDriver();
    }
}
