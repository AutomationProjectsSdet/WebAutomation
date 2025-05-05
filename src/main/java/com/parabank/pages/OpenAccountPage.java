package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenAccountPage {
    WebDriver driver;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By openAccountLink = By.linkText("Open New Account");
    By accountTypeDropdown = By.id("type");
    By openNewAccountButton = By.xpath("//input[@value='Open New Account']");
    By newAccountMessage = By.id("newAccountId");

    public void navigateToOpenAccountPage() {
        driver.findElement(openAccountLink).click();
    }

    public void openNewAccount() {
        driver.findElement(openNewAccountButton).click();
    }

    public boolean isAccountOpened() {
        return driver.findElements(newAccountMessage).size() > 0;
    }
}
