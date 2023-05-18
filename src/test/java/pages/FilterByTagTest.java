package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByTagTest extends BaseTest {

    @Test
    public void testFilterByTag() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.filterResultsByTag("rock");
        Assert.assertTrue(searchPage.areSearchResultsFilteredByTag("rock"));
    }

}
