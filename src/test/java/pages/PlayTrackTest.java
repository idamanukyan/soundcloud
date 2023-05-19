package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class represents a test case for playing the first song on the application.
 * <p>
 * It extends the BaseTest class to inherit the common setup and driver initialization.
 */
public class PlayTrackTest extends BaseTest {

    /**
     * The setup method that runs once before the test class.
     * It initializes the driver using the setUp() method from the BaseTest class.
     */
    @BeforeClass
    public void getDriver() {
        setUp();
    }

    /**
     * Test method to verify playing the first song functionality.
     * It performs the following steps:
     * Navigates to the homepage using the getHomePage() method of the HomePage class.
     * Submits a search query for "Rammstein" using the submitSearch() method of the HomePage class.
     * Creates an instance of the SearchPage class, passing the driver instance.
     * Clicks on the first track in the search results by calling the clickFirstTrack() method of the SearchPage class.
     * Plays the track by calling the playTrack() method of the TrackPage class.
     * Performs assertions to verify that the player is displayed and the pause button is visible on the TrackPage.
     */
    @Test
    public void testPlayFirstSong() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        TrackPage trackPage = searchPage.clickFirstTrack();

        trackPage.playTrack();

        Assert.assertTrue(trackPage.isPlayerDisplayed(), "Player is not displayed");
        Assert.assertTrue(trackPage.isPauseButtonVisible(), "Pause button is not visible");
    }
}
