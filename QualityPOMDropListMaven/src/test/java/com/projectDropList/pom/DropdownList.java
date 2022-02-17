package com.projectDropList.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownList extends Base{

    //dropdownList clásico
    By dropdownListPassengers = By.name("passCount");
    By dropdownListDepartingFrom = By.name("fromPort");
    By dropdownListMonth = By.name("fromMonth");
    By dropdownListDay = By.name("fromDay");
    By dropdownListArrivingIn = By.name("toPort");
    By dropdownListReturning = By.name("toMonth");
    By dropdownListReturningDay = By.name("toDay");

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");

    By flightsLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
    By flightsVerifyLocator = By.xpath("//img[@src='images/mast_flightfinder.gif']");

    public DropdownList(WebDriver driver) {
        super(driver);
    }

    public void sigIn() {
        if (isDisplayed(userLocator)){
            //explicitWait("Welcome: Mercury Tours");
            fluentWait(userLocator);
            type("ktocora", userLocator);
            type("123456", passLocator);
            click(signInBtnLocator);
        }else {
            System.out.println("username textbox was not present");
        }
    }

    public void flightsSelect(){
        click(flightsLocator);
        explicitWait("Find a Flight: Mercury Tours:");
    }


    public String selectDropdownListPassengers(){ //primera forma de automatizar un dropList
        WebElement dropdownList = findElement(dropdownListPassengers);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (getText(options.get(i)).equals("4")){
                click(options.get(i));
            }
        }

        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected())
                selectedOption = getText(options.get(i));
        }

        return selectedOption;
    }

    public String selectDropdownListDepartingFrom(){ //segunda forma de automatizar un dropList
        Select selectList = new Select(findElement(dropdownListDepartingFrom));
        selectList.selectByVisibleText("Paris");
        return getText(selectList.getFirstSelectedOption());
    }

    public String selectDropdownListMonth(){
        Select selectListM = new Select(findElement(dropdownListMonth));
        selectListM.selectByVisibleText("April");
        return getText(selectListM.getFirstSelectedOption());
    }

    public String selectDropdownListDay(){
        Select selectListD = new Select(findElement(dropdownListDay));
        selectListD.selectByVisibleText("25");
        return getText(selectListD.getFirstSelectedOption());
    }

    public String selectDropdownListArriving(){
        Select select = new Select(findElement(dropdownListArrivingIn));
        select.selectByVisibleText("New York");
        return getText(select.getFirstSelectedOption());
    }

    public String selectDropdownListReturningM(){
        Select select = new Select(findElement(dropdownListReturning));
        select.selectByVisibleText("September");
        return getText(select.getFirstSelectedOption());
    }

    public String selectDropdownListReturningD(){
        Select select = new Select(findElement(dropdownListReturningDay));
        select.selectByVisibleText("5");
        return getText(select.getFirstSelectedOption());
    }

    //DropdownList Boostrap React
    By DropdownListBtn = By.xpath("//button[@id='dropdown-basic']");
    By option2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href = '#/action-2']");

    public void selectReactDropdownList() throws InterruptedException {
        click(DropdownListBtn);
        Thread.sleep(3000);
        click(option2);
    }


}
