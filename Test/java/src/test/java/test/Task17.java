package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task17 { private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList logs = new ArrayList<>();

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriver.Window window = driver.manage().window();
        window.maximize();
    }

    @Test
    public void Task17() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> rows = driver.findElements(By.cssSelector(".dataTable .row"));

        for (int i = 3; i < rows.size(); i++) {
            List<WebElement> rows1 = driver.findElements(By.cssSelector(".dataTable .row"));
            rows1.get(i).findElement(By.cssSelector("td:nth-child(5)")).click();

            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                logs.add(l.toString());
                System.out.println(l);
            }
            Assert.assertEquals(0,logs.size());
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}