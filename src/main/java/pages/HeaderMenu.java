package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HeaderMenu extends PageBase {
    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".search-icon")
    private WebElement searchIcon;

    @FindBy(css = ".solr-search-modal")
    private  WebElement searchModal;

    @FindBy(css = "#query")
    private  WebElement queryInput;

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getQueryInput() {
        return queryInput;
    }

    public WebElement getSearchModal() {
        return searchModal;
    }

    public void modalShouldBeDisplayed(){
        Assert.assertTrue(getSearchModal().isDisplayed());
    }

}
