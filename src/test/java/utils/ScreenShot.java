package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShot {

    private final String delimiter = System.getProperty("os.name").toLowerCase().contains("windows")? "\\":"/";
    private WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(ITestResult testResult){

        TakesScreenshot scr = (TakesScreenshot) driver;
        File source = scr.getScreenshotAs(OutputType.FILE);
        Path currentPath = Paths.get(""); //path to the current project
        try {
            FileUtils.copyFile(source, new File(
                    currentPath.toAbsolutePath().toString()
                    + delimiter + "screenshot"
                    + delimiter + testResult.getTestClass().getName().replace(".", delimiter)
                    + delimiter + testResult.getMethod().getConstructorOrMethod().getName()
                    + ".png"
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
