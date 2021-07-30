package com.codecool.parabanktest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountOverviewPage {

    private static final By OVERVIEW_PAGE = By.xpath("//a[@href='/parabank/overview.htm']");
    private static final By TOTAL_BALANCE_FIELD = By.xpath("//*[@id=\"accountTable\"]//b[@class='ng-binding']");
    public static WebDriver driver = Util.GetDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, 20);

    public static Float GetTotalBalanceAmount() throws InterruptedException {
        WebElement totalBalanceField = Util.GetDriver().findElement(TOTAL_BALANCE_FIELD);
        Thread.sleep(500);
        String actualAmount = totalBalanceField.getText();

        return BillPayPage.TransformBalanceToFloat(actualAmount);
    }

    public static void OverviewPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(OVERVIEW_PAGE));
        driver.findElement(OVERVIEW_PAGE).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_BALANCE_FIELD));
    }

    public static List GetListAccounts(){
        List<WebElement> accountOverviewList = driver.findElements(By.xpath("//*[@id=\"accountTable\"]//a"));
        List<String> accountList = new ArrayList<>();
        for (WebElement element : accountOverviewList){

            accountList.add(element.getText());
        }

        return accountList;
    }

    public static ArrayList<String[]> GetFullListFromAccountOverview(){
        ArrayList<String[]> accountsAndBalance = new ArrayList<>();


        List<WebElement> accountRow = driver.findElements(By.xpath("//*[@id=\"rightPanel\"]//tr[@ng-repeat]"));
        for (WebElement element : accountRow){
            String[] accountAndBalance = element.getText().split(" ");
            System.out.print(accountAndBalance[0]);
            System.out.print(" - ");
            System.out.println(accountAndBalance[1]);
            accountsAndBalance.add(accountAndBalance);
        }

        return accountsAndBalance;
    }

    public static Float SumBalance(ArrayList<String[]> accountAndBalanceList){
        float sumBalance = 0.f;
        for (int i = 0; i < accountAndBalanceList.size(); i++) {
            String balance = accountAndBalanceList.get(i)[1];
            sumBalance += BillPayPage.TransformBalanceToFloat(balance);

        }
        return sumBalance;
    }



}
