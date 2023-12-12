import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;


public class ProfileAddBookTest extends BaseTest {
ApiHelper apiHelper = new ApiHelper();
    String username = "Ronny";
    String password = "123Ron321&";

    @Before
    public void deleteBooks(){
        apiHelper.deleteAllBooks();
    }

    @Test
    public void addOneBook() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(Condition.exactText("Ronny"));
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(CollectionCondition.size(0));
        profilePage.followBookStoreLink();
        String selectedBook = bookStorePage.getTitleCollection(1);
        bookStorePage.selectBook(1);
        bookDetailedInformation.clickAddToCollectionButton();
        bookDetailedInformation.confirmModalWindow();
        sideBar.followProfileLink();
        profilePage.containsTitle(selectedBook);
    }

   @After
   public void deleteBooksAfter(){
       apiHelper.deleteAllBooks();
   }

}





