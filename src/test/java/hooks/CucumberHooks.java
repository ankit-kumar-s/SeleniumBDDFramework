package hooks;

import context.TestContext;
import framework.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import framework.factory.DriverFactory;
import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CucumberHooks {

    private TestContext testContext;
    private static final Logger logger = LogManager.getLogger(CucumberHooks.class);

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {

        logger.info("Test setup started");

        String browser = ConfigReader.getProperty("browser").toLowerCase();

        logger.info("Browser selected: " + browser);

        WebDriver driver = DriverFactory.initializeDriver(browser);

        logger.info("WebDriver initialized successfully");

        testContext.setDriver(driver);
        logger.info("WebDriver stored in TestContext");

        driver.get(ConfigReader.getProperty("baseUrl"));
        logger.info("Navigated to base URL");
    }


    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            logger.warn("Scenario failed: " + scenario.getName());

            byte[] screenshot = captureScreenshot(scenario.getName());

            scenario.attach(screenshot, "image/png", "Failure Screenshot"
            );

            logger.info("Failure screenshot captured and attached");
        }

        testContext.getDriver().quit();
        logger.info("WebDriver closed successfully");

        testContext.removeDriver();
        logger.info("WebDriver removed from TestContext");
    }

    private byte[] captureScreenshot(String scenarioName) {

        try {

            TakesScreenshot takesScreenshot = (TakesScreenshot) testContext.getDriver();

            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

            File screenshotDirectory = new File("reports/screenshots");

            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdirs();
            }
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String screenshotName = scenarioName.replaceAll("[^a-zA-Z0-9.-]", "_") + "_" + timestamp + ".png";

            File screenshotFile = new File(screenshotDirectory, screenshotName);

            Files.write(screenshotFile.toPath(), screenshot);

            logger.info("Screenshot saved: " + screenshotFile.getPath());

            return screenshot;


        } catch (Exception e) {

            logger.error("Unable to capture screenshot", e);

            throw new RuntimeException(e);
        }
    }
}
