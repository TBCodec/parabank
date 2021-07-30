package com.codecool.parabanktest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingTotalBalanceAmountTest {

    @BeforeEach
    public void openParabankLogin() {
        Util.GetDriver();
        MenuPage.MainPage();
        LoginToParabankTest login = new LoginToParabankTest();
        login.Login();
    }


    @AfterEach
    public void closeDriver(){
        Util.CloseDriver();
    }

    @Test
    public void checkingTotalBalanceTest() throws InterruptedException {
        AccountOverviewPage.OverviewPage();
        Float expectedAmount = AccountOverviewPage.SumBalance(AccountOverviewPage.GetFullListFromAccountOverview());
        Float actualAmount = AccountOverviewPage.GetTotalBalanceAmount();
        Assertions.assertEquals(expectedAmount, actualAmount);

    }


}
