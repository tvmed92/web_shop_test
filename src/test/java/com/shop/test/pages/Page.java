package com.shop.test.pages;

import com.shop.test.app.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected ApplicationManager app;
    protected WebDriverWait wait;

    public Page(ApplicationManager app) {
        this.app = app;
        this.driver = app.getDriver();
        this.wait = app.getWaiter();
    }

    public Page() {
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void selectFromDropdown(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    protected void fillField(String fieldName, String value) {
        driver.findElement(By.id(fieldName)).sendKeys(value);
    }

    protected void clearField(String fieldName) {
        driver.findElement(By.id(fieldName)).clear();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getValue(String fieldName) {
        return driver.findElement(By.name(fieldName)).getAttribute("value");
    }
}
