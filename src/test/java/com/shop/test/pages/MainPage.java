package com.shop.test.pages;

import com.shop.test.app.ApplicationManager;
import org.openqa.selenium.By;

public class MainPage extends Page {

    public MainPage(ApplicationManager app) {
        super(app);
    }

    public void clickSignInButton() {
        driver.findElement(By.className("login")).click();
    }
}
