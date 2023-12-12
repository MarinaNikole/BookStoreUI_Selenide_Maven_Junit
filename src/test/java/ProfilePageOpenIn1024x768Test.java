import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePageOpenIn1024x768Test {
    SideBarPage sideBar = new SideBarPage();

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Before
    public void setUp(){
        Configuration.browserSize = "1024x768";
        open("https://demoqa.com/books");

    }

    @Test
    public void openInFullScreen_1024x768_Test(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getActionColumn().shouldBe(Condition.visible);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
}
