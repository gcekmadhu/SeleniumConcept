package org.conceptOfSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForAlert {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        ElementUtil elementUtil=new ElementUtil(driver);
        //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        //driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert=elementUtil.waitforAlertToBePresent(10);
        System.out.println(alert.getText());
        //Alert alert=driver.switchTo().alert();
        //alert.sendKeys("This is alert box text");
        alert.accept();
        driver.switchTo().defaultContent();
        driver.quit();

    }
}
