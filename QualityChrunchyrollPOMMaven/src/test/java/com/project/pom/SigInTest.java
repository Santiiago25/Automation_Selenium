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
        sigInPage.visit("https://www.crunchyroll.com/es/login?next=%2Fes");
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void test() throws Exception{
        sigInPage.signIn();
        Thread.sleep(2000);
        sigInPage.isHomePage().isDisplayed();

        }

}
