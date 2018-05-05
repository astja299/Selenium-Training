package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import java.io.File;

public class Task12 {
    private WebDriver driver;
    private WebDriverWait wait;
    
    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @Test
    public void Task12(){
        String img = new File("img/image.png").getAbsolutePath();

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driver.findElement(By.cssSelector("li#app-:nth-child(2)")).click();
        driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();
        driver.findElement(By.cssSelector("input[type='radio']")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Test Duck");
        driver.findElement(By.cssSelector("input[name='code'")).sendKeys("2");

        driver.findElements(By.cssSelector("input[type='checkbox']")).get(5).click();

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("100000000000");

        WebElement status = driver.findElement(By.name("sold_out_status_id"));
        Select status_select = new Select(status);
        status_select.selectByVisibleText("-- Select --");

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(img);

        driver.findElement((By.name("date_valid_from"))).click();
        driver.findElement((By.name("date_valid_from"))).sendKeys(Keys.ARROW_LEFT);
        driver.findElement((By.name("date_valid_from"))).sendKeys(Keys.ARROW_LEFT  + "01.01.2001");

        driver.findElement((By.name("date_valid_to"))).click();
        driver.findElement((By.name("date_valid_to"))).sendKeys(Keys.ARROW_LEFT);
        driver.findElement((By.name("date_valid_to"))).sendKeys(Keys.ARROW_LEFT   + "01.01.2999");

        driver.findElement(By.cssSelector("ul.index li:nth-child(2)")).click();
        WebElement manufacturer = driver.findElement(By.name("manufacturer_id"));
        Select manufacturer_select = new Select(manufacturer);
        manufacturer_select.selectByVisibleText("ACME Corp.");
        driver.findElement((By.name("keywords"))).sendKeys("duck");
        driver.findElement((By.name("short_description[en]"))).sendKeys("best duck");

        driver.findElement((By.cssSelector(".trumbowyg-editor"))).sendKeys("Duck is the common name for a large number of species in the waterfowl family Anatidae, which also includes swans and geese.");
        driver.findElement((By.name("head_title[en]"))).sendKeys("Super Duck");
        driver.findElement((By.name("meta_description[en]"))).sendKeys("Duck");

        driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("900");

        WebElement dollar = driver.findElement(By.name("purchase_price_currency_code"));
        Select dollar_select = new Select(dollar);
        dollar_select.selectByVisibleText("US Dollars");

        driver.findElement(By.name("gross_prices[USD]")).clear();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("999");

        driver.findElement(By.cssSelector("button[name='save']")).click();

        WebElement new_product = driver.findElement(By.xpath("//*[contains(text(),'Test Duck')]"));
        assertTrue (new_product != null);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}