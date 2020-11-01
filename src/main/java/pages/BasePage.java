package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {

    protected WebDriver driver;
    protected final Logger LOG = LogManager.getLogger(this.getClass().getSimpleName());

    public BasePage(WebDriver driver){
        this.driver = driver;
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
