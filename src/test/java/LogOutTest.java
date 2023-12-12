import org.junit.Test;
import static com.codeborne.selenide.Condition.*;

public class LogOutTest extends BaseTest {
    @Test
    public void logOutTest() {
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getHeaderBooksTable().shouldBe(visible);
        profilePage.getActionColumn().shouldBe(visible);
        profilePage.isBookCollectionDisplayed();
        profilePage.clickLogOutButton();
        loginPage.getLoginHeader().shouldBe(visible);
        sideBar.followProfileLink();
        profilePage.getNotLogginLabel().shouldHave(text("Currently you are not logged into the Book Store application,"));
    }
}
