package com.testngreports.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestNGReportsChifonDresses {

    WebDriver driver;

    By searchBoxLocator = By.xpath("//input[@id = 'search_query_top']");
    By resultTextLocator = By.cssSelector("span.heading-counter");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void searchChifonDresses() {
        WebElement searchBox = driver.findElement(searchBoxLocator);

        searchBox.clear();
        searchBox.sendKeys("Chiffon Dresses");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultTextLocator));

        System.out.println("This is the result number: " + driver.findElement(resultTextLocator).getText());

        assertEquals(driver.findElement(resultTextLocator).getText(), "2 results have been found.");

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
