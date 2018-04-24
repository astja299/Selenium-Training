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
import java.util.List;
import static org.junit.Assert.assertTrue;

public class Task9 {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean compare (String a, String b) {
        if(a.compareTo(b) < 0)
        {
            return true;
        }
        else
        {
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
    public void Task9() {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();

        List<WebElement>list = driver.findElements(By.cssSelector(".row a"));
        for (int i=0; i< list.size()-2; i=i+2){
            String a = list.get(i).getAttribute("textContent");
            String b = list.get(i+2).getAttribute("textContent");
            assertTrue(compare (a,b));
        }

    List<WebElement> zones_for_size = driver.findElements(By.cssSelector(".row :nth-child(6)"));
int zones_size =  zones_for_size.size();
    for (int j=0; j < zones_size; j++) {
        List<WebElement> zones = driver.findElements(By.cssSelector(".row :nth-child(6)"));
        String zone_number = zones.get(j).getAttribute("textContent");
         if (zone_number.compareTo("0") !=0) {
        List <WebElement> rows = driver.findElements(By.cssSelector(".row td > a"));
        rows.get(j).click();

        List<WebElement> list2 = driver.findElements(By.cssSelector("#table-zones  td:nth-child(3)"));
        for (int i=0; i< list2.size()-2; i++){
            String a = list2.get(i).getAttribute("textContent");
            String b = list2.get(i+1).getAttribute("textContent");
            assertTrue(compare (a,b));
        }
        driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(3)")).click();
    }
    }}


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}