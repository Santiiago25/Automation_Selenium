package com.qualityframework.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestNGDataProviderTwitter {

    private WebDriver driver;

    By logInLocator = By.xpath("//a[@href='/login']");
    By emailLocator = By.xpath("//input[@name = 'text']");
    By btnNextEmailLocator = By.xpath("//div[@class = 'css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']");

    By passwordLocator = By.xpath("//input[@name = 'password']");
    By signInLocator = By.xpath("//div[@class = 'css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com/?logout=1645386740677");
    }

    @Test(dataProvider = "authenticationData")
    public void testTwitter(String email, String password) {

        if (driver.findElement(logInLocator).isDisplayed()){

            driver.findElement(logInLocator).click();

            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(btnNextEmailLocator).click();

            driver.findElement(passwordLocator).sendKeys(password);
            driver.findElement(signInLocator).click();


        }else{
            System.out.println("No entro");
        }

    }

    @DataProvider(name = "authenticationData")
    public Object[][] getData(){
        Object[][] data = new Object[2][2];

        data[0][0] = "kevinelpapi_3d@hotmail.com";
        data[0][1] = "";

        return data;
    }

    @AfterClass
    public void afterClass() {

    }

}
