import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulLoginIn360x740Test {
    SideBarPage sideBar = new SideBarPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Before
    public void setUp(){
        Configuration.browserSize = "360x740";
        open("https://demoqa.com/books");
    }

    @Test
    public void successfulLogin_360x740_Test(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.confirmLogin("Ronny");
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
}
