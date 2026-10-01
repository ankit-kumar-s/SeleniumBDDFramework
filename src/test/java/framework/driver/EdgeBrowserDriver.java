package framework.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserDriver implements BrowserDriver {

    private EdgeOptions createOptions() {
        return new EdgeOptions();
    }

    @Override
    public Capabilities getCapabilities() {
        return createOptions();
    }

    @Override
    public WebDriver createLocalDriver() {
        return new EdgeDriver(createOptions());
    }
}