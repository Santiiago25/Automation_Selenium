package com.downloadfiles.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class downloadFiles {

    private WebDriver driver;
    private String downloadFilePath = "C:\\Users\\Santiago Tocora\\Desktop\\TEST";

    By txtDownloadLocator = By.xpath("//a[@href='download/some-file.txt']");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0); //funciona parecido a un arreglo
        chromePrefs.put("download.default_directory", downloadFilePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options); //esto es para descargar el fichero directamente

    }

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(txtDownloadLocator).click();
        Thread.sleep(2000);

        File folder = new File(downloadFilePath);

        File[] lisofFiles = folder.listFiles();

        assertTrue(lisofFiles.length>0,"File not downloaded correctly");
    }

    @AfterClass
    public void afterClass() {

    }

}
