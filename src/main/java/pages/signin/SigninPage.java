package pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

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
        Assert.assertTrue(driver.findElement(createAmazonAccountButton).isDisplayed());
        driver.findElement(createAmazonAccountButton).click();
        CreateAccountPage createAccPage = new CreateAccountPage(driver);
        Assert.assertTrue(driver.findElement(createAccPage.getCreateAccountLabel()).isDisplayed());
        return createAccPage;

    }
}
