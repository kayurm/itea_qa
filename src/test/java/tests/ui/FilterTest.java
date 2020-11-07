package tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.landing.MainPage;

import java.util.Arrays;
import java.util.List;

public class FilterTest extends BaseTest{

    private MainPage mainPage;

    @BeforeMethod
    public void initTest(){
        mainPage = new MainPage(driver);
    }

    @DataProvider(name = "provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Dell"},
                {"Asus"},
                {"Toshiba"},
                {"HP"},
                {"Acer"}
        };
    }

    @Test(dataProvider = "provider")
    public void verifyNotebookFilterTest(String brand) {
        LOG.info("Test -> notebook filters verification");
    }


}
