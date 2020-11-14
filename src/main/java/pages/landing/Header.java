package main.java.pages.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import main.java.pages.BasePage;

public abstract class Header extends BasePage {

    protected final By todaysDealsButton = By.xpath("//a[text()=\"Today's Deals\"]");
    protected final By helloSingInMenu = By.xpath("//span[text()='Hello, Sign in']");
    protected final By signInButton = By.xpath("//span[@class='nav-action-inner' and contains(text(),'Sign in')]");

    public Header(WebDriver driver) {
        super(driver);
    }

}
