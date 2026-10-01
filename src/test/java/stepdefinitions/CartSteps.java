package stepdefinitions;

import context.TestContext;
import framework.pages.CartPage;
import framework.testdata.TestData;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {

    private CartPage cartPage;
    private TestContext testContext;

    public CartSteps(TestContext testContext) {
        this.testContext = testContext;
        this.cartPage = new CartPage(testContext.getDriver());
    }

    @When("user opens the cart")
    public void userOpensTheCart() {
        cartPage.openCart();
    }

    @Then("user should see {string} product in the cart")
    public void userShouldSeeProductInTheCart(String productName) {
        Assert.assertTrue(cartPage.isProductDisplayed(productName),
                "Product was not found in the cart: " + productName);
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.proceedToCheckout();
    }

    @Then("user should see product in the cart")
    public void userShouldSeeProductInTheCart() {
        TestData testData = testContext.getTestData();

        Assert.assertTrue(cartPage.isProductDisplayed(testData.getProductName()), "Expected product is not displayed in the cart");
    }
}