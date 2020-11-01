package pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

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


    public CreateAccountPage (WebDriver driver) {
        super(driver);
    }

    public By getCreateAccountLabel() {
        return createAccountLabel;
    }

    public CreateAccountPage clickCreateYourAmazonAccount(){
        driver.findElement(createYourAmazonAccountButton).click();
        return this;
    }

    public CreateAccountPage fillFieldsAndClickCreate(String name, String email, String password, String reenterPassword){

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(reenterPasswordField).sendKeys(reenterPassword);
        driver.findElement(createYourAmazonAccountButton).click();
        return this;
    }

    public CreateAccountPage validateNameField(String name){
        if (name.equals("")){
            Assert.assertEquals(driver.findElement(nameField)
                    .getCssValue("boarder-color"), "#d00");
            Assert.assertTrue(driver.findElement(nameFieldValidationError).isDisplayed());
        }else{
            Assert.assertEquals(driver.findElement(nameField)
                    .getCssValue("boarder-color"), "");
            Assert.assertFalse(driver.findElement(nameFieldValidationError).isDisplayed());
        }
        return this;
    }
    public CreateAccountPage validateEmailField(String email){

        if (email.equals("")){
            Assert.assertEquals(driver.findElement(emailField)
                    .getCssValue("boarder-color"), "#d00");
            Assert.assertTrue(driver.findElement(emailFieldValidationError).isDisplayed());
        }else{
            Assert.assertEquals(driver.findElement(emailField)
                    .getCssValue("boarder-color"), "");
            Assert.assertFalse(driver.findElement(emailFieldValidationError).isDisplayed());
        }
        return this;
    }

    public CreateAccountPage validatePasswordField(String password){

        if (password.equals("")){
            Assert.assertEquals(driver.findElement(passwordField)
                    .getCssValue("boarder-color"), "#d00");
            Assert.assertTrue(driver.findElement(passwordFieldValidationError).isDisplayed());
        }else{
            Assert.assertEquals(driver.findElement(passwordField)
                    .getCssValue("boarder-color"), "");
            Assert.assertFalse(driver.findElement(passwordFieldValidationError).isDisplayed());
        }
        return this;
    }

    public CreateAccountPage validateReenterPasswordField(String reenterPassword){

        if (reenterPassword.equals("")){
            Assert.assertEquals(driver.findElement(reenterPasswordField)
                    .getCssValue("boarder-color"), "#d00");
            Assert.assertTrue(driver.findElement(reenterPasswordFieldValidationError).isDisplayed());
        }else{
            Assert.assertEquals(driver.findElement(reenterPasswordField)
                    .getCssValue("boarder-color"), "");
            Assert.assertFalse(driver.findElement(reenterPasswordFieldValidationError).isDisplayed());
        }
        return this;
    }
}
