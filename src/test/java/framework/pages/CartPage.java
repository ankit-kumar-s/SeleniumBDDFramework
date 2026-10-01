package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);
    private By cartIcon = By.className("shopping_cart_link");
    private By cartItem(String productName) {
        return By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
    }
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        logger.info("Opening cart");
        click(cartIcon);
    }

    public boolean isProductDisplayed(String productName) {
        logger.info("Checking product in cart: " + productName);
        return getText(cartItem(productName)).equals(productName);
    }

    public void proceedToCheckout() {
        logger.info("Proceeding to checkout");
        click(checkoutButton);
    }
}