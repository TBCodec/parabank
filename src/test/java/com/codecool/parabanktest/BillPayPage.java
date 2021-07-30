package com.codecool.parabanktest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BillPayPage {

    public static String accountOut;
    public static Float accountOutBalance;

    public static String accountIn;
    public static Float accountInBalance;

    private static final By BILL_PAY_PAGE = By.xpath("//a[@href='/parabank/billpay.htm']");
    private static WebDriver driver = Util.GetDriver();
    private static WebDriverWait wait = new  WebDriverWait(driver, 10);

    public static void OpenBillPayPage(){
        driver.findElement(BILL_PAY_PAGE).click();
        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/billpay.htm"));
    }

    public static void CreateBillPay(){

        FillPayeeInformationField();
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]//select")).click();
        Select dropdownElement = new Select(driver.findElement(By.xpath("//select[@name='fromAccountId']")));
        dropdownElement.selectByValue(accountOut);
        driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
    }

    public static void FillPayeeInformationField(){
        List<WebElement> payeeInformationField = driver.findElements(By.xpath("//input[@name]"));
        for (int i = 0; i < payeeInformationField.size(); i++) {
            payeeInformationField.get(i).click();
            if (i < 6) payeeInformationField.get(i).sendKeys("sadgsdg");
            if (i == 6 || i == 7) payeeInformationField.get(i).sendKeys(accountIn);
            if (i == 8) payeeInformationField.get(i).sendKeys("1");
        }

    }

    public static void GetTwoAccount(){
        ArrayList<String[]> fullListAccount = AccountOverviewPage.GetFullListFromAccountOverview();

        accountOut = (fullListAccount.get(0)[0]);
        accountOutBalance = TransformBalanceToFloat(fullListAccount.get(0)[1]);

        accountIn = (fullListAccount.get(1)[0]);
        accountInBalance = TransformBalanceToFloat(fullListAccount.get(1)[1]);
    }

    public static Float TransformBalanceToFloat(String balance){
        String balanceString;
        if (balance.startsWith("-")) balanceString = "-" + balance.substring(2);
        else balanceString = balance.substring(1);
        Float balanceFloat = Float.parseFloat(balanceString);
        return balanceFloat;
    }

}