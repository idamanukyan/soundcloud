package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    private final By tracksButton = By.xpath(Locators.TRACKS_BUTTON);
    private final By everythingButton = By.xpath(Locators.EVERYTHING_BUTTON);
    private final By albumsButton = By.xpath(Locators.ALBUMS_BUTTON);
    private final By playlistsButton = By.xpath(Locators.PLAYLISTS_BUTTON);
    private final By filterByTagButton = By.xpath(Locators.TAG_BUTTON);
    private final By tagOfTrack = By.xpath(Locators.TAG_OF_TRACK);
    private final By firstTrack = By.xpath(Locators.FIRST_TRACK);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectSearchOption(String option) {
        WebElement optionElement = driver.findElement(everythingButton);
        if (option.equalsIgnoreCase("tracks")) {
            optionElement = driver.findElement(tracksButton);
        } else if (option.equalsIgnoreCase("albums")) {
            optionElement = driver.findElement(albumsButton);
        } else if (option.equalsIgnoreCase("playlists")) {
            optionElement = driver.findElement(playlistsButton);
        }
        optionElement.click();
    }

    public boolean isSearchOptionSelected(String option) {
        WebElement selectedOptionElement
                = driver.findElement(By.cssSelector(".searchResultsHeader__options .sc-button-selected"));
        return selectedOptionElement.getText().equals(option);
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
        click(firstTrack);
        return new TrackPage(driver);
    }
}
