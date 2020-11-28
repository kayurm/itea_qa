package test.java.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.landing.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LaptopPickRandomBrandTest extends BaseTest{

    private MainPage mainPage;
    private List<String> brandList;
    private String searchValue = "laptop";
    private String filterType = "Brand";

    @BeforeClass
    public void getFilterValues() {
        driverSetup();
        mainPage = new MainPage(driver);

        LOG.debug("Getting the filter's list of values, for the data provider");
        brandList = mainPage
                .searchFor(searchValue)
                .getFilterValues(filterType);
        driver.close();
    }

    @BeforeMethod
    public void initTest() {
        mainPage = new MainPage(driver);
    }

    @Description("Set filter by a random laptop brand" +
            " and verify search result contains only that brand")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyLaptopFilterTest() {
        LOG.info("Test -> notebook filters verification");
        int max=brandList.size()-1;
        int rand = (int)(Math.random() * (max + 1));
        String brand = brandList.get(rand);

        assertTrue(mainPage
                .searchFor(searchValue)
                .setFilterBy(brand)
                .verifyEachSearchResultContainsValue(brand));
    }
}
