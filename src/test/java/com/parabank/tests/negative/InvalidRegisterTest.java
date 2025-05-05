package com.parabank.tests.negative;

import com.parabank.base.BaseTest;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidRegisterTest extends BaseTest {

    @Test
    public void registrationWithMissingFields() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigateToRegisterPage();
        registerPage.register("", "", "", "", "", "", "", "", "", "");
        Assert.assertFalse(registerPage.isRegistrationSuccessful(), "User should not be registered with missing data");
    }
}
