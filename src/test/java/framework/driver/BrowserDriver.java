package framework.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface BrowserDriver {

    Capabilities getCapabilities();
    WebDriver createLocalDriver();
}