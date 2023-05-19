package pages;

import constants.urls.Links;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends BaseTest {

    @BeforeClass
    public void getDriver(){
        setUp();
    }

    @Test
    public void testValidSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.getHomePage(Links.BASE_PAGE);
        homePage.submitSearch("Rammstein");
        String expectedUrl = "https://soundcloud.com/search?q=Rammstein";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
