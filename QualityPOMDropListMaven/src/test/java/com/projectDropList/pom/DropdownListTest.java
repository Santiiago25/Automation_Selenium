package com.projectDropList.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DropdownListTest {

    private WebDriver driver;
    DropdownList ddlPage;

    @Before
    public void setUp() throws Exception{
        ddlPage = new DropdownList(driver);
        driver = ddlPage.chromeDriverConnection();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void testingClassicDDL() throws Exception{
        ddlPage.visit("https://demo.guru99.com/test/newtours/");
        ddlPage.sigIn();
        ddlPage.flightsSelect();
        assertEquals(ddlPage.selectDropdownListPassengers(), "4");
        assertEquals(ddlPage.selectDropdownListDepartingFrom(), "Paris");
        assertEquals(ddlPage.selectDropdownListMonth(),"April");
        assertEquals(ddlPage.selectDropdownListDay(),"25");
        assertEquals(ddlPage.selectDropdownListArriving(),"New York");
        assertEquals(ddlPage.selectDropdownListReturningM(),"September");
        assertEquals(ddlPage.selectDropdownListReturningD(),"5");
    }

    @Test
    public void testingReacDDL() throws Exception{
        ddlPage.visit("https://react-bootstrap.github.io/components/dropdowns/");
        ddlPage.selectReactDropdownList();
    }

}
