package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task14 {  private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList<String> oldWindows;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriver.Window window = driver.manage().window();
        window.maximize();
    }

 @Test
public void Task14() {
     driver.get("http://localhost/litecart/admin/login.php");
     driver.findElement(By.name("username")).sendKeys("admin");
     driver.findElement(By.name("password")).sendKeys("admin");
     driver.findElement(By.name("login")).click();
     driver.findElement(By.cssSelector("ul#box-apps-menu li:nth-child(3)")).click();
     driver.findElement(By.cssSelector("a.button")).click();
     String mainWindow = driver.getWindowHandle();

List <WebElement> links = driver.findElements(By.cssSelector("i.fa.fa-external-link"));

     for (WebElement element:links) {
         element.click();
         oldWindows = new ArrayList<String>(driver.getWindowHandles());
         if (!oldWindows.isEmpty()) {
             driver.switchTo().window(oldWindows.get(1));
         }
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.close()");
         driver.switchTo().window(mainWindow);
     }
 }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}

