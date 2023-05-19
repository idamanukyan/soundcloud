package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestListener;

/**
 * This class contains test cases for filtering search results by tag.
 */
@Listeners(TestListener.class)
public class FilterByTagTest extends BaseTest {

    /**
     * Tests the filtering of search results by tag.
     * It navigates to the homepage, performs a search, filters the results by tag,
     * and asserts that the filtered results have the expected tag.
     */

    @Test
    public void testFilterByTag() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.filterResultsByTag("rock");
        Assert.assertEquals(searchPage.getTag(), "Rock");
    }

}
