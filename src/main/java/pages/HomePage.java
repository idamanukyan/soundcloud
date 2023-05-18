package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(Locators.SEARCH_INPUT);
    private By searchButton = By.cssSelector(Locators.SEARCH_BUTTON_SUBMIT);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public HomePage clickSearchButton() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        button.click();
        return new HomePage(driver);
    }

    public void submitSearch(String query) {
        enterSearchQuery(query);
        clickSearchButton();
    }
}
