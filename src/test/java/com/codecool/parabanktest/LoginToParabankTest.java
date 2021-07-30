package com.codecool.parabanktest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToParabankTest {
    WebDriverWait wait = new WebDriverWait(Util.GetDriver(), 10);
    WebDriver driver = Util.GetDriver();
    @BeforeEach
    public void openParabankLogin() {

        MenuPage.MainPage();
        Login();
    }


    @AfterEach
    public void closeDriver(){
        Util.CloseDriver();
    }


    public void Login(){
        MenuPage.SendUserName();
        System.out.println(Util.GetDriver().getCurrentUrl());
        MenuPage.SendPassword();
        MenuPage.ClickLogInButton();
        /*
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/p")));
            if (Util.GetDriver().findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getAttribute("class").equals("error")){
                MenuPage.Register();
                }
        }
        catch (Exception e){
            throw e;
        }
        */
    }

    @Test
    public void LoginTest(){
        String expectedText = "Welcome";
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"leftPanel\"]/p/b")));
        String actualText = Util.GetDriver().findElement(By.xpath("//*[@id=\"leftPanel\"]/p/b")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }

}
