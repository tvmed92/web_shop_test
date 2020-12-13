package com.shop.test.app;

import com.shop.test.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private Page page;
    private MainPage main;
    private RegistrationForm registration;
    private AccountPage account;
    private SignInSignUpPage signInSignUp;
    private WebDriverWait wait;

    public ApplicationManager() {
    }

    public void init() {
        page = new Page(this);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriverWait getWaiter() {
        wait = new WebDriverWait(driver, 10);
        return wait;
    }

    public MainPage main() {
        if (main == null) {
            main = new MainPage(this);
        }
        return main;
    }

    public SignInSignUpPage signInSignUp() {
        if (signInSignUp == null) {
            signInSignUp = new SignInSignUpPage(this);
        }
        return signInSignUp;
    }

    public RegistrationForm registration() {
        if (registration == null) {
            registration = new RegistrationForm(this);
        }
        return registration;
    }

    public AccountPage account() {
        if (account == null) {
            account = new AccountPage(this);
        }
        return account;
    }
}
