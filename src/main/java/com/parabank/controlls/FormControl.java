package com.parabank.controlls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormControl {
    private WebDriver driver;
    public FormControl(WebDriver driver) {
        this.driver = driver;
    }
    public void fillInputField(WebElement inputElement, String text) {
        inputElement.clear();
        inputElement.sendKeys(text);
    }
    public void selectRadioButton(WebElement radioButtonElement) {
        if (!radioButtonElement.isSelected()) {
            radioButtonElement.click();
        }
    }
    public void selectCheckbox(WebElement checkboxElement) {
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }
    public void submitForm(WebElement formElement) {
        formElement.submit();
    }
    public void clearForm(WebElement formElement) {
        formElement.clear();
    }
    }

