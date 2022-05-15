package amazon.pages;

import amazon.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
    private Helpers helpers;

    private By aboutThisItemText = By.xpath("//*[@class='a-size-base-plus a-text-bold']");
    private By aboutThisItemDetail = By.xpath("//*[@class='a-size-base-plus a-text-bold']//following-sibling::*[@class='a-unordered-list a-vertical a-spacing-mini']");


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    public boolean aboutThisItemIsDisplayed() {
        return helpers.doIsDisplayed(aboutThisItemText);
    }

    public String aboutThisItemDetailContent() {
        return helpers.getElement(aboutThisItemDetail).getText();

    }

}
