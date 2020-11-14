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
    public void simpleFailingTest() {
        LOG.error("(ERROR log level testing) Simple dummy test which always fails");
        driver.getCurrentUrl();
        assertEquals(driver.getCurrentUrl(), "www.google.com");
    }

    @Test(dataProvider = "dummyProvider")
    public void someFailingTestsWithDataProvider(int num) {
        LOG.warn("(WARN log level testing) Dummy tests with the data provider-two of them should fail and be retried");
        assertEquals(num, 2);
    }

    @Test
    public void positiveTest() {
        LOG.info("Simple dummy test which always passes");
        assertTrue(true);
    }
}
