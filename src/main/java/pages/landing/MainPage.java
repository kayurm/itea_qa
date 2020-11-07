package pages.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.signin.SigninPage;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class MainPage extends Header {

    private final By dealsAndPromotionsLabel = By.xpath("//b[text()='Deals and Promotions']");
    private final By firstDealPrice = By
            .xpath("//div[@id='100_dealView_0']//span[@class='gb-font-size-medium inlineBlock unitLineHeight dealPriceText']']");
    private final By searchField = By.id("twotabsearchtextbox");
    private final By allSearchResults = By.className("a-size-medium a-color-base a-text-normal'");
    WebElement element;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openTodaysDeals() {
        clickIfDisplayed(todaysDealsButton);
        assertTrue(driver.findElement(dealsAndPromotionsLabel).isDisplayed());
        return this;
    }

    public float[] getMinMaxPrice(int dealNumber) {
        float minPrice = 0;
        float maxPrice = 0;
        if (dealNumber == 1) {
            String[] prices = isDisplayed(firstDealPrice) ?
                    driver.findElement(firstDealPrice).getText().split("-")
                    : null;
            if (prices != null) {
                minPrice = Float.parseFloat(prices[0].replace("$", "").trim());
                maxPrice = Float.parseFloat(prices[0].replace("$", "").trim());
            }
        } else {
            LOG.info("Only first deal price is implemented");
        }
        return new float[]{minPrice, maxPrice};
    }

    public SigninPage openSigninPage(){
        LOG.info("Open sign in page");
        SigninPage signInPage = new SigninPage(driver);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(helloSingInMenu))
                .click()
                .build()
                .perform();
        assertTrue(driver.findElement(signInPage.getSignInLabel())
                .isDisplayed());
        return signInPage;
    }

    public MainPage searchFor(String searchValue){
        LOG.info("Searching for: "+searchValue);
        element = driver.findElement(searchField);
        element.sendKeys(searchValue);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean verifySearchResultContainsValue(String value){
        LOG.info("Verifying that returned search result contains value: "+value);
        List<WebElement> searchResult = driver.findElements(allSearchResults);
        for (WebElement result:searchResult) {
            if (!result.getText().contains(value)) return false;
        }
        return true;
    }


}

