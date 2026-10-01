package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductsPage.class);
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productName) {
        logger.info("Adding product to cart: " + productName);
        By addToCartButton = By.xpath(
                "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"
        );

        click(addToCartButton);
        logger.info("Product added to cart: " + productName);
    }

    public void logout() {
        logger.info("Logging out");

        click(menuButton);
        click(logoutLink);

        logger.info("Logout completed");
    }
}