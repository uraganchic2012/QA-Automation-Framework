package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "[data-testid=sidebar-create-playlist-btn]")
    WebElement createPlaylistButton;

    @FindBy(css = "[data-testid=playlist-context-menu-create-simple]")
    WebElement newPlaylistOption;

    @FindBy (css = "[name=name]")
    WebElement playlistNameField;

    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;

    public HomePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public void createPlaylist(String new_songs) {
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistNameField.sendKeys(new_songs);
        playlistNameField.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));

    }

    public int getNumberOfPlaylists() {
        return playlists.size();
    }
}
