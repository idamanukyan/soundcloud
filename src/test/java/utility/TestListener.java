package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import pages.BaseTest;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }

    private void captureScreenshot(ITestResult result) {
        // Get the driver instance from the test result
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        // Take screenshot and save it to a file
        String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
        String filePath = "src/screenshots/" + fileName;
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            File screenshotFile = new File(filePath);
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Attach the screenshot to the test report
        Reporter.log("<br><b><font color='red'>Screenshot of failure:</font></b><br>");
        Reporter.log("<a href='" + filePath + "'> <img src='" + filePath + "' height='100' width='100'/> </a>");
    }
}
