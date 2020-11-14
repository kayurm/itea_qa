package main.java.pages.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import main.java.pages.signin.SigninPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class MainPage extends main.java.pages.landing.Header {

    private final By dealsAndPromotionsLabel = By.xpath("//b[text()='Deals and Promotions']");
    private final By firstDealPrice = By
            .xpath("//div[@id='100_dealView_0']//span[@class='gb-font-size-medium inlineBlock unitLineHeight dealPriceText']']");
    private final By searchField = By.id("twotabsearchtextbox");
    private final By searchResultListBy = By.className("a-size-medium a-color-base a-text-normal'");
    private final By brandFilterListBy = By.xpath("//li[(contains(@id, 'p_89'))]");
    private By seeMoreFilters = By.xpath("//ul[@aria-labelledby='p_89-title']//span[text()='See more']");
    private String brandFilterValueWildString = "//span[text()='%s']";
    private WebElement elem;


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

    public SigninPage openSigninPage() {
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

    public MainPage searchFor(String searchValue) {
        LOG.info("Searching for: " + searchValue);
        elem = driver.findElement(searchField);
        elem.sendKeys(searchValue);
        elem.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean verifyEachSearchResultContainsValue(String value) {
        LOG.info("Verifying that returned search result contains value: " + value);
        List<WebElement> searchResult = driver.findElements(searchResultListBy);
        for (WebElement result : searchResult) {
            if (!result.getText().contains(value)) return false;
        }
        return true;
    }

    //private - helper
    private By defineFilterLocator(String filterType) {
        LOG.info("Defying filter's locator by filter type: " + filterType);
        By filterValuesLocator = null;
        switch (filterType.toLowerCase()) {
            case "brand":
                filterValuesLocator = brandFilterListBy;
                break;
            case "avg. customer review":
                LOG.warn("Filter 'by avg. customer review''s locator not yet defined!!");
            default:
                LOG.warn("This locator not yet defined - filter by type: " + filterType);
        }
        return filterValuesLocator;
    }

    //for the dataProvider
    public List<String> getFilterValues(String filterType) {
        LOG.info("Getting all filter values for the filter: " + filterType);
        List<String> filterValuesList = new ArrayList<>();

        driver.findElements(defineFilterLocator(filterType)).forEach(
                t -> filterValuesList.add(t.getAttribute("aria-label")));


        return filterValuesList;
    }


    public MainPage setFilterBy(String filterValue) {
        LOG.info("Setting filter by value: " + filterValue);

        //first expand the list to all the filters become visible
        elem=driver.findElement(seeMoreFilters);
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();

        //then set the filter
        driver.findElement(
                By.xpath(String.format(
                        brandFilterValueWildString, filterValue)))
                .click();
        return this;
    }
}

