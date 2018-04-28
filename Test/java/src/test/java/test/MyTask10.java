package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MyTask10  {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyTask10() {

        driver.get("http://localhost/litecart/en/");
        WebElement product = driver.findElement(By.cssSelector("#box-campaigns li:first-child"));

        WebElement product_text = product.findElement(By.cssSelector("div.name"));
        String product_name = product_text.getAttribute("textContent");

        String promo_price = product.findElement(By.cssSelector(".price-wrapper .campaign-price")).getAttribute("textContent");

        WebElement promo_price_element = product.findElement(By.cssSelector(".price-wrapper .campaign-price"));
        String promo_price_strong = promo_price_element.getAttribute("tagName");
        assertEquals(promo_price_strong, "STRONG");
        String promo_pr_color = promo_price_element.getCssValue("color");
        String [] promo_pr_rgba =  promo_pr_color.replace("rgba(", "").replace(")", "").split(", ");
        assertEquals(promo_pr_rgba [1] ,promo_pr_rgba [2] ,"0" );

        String promo_price_element_new = promo_price_element.getCssValue("font-size");
        String Number = promo_price_element_new.replace("px","");

        String regular_price = product.findElement(By.cssSelector(".price-wrapper .regular-price")).getAttribute("textContent");
        WebElement regular_price_element = driver.findElement(By.cssSelector(".price-wrapper .regular-price"));
        String regular_price_s  = regular_price_element.getAttribute("tagName");
        assertEquals(regular_price_s, "S");
        String reg_pr_color = regular_price_element.getCssValue("color");

        String[] strArray = reg_pr_color.replace("rgba(", "").replace(")", "").split(", ");
        assertEquals(strArray[0], strArray[1], strArray[2]);

        String reg_price_element_new = regular_price_element.getCssValue("font-size");
        String NumberR = reg_price_element_new.replace("px","");
        assertTrue(Number.compareTo(NumberR) > 0 );

        product.click();
       String product_name2 = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");

        String promo_price2 = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getAttribute("textContent");

        WebElement promo_price_element2 = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price"));
        String promo_price_strong2 = promo_price_element2.getAttribute("tagName");
        assertEquals(promo_price_strong2, "STRONG");
        String promo_pr_color2 = promo_price_element2.getCssValue("color");
        String [] promo_pr_rgba2 =  promo_pr_color2.replace("rgba(", "").replace(")", "").split(", ");

        assertEquals(promo_pr_rgba2 [1] ,promo_pr_rgba2 [2] ,"0" );

        String promo_price_element_new2 = promo_price_element2.getCssValue("font-size");
        String Number2 = promo_price_element_new2.replace("px","");

        String regular_price2 = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getAttribute("textContent");
        WebElement regular_price_element2 = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price"));
        String regular_price_s2  = regular_price_element2.getAttribute("tagName");
        assertEquals(regular_price_s2, "S");

        String reg_pr_color2 = regular_price_element2.getCssValue("color");
        String[] strArray2 = reg_pr_color2.replace("rgba(", "").replace(")", "").split(", ");
        assertEquals(strArray2[0], strArray2[1], strArray2[2]);

        String reg_price_element_new2 = regular_price_element2.getCssValue("font-size");
        String NumberR2 = reg_price_element_new2.replace("px","");

        assertTrue(Number2.compareTo(NumberR2) > 0 );

        assertEquals ( product_name , product_name2);
        assertEquals ( promo_price , promo_price2);
        assertEquals ( regular_price , regular_price2);
}
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}