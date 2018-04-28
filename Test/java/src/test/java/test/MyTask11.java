package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class MyTask11    {
    private WebDriver driver;
    private WebDriverWait wait;

    private String emailBuilder() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String email = salt.toString() +"@email.com";
         return email;
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void MyTask11() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("[name=login_form] a")).click();

        WebElement country_sel = driver.findElement(By.cssSelector("select:nth-child(3)"));
        Select country_select = new Select(country_sel);
        country_select.selectByVisibleText("United States");
        WebElement zone_sel = driver.findElement(By.cssSelector("select[name*='zone']"));
        Select zone_select = new Select(zone_sel);
        zone_select.selectByVisibleText("Washington");

        driver.findElement(By.cssSelector("td input[name='tax_id']")).sendKeys("111111");
        driver.findElement(By.cssSelector("td input[name='company']")).sendKeys("NastjaCorp");
        driver.findElement(By.cssSelector("td input[name='firstname']")).sendKeys("Nastja");
        driver.findElement(By.cssSelector("td input[name='lastname']")).sendKeys("Test");
        driver.findElement(By.cssSelector("td input[name='address1']")).sendKeys("Tel Aviv, 5a");
        driver.findElement(By.cssSelector("td input[name='address2']")).sendKeys("Raanana");
        driver.findElement(By.cssSelector("td input[name='postcode']")).sendKeys("61000");
        driver.findElement(By.cssSelector("td input[name='city']")).sendKeys("Tel Aviv");
        String emailForm = emailBuilder();
        driver.findElement(By.cssSelector("td input[name='email']")).sendKeys(emailForm);
        driver.findElement(By.cssSelector("td input[name='phone']")).sendKeys("+0535301111");
        driver.findElement(By.cssSelector("td input[name='password']")).sendKeys("123321");
        driver.findElement(By.cssSelector("td input[name='confirmed_password']")).sendKeys("123321");
        driver.findElement(By.cssSelector("input[name='newsletter'")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
        driver.findElement(By.cssSelector("form[name='login_form'] input[name='email']")).sendKeys(emailForm);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123321");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
    }

    @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }