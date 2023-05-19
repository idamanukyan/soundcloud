package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;

/**
 * This class serves as the base test class for setting up and tearing down the WebDriver instance.
 * It provides common setup and teardown methods that can be inherited by other test classes.
 */
public class BaseTest {

    /**
     * The WebDriver instance used for test execution.
     */
    protected WebDriver driver;

    /**
     * Setup method that initializes the WebDriver instance.
     * It creates a new ChromeDriver, sets implicit wait to 5 seconds, and maximizes the browser window.
     */
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    /**
     * Teardown method that closes the WebDriver instance.
     * It checks if the driver is not null and then quits the browser window.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
