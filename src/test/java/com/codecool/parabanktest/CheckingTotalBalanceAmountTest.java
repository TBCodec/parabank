package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.AccountOverviewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckingTotalBalanceAmountTest {

    @Test
    public static void checkingTotalBalanceTest() throws InterruptedException {
        AccountOverviewPage.OverviewPage();
        Float expectedAmount = AccountOverviewPage.SumBalance(AccountOverviewPage.GetFullListFromAccountOverview());
        Float actualAmount = AccountOverviewPage.GetTotalBalanceAmount();
        Assertions.assertEquals(expectedAmount, actualAmount);

    }


}
