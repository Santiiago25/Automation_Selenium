package com.qualitystream.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AutomatedTestMercuryTours {

    private WebDriver driver;
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/banner2.gif']");
    By registerNameLocator = By.id("email");
    By registerPassLocator = By.name("password");
    By registerConfirPassLocator = By.name("confirmPassword");
    By submitLocator = By.name("submit");

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By enterLocator = By.name("submit");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); //creamos la instancia de chrome
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000); //temporizador
        if (driver.findElement(registerPageLocator).isDisplayed()){
            driver.findElement(registerNameLocator).sendKeys("ktocora");
            driver.findElement(registerPassLocator).sendKeys("123456");
            driver.findElement(registerConfirPassLocator).sendKeys("123456");
            driver.findElement(submitLocator).click();
        }else {
            System.out.println("Registro no exitoso!");
        }

        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is ktocora.",fonts.get(5).getText());
    }

    @Test
    public void sigIn(){
        if (driver.findElement(userLocator).isDisplayed()) {
            driver.findElement(userLocator).sendKeys("ktocora");
            driver.findElement(passLocator).sendKeys("123456");
            driver.findElement(enterLocator).click();

            List<WebElement> fontss = driver.findElements(By.tagName("font"));
            assertEquals("Thank you for Loggin.", fontss.get(3).getText());
        }else{
            System.out.println("El usuario no esta registrado");
        }

    }

}
