package stepdefinitions;

import context.TestContext;
import framework.pages.LoginPage;
import framework.testdata.TestData;
import framework.utils.TestDataManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    private TestContext testContext;
    private LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = new LoginPage(testContext.getDriver());
    }

    @Given("user is on the SauceDemo login page")
    public void userIsOnTheSauceDemoLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }

    @Given("user is on the SauceDemo login page for test case {string}")
    public void userIsOnTheSauceDemoLoginPageForTestCase(String testCaseId) {
        TestData testData = TestDataManager.getTestData(testCaseId);
        testContext.setTestData(testData);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "Login page is not displayed");
    }

    @When("user logs in with {string} and {string}")
    public void userLogsInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see the products page")
    public void userShouldSeeTheProductsPage() {
        Assert.assertTrue(loginPage.isProductsPageDisplayed());
    }


    @When("user logs in")
    public void userLogsIn() {
        TestData testData = testContext.getTestData();

        loginPage.login(testData.getUsername(), testData.getPassword()
        );
    }
}