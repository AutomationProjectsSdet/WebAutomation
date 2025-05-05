package com.parabank.controlls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class InputControl {


    private final WebDriver driver;

    public InputControl(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement textBox = driver.findElement(locator);
        return textBox.getAttribute("value");
    }

    public void appendText(By locator, String text) {
        WebElement textBox = driver.findElement(locator);
        textBox.sendKeys(text);
    }

    public void clearText(By locator) {
        WebElement textBox = driver.findElement(locator);
        textBox.clear();
    }

    public void clearNumbers(WebElement el) {
        el.click();
        el.sendKeys(Keys.CONTROL + "a");
        el.sendKeys(Keys.DELETE);
    }

    public void pressBackSpace(WebElement el, int numberBackSpaces) {
        try {

            el.click();
            while (numberBackSpaces > 0) {
                driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
                el.sendKeys(Keys.BACK_SPACE);
                numberBackSpaces--;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean isTextBoxEnabled(By locator) {
        WebElement textBox = driver.findElement(locator);
        return textBox.isEnabled();
    }

    public boolean isTextBoxDisplayed(By locator) {
        WebElement textBox = driver.findElement(locator);
        return textBox.isDisplayed();
    }

    public boolean isTextBoxReadOnly(By locator) {
        WebElement textBox = driver.findElement(locator);
        String readOnlyAttr = textBox.getAttribute("readonly");
        return readOnlyAttr != null && readOnlyAttr.equalsIgnoreCase("true");
    }

public void sendKeysElement(WebElement element, String keysToSend){

    element.click();
    element.sendKeys(keysToSend);

    }

public void setTextAction(WebElement element, String desiredValue){
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().sendKeys(desiredValue).sendKeys(Keys.TAB).build().perform();
}
}
