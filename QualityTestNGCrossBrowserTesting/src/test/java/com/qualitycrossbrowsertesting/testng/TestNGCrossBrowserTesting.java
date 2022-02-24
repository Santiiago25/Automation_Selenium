package com.qualitycrossbrowsertesting.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestNGCrossBrowserTesting {

    private WebDriver driver;

    By searchBoxLocator = By.name("q");
    By videoLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=tAGnKpE4NCI']");
    By metallicaLocator = By.cssSelector("h2[class='qrShPb kno-ecr-pt PZPZlf q8U8x']");

    @BeforeClass
    @Parameters({"URL", "BrowserType"})
    public void beforeClass(String url, String browsertype){

        if (browsertype.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browsertype.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","./src/main/resources/firefoxdriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browsertype.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","./src/main/resources/edgedriver/msedgedriver.exe");
            driver = new EdgeDriver();
        } //else if (browsertype.equalsIgnoreCase("Internet Explorer")){
            //System.setProperty("webdriver.ie.driver","./src/main/resources/iexplorerdriver/IEDriverServer.exe");
            //driver = new InternetExplorerDriver();
        //}

        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("Opening: " + browsertype);
    }

    @Test
    public void searchGoogle(){

        WebElement searchBoxElement = driver.findElement(searchBoxLocator);
        searchBoxElement.clear();
        searchBoxElement.sendKeys("metallica");
        searchBoxElement.submit();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator));

        assertTrue(driver.findElement(videoLocator).isDisplayed());
        //assertEquals(driver.findElement(metallicaLocator).getText(),"Metallica");

    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }



}
