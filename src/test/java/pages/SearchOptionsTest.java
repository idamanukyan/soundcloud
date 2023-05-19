package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestListener;

/**
 * This class represents a test suite for testing the search options functionality on the SoundCloud web application.
 * <p>
 * It extends the BaseTest class to inherit the common setup and driver initialization.
 */

@Listeners(TestListener.class)
public class SearchOptionsTest extends BaseTest {


    /**
     * Test method to verify the functionality of selecting the "Everything" search option.
     * <p>
     * It performs the following steps:
     * <p>
     * Navigates to the homepage using the getHomePage() method of the HomePage class.
     * Submits a search query for "Rammstein" using the submitSearch() method of the HomePage class.
     * Creates an instance of the SearchPage class, passing the driver instance.
     * Selects the "Everything" search option using the selectSearchOption() method of the SearchPage class.
     * Performs an assertion to verify that the "Everything" search option is selected using the isSearchOptionSelected() method of the SearchPage class.
     */
    @Test
    public void testSearchOptionEverything() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Everything");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Everything"));
    }

    /**
     * Test method to verify the functionality of selecting the "Tracks" search option.
     * It performs similar steps as the testSearchOptionEverything() method but selects the "Tracks" search option.
     */
    @Test
    public void testSearchOptionTracks() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Tracks");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Tracks"));
    }

    /**
     * Test method to verify the functionality of selecting the "Albums" search option.
     * It performs similar steps as the testSearchOptionEverything() method but selects the "Albums" search option.
     */
    @Test
    public void testSearchOptionAlbums() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Albums");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Albums"));
    }

    /**
     * Test method to verify the functionality of selecting the "Playlists" search option.
     * It performs similar steps as the testSearchOptionEverything() method but selects the "Playlists" search option.
     */
    @Test
    public void testSearchOptionPlaylists() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Playlists");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Playlists"));
    }
}
