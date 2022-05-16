package amazon.pages;

import amazon.constants.Constants;
import amazon.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;
    private Helpers helpers;

    private By allMenu = By.id("nav-hamburger-menu");


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);

    }

    public String getLandingTitle() {
        return driver.getTitle();
    }

    public void doClickAllMenu() {
        helpers.clickElementWhenReady(allMenu, Constants.DEFAULT_TIME_OUT);
    }

    public void doClickAllMenuItem(String item) {
        helpers.clickElementWhenReady(By.xpath("//*[@id='hmenu-content']//*[contains(text(), '" + item + "')]"), Constants.DEFAULT_TIME_OUT);
    }
}
