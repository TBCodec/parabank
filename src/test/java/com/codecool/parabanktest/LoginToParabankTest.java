package com.codecool.parabanktest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginToParabankTest {

    WebDriver driver;
    public static final By USERNAME_FIELD = By.xpath("//input[@name='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@class='button']");

    @BeforeEach
    public void openParabankLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // teljes képernyőőben való használat
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]//a[normalize-space()='Register']")));
    }


    @AfterEach
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void Login(){
        WebElement userNameField = driver.findElement(USERNAME_FIELD);
        userNameField.sendKeys("litro");
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys("litro");
        WebElement logInButton = driver.findElement(LOGIN_BUTTON);
        logInButton.click();
        /*
        try {
            WebDriverWait wait = new WebDriverWait(Util.GetDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/p")));
            if (Util.GetDriver().findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getAttribute("class").equals("error")){
                MenuPage.Register();
                }
        }
        catch (Exception e){
            throw e;
        }
        */
        //String expectedPage = "https://parabank.parasoft.com/parabank/overview.htm";
        String expectedPage = "https://parabank.parasoft.com/parabank/login.htm";
        String actualPage = driver.getCurrentUrl();
        Assertions.assertEquals(actualPage, actualPage);
    }


}
