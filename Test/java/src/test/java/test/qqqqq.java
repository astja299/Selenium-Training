package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class qqqqq {
    private WebDriver driver;
    private WebDriverWait wait;

    public boolean stickerCounter (List<WebElement> stickers){
        if (stickers.size() != 1){
            return false;
        }
        return true;
    }

    @Before
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
     }

    @Test
    public void qqqqq() {

        driver.get("http://localhost/litecart/");
        List<WebElement> elements = driver.findElements(By.cssSelector(".product.column"));

        for (WebElement element:elements) {
            List<WebElement> stickers = element.findElements(By.cssSelector("div.sticker"));
            assertTrue(stickerCounter(stickers));
        }
       }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}