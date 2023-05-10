package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static setup.DriverUtils.driver;

public class WaitHelper {
    private static Duration DURATION;

    private WaitHelper() {
    }

    public static WaitHelper getInstance(int seconds) {
        DURATION = Duration.ofSeconds(seconds);
        return new WaitHelper();
    }

    public WebElement waitForElementToBeClickable(By location) {
        try {
            return new WebDriverWait(driver, DURATION).
                    until(ExpectedConditions.elementToBeClickable(location));
        } catch (WebDriverException ignored) {
            throw new Error(location + " " + ELEMENT_NOT_FOUND.getMessage());
        }
    }

    public List<WebElement> waitForElementsToBeVisible(By location) {
        try {
            return new WebDriverWait(driver, DURATION).
                    until(ExpectedConditions.visibilityOfAllElementsLocatedBy(location));
        } catch (WebDriverException ignored) {
            throw new Error(location + " " + ELEMENT_NOT_FOUND.getMessage());
        }
    }

    public WebElement waitForElementToBeVisible(By location) {
        try {
            return new WebDriverWait(driver, DURATION).
                    until(ExpectedConditions.visibilityOfElementLocated(location));
        } catch (WebDriverException ignored) {
            throw new Error(location + " " + ELEMENT_NOT_FOUND.getMessage());
        }
    }

    public void waitForSeconds() {
        try {
            Thread.sleep(DURATION.getSeconds());
        } catch (Exception e) {
            throw new Error("Wait crashed");
        }
    }

}
