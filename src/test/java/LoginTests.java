import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\uraga\\Documents\\GitHub\\QA-Automation-Framework\\src\\test\\resources\\chromedriver106.exe");

        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";

        Thread.sleep(4000);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }
}
