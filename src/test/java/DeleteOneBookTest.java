import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.switchTo;

public class DeleteOneBookTest extends BaseTest{
    ApiHelper apiHelper = new ApiHelper();

    @Before
    public void addBooks(){
        apiHelper.addThreeBooks();
    }

    @Test
    public void deleteOneBook(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getRegisteredUserName().shouldHave(Condition.exactText("Ronny"));
        String selectedBook = profilePage.getTitleCollection(1);
        profilePage.deleteOneBook(1);
        profilePage.confirmModalWindow();
        switchTo().alert().accept();
        profilePage.doesNotContainsTitle(selectedBook);
    }

    @After
    public void deleteAllBooks() {
        apiHelper.deleteAllBooks();
    }

}
