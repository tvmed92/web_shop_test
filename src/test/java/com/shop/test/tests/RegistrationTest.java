package com.shop.test.tests;

import com.shop.test.pages.States;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private final String email = RandomStringUtils.randomAlphanumeric(8) + "@email.rand";
    private final String password = RandomStringUtils.randomAlphanumeric(12);
    private final String alphabetic = RandomStringUtils.randomAlphabetic(10);
    private final String firstName = RandomStringUtils.randomAlphabetic(8);
    private final String lastName = RandomStringUtils.randomAlphabetic(8);
    private final String zipCode = RandomStringUtils.randomNumeric(5);
    private final String phone = RandomStringUtils.randomNumeric(10);

    @Test(description = "Проверяем возможность успешной регистрации пользователя")
    public void testPositiveRegistration() {
        openMainPage();
        app.main()
                .clickSignInButton();
        app.signInSignUp()
                .fillEmailForSignUp(email);
        app.registration()
                .checkOpen()
                .fillOnlyRequiredFields(firstName, lastName, email, password, alphabetic, alphabetic,
                                        States.Alabama, zipCode, phone, alphabetic).clickSubmit();
        app.account()
                .checkOpen()
                .checkUserAccount(firstName, lastName);
    }

    @Test(description = "Если ввести абракадабру в поле e-mail на странице первичной проверки," +
            "к следующему шагу регистрации не переходим")
    public void testInvalidEmailRegistration() {
        openMainPage();
        app.main()
                .clickSignInButton();
        app.signInSignUp()
                .checkOpen()
                .fillEmailForSignUp("!@#$%^&*()_+=-[]{}/\\<>.,':;");
        app.signInSignUp()
                .checkOpen();
    }
}
