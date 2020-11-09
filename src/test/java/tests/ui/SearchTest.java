package tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.landing.MainPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    MainPage mainPage;

    @BeforeMethod
    public void initTest() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void searchResultContainsIphoneOnlyTest() {
        LOG.info("Test -> performed search contains results with iPhone in each");
        String iPhone = "iPhone";
        assertTrue(mainPage
                .searchFor(iPhone)
                .verifyEachSearchResultContainsValue(iPhone));
    }

    @Test
    public void searchResultContainsSamsungOnlyTest() {
        LOG.info("Test -> performed search contains results with Samsung in each");
        String samsung = "Samsung";
        assertTrue(mainPage
                .searchFor(samsung)
                .verifyEachSearchResultContainsValue(samsung));

    }
}
