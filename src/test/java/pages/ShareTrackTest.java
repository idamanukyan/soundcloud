package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareTrackTest extends BaseTest {

    @Test
    public void testShareTrack() {
        HomePage homePage = new HomePage(driver);
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

    private boolean isValidShortenedLink(String link) {
        return link != null && link.startsWith("https://shortened-link.com");
    }
}
