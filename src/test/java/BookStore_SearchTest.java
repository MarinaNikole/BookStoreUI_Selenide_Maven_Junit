import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class BookStore_SearchTest extends BaseTest{

    @Test
    public void searchBooksByAuthor(){
        String authorToSearch = bookStorePage.getSearchAuthor(1);
        bookStorePage.authorSearchAssert(authorToSearch);
        bookStorePage.getBooksAuthorCollection().filter(not(empty)).get(0).shouldHave(text(authorToSearch));
    }

    @Test
    public void searchBooksByTitle(){
        String titleToSearch = bookStorePage.getSearchTitle(3);
        bookStorePage.titleSearchAssert(titleToSearch);
        bookStorePage.getBooksTitleCollection().filter(not(empty)).get(0).shouldHave(text(titleToSearch));
    }

    @Test
    public void searchBookByPublisher(){
        String publisherToSearch = bookStorePage.getSearchPublisher(7);
        bookStorePage.publisherSearchAssert(publisherToSearch);
        bookStorePage.getBooksPublisherCollection().filter(not(empty)).get(0).shouldHave(text(publisherToSearch));
    }

}
