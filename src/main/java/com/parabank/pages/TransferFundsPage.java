package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage {
    WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    By transferFundsLink = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By fromAccount = By.id("fromAccountId");
    By toAccount = By.id("toAccountId");
    By transferButton = By.xpath("//input[@value='Transfer']");
    By successMessage = By.xpath("//h1[text()='Transfer Complete!']");
    By errorMessage = By.cssSelector(".error");

    public void navigateToTransferPage() {
        driver.findElement(transferFundsLink).click();
    }

    public void transferFunds(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(transferButton).click();
    }

    public boolean isTransferSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isTransferFailed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
