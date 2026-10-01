package stepdefinitions;

import context.TestContext;
import framework.pages.ProductsPage;
import framework.testdata.TestData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

    private ProductsPage productsPage;
    private TestContext testContext;
    public ProductSteps(TestContext testContext) {
        this.testContext = testContext;
        this.productsPage = new ProductsPage(testContext.getDriver());

    }

    @When("user adds {string} product to cart")
    public void userAddsProductToCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("user adds product to cart")
    public void userAddsProductToCart() {

        TestData testData = testContext.getTestData();
        productsPage.addProductToCart(testData.getProductName());
    }

    @Then("user logs out")
    public void userLogsOut() {
        productsPage.logout();
    }
}