package amazon.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Helpers {
    private WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element;
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public void scrollToElementByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToAnotherWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToMainWindow(){
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
        driver.close();
    }

    public WebElement waitForElementToBeVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElementWhenReady(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
    }

}
