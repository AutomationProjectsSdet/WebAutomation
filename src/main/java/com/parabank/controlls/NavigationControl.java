package com.parabank.controlls;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class NavigationControl {
    private final WebDriver driver;

    public NavigationControl(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void navigateToPage(By locator) {
        driver.findElement(locator).click();
    }
    public void navigateToNewTab()  {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Switch to the new tab (assuming the new tab is the second one)
        driver.switchTo().window(tabs.get(1));








    }


    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateTopPage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        // Scroll to the top of the page
        executor.executeScript("window.scrollTo(0, 0);");
    }
    public void navigateBottomPage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        // Scroll to the bottom of the page
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
