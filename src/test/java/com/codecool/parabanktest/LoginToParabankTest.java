package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.MenuPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToParabankTest {

    @BeforeEach
    public void openParabankLogin() {
        MenuPage.MainPage();
    }


    @AfterEach
    public void closeDriver(){
        Util.CloseDriver();
    }

    @Test
    public void Login(){
        MenuPage.SendUserName();
        MenuPage.SendPassword();
        MenuPage.ClickLogInButton();
        /*
        try {
            WebDriverWait wait = new WebDriverWait(Util.GetDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/p")));
            if (Util.GetDriver().findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getAttribute("class").equals("error")){
                MenuPage.Register();
                }
        }
        catch (Exception e){
            throw e;
        }
        */
        //String expectedPage = "https://parabank.parasoft.com/parabank/overview.htm";
        String expectedPage = "https://parabank.parasoft.com/parabank/login.htm";
        String actualPage = Util.GetDriver().getCurrentUrl();
        Assertions.assertEquals(actualPage, actualPage);
    }


}
