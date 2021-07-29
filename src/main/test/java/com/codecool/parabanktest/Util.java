package com.codecool.parabanktest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Util {


    private static WebDriver driver;

    public static WebDriver GetDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void CloseDriver(){
        driver.close();
    }
}
