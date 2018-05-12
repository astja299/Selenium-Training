package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkout extends Page {

    public Checkout (WebDriver driver) { super(driver); }
    public WebElement removeProduct () {return driver.findElement(By.cssSelector("button[name='remove_cart_item']"));}
    public List<WebElement> tableRows() {return driver.findElements(By.cssSelector("table.dataTable.rounded-corners tr"));}
    public WebElement table() {return driver.findElement(By.cssSelector("table.dataTable.rounded-corners"));}
    public WebElement message () {return driver.findElement(By.cssSelector("em"));}
}
