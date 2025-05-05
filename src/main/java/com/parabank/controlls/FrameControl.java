package com.parabank.controlls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameControl {


    private WebDriver driver;
    public FrameControl(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrameByIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }
    public void switchToFrameByNameOrId(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }
    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
