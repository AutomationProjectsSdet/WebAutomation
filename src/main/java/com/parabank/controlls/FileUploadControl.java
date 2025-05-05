package com.parabank.controlls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadControl {
    private WebDriver driver;

    public FileUploadControl(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(WebElement fileInputElement, String filePath) {
        try {

            fileInputElement.sendKeys(filePath);





        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void clearFileInput(WebElement fileInputElement) {
        fileInputElement.clear();
    }
}
