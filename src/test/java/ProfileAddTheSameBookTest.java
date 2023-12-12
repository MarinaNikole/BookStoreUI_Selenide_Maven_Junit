import com.codeborne.selenide.CollectionCondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.switchTo;

public class ProfileAddTheSameBookTest extends BaseTest{
    ApiHelper apiHelper = new ApiHelper();
   @Before
   public void addOneBook(){
    apiHelper.addOneBook(1);
   }
    @Test
    public void addTheSameBook(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getRegisteredUserName().shouldHave(exactText("Ronny"));
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(CollectionCondition.size(1));
        profilePage.followBookStoreLink();
        String selectedBook = bookStorePage.getTitleCollection(1);
        bookStorePage.selectBook(1);
        bookDetailedInformation.clickAddToCollectionButton();
        switchTo().alert(Duration.ofSeconds(6)).accept();
        bookDetailedInformation.clickBackToBookStore();
        sideBar.followProfileLink();
        profilePage.containsTitle(selectedBook);
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(1));
    }
    @After
    public void deleteAllBooks() {
       apiHelper.deleteAllBooks();
    }


}
