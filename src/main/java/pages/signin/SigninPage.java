package pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

import static org.testng.Assert.assertTrue;

public class SigninPage extends BasePage {

    private final By signInLabel = By.xpath("//h1[contains(text(),'Sign-In')]");
    private final By createAmazonAccountButton = By.id("createAccountSubmit");

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    public By getSignInLabel() {
        return signInLabel;
    }

    public CreateAccountPage clickCreateAmazonAccount(){
        LOG.info("Create account method");
        WebElement createAccElem = driver.findElement(createAmazonAccountButton);
        LOG.debug("Asserting create account button is present");
        assertTrue(createAccElem.isDisplayed());
        LOG.debug("Clicking create account button");
        createAccElem.click();
        CreateAccountPage createAccPage = new CreateAccountPage(driver);
        LOG.debug("Asserting create account page is opened");
        assertTrue(driver.findElement(createAccPage.getCreateAccountLabel())
                .isDisplayed());
        return createAccPage;

    }
}
