package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;

    private By allMenu = By.id("nav-hamburger-menu");


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLandingTitle() {
        return driver.getTitle();
    }

    public void doClickAllMenu () {
        driver.findElement(allMenu).click();
    }

    public void doClickAllMenuItem(String item) {
        driver.findElement(By.xpath("//*[@id='hmenu-content']//*[contains(text(), '" + item + "')]")).click();
    }
}
