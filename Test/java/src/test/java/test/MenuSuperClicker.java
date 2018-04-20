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
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class MenuSuperClicker {
    private WebDriver driver;
    private WebDriverWait wait;
   public boolean isElementPresent(By locator) {
       try {
           driver.findElement(locator);
           return true;
       } catch (NoSuchElementException ex) {
           return false;
       }
   }

        @Before
        public void start() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-fullscreen");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
            }

        @Test
        public void aaaq() {

            driver.get("http://localhost/litecart/admin/");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("remember_me")).click();
            driver.findElement(By.name("login")).click();

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(1)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-logotype")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(2)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-product_groups")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-option_groups")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-manufacturers")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-suppliers")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-sold_out_statuses")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-quantity_units")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-csv")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(3)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(4)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(5)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-csv")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-newsletter")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(6)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(7)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-storage_encoding")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(8)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-customer")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-shipping")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-payment")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-order_total")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-order_success")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-order_action")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(9)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-order_statuses")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(10)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(11)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("#doc-most_sold_products")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-most_shopping_customers")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(12)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-store_info")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-defaults")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-general")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-listings")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-images")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-checkout")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-advanced")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-security")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(13)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(14)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-tax_rates")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(15)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-scan")).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            driver.findElement(By.cssSelector("#doc-csv")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(16)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

            driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(17)")).click();
            assertTrue(isElementPresent(By.tagName("h1")));

        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }