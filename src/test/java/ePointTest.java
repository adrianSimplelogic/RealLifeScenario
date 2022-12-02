import base.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ePointTest extends Pages {

    @Test
    public void ePointScenario(){
        Assert.assertEquals(driver.getTitle(),"Strona główna | e-point SA");
        cookiesModal.click(cookiesModal.getAcceptBtn());
        headerMenu.click(headerMenu.getSearchIcon());
        headerMenu.modalShouldBeDisplayed();
        headerMenu.sendKeysAndPressEnter(headerMenu.getQueryInput(), "test");
        searchResults.urlShouldContainQuery();
        searchResults.searchInputShouldBeTest();
        searchResults.waitToBeVisible(searchResults.getListOfResults());
        searchResults.resultsAreDisplayed();
        searchResults.saveResultsOnList();
        searchResults.click(searchResults.getPagination().get(1));
        searchResults.waitToBeVisible(searchResults.getListOfResults());
        searchResults.searchInputShouldBeTest();
        searchResults.resultsAreDisplayed();
        searchResults.saveResultsOnList();
        searchResults.listComparison();
        searchResults.clearSearchWithX();
        searchResults.resultsAreEmpty();
        searchResults.searchInputShouldBeEmpty();
    }

}
