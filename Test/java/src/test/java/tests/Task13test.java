package tests;

import org.junit.Test;
public class Task13test extends TestBase {

    @Test
    public void test () {

        app.openHomePage();
        app.addToCart(3);
        app.moveToCheckout();
        app.removeAllProducts();
        app.checkCartIsEmpty();
}
}
