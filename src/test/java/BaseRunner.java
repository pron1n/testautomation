import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseRunner {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws MalformedURLException {
        driver = BrowserFactory.buildDriver("chrome_invisible");
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
