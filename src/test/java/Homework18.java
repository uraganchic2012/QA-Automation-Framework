import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        provideEmail("uraganchic2012@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        Thread.sleep(3000);
        playASong();
        Thread.sleep(3000);

//        validateSongIsPlaying();
        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }
    private void playASong() {
        Actions action= new Actions(driver);
//        playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        action.moveToElement(playPauseBtn).perform();
        playPauseBtn.click();
    }

}
