package framework.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ChromeBrowserDriver implements BrowserDriver {

    private ChromeOptions createOptions() {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        return options;
    }

    @Override
    public Capabilities getCapabilities() {
        return createOptions();
    }

    @Override
    public WebDriver createLocalDriver() {
        return new ChromeDriver(createOptions());
    }
}