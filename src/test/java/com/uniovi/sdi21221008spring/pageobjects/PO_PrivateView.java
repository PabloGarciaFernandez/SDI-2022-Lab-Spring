package com.uniovi.sdi21221008spring.pageobjects;

import com.uniovi.sdi21221008spring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public int countNumberOfMarks(WebDriver driver, String xpath){
        List<WebElement> markList = SeleniumUtils.waitLoadElementsBy(driver, "free", xpath, PO_View.getTimeout());
        return markList.size();
    }

    static public void clickMarkDetails(WebDriver driver, String xpath){
        By enlace = By.xpath(xpath);
        driver.findElement(enlace).click();
    }

    static public void openNavOption(WebDriver driver, String xpath, int position){
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", xpath);
        elements.get(position).click();
    }
}
