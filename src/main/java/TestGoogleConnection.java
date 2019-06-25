import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestGoogleConnection {

    private WebDriver driver;
    private WebDriverWait wait;
    private static String URL = "https://www.google.by/";
    private static String SEARCH_BUTTON = "btnK";
    private static String SEARCH_KEY = "java";
    private static String SEARCH_WINWOW = "q";
    private static String TITLE_SEARCH_RESULT = "java - Поиск в Google";
    private static int TIMEOUT = 5;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(String browser) {
        driver = BrowserFactory.getDriver(browser);
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    @AfterSuite
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void testConnection() {
        driver.get(URL);
        driver.findElement(By.name(SEARCH_WINWOW)).sendKeys(SEARCH_KEY);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(SEARCH_BUTTON))));
        driver.findElement(By.name(SEARCH_BUTTON)).click();
        wait.until(titleIs(TITLE_SEARCH_RESULT));
    }
}
