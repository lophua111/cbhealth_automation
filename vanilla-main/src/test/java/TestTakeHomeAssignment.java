import amazon.config.EnvFactory;
import amazon.constants.Constants;
import amazon.factories.DriverFactory;
import amazon.pages.LandingPage;
import amazon.pages.ProductDetailPage;
import amazon.pages.ProductPage;
import amazon.utilities.Helpers;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTakeHomeAssignment {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    public LandingPage landingPage;
    public ProductPage productPage;

    public ProductDetailPage productDetailPage;
    public Helpers helpers;

    @BeforeAll
    public static void setUp() {
        driver.get(HOME_PAGE_URL);

    }

    @Tag("smokeTest")
    @DisplayName("This test is for the take home assignment for Clipboard Health.")
    @Test
    void assertAboutThisItemIsPresent() throws InterruptedException {
        landingPage = new LandingPage(driver);
        helpers = new Helpers(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        landingPage.doClickAllMenu();
        landingPage.doClickAllMenuItem("TV, Appliances, Electronics");
        landingPage.doClickAllMenuItem("Televisions");
        helpers.waitForElementToBeVisible(By.id("navBackToTop"), Constants.DEFAULT_TIME_OUT);
        helpers.scrollToElementByJS(driver.findElement(By.xpath("//span[text()='Brands']")));
        productPage.doClickOnCheckbox("Samsung");
        productPage.doSelectValueFromProductDropDown("Price: High to Low");
        productPage.doClickOnSecondHighestPricedItem();
        helpers.switchToAnotherWindow();
        productDetailPage.aboutThisItemIsDisplayed();
        String aboutProductDetailContent = productDetailPage.aboutThisItemDetailContent();
        assertEquals(aboutProductDetailContent, Constants.SECOND_HIGHEST_PRICED_PRODUCT_DETAIL);
        System.out.println(productDetailPage.aboutThisItemDetailContent());
        helpers.switchToMainWindow();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
