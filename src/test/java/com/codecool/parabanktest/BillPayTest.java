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
        LoginToParabankTest login = new LoginToParabankTest();
        login.Login();
    }


    @AfterEach
    public void closeDriver(){
        Util.CloseDriver();
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
