package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    public void click(WebElement element){
        System.out.println("Clicking: "+element.getText());
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        System.out.println("Typeing: "+text);
        element.sendKeys(text);
    }

    public void sendKeysAndPressEnter(WebElement element, String text){
        System.out.println("Typing: "+text);
        element.sendKeys(text);
        actions.keyDown(Keys.ENTER).perform();
    }

    public void clear(WebElement element){
        System.out.println("Clearing: "+element);
        element.clear();
    }

    public void waitToBeVisible(WebElement element){
        System.out.println("Waiting to be visiblie: "+element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(WebElement element){
        System.out.println("Waiting to be clickable: "+element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
