package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(CartPage.class);

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By orderSummary = By.className("summary_info");
    private By finishButton = By.id("finish");
    private By orderConfirmation = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerDetails(String firstName, String lastName, String postalCode) {
        logger.info("Entering customer details");
        type(this.firstName, firstName);
        type(this.lastName, lastName);
        type(this.postalCode, postalCode);
    }
    public void continueToOverview() {
        logger.info("Continuing to order overview");
        click(continueButton);
    }
    public boolean isOrderSummaryDisplayed() {
        logger.info("Checking whether order summary is displayed");
        return isDisplayed(orderSummary);
    }

    public void finishOrder() {
        logger.info("Finishing order");
        click(finishButton);
    }

    public boolean isOrderConfirmationDisplayed() {
        logger.info("Checking whether order confirmation is displayed");
        return isDisplayed(orderConfirmation);
    }


}
