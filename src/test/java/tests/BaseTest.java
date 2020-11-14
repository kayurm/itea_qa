package test.java.tests;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.PropertyLoader;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Logger LOG = LogManager.getLogger(this.getClass().getSimpleName());

    public void driverSetup(){

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);

        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/edge/v86/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        driver=new EdgeDriver(edgeOptions);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertyLoader.loadProperty("url"));
    }

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driverSetup();
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(ITestContext iTestContext) {
        //new test.java.utils.Screenshot(driver).takeScreenshot(testResult);
        driver.quit();
    }
}
