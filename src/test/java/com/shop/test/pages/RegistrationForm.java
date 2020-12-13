package com.shop.test.pages;

import com.shop.test.app.ApplicationManager;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;

public class RegistrationForm extends Page {

    public RegistrationForm(ApplicationManager app) {
        super(app);
    }

    public RegistrationForm checkOpen() {
        wait.until(visibilityOfElementLocated(By.id("account-creation_form")));
        String title = getText(By.className("page-heading"));
        assertEquals(title, "CREATE AN ACCOUNT");
        return this;
    }

    /**
     * Method fills all fields and elements of registration form
     * @return this page
     * */
    public RegistrationForm fillForm(String gender, String firstName, String lastName, String email, String password,
                                     String day, String months, String year, Boolean news, Boolean promos, String company,
                                     String address1, String address2, String city, States state, String zipCode,
                                     String additionalInfo, String homePhone, String mobilePhone, String addressAlias) {
        if (gender != null) {
            if (gender.equals("муж")) {
                click(cssSelector("[for='id_gender1']"));
            }
            click(cssSelector("[for='id_gender2']"));
        }
        fillField("customer_firstname", firstName);
        fillField("customer_lastname", lastName);
        //check if email is already filled
        String emailValue = getValue("email");
        if (emailValue == null || !emailValue.equals(email)) {
            fillField("email", email);
        }
        fillField("passwd", password);
        if (day != null) {
            selectFromDropdown(id("days"), day);
        }
        if (months != null) {
            selectFromDropdown(id("months"), months);
        }
        if (year != null) {
            selectFromDropdown(id("years"), year);
        }
        if (news) {
            click(cssSelector("[for='newsletter']"));
        }
        if (promos) {
            click(cssSelector("[for='optin']"));
        }
        String firstNameValue = getValue("firstname");
        if (firstNameValue == null) {
            fillField("firstname", firstName);
        }
        String lastNameValue = getValue("lastname");
        if (lastNameValue == null) {
            fillField("lastname", firstName);
        }
        if (company != null) {
            fillField("company", company);
        }
        fillField("address1", address1);
        if (address2 != null) {
            fillField("address2", address2);
        }
        fillField("city", city);
        selectFromDropdown(id("id_state"), state.toString());
        fillField("postcode", zipCode);
        selectFromDropdown(id("id_country"), "United States");
        if (additionalInfo != null) {
            fillField("other", additionalInfo);
        }
        if (homePhone != null) {
            fillField("phone", homePhone);
        }
        fillField("phone_mobile", mobilePhone);
        //clear alias field if filled
        String aliasValue = getValue("alias");
        if (aliasValue != null) {
            clearField("alias");
        }
        fillField("alias", addressAlias);
        return this;
    }

    /**
     * Method fills only required fields and elements of registration form
     * @return this page
     * */
    public RegistrationForm fillOnlyRequiredFields(String firstName, String lastName, String email, String password,
                                                   String address1, String city, States state, String zipCode,
                                                   String mobilePhone, String addressAlias) {
        fillForm(null, firstName, lastName, email, password, null, null, null, false,
                false, null, address1, null, city, state, zipCode, null,
                null, mobilePhone, addressAlias);
        return this;
    }

    public void clickSubmit() {
        click(name("submitAccount"));
    }
}
