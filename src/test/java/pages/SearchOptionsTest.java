package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchOptionsTest extends BaseTest {

    @Test
    public void testSearchOptionEverything() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Everything");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Everything"));
        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
    }

    @Test
    public void testSearchOptionTracks() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Tracks");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Tracks"));
        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
    }

    @Test
    public void testSearchOptionAlbums() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Albums");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Albums"));
        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
    }

    @Test
    public void testSearchOptionPlaylists() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectSearchOption("Playlists");
        Assert.assertTrue(searchPage.isSearchOptionSelected("Playlists"));
        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
    }
}
