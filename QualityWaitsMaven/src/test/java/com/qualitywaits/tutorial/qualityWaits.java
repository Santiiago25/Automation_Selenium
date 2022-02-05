package com.qualitywaits.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class qualityWaits {

    private WebDriver driver;
    By PagAwsLocator = By.cssSelector("a[href='https://es.wikipedia.org/wiki/Inteligencia_artificial']");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.co/");

    }

    @After
    public void tearDown() throws Exception {
        //

    }

    @Test
    public void test(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Inteligencia Artificial");
        searchBox.submit();

        //Explicit wait
        //WebDriverWait ewait = new WebDriverWait(driver,10); //creamos el objeto
        //ewait.until(ExpectedConditions.titleContains("Inteligencia")); //condicion por la cual estamos esperando

        //assertEquals("Inteligencia Artificial - Buscar con Google", driver.getTitle());

        //FluentWait
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS) //que su tiempo de espera maximo es de 10 segundos
                .pollingEvery(2, TimeUnit.SECONDS) //que realice consultas a la pagina cada 2 segundos
                .ignoring(NoSuchElementException.class); //ignore la excepcion NoSuchElementException

        WebElement pag = fwait.until(new Function<WebDriver,WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(PagAwsLocator);
            }
        });

        assertTrue(driver.findElement(PagAwsLocator).isDisplayed());

    }

}
