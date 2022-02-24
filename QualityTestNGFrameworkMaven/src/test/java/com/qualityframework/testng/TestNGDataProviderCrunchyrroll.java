package com.qualityframework.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestNGDataProviderCrunchyrroll {

    private WebDriver driver;

    By emailLocator = By.xpath("//input[@id = 'login_form_name']");
    By passwordLocator = By.xpath("//input[@id = 'login_form_password']");
    By btnLoginLocator = By.xpath("//button[@id = 'login_submit_button']");

    By mangaLocator = By.xpath("//span[@class = 'c-text c-text--l']");

    By dropDownListLocator = By.xpath("//div[@id='content']/div/div[1]/div[1]/div[3]/ul/li[4]/div/div[1]");
    By desconectLocator = By.xpath("//a[@href = 'https://crunchyroll.com/es/logout']");
    By recaptchaLocator = By.xpath("//div[@class = 'recaptcha-checkbox-checkmark']");



    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.crunchyroll.com/es/login?next=%2Fes");
    }

    @Test(dataProvider = "authenticationData")
    public void testLoginCrunchyrroll(String email, String password) {

        if (driver.findElement(emailLocator).isDisplayed()){

            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(passwordLocator).sendKeys(password);
            driver.findElement(recaptchaLocator).click();
            driver.findElement(btnLoginLocator).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(mangaLocator));

            assertEquals(driver.findElement(mangaLocator).getText(), "Manga");

            driver.findElement(dropDownListLocator).click();
            driver.findElement(desconectLocator).click();

        }else{
            System.out.println("No entro");

        }


    }


    @DataProvider(name = "authenticationData")
    public Object[][] getData(){
        Object[][]data = new Object[2][2];

        data[0][0] = "kevintocora_3d@hotmail.com";
        data[0][1] = "";

        data[1][0] = "castrovilla-@hotmail.com";
        data[1][1] = "";

        return data;
    }

    @AfterClass
    public void afterClass() {

    }


}
