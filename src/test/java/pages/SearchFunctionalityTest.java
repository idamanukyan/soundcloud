package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestListener;

/**
 * This class contains tests to validate the search functionality of the SoundCloud website.
 * It extends the BaseTest class, which provides the setup and driver initialization.
 */
@Listeners(TestListener.class)
public class SearchFunctionalityTest extends BaseTest {

    /**
     * Test case to verify a valid search query.
     * It navigates to the home page, submits a search query for "Rammstein",
     * and asserts that the URL of the search results page matches the expected URL.
     */
    @Test
    public void testValidSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");
        String expectedUrl = "https://soundcloud.com/search?q=Rammstein";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
