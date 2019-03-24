import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;


public class BrowserFactory {
    public static WebDriver buildDriver(String browserName) throws MalformedURLException {
        switch (browserName) {

            case "chrome":
                ChromeOptions chromeOpt = new ChromeOptions();
                chromeOpt.addArguments("--disable-notifications");

                return new ChromeDriver(chromeOpt);

            case "firefox":
                FirefoxOptions ffOpt = new FirefoxOptions();
                ffOpt.addPreference("dom.webnotifications.enabled", false);

                return new FirefoxDriver(ffOpt);

            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
        }
    }
}
