import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class ProfileBorrowingHistoryTest extends BaseTest{
    @Test
    public void borrowingHistoryDisplay(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getRegisteredUserName().shouldHave(exactText("Ronny"));
        profilePage.getBorrowingHistory().shouldBe(visible).isDisplayed();
    }

}
