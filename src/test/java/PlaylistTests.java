import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void createPlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("name");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }
}