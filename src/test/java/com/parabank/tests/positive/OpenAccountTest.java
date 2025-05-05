package com.parabank.tests.positive;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.OpenAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest {

    @Test
    public void openNewAccountTest() {
        new LoginPage(driver).login("john", "demo");
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.navigateToOpenAccountPage();
        openAccountPage.openNewAccount();
        Assert.assertTrue(openAccountPage.isAccountOpened(), "Account should be opened successfully");
    }
}
