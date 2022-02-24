package com.qualityframework.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class TestNGExample {

    //anotaciones del TestNG
    //Las precondiciones van a empezar con @before
    //Las pruebas van a tener la condición @test
    // Las poscondiciones que comienzan con @after
    //siguen un orden logico

    private WebDriver driver;

    By searchBoxLocator = By.xpath("//input[@id='search_query_top']");
    By resultBlouseLocator = By.xpath("//span[@class = 'heading-counter' ]");

    @Test
    public void searchBlouseTest() {
        WebElement searchaBox = driver.findElement(searchBoxLocator);
        searchaBox.clear(); // para limpiar cualquier texto que este escrito
        searchaBox.sendKeys("blouse");
        searchaBox.submit();

        //Creamos una espera
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultBlouseLocator));

        //enviamos texto a la consola
        System.out.println("This is the result number: " + driver.findElement(resultBlouseLocator).getText());

        assertTrue("El resultado no esta presente", driver.findElement(resultBlouseLocator).isDisplayed());

    }
    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeTest
    public void beforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }

    @BeforeSuite
    public void beforeSuite() {

    }

    @AfterSuite
    public void afterSuite() {

    }

}
