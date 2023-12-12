import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;


public class DeleteAllBooksTest extends BaseTest {
    ApiHelper apiHelper = new ApiHelper();

    @Before
    public void addBooks() {
        apiHelper.addTwoBooks();
    }

    @Test
    public void deleteAllBooks() {
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getRegisteredUserName().shouldHave(exactText("Ronny"));
        profilePage.clickDeleteAllBooksButton();
        profilePage.confirmModalWindow();
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(0));
        profilePage.followBookStoreLink();
    }

    @After
    public void deleteBooks() {
        apiHelper.deleteAllBooks();
    }
}
