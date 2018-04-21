package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.Assert.assertTrue;



public class MenuSuperClickerTwo {
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


        driver = new ChromeDriver();
     //   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MenuSuperClickerTwo() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();

        List<WebElement> menuItems = driver.findElements(By.cssSelector("#box-apps-menu > li"));
        System.out.println(menuItems.size());




        for (int i=0; i< menuItems.size(); i++){
            List<WebElement> items = driver.findElements(By.cssSelector("#box-apps-menu > li"));
            items.get(i).click();
            assertTrue(isElementPresent(By.tagName("h1")));
            if  (isElementPresent(By.cssSelector("ul.docs"))){
                List<WebElement> containerItems = driver.findElements(By.cssSelector("ul.docs li"));
                for (int j=0; j<containerItems.size(); j++) {
                    List<WebElement> containerItemsInner = driver.findElements(By.cssSelector("ul.docs li"));
                    containerItemsInner.get(j).click();
                    assertTrue(isElementPresent(By.tagName("h1")));
                    }
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

