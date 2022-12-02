package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends PageBase {
    public SearchResults(WebDriver driver) {
        super(driver);
    }

    List<String> resultsList1 = new ArrayList<String>();
    List<String> resultsList2 = new ArrayList<String>();
    int iterator = 1;

    @FindBy(css = ".gsc-cursor-page")
    private List<WebElement> pagination;

    @FindBy(css = ".gsc-wrapper")
    private WebElement listOfResults;

    @FindBy(css = "[title='Wyczyść wyniki']")
    private WebElement clearResultsBtn;

    @FindBy(css = "tr > .gsc-input > input")
    private WebElement searchInput;

    public List<WebElement> getPagination() {
        return pagination;
    }

    public WebElement getListOfResults() {
        return listOfResults;
    }

    public WebElement getClearResultsBtn() {
        return clearResultsBtn;
    }

    public void urlShouldContainQuery() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/wyniki-wyszukiwania?q=test"));
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public void searchInputShouldBeTest() {
        Assert.assertEquals(searchInput.getAttribute("value"), "test");
    }

    public void searchInputShouldBeEmpty() {
        Assert.assertEquals(searchInput.getAttribute("value"), "");
    }

    public void resultsAreDisplayed() {
//        List<WebElement> results = driver.findElements(By.cssSelector("a.gs-title"));
//        Assert.assertTrue(results.size()>0);
        Assert.assertEquals(driver.findElement(By.cssSelector(".gsc-results-wrapper-nooverlay")).getAttribute("style"), "");
    }

    public void resultsAreEmpty() {
        Assert.assertEquals(driver.findElement(By.cssSelector(".gsc-results-wrapper-nooverlay")).getAttribute("style"), "display: none;");
    }

    public void clearSearchWithX() {
        ((JavascriptExecutor) driver).executeScript("document.querySelector('span.gsc-clear-button',':before').click();");
    }

    public void saveResultsOnList() {
        List<WebElement> results = driver.findElements(By.cssSelector("a.gs-title"));
        if (iterator == 1) {
            for (WebElement el : results) {
                resultsList1.add(el.getText());
            }
            System.out.println(resultsList1);
        } else if (iterator == 2) {
            for (WebElement el : results) {
                resultsList2.add(el.getText());
            }
            System.out.println(resultsList2);
        }
        iterator++;
    }

    public void listComparison() {
        Assert.assertNotEquals(resultsList1, resultsList2);
    }


}
