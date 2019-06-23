import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "Firefox_45": {
                if (driver == null) {
                    driver = FireFox45Driver.createInstance();
                }
            }
            break;
            case "Firefox_48": {
                if (driver == null) {
                    driver = Firefox48Driver.createInstance();
                }
            }
            break;
            case "Chrome": {
                if (driver == null) {
                    driver = ChromeLatestDriver.createInstance();
                }
            }
            break;
        }
        return driver;
    }

    private static class FireFox45Driver {
        public static WebDriver createInstance() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", false);
            return new FirefoxDriver(capabilities);
        }
    }

    private static class Firefox48Driver {
        public static WebDriver createInstance() {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        }
    }

    private static class ChromeLatestDriver {
        public static WebDriver createInstance() {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
