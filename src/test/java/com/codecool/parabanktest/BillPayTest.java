package com.codecool.parabanktest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BillPayTest {

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

    public static void Login(){
        MenuPage.SendUserName();
        System.out.println(Util.GetDriver().getCurrentUrl());
        MenuPage.SendPassword();
        MenuPage.ClickLogInButton();

    }

    @Test
    public void BillPayTest(){
        BillPayPage.GetTwoAccount();
        float balanceBeforePaymentNumber = BillPayPage.accountOutBalance;
        BillPayPage.OpenBillPayPage();
        BillPayPage.CreateBillPay();
        AccountOverviewPage.OverviewPage();
        BillPayPage.GetTwoAccount();
        float balanceAfterPayment = BillPayPage.accountOutBalance;
        balanceBeforePaymentNumber -= 1;

        Assertions.assertEquals(balanceBeforePaymentNumber,balanceAfterPayment);
    }
}
