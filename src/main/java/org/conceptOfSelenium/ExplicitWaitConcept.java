package org.conceptOfSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcept {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        ElementUtil el=new ElementUtil(driver);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.xpath("//button[contains(text(),'Display button after 10 seconds')]")).click();
        WebElement button = null;
        try {
            button = el.waitForElementVisible(By.xpath("//button[contains(text(),'Enabled')]"),10,200);
            System.out.println(button.isDisplayed());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.findElement(By.id("alert")).click();
        try{
           // Alert alert= el.waitforAlertToBePresent(5);
            System.out.println(el.getTextAlert(5));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
