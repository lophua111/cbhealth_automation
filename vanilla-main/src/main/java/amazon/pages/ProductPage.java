package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.cyberneko.html.HTMLElements.getElement;

public class ProductPage {

    private WebDriver driver;

    private By allMenu = By.id("nav-hamburger-menu");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doClickOnCheckbox(String item) {
        driver.findElement(By.xpath("//*[@class='a-link-normal' and normalize-space()='" + item + "']")).click();
    }
}
