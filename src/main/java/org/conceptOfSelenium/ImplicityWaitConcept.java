package org.conceptOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ImplicityWaitConcept {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("https://phptravels.com/demo");
       driver.findElement(By.xpath("//footer[@class='bg-black']//a[contains(text(),'Contact Us')]")).click();
        String title=driver.getTitle();
        System.out.println(title);


    }
}
