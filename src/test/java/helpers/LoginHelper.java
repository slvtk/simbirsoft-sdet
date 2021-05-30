package helpers;

import config.Configurations;
import manager.ApplicationManager;
import pages.LoginPage;


public class LoginHelper extends HelperBase {

    private final LoginPage loginPage;

    public LoginHelper(ApplicationManager applicationManager,
                       LoginPage loginPage) {
        super(applicationManager);
        this.loginPage = loginPage;
    }

    public void login() {
        loginPage
                .fillUsernameField(Configurations.EMAIL)
                .fillPasswordField(Configurations.PASSWORD);
    }

}
