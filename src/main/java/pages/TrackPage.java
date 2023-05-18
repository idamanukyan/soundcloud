package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackPage extends BasePage {

    private By shareButtonSelector = By.cssSelector(".trackPage__shareButton");
    private By shareLinkSelector = By.cssSelector(".shareDialog__copyLink input");
    private By shortenedLinkSelector = By.cssSelector(".shareDialog__shortenedLink");
    private By embeddedSectionSelector = By.cssSelector(".trackPage__embedSection");
    private By playerSelector = By.cssSelector(".player");
    private By playButtonSelector = By.cssSelector(".player__playButton");
    private By pauseButtonSelector = By.cssSelector(".player__pauseButton");
    private By shuffleButtonSelector = By.cssSelector(".player__shuffleButton");

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

    public void playFirstSong() {
        WebElement playButton = driver.findElement(playButtonSelector);
        playButton.click();
    }

    public boolean isPlayerDisplayed() {
        return driver.findElement(playerSelector).isDisplayed();
    }

    public boolean isPlayButtonVisible() {
        return driver.findElement(playButtonSelector).isDisplayed();
    }

    public boolean isPauseButtonVisible() {
        return driver.findElement(pauseButtonSelector).isDisplayed();
    }

    public boolean isShuffleButtonVisible() {
        return driver.findElement(shuffleButtonSelector).isDisplayed();
    }
}
