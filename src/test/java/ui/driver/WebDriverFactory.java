package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;

public class WebDriverFactory {
    private static final int IMPLICITLY_WAIT_TIMEOUT_SECOND = 5;

    private WebDriverFactory() {
    }
    public static WebDriver getWebDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking", "--disable-notifications");
            options.setUnhandledPromptBehaviour(ACCEPT);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT_SECOND, TimeUnit.SECONDS);
        return driver;
    }
}
