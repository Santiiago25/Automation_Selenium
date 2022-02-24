package com.qualityframework.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestNGDataProvider {

    private WebDriver driver;

    By sigInLocator = By.xpath("//a[@class = 'login']");
    By userLocator = By.xpath("//input[@id = 'email']");
    By passLocator = By.xpath("//input[@id = 'passwd']");

    By btnSignInLocator = By.xpath("//button[@class = 'button btn btn-default button-medium']");

    By signOutLocator = By.xpath("//a[@class = 'logout']");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(dataProvider = "authenticationData")
    public void login(String email, String password){

        if (driver.findElement(sigInLocator).isDisplayed()){
            driver.findElement(sigInLocator).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(userLocator));

            driver.findElement(userLocator).sendKeys(email);
            driver.findElement(passLocator).sendKeys(password);
            driver.findElement(btnSignInLocator).click();

            assertEquals(driver.findElement(signOutLocator).getText(), "Sign out");

            driver.findElement(signOutLocator).click();
        }else {
            System.out.println("Sign in link is not present");
        }

    }

    @DataProvider(name = "authenticationData")
    public Object[][] getData() {
        Object[][]data = new Object[2][2];

        data[0][0] = "qs123@gmail.com";
        data[0][1] = "qs123";
        data[1][0] = "testng_qs@gmail.com";
        data[1][1] = "qs123";

        return data;
    }

    @AfterClass
    public void afterClass() {
        //driver.close();

    }

}
