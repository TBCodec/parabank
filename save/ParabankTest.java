package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.BillPayPage;
import com.codecool.parabanktest.pages.MenuPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ParabankTest {

    @BeforeEach
    public void openParabankLogin() {

        MenuPage.MainPage();
        LoginToParabankTest.Login();

    }


    @AfterEach
    public void closeDriver(){
        Util.CloseDriver();
    }

    @Test
    public void testParabank() throws InterruptedException {
        LoginToParabankTest.LoginTest();
        CheckingTotalBalanceAmountTest.checkingTotalBalanceTest();
        OpenNewAccountTest.CheckingNewAccountCreated();
        BillPayTest.BillPayTest();
    }


}
