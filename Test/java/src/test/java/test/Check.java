package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;



public class Check {
    private WebDriver driver;
    private WebDriverWait wait;

    public   boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() == 1;
    }

    public    boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Before
    public void start() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Check() {

        driver.get("http://localhost/litecart/");

///    for (int i = 1; i < 5; i++) {
        ///       assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child[i]) div.sticker")));
        ///  }



        assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child(1) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child(2) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child(3) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child(4) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-most-popular li:nth-child(5) div.sticker")));

        assertTrue(isElementPresent (By.cssSelector("#box-campaigns li:nth-child(1) div.sticker")));

        assertTrue(isElementPresent (By.cssSelector("#box-latest-products li:nth-child(1) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-latest-products li:nth-child(2) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-latest-products li:nth-child(3) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-latest-products li:nth-child(4) div.sticker")));
        assertTrue(isElementPresent (By.cssSelector("#box-latest-products li:nth-child(5) div.sticker")));

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}








