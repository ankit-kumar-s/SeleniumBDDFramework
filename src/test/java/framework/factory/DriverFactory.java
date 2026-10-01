package framework.factory;

import framework.driver.BrowserDriver;
import framework.driver.ChromeBrowserDriver;
import framework.driver.EdgeBrowserDriver;
import framework.driver.FirefoxBrowserDriver;
import framework.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private static final Map<String, Supplier<BrowserDriver>> BROWSER_DRIVERS =
            Map.of(
                    "chrome", ChromeBrowserDriver::new,
                    "firefox", FirefoxBrowserDriver::new,
                    "edge", EdgeBrowserDriver::new
            );

    public static WebDriver initializeDriver(String browser) {

        browser = browser.toLowerCase();

        String execution = ConfigReader.getProperty("execution").toLowerCase();

        logger.info("Initializing browser: " + browser);
        logger.info("Execution mode: " + execution);

        Supplier<BrowserDriver> browserSupplier = BROWSER_DRIVERS.get(browser);

        if (browserSupplier == null) {
            logger.error("Browser not supported: " + browser);
            throw new RuntimeException("Browser not supported: " + browser);
        }

        BrowserDriver browserDriver = browserSupplier.get();

        if (execution.equals("local")) {
            logger.info("Starting local browser: " + browser);
            return browserDriver.createLocalDriver();
        }

        if (execution.equals("grid")) {

            logger.info("Starting browser through Selenium Grid");
            String gridUrl = ConfigReader.getProperty("grid.url");
            try {
                return new RemoteWebDriver(new URL(gridUrl), browserDriver.getCapabilities());

            } catch (MalformedURLException e) {
                throw new RuntimeException( "Invalid Selenium Grid URL: " + gridUrl, e);
            }
        }

        throw new RuntimeException(
                "Unsupported execution mode: " + execution
        );
    }
}