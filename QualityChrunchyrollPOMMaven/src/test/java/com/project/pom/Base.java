package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver){ //constructor
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){ //Conexión e instancia del driver
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); //instancia del objeto
        return driver;
    }

    public WebElement findElement(By locator){ //creacion del envoltorio, Wrapping o Wrapper
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){ //metodo para tipear
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

}
