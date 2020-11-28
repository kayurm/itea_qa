package test.java.tests;


import io.qameta.allure.Attachment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;
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
//
//        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/edge/v86/msedgedriver.exe");
//        EdgeOptions edgeOptions = new EdgeOptions();
//        driver=new EdgeDriver(edgeOptions);

        //FOR SELENIUM GRID
        //ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions ffOptions = new FirefoxOptions();
        try {
            //driver = new RemoteWebDriver(new URL("http://ec2-3-250-219-25.eu-west-1.compute.amazonaws.com:4444/wd/hub"), ffOptions);
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), ffOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

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
        attachText();
        attachScreen();
        driver.quit();
    }

    @Attachment
    private String attachText() {
        return "Attached text";
    }

    @Attachment
    private byte[] attachScreen() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
