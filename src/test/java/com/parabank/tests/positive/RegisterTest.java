package com.parabank.tests.positive;

import com.parabank.base.BaseTest;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigateToRegisterPage();
        registerPage.register("John", "Doe", "123 Street", "City", "State", "12345", "1234567890", "123-45-6789", "john_doe_user", "password123");
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "User should be registered successfully");
    }
}
