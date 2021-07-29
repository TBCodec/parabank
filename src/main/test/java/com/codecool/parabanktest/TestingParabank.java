package com.codecool.parabanktest;


import com.codecool.parabanktest.pages.OpenNewAccount;

public class TestingParabank {


    public static void main(String[] args) throws InterruptedException {
        LoginToParabankTest.Login();
        OpenNewAccount.CreateNewAccount();
        Util.CloseDriver();
    }
}
