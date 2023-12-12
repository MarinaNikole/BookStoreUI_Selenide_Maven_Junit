import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class ProfileSortTest extends BaseTest {
    ApiHelper apiHelper = new ApiHelper();
    String username = "Ronny";
    String password = "123Ron321&";

    @Before
    public void addBooks() {
        apiHelper.addListOfSixBooks();
    }

    @Test
    public void titleSort_A_Z() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.clickTitleHeader();
        profilePage.sortTitleA_Z();
    }

    @Test
    public void titleSort_Z_A() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.doubleClickTitleHeader();
        profilePage.sortTitleZ_A();
    }


    @Test
    public void authorSort_A_Z() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.clickAuthorHeader();
        profilePage.sortAuthorA_Z();
    }

    @Test
    public void authorSort_Z_A() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.doubleClickAuthorHeader();
        profilePage.sortAuthorZ_A();
    }

    @Test
    public void publisherSort_A_Z() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.clickPublisherHeader();
        profilePage.sortPublisherA_Z();
    }

    @Test
    public void publisherSort_Z_A() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        profilePage.doubleClickPublisherHeader();
        profilePage.sortPublisherZ_A();
    }

    @After
    public void deleteAllBooks() {
        apiHelper.deleteAllBooks();
    }

}
