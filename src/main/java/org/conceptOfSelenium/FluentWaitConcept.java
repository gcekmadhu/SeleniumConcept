package org.conceptOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class FluentWaitConcept {
    public static WebDriver driver;
    public static void main(String args[]) {
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        ElementUtil elementUtil=new ElementUtil(driver);
        By footerList=By.xpath("//footer[@class=\"bg-black\"]//a");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> webElements=waitForElementsPresence(footerList,10);
        Iterator<WebElement> iterator=webElements.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getText());
        }

        Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .withMessage("Time expired-->Element not found")
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@class=\"bg-black\"]//a[text()='Contact Us']"))).click();

    }
    public static List<WebElement> waitForElementsPresence(By locator, int timeout){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
