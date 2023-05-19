package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    private final By tracksButton = By.xpath(Locators.TRACKS_BUTTON);
    private final By filterByTagButton = By.xpath(Locators.TAG_BUTTON);
    private final By searchResultsSelector = By.xpath(Locators.RESULT_LIST);//jnj
    private final By tagOfTrack = By.xpath(Locators.TAG_OF_TRACK);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectSearchOption(String option) {
        WebElement optionElement = driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]"));
        optionElement.click();
    }

    public boolean isSearchOptionSelected(String option) {
        WebElement selectedOptionElement = driver.findElement(By.cssSelector(".searchResultsHeader__options .sc-button-selected"));
        return selectedOptionElement.getText().equals(option);
    }

    public boolean areSearchResultsDisplayed() {
        return driver.findElements(searchResultsSelector).size() > 0;
    }

    public void filterResultsByTag(String tag) {
        click(tracksButton);
        click(filterByTagButton);
    }

    public String getTag() {
        final WebElement element = tagOfTrack.findElement(driver);
        return element.getText();
    }

    public TrackPage clickFirstTrack() {
        WebElement firstTrack = driver.findElement(searchResultsSelector);
        firstTrack.click();
        return new TrackPage(driver);
    }
}
