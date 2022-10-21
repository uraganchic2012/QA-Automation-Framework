import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork14{


        @Test

        public static void RegistrationNavigationTest() throws InterruptedException {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\uraga\\Documents\\GitHub\\QA-Automation-Framework\\src\\test\\resources\\chromedriver106.exe");
            WebDriver driver = new ChromeDriver();
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(),url);

            WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
            registrationLink.click();

            // WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//            emailField.click();
//            emailField.sendKeys("uraganchic2012@gmail.com");
//
//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//            passwordField.click();
//            passwordField.sendKeys("te$t$tudent");
//
//            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//            submitButton.click();

            Thread.sleep(4000);
            driver.quit();



        }
}




