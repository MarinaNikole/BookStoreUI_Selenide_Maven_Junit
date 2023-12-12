import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static org.junit.Assert.assertEquals;


public class BookStoreCatalogDisplayTest extends BaseTest {

    @Test
    public void theBooksAreDisplayedInBookStore() {
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(8));
    }

    @Test
    public void booksRatingIsDisplayed(){
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookRatingDisplay().shouldBe(visible);
    }
    @Test
    public void booksReviewIsDisplayed(){
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookReviewDisplay().shouldBe(visible);
    }

    @Test
    public void bookQuantityDisplayOnTheFirstPage(){
        bookStorePage.getBooksCollection().filter(not(empty)).filter(visible).shouldHave(size(8));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value","1"));
        Assert.assertEquals("Expected and actual number of pages do not match", 1, bookStorePage.getActualTotalPages());
    }

    @Test
    public void coverImageTitleAuthorAreDisplayedTest() {
        bookStorePage.getImageHeaderButton().shouldBe(visible);
        bookStorePage.getTitleHeaderButton().shouldBe(visible);
        bookStorePage.getAuthorHeaderButton().shouldBe(visible);
    }


    @Test
    public void rowsOptionsTest() {
        List<String> expectedRowsSelector = new ArrayList<>();
        expectedRowsSelector.add("5 rows");
        expectedRowsSelector.add("10 rows");
        expectedRowsSelector.add("20 rows");
        expectedRowsSelector.add("25 rows");
        expectedRowsSelector.add("50 rows");
        expectedRowsSelector.add("100 rows");
        bookStorePage.clickRowSelector();
        List<String> actualRowsSelector = new ArrayList<>(bookStorePage.getRowsOptions());
        assertEquals("Expected row selector quantity and actual does not match", expectedRowsSelector, actualRowsSelector);

  // ****    select 5 rows  ****
        bookStorePage.select5Rows();
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(5));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do not match", 2, bookStorePage.getActualTotalPages());
        bookStorePage.clickNextButton();
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(3));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value", "2"));
        Assert.assertEquals("Expected and actual number of pages do not match", 2, bookStorePage.getActualTotalPages());
        bookStorePage.clickPreviousButton();
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(5));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do not match", 2, bookStorePage.getActualTotalPages());

 //   select 25 rows
        bookStorePage.select25Rows();
        bookStorePage.getBooksCollection().filter(exist).shouldHave(size(25));
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(8));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do not match", 1, bookStorePage.getActualTotalPages());
    }

    @Test
    public void select100rowsTest() {
        bookStorePage.clickRowSelector();
        bookStorePage.select100Rows();
        bookStorePage.getBooksCollection().filter(exist).shouldHave(size(100));
        bookStorePage.getBooksCollection().filter(not(empty)).shouldHave(size(8));
        bookStorePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do not match", 1, bookStorePage.getActualTotalPages());
    }

    @Test
    public void genreIsDisplayed(){
        bookStorePage.getGenreColumn().shouldBe(visible);
    }

    @Test
    public void publicationDateIsDisplayed(){
        bookStorePage.getPublicationDateColumn().shouldBe(visible);
    }

}
