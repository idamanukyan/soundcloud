package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackPage extends BasePage {

    private final By playButtonSelector = By.cssSelector(Locators.PLAY_BUTTON);
    private final By pauseButtonSelector = By.cssSelector(Locators.PAUSE_BUTTON);


    private By shareButtonSelector = By.cssSelector(".trackPage__shareButton");
    private By shareLinkSelector = By.cssSelector(".shareDialog__copyLink input");
    private By shortenedLinkSelector = By.cssSelector(".shareDialog__shortenedLink");
    private By embeddedSectionSelector = By.cssSelector(".trackPage__embedSection");


    public TrackPage(WebDriver driver) {
        super(driver);
    }

    public String getShareLink() {
        WebElement shareButton = driver.findElement(shareButtonSelector);
        shareButton.click();

        WebElement shareLinkElement = driver.findElement(shareLinkSelector);
        return shareLinkElement.getAttribute("value");
    }

    public String getShortenedLink() {
        WebElement shortenedLinkElement = driver.findElement(shortenedLinkSelector);
        return shortenedLinkElement.getText();
    }

    public String getEmbeddedSection() {
        WebElement embeddedSectionElement = driver.findElement(embeddedSectionSelector);
        return embeddedSectionElement.getText();
    }

    public void playTrack() {
        click(playButtonSelector);
    }

    public boolean isPlayerDisplayed() {
        return driver.findElement(playButtonSelector).isDisplayed();
    }

    public boolean isPauseButtonVisible() {
        return driver.findElement(pauseButtonSelector).isDisplayed();
    }

}
