package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Base {

    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/banner2.gif']");
    By registerNameLocator = By.id("email");
    By registerPassLocator = By.name("password");
    By registerConfirPassLocator = By.name("confirmPassword");
    By submitLocator = By.name("submit");

    By registerMessage = By.tagName("font");

    public RegisterPage(WebDriver driver) { //creamos el constructor
        super(driver);
    }

    public void registerUser() throws InterruptedException {
        click(registerLinkLocator); //usamos el metodo
        Thread.sleep(2000);
        if (isdDisplayed(registerPageLocator)){ //verificamos que si estemos en la pagina correcta
            type("ktocora", registerNameLocator);
            type("123456",registerPassLocator);
            type("123456",registerConfirPassLocator);

            click(submitLocator); //btn de la pagina
        }else {
            System.out.println("Registro de la pagina no fue encontrado");
        }

    }

    public String registeredMessage(){ //el mensaje de que fue registrado
        List<WebElement> fonts = findElements(registerMessage);
        return getText(fonts.get(5));
    }

}
