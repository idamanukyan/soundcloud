package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends BaseTest {

    @Test
    public void testValidSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.submitSearch("Rammstein");

        String expectedUrl = "https://soundcloud.com/search?q=rammstein";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
