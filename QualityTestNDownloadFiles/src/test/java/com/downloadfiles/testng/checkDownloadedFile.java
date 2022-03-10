package com.downloadfiles.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class checkDownloadedFile {

    private WebDriver driver;
    By txtDownloadLocator = By.xpath("//a[@href='download/some-file.txt']");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/download");
    }

    @Test
    public void checkDownloadedFile() throws MalformedURLException, IOException {
        String link = driver.findElement(txtDownloadLocator).getAttribute("href");

        HttpURLConnection httpConnection = (HttpURLConnection)(new URL(link).openConnection());
        httpConnection.setRequestMethod("HEAD");
        httpConnection.connect();

        String contentType = httpConnection.getContentType();
        int contentLength = httpConnection.getContentLength();

        System.out.println("Content Type: " + contentType);

        System.out.println("Content Length: " + contentLength);

        assertEquals(contentType, "application/octet-stream");

        assertNotEquals(contentLength, 0);

    }

    @AfterClass
    public void afterClass() {

    }

}
