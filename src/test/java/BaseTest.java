import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BaseTest {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;

    static String where = System.getProperty("where");
    static String browser = System.getProperty("browser");
    static String env = System.getProperty("env");
    static String suite = System.getProperty("suite");

    static String parameters = where + " " + browser + " " + env + " " + suite;

    @BeforeSuite
    public static void chromeConfig() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "Untitled/chromedriver");
        }
        // Just checking
        System.out.println(parameters);
    }

    private WebDriver getDriver() throws MalformedURLException {
        if(where.contains("selenoid")) {
            return configRemoteWebDriver();
        }
        else if (where.contains("lambdatest")){
            return configLambdaTestDriver();
        }
        if(browser.contains("safari")){
            return new SafariDriver();
        }
        else if(browser.contains("firefox")){
            return new FirefoxDriver();
        }
        else return new ChromeDriver();
    }

    private WebDriver configLambdaTestDriver() throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "dancefront" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Q3kapiUPNjt4PRRUTA4Hx6SEK523Lpi5vGF148aniE6qcdxcwx" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "91.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    private WebDriver configRemoteWebDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "106.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", false,
                "enableVideo", false
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://13.59.76.15:4444/wd/hub").toURL(),
                capabilities);
        return driver;
    }

    private String getUrl(){
        if (env != null) {
            if (env.contains("dev")) {
                return "https://dev.koel.app";
            } else if (env.contains("stage")) {
                return "https://stage.koel.app";
            } else if (env.contains("prod")) {
                return "https://koel.app";
            }
        }
        return "https://bbb.testpro.io";
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        url = getUrl();
        driver = getDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}