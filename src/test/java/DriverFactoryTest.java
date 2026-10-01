import framework.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import framework.utils.ConfigReader;
import framework.pages.LoginPage;

public class DriverFactoryTest {

    @Test
    public void launchBrowser() {
        String browser =ConfigReader.getProperty("browser");
        WebDriver driver = DriverFactory.initializeDriver(browser);
        driver.get(ConfigReader.getProperty("baseUrl"));

        System.out.println("Title: " + driver.getTitle());

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        driver.quit();
    }
}
