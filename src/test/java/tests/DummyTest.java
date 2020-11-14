package test.java.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DummyTest extends BaseTest{

    @DataProvider(name = "dummyProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test
    public void failingTestWithScreenshot() {
        driver.getCurrentUrl();
        assertEquals(driver.getCurrentUrl(), "www.google.com");
    }

    @Test(dataProvider = "dummyProvider")
    public void failingTestWithDataProvider(int num) {
        assertEquals(num, 0);
    }

    @Test
    public void positiveTest() {
        assertTrue(true);
    }
}
