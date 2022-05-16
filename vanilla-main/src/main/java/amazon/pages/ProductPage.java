package amazon.pages;

import amazon.constants.Constants;
import amazon.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.cyberneko.html.HTMLElements.getElement;

public class ProductPage {

    private WebDriver driver;
    private Helpers helpers;

    private By productDropDown = By.id("a-autoid-0-announce");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }


    public void doClickOnCheckbox(String item) {
        helpers.doClick(By.xpath("//*[@class='a-link-normal' and normalize-space()='" + item + "']"));
    }

    public void doSelectValueFromProductDropDown(String value) {
        helpers.doClick(productDropDown);
        helpers.clickElementWhenReady(By.xpath("//*[@role='option']//*[contains(text(), '" + value + "')]"), Constants.DEFAULT_TIME_OUT);
    }

    public void doClickOnSecondHighestPricedItem() {
        helpers.getElements(By.xpath("//*[@class='a-price-whole']")).get(1).click();
    }


}
