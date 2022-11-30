import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CreatePlaylistTests extends BaseTest{
    @Test
    public void createPlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("New Songs");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists+1, "Playlist not created" );

    }
    @Test
    public void createDuplicatePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("Classic");
        homePage.createPlaylist("Classic");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists+1, "Duplicate Playlist not created");

    }

    @Test
    public void createTwoCharacterNamePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("BS");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists, "Name is too short. Playlist not created");

    }

    @Test
    public void createThreeCharacterNamePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("Sol");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists+1, "Playlist not created");

    }

    @Test
    public void createSixCharacterNamePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("Serena");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists+1, "Playlist not created");

    }

    @Test
    public void createTenCharacterNamePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("Beautifuls");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists+1, "Playlist not created");
    }

    @Test
    public void createElevenCharacterNamePlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylists();
        homePage.createPlaylist("Beautifulls");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylists();
        Assert.assertEquals(updatedNumberOfPlaylists,initialNumberOfPlaylists, "Playlist not created. Name is too long");
    }
}
