package com.parabank.controlls;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CheckboxControl {
    private WebDriver driver;

    public CheckboxControl(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCheckbox(WebElement checkboxElement) {
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    public void deselectCheckbox(WebElement checkboxElement) {
        if (checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }
    public void jsExecuter(String eventToExecute) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(eventToExecute);
    }

    public boolean isCheckboxSelected(WebElement checkboxElement) {
        return checkboxElement.isSelected();
    }
}