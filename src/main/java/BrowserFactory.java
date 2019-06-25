import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        return driver == null ? createDriver(browser) : driver;
    }

    private static WebDriver createDriver(String browser) {
        switch (browser) {
            case "Firefox_45": {
                driver = new FireFox45Driver().createInstance();
            }
            break;
            case "Firefox_48": {
                driver = new Firefox48Driver().createInstance();
            }
            break;
            case "Chrome": {
                driver = new ChromeLatestDriver().createInstance();
            }
            break;
        }
        return driver;
    }

    private static class FireFox45Driver implements IDriver {
        public WebDriver createInstance() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", false);
            return new FirefoxDriver(capabilities);
        }
    }

    private static class Firefox48Driver implements IDriver {
        public WebDriver createInstance() {
            System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        }
    }

    private static class ChromeLatestDriver implements IDriver {
        public WebDriver createInstance() {
            System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
