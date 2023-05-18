package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    private By searchOptionSelector = By.cssSelector(".searchResultsHeader__options .sc-button");
    private By searchResultsSelector = By.cssSelector(".searchResult");

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
        WebElement tagElement = driver.findElement(By.xpath("//a[@title='" + tag + "']"));
        tagElement.click();
    }

    public boolean areSearchResultsFilteredByTag(String tag) {
        List<WebElement> results = driver.findElements(searchResultsSelector);
        for (WebElement result : results) {
            String resultTags = result.getAttribute("data-tags");
            if (!resultTags.contains(tag)) {
                return false;
            }
        }
        return true;
    }

    public TrackPage clickFirstTrack() {
        WebElement firstTrack = driver.findElement(searchResultsSelector);
        firstTrack.click();
        return new TrackPage(driver);
    }
}
