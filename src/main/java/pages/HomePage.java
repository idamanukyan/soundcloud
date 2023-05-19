package pages;

import constants.locators.Locators;
import constants.urls.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private By searchInput = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/div[1]/span/span/form/input");
    private By searchButton = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/div[1]/span/span/form/button");
    private By acceptButton = By.id("onetrust-accept-btn-handler");

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
    public void getHomePage(String url){
        driver.get(url);
        click(acceptButton);
    }

    public void submitSearch(String query) {
        writeText(searchInput, query);
        click(searchButton);
    }
}
