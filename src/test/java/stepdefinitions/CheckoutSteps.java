package stepdefinitions;

import framework.pages.CheckoutPage;
import framework.testdata.TestData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import context.TestContext;
import org.testng.Assert;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;
    private TestContext testContext;

    public CheckoutSteps(TestContext testContext) {
        this.testContext = testContext;
        this.checkoutPage = new CheckoutPage(testContext.getDriver());
    }

    @When("user enters customer details {string}, {string}, and {string}")
    public void userEntersCustomerDetails(String firstName, String lastName, String postalCode) {

        checkoutPage.enterCustomerDetails(firstName, lastName, postalCode);
    }

    @When("user continues to order overview")
    public void userContinuesToOrderOverview() {
        checkoutPage.continueToOverview();
    }

    @When("user enters customer details")
    public void userEntersCustomerDetails() {

        TestData testData = testContext.getTestData();
        checkoutPage.enterCustomerDetails(testData.getFirstName(), testData.getLastName(), testData.getPostalCode());
    }

    @Then("user should see the order summary")
    public void userShouldSeeTheOrderSummary() {
        Assert.assertTrue(checkoutPage.isOrderSummaryDisplayed(), "Order summary is not displayed");
    }

    @When("user finishes the order")
    public void userFinishesTheOrder() {
        checkoutPage.finishOrder();
    }

    @Then("user should see the order confirmation")
    public void userShouldSeeTheOrderConfirmation() {
        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed(), "Order confirmation is not displayed");
    }
}