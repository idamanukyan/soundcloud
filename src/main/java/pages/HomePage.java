package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchInput = By.xpath(Locators.SEARCH_INPUT);
    private final By searchButton = By.xpath(Locators.SEARCH_BUTTON_SUBMIT);
    private final By acceptButton = By.id(Locators.ACCEPT_BUTTON);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getHomePage(String url) {
        driver.get(url);
        click(acceptButton);
    }

    public void submitSearch(String query) {
        writeText(searchInput, query);
        click(searchButton);
    }
}
