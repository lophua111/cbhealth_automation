import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.LandingPage;
import amazon.pages.ProductPage;
import com.typesafe.config.Config;
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

    @Tag("smokeTest")
    @DisplayName("This test is for the take home assignment for Clipboard Health.")
    @Test
    void assertAboutUsIsPresent() throws InterruptedException {
        driver.get(HOME_PAGE_URL);
        landingPage = new LandingPage(driver);
        landingPage.doClickAllMenu();
        landingPage.doClickAllMenuItem("TV, Appliances, Electronics");
        landingPage.doClickAllMenuItem("Televisions");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//span[text()='Brands']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        productPage = new ProductPage(driver);
        productPage.doClickOnCheckbox("Samsung");
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_2")).click();
        Thread.sleep(2000);
        List<WebElement> priceList = driver.findElements(By.xpath("//*[@class='a-price-whole']"));
        priceList.get(1).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement((By.xpath("//*[@class='a-size-base-plus a-text-bold']"))).isDisplayed();
        String about_us = driver.findElement(By.xpath("//*[@class='a-size-base-plus a-text-bold']//following-sibling::*[@class='a-unordered-list a-vertical a-spacing-mini']")).getText();
        System.out.println(about_us);
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }
}
