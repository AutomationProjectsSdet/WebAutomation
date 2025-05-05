package com.parabank.tests.positive;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test
    public void validTransferTest() {
        new LoginPage(driver).login("john", "demo");
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.navigateToTransferPage();
        transferFundsPage.transferFunds("100");
        Assert.assertTrue(transferFundsPage.isTransferSuccessful(), "Transfer should be successful");
    }
}
