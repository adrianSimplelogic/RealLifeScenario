package base;

import org.testng.annotations.BeforeMethod;
import pages.CookiesModal;
import pages.HeaderMenu;
import pages.SearchResults;

public class Pages extends TestBase{

    public CookiesModal cookiesModal;
    public HeaderMenu headerMenu;
    public SearchResults searchResults;

    @BeforeMethod
    public void pagesSetup(){
        cookiesModal = new CookiesModal(driver);
        headerMenu = new HeaderMenu(driver);
        searchResults = new SearchResults(driver);
    }

}
