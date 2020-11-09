package pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import static org.testng.Assert.*;

public class CreateAccountPage extends BasePage {

    private final By createAccountLabel = By.cssSelector(".a-spacing-small");
    private final By createYourAmazonAccountButton = By.xpath("//input[@type='submit']");
    private final By nameField = By.name("customerName");
    private final By nameFieldValidationError = By.xpath("//div[contains(text(),'Enter your name')]");
    private final By emailField = By.name("email");
    private final By emailFieldValidationError = By.xpath("//div[contains(text(),'Enter your email')]");
    private final By passwordField = By.name("password");
    private final By passwordFieldValidationError = By.xpath("//div[contains(text(),'Enter your password')]");
    private final By reenterPasswordField = By.name("passwordCheck");
    private final By reenterPasswordFieldValidationError = By.xpath("//div[contains(text(),'Type your password again')]");
    WebDriverWait wait;


    public CreateAccountPage (WebDriver driver) {
        super(driver);
         wait = new WebDriverWait(driver, 60);
    }

    public By getCreateAccountLabel() {
        return createAccountLabel;
    }

    public CreateAccountPage clickCreateYourAmazonAccount(){
        LOG.info("Click create your amazon account");
        driver.findElement(createYourAmazonAccountButton).click();
        return this;
    }

    public CreateAccountPage fillFieldsAndClickCreate(String name, String email, String password, String reenterPassword){
        LOG.info("Fill fields and click create");
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(reenterPasswordField).sendKeys(reenterPassword);
        driver.findElement(createYourAmazonAccountButton).click();
        return this;
    }

    //this method is used in the next public validate methods
    private void validateField(WebElement fieldIn, WebElement fieldValidationMessage, String valueIn){
        if (valueIn.equals("")){
            LOG.debug("Field was left empty, validating red frame and the error message");
            assertEquals(fieldIn
                    .getCssValue("border-top-color"),
                    "rgba(209, 85, 33, 1)",
                    "Expected red frame but found some other color");
            assertTrue(fieldValidationMessage.isDisplayed());
        }else{
            LOG.debug("Field was filled, validating no red frame and no error message appeared");
            assertEquals(
                    fieldIn.getCssValue("border-top-color"),
                    "rgba(148, 148, 148, 1)",
                    "Expected black frame but found some other color");
            assertFalse(fieldValidationMessage.isDisplayed());
        }
    }

    public CreateAccountPage validateNameField(String name){
        LOG.info("Validate name field");
        validateField(
                driver.findElement(nameField),
                driver.findElement(nameFieldValidationError),
                name);
        return this;
    }
    public CreateAccountPage validateEmailField(String email){
        LOG.info("Validate email field");
        validateField(
                driver.findElement(emailField),
                driver.findElement(emailFieldValidationError),
                email);
        return this;
    }

    public CreateAccountPage validatePasswordField(String password){
        LOG.info("Validate password field");
        validateField(
                driver.findElement(passwordField),
                driver.findElement(passwordFieldValidationError),
                password);
        return this;
    }

    public CreateAccountPage validateReenterPasswordField(String reenterPassword){
        LOG.info("Validate reenter password field");
        validateField(
                driver.findElement(reenterPasswordField),
                driver.findElement(reenterPasswordFieldValidationError),
                reenterPassword);
        return this;
    }
}
