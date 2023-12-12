import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class ProfileSearchTest extends BaseTest {
    ApiHelper apiHelper = new ApiHelper();
    String username = "Ronny";
    String password = "123Ron321&";


    @Before
    public void addBooks(){
        apiHelper.addThreeBooks();
    }

    @Test
    public void searchBooksByAuthor(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
       profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        String authorToSearch = profilePage.getSearchAuthor(1);
        profilePage.authorSearchAssert(authorToSearch);
        profilePage.getBooksAuthorCollection().filter(not(empty)).get(0).shouldHave(text(authorToSearch));
    }

    @Test
    public void searchBooksByTitle(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        String titleToSearch = profilePage.getSearchTitle(0);
        profilePage.titleSearchAssert(titleToSearch);
        profilePage.getBooksTitleCollection().filter(not(empty)).get(0).shouldHave(text(titleToSearch));
    }

    @Test
    public void searchBookByPublisher(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        String publisherToSearch = profilePage.getSearchPublisher(2);
        profilePage.publisherSearchAssert(publisherToSearch);
        profilePage.getBooksPublisherCollection().filter(not(empty)).get(0).shouldHave(text(publisherToSearch));
    }

    @After
    public void deleteAllBooks() {
        apiHelper.deleteAllBooks();
    }
}
