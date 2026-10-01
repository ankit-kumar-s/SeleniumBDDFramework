package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    //bas existing driver ka reference LoginPage ke andar store karta hai.
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageDisplayed() {
        logger.info("Checking whether login page is displayed");
        return isDisplayed(loginButton);
    }

    public void login(String userName, String passWord) {
        logger.info("Starting login");
        type(username, userName);
        type(password, passWord);
        click(loginButton);
        logger.info("Login action completed");
        System.out.println("URL after click: " + driver.getCurrentUrl());
    }

    public boolean isProductsPageDisplayed() {
        logger.info("Checking whether products page is displayed");
        logger.info("Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("inventory.html");
    }
}
