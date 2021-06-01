package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected ApplicationManager appManager;

    @BeforeEach
    public void setApplicationManager() {
        appManager = ApplicationManager.getInstance();
    }

    @AfterEach
    public void closeConnection(){
        appManager.stop();
    }

}
