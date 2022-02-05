package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SigInTest {
    private WebDriver driver;
    SigInPage sigInPage;

    @Before
    public void setUp() throws Exception{
        sigInPage = new SigInPage(driver);
        driver = sigInPage.chromeDriverConnection();
        sigInPage.visit("https://demo.guru99.com/test/newtours/");

    }

    @After
    public void tearDown() throws Exception{
        //driver.quit();
    }

    @Test
    public void test() throws Exception{
        sigInPage.signIn();
        Thread.sleep(2000);
        assertEquals("Thank you for Loggin.",sigInPage.isHomePage());
    }

}
