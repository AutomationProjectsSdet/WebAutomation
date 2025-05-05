package com.parabank.controlls;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ButtonControl {
    private WebDriver driver;

    public ButtonControl(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(WebElement buttonElement) {
        buttonElement.click();
    }

    public boolean isButtonEnabled(WebElement buttonElement) {
        return buttonElement.isEnabled();
    }

    public boolean isButtonDisplayed(WebElement buttonElement) {
        return buttonElement.isDisplayed();
    }

    public String getButtonText(WebElement buttonElement) {
        return buttonElement.getText();
    }

    public void closeApprovalButton() {
        List<WebElement> elements = null;
        try {

            elements = driver.findElements(By.xpath("//*[@aria-label='close']"));

            if (elements != null && elements.size() > 0) {
                for (WebElement el : elements) {
                    el.click();
                }
            }
        } catch (Exception e) {
            elements = driver.findElements(By.xpath("//*[@aria-label='close']"));

            if (elements != null && elements.size() > 0) {
                for (WebElement el : elements) {
                    el.click();
                }
            }

        }


    }
    public void clickButtonJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public void setFocusAndClickButton(WebElement overlappingElement) {
        // Find the overlapping element
        // Create Actions object
        Actions actions = new Actions(driver);
        // Move to the overlapping element
        actions.moveToElement(overlappingElement).click().perform();
        actions.release();
        // Close the browser
    }

    public void clickIfButtonExists(WebElement element) {
        try {


            if (element != null) {

                element.click();

            }
        } catch (Exception e) {

           e.printStackTrace();

            }

        }
    }



