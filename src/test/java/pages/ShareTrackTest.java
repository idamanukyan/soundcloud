package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestListener;

/**
 * This class represents a test for sharing a track on the SoundCloud web application.
 * <p>
 * It extends the BaseTest class to inherit the common setup and driver initialization.
 */
@Listeners(TestListener.class)
public class ShareTrackTest extends BaseTest {
    /**
     * Test method to verify the functionality of sharing a track.
     * <p>
     * It performs the following steps:
     * <p>
     * Navigates to the homepage using the getHomePage() method of the HomePage class.
     * Submits a search query for "Rammstein" using the submitSearch() method of the HomePage class.
     * Creates an instance of the SearchPage class, passing the driver instance.
     * Clicks on the first track in the search results using the clickFirstTrack() method of the SearchPage class.
     * Retrieves the share link, shortened link, and embedded section using respective methods of the TrackPage class.
     * Performs assertions to verify that the share link is not null, the shortened link is valid, and the embedded section is not null.
     */
    @Test
    public void testShareTrack() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        TrackPage trackPage = searchPage.clickFirstTrack();

        String shareLink = trackPage.getShareLink();
        String shortenedLink = trackPage.getShortenedLink();
        String embeddedSection = trackPage.getEmbeddedSection();

        Assert.assertNotNull(shareLink, "Share link is null");
        Assert.assertTrue(isValidShortenedLink(shortenedLink), "Shortened link is not valid");
        Assert.assertNotNull(embeddedSection, "Embedded section is null");
    }

    /**
     * Helper method to check if the shortened link is valid.
     * It verifies that the link is not null and starts with the expected prefix "https://on.soundcloud.com/".
     *
     * @param link The shortened link to validate.
     * @return True if the link is valid, false otherwise.
     */
    private boolean isValidShortenedLink(String link) {
        return link != null && link.startsWith("https://on.soundcloud.com/");
    }
}
