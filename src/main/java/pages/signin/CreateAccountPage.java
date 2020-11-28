package main.java.pages.signin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.java.pages.BasePage;

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
         wait = new WebDriverWait(driver, 5);
    }

    public By getCreateAccountLabel() {
        return createAccountLabel;
    }

    @Step("Click Create accout")
    public CreateAccountPage clickCreateYourAmazonAccount(){
        LOG.info("Click create your amazon account");
        driver.findElement(createYourAmazonAccountButton).click();
        return this;
    }

    @Step("Fill fields and submit")
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
    private void validateField(WebElement fieldIn, WebElement fieldValidationMessage, String valueIn) throws InterruptedException {
        if (valueIn.equals("")){
            LOG.debug("Field was left empty, validating red frame and the error message");

            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(fieldIn),
                    (d) -> fieldIn.getCssValue("border-top-color").equals("rgba(221, 0, 0, 1)")
            ));
            assertEquals(fieldIn
                    .getCssValue("border-top-color"),
                    "rgba(221, 0, 0, 1)",
                    "Expected red frame but found some other color");
            assertTrue(fieldValidationMessage.isDisplayed());
        }else{
            LOG.debug("Field was filled, validating no red frame and no error message appeared");
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(fieldIn),
                    (d) -> fieldIn.getCssValue("border-top-color").equals("rgba(148, 148, 148, 1)")
            ));
            assertEquals(
                    fieldIn.getCssValue("border-top-color"),
                    "rgba(148, 148, 148, 1)",
                    "Expected black frame but found some other color");
            assertFalse(fieldValidationMessage.isDisplayed());
        }
    }

    @Step("Validate field Name")
    public CreateAccountPage validateNameField(String name) throws InterruptedException {
        LOG.info("Validate name field");
        validateField(
                driver.findElement(nameField),
                driver.findElement(nameFieldValidationError),
                name);
        return this;
    }

    @Step("Validate field Email")
    public CreateAccountPage validateEmailField(String email) throws InterruptedException {
        LOG.info("Validate email field");
        validateField(
                driver.findElement(emailField),
                driver.findElement(emailFieldValidationError),
                email);
        return this;
    }

    @Step("Validate field Password")
    public CreateAccountPage validatePasswordField(String password) throws InterruptedException {
        LOG.info("Validate password field");
        validateField(
                driver.findElement(passwordField),
                driver.findElement(passwordFieldValidationError),
                password);
        return this;
    }

    @Step("Validate field reenter Password")
    public CreateAccountPage validateReenterPasswordField(String reenterPassword) throws InterruptedException {
        LOG.info("Validate reenter password field");
        validateField(
                driver.findElement(reenterPasswordField),
                driver.findElement(reenterPasswordFieldValidationError),
                reenterPassword);
        return this;
    }
}
