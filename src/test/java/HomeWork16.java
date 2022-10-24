import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork16 extends MyBaseTest{

    @Test

    public void CreateNewPlaylistTest() throws InterruptedException {
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Create a new playlist (use XPath locators to locate the elements)
//        Validate that there is a new playlist made
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys("uraganchic2012@gmail.com");
        Thread.sleep(2000);


        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement createNewPlaylistButton = driver.findElement(By.xpath("//i[@title='Create a new playlist'] "));
        createNewPlaylistButton.click();

        WebElement newPlaylist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        newPlaylistNameField.click();
        newPlaylistNameField.sendKeys("New songs");
//        I can't come up with the part of the code to save this new playlist.






            }


        }


