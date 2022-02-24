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

public class TestNGDataProviderHotmail {

    private WebDriver driver;

    By signInLocator = By.xpath("//a[@data-task='signin']");

    By emailLocator = By.xpath("//input[@name = 'loginfmt']");
    By nextLocator = By.xpath("//input[@id = 'idSIButton9']");

    By passwordLocator = By.xpath("//input[@name = 'passwd']");
    By iniSeLocator = By.xpath("//input[@class = 'win-button button_primary button ext-button primary ext-primary']");

    By btnN1Locator = By.xpath("//input[@id = 'KmsiCheckboxField']");
    By btnN2Locator = By.xpath("//input[@id = 'idBtn_Back']");

    By textInputLocator = By.xpath("//span[@class = 'ms-Button-label uHWG8PYRNYDO2895_TmUG label-175']");

    By btnProfileLocator = By.xpath("//div[@id= 'mectrl_headerPicture']");
    By closeSesionLocator = By.xpath("//a[@id= 'mectrl_body_signOut']");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://outlook.live.com/owa/");
    }

    @Test(dataProvider = "athenticationData")
    public void testHotmail(String email, String password) {

        if (driver.findElement(signInLocator).isDisplayed()){

            WebDriverWait wait1 = new WebDriverWait(driver,10);
            wait1.until(ExpectedConditions.presenceOfElementLocated(signInLocator));

            driver.findElement(signInLocator).click(); //input

            driver.findElement(emailLocator).sendKeys(email); //type email
            driver.findElement(nextLocator).click();

            driver.findElement(passwordLocator).sendKeys(password);
            driver.findElement(iniSeLocator).click();

            driver.findElement(btnN1Locator).click();
            driver.findElement(btnN2Locator).click();

            WebDriverWait wait = new WebDriverWait(driver,10);

            assertEquals(driver.findElement(textInputLocator), "Mensaje nuevo");

            driver.findElement(btnProfileLocator).click();
            driver.findElement(closeSesionLocator).click();


        }else {
            System.out.println("Inicio de sesion incorrecto");

        }

    }

    @DataProvider(name = "athenticationData")
    public Object[][] getData(){
        Object[][] data = new Object[2][2];

        data[0][0] = "kevintocora_3d@hotmail.com";
        data[0][1] = "";

        data[1][0] = "kevinelpapi_3d@hotmail.com";
        data[1][1] = "";

        return data;
    }

    @AfterClass
    public void afterClass() {

    }


}
