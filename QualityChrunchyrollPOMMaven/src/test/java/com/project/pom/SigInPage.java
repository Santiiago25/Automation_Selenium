package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SigInPage extends Base{

    By userLocator = By.id("login_form_name");
    By passLocator = By.name("login_form[password]");
    By btnIniLocator = By.id("login_submit_button");

    By mangaLocator = By.xpath("//a[@class = 'erc-logo state-scalable']");

    public SigInPage(WebDriver driver) {
        super(driver);
    }


    public void signIn(){
        if (isDisplayed(userLocator)){
            type("kevintocora_3d@hotmail.com",userLocator);
            type("tocora25",passLocator);

            click(btnIniLocator);
        }else {
            System.out.println("Clave o Usuario incorrecto");
        }
    }

    public WebElement isHomePage(){
        WebElement manga = findElement(mangaLocator);
        return manga;
    }


}
