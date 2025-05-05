package com.parabank.tests.negative;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidTransferFundsTest extends BaseTest {

    @Test
    public void invalidTransferTest() {
        new LoginPage(driver).login("john", "demo");
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.navigateToTransferPage();
        transferFundsPage.transferFunds("-50");
        Assert.assertTrue(transferFundsPage.isTransferFailed(), "Transfer should fail for invalid amount");
    }
}
