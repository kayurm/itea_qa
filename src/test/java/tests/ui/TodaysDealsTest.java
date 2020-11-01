package tests.ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.landing.MainPage;

public class TodaysDealsTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void initTest(){
        mainPage = new MainPage(driver);
    }

    @Test
    public void pricesTest(){
        LOG.info("Testing prices");
        float[] prices = mainPage.openTodaysDeals().getMinMaxPrice(1);
        System.out.println("Min price: "+ prices[0]);
        System.out.println("Max price: "+ prices[0]);
    }
}
