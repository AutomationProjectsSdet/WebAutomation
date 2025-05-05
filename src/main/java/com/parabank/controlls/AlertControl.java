package com.parabank.controlls;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertControl {
    private WebDriver driver;

    public AlertControl(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println("Alert"+alertMessage);
        return alertMessage;
    }

    public void typeTextInAlert(String inputText) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
    }


    public boolean checkSuccessTooltip(WebElement successTooltip, String successText) {
        System.out.println("Text in tooltip is" + successTooltip.getText());
        if (successTooltip.isDisplayed() && successTooltip.getAttribute("innerText").contains(successText)) {
            return true;
        } else {
            return false;
        }
    }

    public String getToolTipById(String tooltipId) {
        return getToolTip(By.id(tooltipId));
    }
    public String getToolTipByClass(String tooltipClass) {
        return getToolTip(By.className(tooltipClass));
    }
    private String getToolTip(By locator) {
        String content = "";
        int maxRetries = 5;
        for (int retry = 1; retry <= maxRetries; retry++) {
            try {
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(ExpectedConditions.presenceOfElementLocated(locator));
                System.out.println("Element found: " + element.getAttribute("innerText"));
                content = element.getAttribute("innerText");
                if (!content.isEmpty()) {
                    System.out.println("Tooltip found: " + content);
                    break;
                }
            } catch (Exception e) {
                if (retry < maxRetries) {
                    System.out.println("Element not found, retrying...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                } else {
                    System.out.println("Tooltip did not appear after maximum retries.");
                }
            }
        }
        return content;
    }



    public String getAlertNotification(WebElement tooltip){
        String content="";
        int maxRetries = 5;
        for (int retry = 1; retry <= maxRetries; retry++) {
            try {
                // Attempt to locate the element (adjust timeout as needed)
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(tooltip));
                System.out.println("Alert"+element.getAttribute("innerText"));
                content =element.getAttribute("innerText");
                // If the element is found, print a message and break out of the loop
                if (!content.isEmpty()) {

                    System.out.println("Alert has appeared."+content);
                    break;
                }
            } catch (Exception e) {
                // Element not found in this attempt, wait a bit and retry
                if (retry < maxRetries) {
                    System.out.println("Alert not found, retrying...");
                    try {
                        Thread.sleep(1000); // Wait for 1 second before retrying (adjust as needed)
                    } catch (InterruptedException ignored) {
                    }
                } else {
                    // Element not found after all retries, print an error message
                    System.out.println("Alert did not appear after maximum retries.");
                }
            }
        }
        return content;
    }


}
