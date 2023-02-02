package org.conceptOfSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementUtil {
    private static WebDriver driver;
    public ElementUtil(WebDriver driver){
        this.driver=driver;
    }
    /*******************wait utils*************/
    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementPresent(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementPresent(By locator, long timeOut, long intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but also
     * has a height and width that is greater than 0.
     *
     * @param locator
     * @param timeout
     */
    public WebElement waitForElementVisible(By locator, int timeout, long interval){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofMillis(interval));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForElementVisible(By locator, int timeout){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public Alert waitforAlertToBePresent(int timeout){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(int timeout){
        waitforAlertToBePresent(timeout).accept();
    }
    public void dismissAlert(int timeout){
        waitforAlertToBePresent(timeout).dismiss();
    }
    public void sendKeysToAlert(int timeout,String value){
        waitforAlertToBePresent(timeout).sendKeys(value);
    }
    public String getTextAlert(int timeout){
        return waitforAlertToBePresent(timeout).getText();
    }
    public boolean waitForUrlContains(String urlfraction,int timeout){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains(urlfraction));
    }
    /*public String getCurrentUrl(String urlfraction,int timeout){
        if(waitForUrlContains(urlfraction,timeout)){
            return driver.getCurrentUrl();
        }
        return null;
    }*/
    public boolean waitForUrlToBe(String urlValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.urlToBe(urlValue));
    }

    public String waitForTitleContains(int timeOut, String titleFraction) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
            return driver.getTitle();
        }
        return null;
    }

    public String waitForTitleToBe(int timeOut, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleIs(title))) {
            return driver.getTitle();
        }
        return null;
    }
    public void waitForFrameUsingIDOrName(String frameIdOrName,int timeout){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
    }
    public void waitForFrameUsingIndex(int frameIndex, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public void waitForFrameUsingByLocator(By frameLocator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void waitForFrameUsingWebElement(WebElement frameElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public WebElement waitForElementToBeClickable(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void clickWhenReady(By locator,int timeout){
        waitForElementToBeClickable(locator,timeout).click();
    }

    public List<WebElement> waitForElementsPresence(By locator, int timeout){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
