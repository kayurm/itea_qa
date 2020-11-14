package test.java.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class Listener implements ISuiteListener, ITestListener, IInvokedMethodListener {
    WebDriver driver;
    private Logger LOG = LogManager.getLogger("Listeners");

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void onStart(ISuite iSuite) {
    }

    @Override
    public void onFinish(ISuite iSuite) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.warn("Test failed!!! Taking screen shot...");
        driver = (WebDriver) (iTestResult.getTestContext().getAttribute("driver"));
        new Screenshot(driver).takeScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
