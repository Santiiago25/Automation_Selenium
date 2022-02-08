package com.projectExcel.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTestingSWDTest {
    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;
    private By searchBoxLocator = By.xpath("//input[@class = 'search_query form-control ac_input']");
    private By btnLocator = By.xpath("//button[@class = 'btn btn-default button-search']");
    private By resultTextLocator = By.xpath("//span[@class = 'heading-counter']");

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); //instancia del objeto
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();

        driver.get("http://automationpractice.com/index.php");

    }

    @After
    public void tearDown() throws Exception{
        //driver.quit();

    }

    @Test
    public void test() throws Exception{

        String filepath = "./src/main/resources/DataInjection/Test.xlsx";

        String searchText = readFile.getCellValue(filepath,  "Hoja1", 2, 0);

        driver.findElement(searchBoxLocator).sendKeys(searchText);
        driver.findElement(btnLocator).click();
        String resultText = driver.findElement(resultTextLocator).getText();

        System.out.println("Page result text: " + resultText);

        readFile.readExcel(filepath, "Hoja1");
        writeFile.writeCellValue(filepath,"Hoja1",2,1, resultText);

        readFile.readExcel(filepath,"Hoja1");

    }
}
