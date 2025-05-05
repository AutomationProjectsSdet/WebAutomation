package com.parabank.tests.positive;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");
        // Add assertion to verify successful login
    }
}
