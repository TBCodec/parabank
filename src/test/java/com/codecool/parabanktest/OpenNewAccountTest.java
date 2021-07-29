package com.codecool.parabanktest;

import com.codecool.parabanktest.pages.AccountOverviewPage;
import com.codecool.parabanktest.pages.OpenNewAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenNewAccountTest {

    public static void CheckingNewAccountCreated() throws InterruptedException {
        boolean isThereTheNewAccount = false;
        String newAccountNumber = OpenNewAccount.CreateNewAccount();
        AccountOverviewPage.OverviewPage();
        List<String> accountList = AccountOverviewPage.GetListAccounts();
        for (String element : accountList){
            if (element.equals(newAccountNumber)){
                isThereTheNewAccount = true;
                break;
            }
        }
        Assertions.assertTrue(isThereTheNewAccount);
    }

}
