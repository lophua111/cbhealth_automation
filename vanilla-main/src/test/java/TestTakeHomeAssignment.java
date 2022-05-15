import amazon.config.EnvFactory;
import amazon.constants.Constants;
import amazon.factories.DriverFactory;
import amazon.pages.LandingPage;
import amazon.pages.ProductDetailPage;
import amazon.pages.ProductPage;
import amazon.utilities.Helpers;
import com.typesafe.config.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTakeHomeAssignment {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    public LandingPage landingPage;
    public ProductPage productPage;

    public ProductDetailPage productDetailPage;
    public Helpers helpers;

    @Tag("smokeTest")
    @DisplayName("This test is for the take home assignment for Clipboard Health.")
    @Test
    void assertAboutThisItemIsPresent() throws InterruptedException {
        landingPage = new LandingPage(driver);
        helpers = new Helpers(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        driver.get(HOME_PAGE_URL);
        landingPage.doClickAllMenu();
        landingPage.doClickAllMenuItem("TV, Appliances, Electronics");
        landingPage.doClickAllMenuItem("Televisions");
        Thread.sleep(2000);
        helpers.scrollToElementByJS(driver.findElement(By.xpath("//span[text()='Brands']")));
        productPage.doClickOnCheckbox("Samsung");
        helpers.doClick(By.id("a-autoid-0-announce"));
        helpers.doClick(By.id("s-result-sort-select_2"));
        Thread.sleep(2000);
        helpers.getElements(By.xpath("//*[@class='a-price-whole']")).get(1).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        productDetailPage.aboutThisItemIsDisplayed();
        String aboutProductDetailContent = productDetailPage.aboutThisItemDetailContent();
        assertEquals(aboutProductDetailContent, Constants.SECOND_HIGHEST_PRICED_PRODUCT_DETAIL);
        System.out.println(productDetailPage.aboutThisItemDetailContent());
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }
}
