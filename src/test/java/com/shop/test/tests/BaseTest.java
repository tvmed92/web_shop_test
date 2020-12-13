package com.shop.test.tests;

import com.shop.test.app.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static ApplicationManager app;

    static {
        app = new ApplicationManager();
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    public void openMainPage() {
        app.getDriver().get("http://automationpractice.com/index.php");
    }
}
