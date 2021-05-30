package helpers;

import config.Configurations;
import manager.ApplicationManager;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void navigateToIndexPage() {
        driver.get(Configurations.INDEX_PAGE_URL);
    }
}
