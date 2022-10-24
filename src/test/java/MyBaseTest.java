import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class MyBaseTest {

    @BeforeSuite
    public static void chromeConfigs() {
            // This is for Windows users
         if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         }
    }
    WebDriver driver;
    String url;

    @BeforeMethod
    public void LaunchBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = "https://bbb.testpro.io/";
        driver.get(url);
    }
//    @BeforeTest
//    public void LogIn() throws InterruptedException {
//
//
//        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
//        emailField.click();
//        emailField.sendKeys("uraganchic2012@gmail.com");
//        Thread.sleep(2000);
//
//
//        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
//        passwordField.click();
//        passwordField.sendKeys("te$t$tudent");
//        Thread.sleep(2000);
//
//        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitButton.click();
//        Thread.sleep(2000);
//    }

//    @AfterTest
//    public void quitDriver(){
//        driver.quit();
//    }

}