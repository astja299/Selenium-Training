package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends Page {
    public ProductPage (WebDriver driver) {super(driver);}
    public WebElement clickAddToCart () {return driver.findElement(By.cssSelector("button[name='add_cart_product']"));
    }
    public WebElement moveToHomePage () {return driver.findElement(By.cssSelector(".general-0"));
    }
    public By productsQuantity () {return By.cssSelector("#cart > a.content > span.quantity");}

}