package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected ApplicationManager app;

    @BeforeEach
    public void setApplicationManager() {
        app = ApplicationManager.getInstance();
    }

    @AfterEach
    public void closeConnection(){
        app.stop();
    }
}
