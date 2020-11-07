package tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final Logger LOG = LogManager.getLogger(this.getClass().getSimpleName());

    @BeforeMethod
    public void setUp() {
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
        driver.get("https://amazon.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
