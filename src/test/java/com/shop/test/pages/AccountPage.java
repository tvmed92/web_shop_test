package com.shop.test.pages;

import com.shop.test.app.ApplicationManager;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;

public class AccountPage extends Page {

    public AccountPage(ApplicationManager app) {
        super(app);
    }

    public AccountPage checkOpen() {
        wait.until(visibilityOfElementLocated(By.className("addresses-lists")));
        String title = getText(By.className("page-heading"));
        assertEquals(title, "MY ACCOUNT");
        return this;
    }

    public void checkUserAccount(String firstName, String lastName) {
        assertEquals(getText(By.className("account")), firstName + " " + lastName);
    }
}
