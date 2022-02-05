package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SigInPage extends Base{

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By enterLocator = By.name("submit");

    By registerMessage = By.tagName("font");

    public SigInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(){
        if (isdDisplayed(userLocator)){
            type("ktocora", userLocator);
            type("123456",passLocator);

            click(enterLocator);
        }else{
            System.out.println("Usuario no registrado");
        }
    }

    public String isHomePage(){
        List<WebElement> fontss = findElements(registerMessage);
        return getText(fontss.get(3));
    }


}
