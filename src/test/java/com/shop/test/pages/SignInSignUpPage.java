package com.shop.test.pages;

import com.shop.test.app.ApplicationManager;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;

public class SignInSignUpPage extends Page {

    public SignInSignUpPage(ApplicationManager app) {
        super(app);
    }

    public SignInSignUpPage checkOpen() {
        wait.until(visibilityOfElementLocated(By.id("login_form")));
        String title = getText(By.className("page-heading"));
        assertEquals(title, "AUTHENTICATION");
        return this;
    }

    public void signIn(String email, String password) {
        fillField("email", email);
        fillField("passwd", password);
        driver.findElement(By.name("SubmitLogin")).click();
    }

    public void fillEmailForSignUp(String email) {
        fillField("email_create", email);
        driver.findElement(By.name("SubmitCreate")).click();
    }
}
