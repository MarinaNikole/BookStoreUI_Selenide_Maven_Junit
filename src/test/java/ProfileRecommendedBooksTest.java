import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class ProfileRecommendedBooksTest extends BaseTest {
    @Test
    public void recommendedBooksDisplay(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getRegisteredUserName().shouldHave(exactText("Ronny"));
        profilePage.getRecommendedBooks().shouldBe(visible);
    }

}
