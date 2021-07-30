package com.codecool.parabanktest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccount {

    private static final By OPEN_NEW_ACCOUNT_PAGE = By.xpath("//a[@href='/parabank/openaccount.htm']");
    private static final By OPEN_NEW_ACCOUNT_FIELD = By.xpath("//input[@value='Open New Account']");


    public static String CreateNewAccount() throws InterruptedException {
        WebDriver driver = Util.GetDriver();
        driver.findElement(OPEN_NEW_ACCOUNT_PAGE).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(OPEN_NEW_ACCOUNT_FIELD));
        driver.findElement(OPEN_NEW_ACCOUNT_FIELD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newAccountId\"]")));
        String newAccountNumber = driver.findElement(By.xpath("//*[@id=\"newAccountId\"]")).getText();
        return newAccountNumber;
    }


}
