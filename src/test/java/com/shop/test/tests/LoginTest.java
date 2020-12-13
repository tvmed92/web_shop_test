package com.shop.test.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Если e-mail и пароль не заданы аутентификация не происходит")
    public void testEmptyEmailAndPasswordLogin() {
        openMainPage();
        app.main()
                .clickSignInButton();
        app.signInSignUp()
                .checkOpen().signIn("", "");
        app.signInSignUp()
                .checkOpen();
    }
}
