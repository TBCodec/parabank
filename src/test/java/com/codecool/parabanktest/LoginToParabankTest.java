package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToParabankTest {

    public static void Login(){
        MenuPage.SendUserName();
        MenuPage.SendPassword();
        MenuPage.ClickLogInButton();
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
    }

    public static void LoginTest(){
        String expectedPage = "https://parabank.parasoft.com/parabank/overview.htm";
        String actualPage = Util.GetDriver().getCurrentUrl();
        Assertions.assertEquals(expectedPage, actualPage);
    }

}
