package pages;

import constants.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackPage extends BasePage {

    private final By playButton = By.cssSelector(Locators.PLAY_BUTTON);
    private final By pauseButton = By.cssSelector(Locators.PAUSE_BUTTON);


    private final By shareButton = By.cssSelector(Locators.SHARE_BUTTON);
    private final By shareLinkSelector = By.cssSelector(".shareDialog__copyLink input");
    private final By shortenedButton = By.cssSelector(Locators.SHORTENED_LINK);
    private final By embeddedButton = By.cssSelector(Locators.EMBEDDED_SECTION);


    public TrackPage(WebDriver driver) {
        super(driver);
    }

    public String getShareLink() {
        click(shareButton);
        WebElement shareLinkElement = driver.findElement(shareLinkSelector);
        return shareLinkElement.getAttribute("value");
    }

    public String getShortenedLink() {
        click(shortenedButton);
        return shortenedButton.findElement(driver).getText();
    }

    public String getEmbeddedSection() {
        click(embeddedButton);
        return embeddedButton.findElement(driver).getText();
    }

    public void playTrack() {
        click(playButton);
    }

    public boolean isPlayerDisplayed() {
        return driver.findElement(playButton).isDisplayed();
    }

    public boolean isPauseButtonVisible() {
        return driver.findElement(pauseButton).isDisplayed();
    }

}
