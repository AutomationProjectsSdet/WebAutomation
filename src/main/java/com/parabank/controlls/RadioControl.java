package com.parabank.controlls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioControl {
    private final WebDriver driver;
    public RadioControl(WebDriver driver) {
        this.driver = driver;
    }
    public void selectRadioButton(By locator) {
        WebElement radioButton = driver.findElement(locator);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }
    public boolean isRadioButtonSelected(By locator) {
        WebElement radioButton = driver.findElement(locator);
        return radioButton.isSelected();
    }
    public void clearSelectedRadioButton(By groupLocator) {
        for (WebElement radioButton : driver.findElements(groupLocator)) {
            if (radioButton.isSelected()) {
                radioButton.click();
                break;
            }
        }
    }
}
