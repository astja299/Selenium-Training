package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Task13plus {
  private WebDriver driver;
  private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

        @Test
        public void Task13plus() {
            driver.get("http://localhost/litecart/en/");

            for (int i = 0; i < 3; i++) {
                driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)")).click();
                driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
                wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart > a.content > span.quantity"), String.valueOf(i + 1)));
                driver.findElement(By.cssSelector(".general-0")).click();
            }

            driver.findElement(By.cssSelector("#cart a.link")).click();

do {
    driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
    wait.until(stalenessOf(driver.findElement(By.cssSelector("table.dataTable.rounded-corners"))));
}

while   (driver.findElements(By.cssSelector("table.dataTable.rounded-corners tr")).size() > 0);
        Assert.assertEquals("There are no items in your cart.", driver.findElement(By.cssSelector("em")).getText());

WebElement em = driver.findElement(By.cssSelector("em"));
System.out.println(em);
System.out.println(em.getText());

}
            @After
            public void stop() {
                driver.quit();
                driver = null;
            }
        }