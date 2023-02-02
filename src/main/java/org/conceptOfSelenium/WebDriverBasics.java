package org.conceptOfSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverBasics {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        String title=driver.getTitle();
        System.out.println("Page title"+title);
        if(title.equals("Google")){
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Wrong title");
        }
        System.out.println("Current URL:--"+driver.getCurrentUrl());
        driver.close();
        driver.getPageSource();
    }
}
