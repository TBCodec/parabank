package com.codecool.parabanktest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OpenNewAccountTest {


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
    public void CheckingNewAccountCreated() throws InterruptedException {
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
