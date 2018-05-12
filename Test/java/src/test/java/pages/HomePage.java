package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends Page {

    public HomePage (WebDriver driver) {super(driver);}

    public WebElement moveToCheckout () {return driver.findElement(By.cssSelector("#cart a.link")); }
    public void open () {driver.get("http://localhost/litecart/en/");}
    public WebElement addToCartFirstProduct () {return driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"));}


}
