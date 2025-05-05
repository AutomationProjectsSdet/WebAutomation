package com.parabank.controlls;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitControl {

    private WebDriver driverThreadLocal;
    private final int timeoutinSeconds;
    private WebDriverWait wait;
    public WaitControl(WebDriver driver,int timeoutinSeconds) {
        this.driverThreadLocal = driver;
        this.timeoutinSeconds = timeoutinSeconds;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(30) );

    }
    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForAttributeInvisibility(WebElement element,String attribute,String val) {
        wait.until(ExpectedConditions.attributeContains(element,attribute,val));
    }
    public void waitForDomToBeReady(WebElement el,String property, String value) {
        wait.until(ExpectedConditions.domPropertyToBe(el,property,value));
    }
    public void waitForElementToBeSelected(By locator) {
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void waitForTextToBePresentInElement(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    public void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    public void waitForTitleToBe(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }
    public void waitForTitleToContain(String partialTitle) {
        wait.until(ExpectedConditions.titleContains(partialTitle));
    }

    public void waitForElementInvisibility(By element) {

        WebDriverWait wait = new WebDriverWait(driverThreadLocal, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(20)); // Adjust polling interval
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

    }

    public void waitForElementInvisibility(WebElement element) {


        wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true; // Element not found or stale, consider it invisible
            }
        });
    }


    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForLoadToDesapire() {
        try {


            WebDriverWait wdWait = new WebDriverWait(driverThreadLocal, Duration.ofSeconds(90));
            wdWait.pollingEvery(Duration.ofMillis(50));
            wdWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@aria-label='audio-loading']")));

        }
        catch (Exception exception){
            exception.printStackTrace();
        }

    }


    public void waitForMenuToLoad(String menuLocator){
        WebElement elMenu =driverThreadLocal.findElement(By.className(menuLocator));
        wait.until(ExpectedConditions.attributeToBe(elMenu,"style","transform: unset;"));


    }


    public void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void customWaitForElementVisibility(By elementToWait) {
        try {
            // Wait for the notification tooltip to appear with a shorter timeout (e.g., 3 minutes)
            WebDriverWait wdWait= new WebDriverWait(driverThreadLocal,Duration.ofSeconds(300));
            WebElement notificationTooltip = wdWait
                    .until(ExpectedConditions.visibilityOfElementLocated(elementToWait));
            // Process the notification (e.g., click on it, verify its content, etc.)
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
