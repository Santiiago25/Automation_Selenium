package com.quality.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearh {

    private WebDriver driver;

    //anotaciones de Junit
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.co/");
    }

    @Test
    public void testGooglePage(){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Inteligencia Artificial");//enviamos el texto
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //tiempo para que traiga los resultados de busqueda
        assertEquals("Inteligencia Artificial - Buscar con Google", driver.getTitle());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
