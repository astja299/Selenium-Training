package app;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Checkout;
import pages.HomePage;
import pages.ProductPage;

public class Application {

    private WebDriver driver;
    private  WebDriverWait wait;
    private  Checkout checkout;
    private  ProductPage productPage;
    private  HomePage homePage;

    public Application() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        checkout = new Checkout(driver);
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
    }

    public void openHomePage() {
        homePage.open();
    }

    public void addToCart (int q) {
        for (int i = 0; i < q; i++) {
            homePage.addToCartFirstProduct().click();
            productPage.clickAddToCart().click();
            wait.until(ExpectedConditions.textToBe(productPage.productsQuantity(), String.valueOf(i+1)));
            productPage.moveToHomePage().click();
        }
    }

    public void moveToCheckout () { homePage.moveToCheckout().click();}

    public void removeAllProducts () {
        do {
            checkout.removeProduct().click();
            wait.until(ExpectedConditions.stalenessOf(checkout.table()));
        }
        while (checkout.tableRows().size() > 0);
    }

    public void checkCartIsEmpty() {
        Assert.assertEquals("There are no items in your cart.", checkout.message().getText());
    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}