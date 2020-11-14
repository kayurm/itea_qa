package main.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger LOG = LogManager.getLogger(this.getClass().getSimpleName());

    public BasePage(WebDriver driver){
        this.driver = driver;
         wait = new WebDriverWait(driver,3,300);
    }

    public boolean isDisplayed(By selector) {
        try {
            return driver.findElement(selector).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public BasePage clickIfDisplayed(By selector){
        if (isDisplayed(selector)) driver.findElement(selector).click();
        else LOG.info("no such element: "+selector);
        return this;
    }
}
