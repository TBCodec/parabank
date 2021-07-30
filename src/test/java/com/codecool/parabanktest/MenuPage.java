package com.codecool.parabanktest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MenuPage {

    public static final By USERNAME_FIELD = By.xpath("//input[@name='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@class='button']");
    private static final By LOGOUT_BUTTON = By.xpath("//a[@normalize-space()='Log Out']");
    private static final By REGISTER_BUTTON = By.xpath("//*[@id=\"loginPanel\"]//a[normalize-space()='Register']");

    private static WebDriver driver = Util.GetDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void MainPage(){
        wait.until(ExpectedConditions.urlToBe("data:,"));
        driver.get("https://parabank.parasoft.com/");
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }

    public static void Register(){
        WebElement registerButton = driver.findElement(REGISTER_BUTTON);
        registerButton.click();
        List<WebElement> signingUpFields = driver.findElements(By.xpath("//input[@id]"));
        for (int i = 0; i < signingUpFields.size(); i++) {
            if (i < 8){
                signingUpFields.get(i).sendKeys("sdfgh");
            }
            else {
                signingUpFields.get(i).sendKeys("litro");
            }
        }
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
        driver.findElement(LOGOUT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }


    public static void SendUserName(){
        WebElement userNameField = driver.findElement(USERNAME_FIELD);
        userNameField.sendKeys("litro");
    }

    public static void SendPassword(){
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys("litro");
    }

    public static void ClickLogInButton(){
        WebElement logInButton = driver.findElement(LOGIN_BUTTON);
        logInButton.click();
    }


}
