package framework.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserDriver implements BrowserDriver {

    private FirefoxOptions createOptions() {
        return new FirefoxOptions();
    }

    @Override
    public Capabilities getCapabilities() {
        return createOptions();
    }

    @Override
    public WebDriver createLocalDriver() {
        return new FirefoxDriver(createOptions());
    }
}