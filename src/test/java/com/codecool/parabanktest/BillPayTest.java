package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.AccountOverviewPage;
import com.codecool.parabanktest.pages.BillPayPage;
import com.codecool.parabanktest.pages.MenuPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BillPayTest {

    @BeforeEach
    public void Login(){
        //MenuPage.MainPage();
        try {
            LoginToParabankTest.Login();
        }
        catch (Exception e){
        MenuPage.Register();
        }
    }

    @AfterEach
    public void CloseDriver(){
        Util.CloseDriver();
    }

    @Test
    public static void BillPayTest(){
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
