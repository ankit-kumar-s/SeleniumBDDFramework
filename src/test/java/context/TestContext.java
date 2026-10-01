package context;

import org.openqa.selenium.WebDriver;
import framework.testdata.TestData;

public class TestContext {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private ThreadLocal<TestData> testData = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public void removeDriver() {
        driver.remove();
    }

    public TestData getTestData() {
        return testData.get();
    }

    public void setTestData(TestData testData) {
        this.testData.set(testData);
    }

    public void removeTestData() {
        testData.remove();
    }
}
