package org.conceptOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFrame {
    private static WebDriver driver;
    public static void main(String args[]){
        driver=new ChromeDriver();
        ElementUtil elementUtil=new ElementUtil(driver);
        driver.get("http://www.londonfreelance.org/courses/frames/index.html");
        waitForFrameUsingIDOrName("main",10);
        String header=driver.findElement(By.xpath("//html/body/h2")).getText();
        System.out.println(header);
        driver.switchTo().defaultContent();
        driver.quit();
    }

    public static void waitForFrameUsingIDOrName(String frameIdOrName,int timeout){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
    }
}
