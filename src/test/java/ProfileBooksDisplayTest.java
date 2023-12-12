import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static org.junit.Assert.assertEquals;


public class ProfileBooksDisplayTest extends BaseTest {

    ApiHelper apiHelper = new ApiHelper();
    String username = "Ronny";
    String password = "123Ron321&";
    @Before
    public void addBooks() {
        apiHelper.addListOfSixBooks();
    }

    @Test
    public void rowsOptionsTest() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(exactText(username));
        List<String> expectedRowsSelector = new ArrayList<>();
        expectedRowsSelector.add("5 rows");
        expectedRowsSelector.add("10 rows");
        expectedRowsSelector.add("20 rows");
        expectedRowsSelector.add("25 rows");
        expectedRowsSelector.add("50 rows");
        expectedRowsSelector.add("100 rows");
        profilePage.clickRowSelector();
        List<String> actualRowsSelector = new ArrayList<>(profilePage.getRowsOptions());
        assertEquals("Expected row selector quantity and actual does not match", expectedRowsSelector, actualRowsSelector);
    }

    @Test
    public void bookQuantityDisplayOnTheFirstPage() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(exactText(username));

        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(5));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do NOT match", 2, profilePage.getActualTotalPages());

        profilePage.clickNextButton();
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(1));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value", "2"));
        Assert.assertEquals("Expected and actual number of pages do NOT match", 2, profilePage.getActualTotalPages());

        profilePage.clickPreviousButton();
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(5));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do NOT match", 2, profilePage.getActualTotalPages());
    }

    @Test
    public void select10RowsToDisplayTest() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(exactText(username));
        profilePage.clickRowSelector();
        profilePage.select10Rows();
        profilePage.getBooksCollection().filter(exist).shouldHave(size(10));
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(6));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do NOT match", 1, profilePage.getActualTotalPages());
    }

    @Test
    public void select25RowsToDisplayTest() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(exactText(username));
        profilePage.clickRowSelector();
        profilePage.select25Rows();
        profilePage.getBooksCollection().filter(exist).shouldHave(size(25));
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(6));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value", "1"));
        Assert.assertEquals("Expected and actual number of pages do NOT match", 1, profilePage.getActualTotalPages());
    }

    @Test
    public void select100RowsToDisplayTest() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldHave(exactText(username));
        profilePage.clickRowSelector();
        profilePage.select100Rows();
        profilePage.getBooksCollection().filter(exist).shouldHave(size(100));
        profilePage.getBooksCollection().filter(not(empty)).shouldHave(size(6));
        profilePage.getPageActualValue().shouldHave(attributeMatching("value","1"));
        Assert.assertEquals("Expected and actual number of pages do NOT match",1,profilePage.getActualTotalPages());
}

    @After
    public void deleteAllBooks() {
        apiHelper.deleteAllBooks();
    }

}



