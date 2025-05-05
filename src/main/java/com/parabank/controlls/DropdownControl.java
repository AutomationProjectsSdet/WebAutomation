package com.parabank.controlls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownControl {

    private WebDriver driver;
    private WaitControl waitControl;

    public DropdownControl(WebDriver driver) {
        this.driver = driver;
        waitControl = new WaitControl(driver, 5);
    }

    public void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }


    public void selectByIndex(WebElement dropdownElement, int index) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public String getSelectedOptionText(WebElement dropdownElement) {
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectByValueInCombox(WebElement elmentCombobox, WebElement inputHolder, String value) {
        inputHolder.sendKeys(value);
        waitControl.waitForElementToBeVisible(elmentCombobox);
        System.out.println("Combox HTML" + elmentCombobox.getText());
        elmentCombobox.findElement(By.className("MuiAutocomplete-option")).click();
    }

    public void setValueInComboxText(WebElement elmentCombobox,WebElement inputHolder, String value) {
        inputHolder.click();
        inputHolder.sendKeys(Keys.CONTROL + "a");
        inputHolder.sendKeys(Keys.DELETE);
        inputHolder.sendKeys(value);
        elmentCombobox.click();

    }

    public void selectByValueInDiv(WebElement elmentCombobox, WebElement listItems, String value) {

        waitControl.waitForElementToBeVisible(elmentCombobox);
        elmentCombobox.click();
        System.out.println("Combox HTML" + elmentCombobox.getText());
        List<WebElement> lItems = listItems.findElements(By.tagName("li"));
        for (WebElement webElement : lItems) {
            if (webElement.getAttribute("data-value").equalsIgnoreCase(value)) {
                webElement.click();
                break;
            }
        }

    }
}

