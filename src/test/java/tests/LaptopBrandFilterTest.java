package test.java.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main.java.pages.landing.MainPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LaptopBrandFilterTest extends BaseTest {

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

    @DataProvider(name = "brandsProvider")
    public Object[][] dataProvider() {
        Object[][] result = new Object[brandList.size()][1];
        for (int i = 0; i < brandList.size(); i++) {
            result[i][0] = brandList.get(i);
        }
        return result;
    }

    @Test(dataProvider = "brandsProvider")
    public void verifyLaptopFilterTest(String brand) {
        LOG.info("Test -> notebook filters verification");

        assertTrue(mainPage
                .searchFor(searchValue)
                .setFilterBy(brand)
                .verifyEachSearchResultContainsValue(brand));
    }
}
