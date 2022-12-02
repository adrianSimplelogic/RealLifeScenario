package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesModal extends PageBase {
    public CookiesModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#hs-eu-cookie-confirmation-button-group > a#hs-eu-confirmation-button")
    private WebElement acceptBtn;

    public WebElement getAcceptBtn() {
        return acceptBtn;
    }

}
