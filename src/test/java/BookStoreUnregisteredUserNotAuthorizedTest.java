import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class BookStoreUnregisteredUserNotAuthorizedTest extends BaseTest {

    @Test
    public void noAccessToProfileFeaturesTest() {
        sideBar.followProfileLink();
        profilePage.getNotLogginLabel().shouldBe(visible).
                shouldHave(text("please visit the login page to enter or register page to register yourself."));
    }
}


