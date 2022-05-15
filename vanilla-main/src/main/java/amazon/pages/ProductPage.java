package amazon.pages;

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


}
