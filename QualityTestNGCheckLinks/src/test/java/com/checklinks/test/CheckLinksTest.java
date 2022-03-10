package com.checklinks.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckLinksTest {

    private WebDriver driver;
    CheckingLinkPage page;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        page = new CheckingLinkPage(driver);
        driver.manage().window().maximize();
        //driver.get("https://demo.guru99.com/test/newtours/");
        //driver.get("https://admisiones.unal.edu.co/posgrado/");
        driver.get("http://www.pamplonita-nortedesantander.gov.co/");
    }

    @Test
    public void checkLinksTest() {
        assertTrue(page.checkinPageLinks(), "There are broken links");
    }

    @AfterClass
    public void afterClass() {
        driver.close();

    }


}
