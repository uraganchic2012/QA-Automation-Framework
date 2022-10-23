
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class HomeWork15 extends BaseTest{
    @Test

    public static void SearchTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\uraga\\Documents\\GitHub\\QA-Automation-Framework\\src\\test\\resources\\chromedriver106.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("uraganchic2012@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

//        WebElement avatarIcon = driver.findElement(By.xpath("//img[@alt='Avatar of student']");
//        Assert.assertTrue(avatarIcon.isDisplayed());

        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.click();
//        searchField.sendKeys("F");
        searchField.sendKeys("Pluto");
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//*[@data-test='song-card']//*[contains(text(),'Pluto')]"));
//        I think this must be xpath
        Assert.assertTrue(result.isDisplayed());

        Thread.sleep(3000);
        driver.quit();

    }
}

