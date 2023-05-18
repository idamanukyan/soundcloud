package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayTrackTest extends BaseTest {
    @Test
    public void testPlayFirstSong() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        TrackPage trackPage = searchPage.clickFirstTrack();

        trackPage.playFirstSong();

        Assert.assertTrue(trackPage.isPlayerDisplayed(), "Player is not displayed");
        Assert.assertTrue(trackPage.isPlayButtonVisible(), "Play button is not visible");
        Assert.assertTrue(trackPage.isPauseButtonVisible(), "Pause button is not visible");
        Assert.assertTrue(trackPage.isShuffleButtonVisible(), "Shuffle button is not visible");

        // Add more assertions for other player buttons and functionality
    }
}
