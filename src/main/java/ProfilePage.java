import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;
import static java.time.Duration.ofSeconds;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

@Getter
@Setter
public class ProfilePage {
    private SelenideElement profileHeader = $("[class='main-header']");
    private SelenideElement logOutButton = $x("//*[text()='Log out']");
    private SelenideElement registeredUserName = $(By.id("userName-value"));
    private SelenideElement notLogginLabel = $(By.id("notLoggin-label"));
    private ElementsCollection booksCollection = $$(By.cssSelector("[class ='rt-tr-group']"));
    private ElementsCollection booksTitleCollection = $$(By.className("action-buttons"));
    private ElementsCollection booksAuthorCollection = $$x("//div[@class='rt-td'][3]");
    private ElementsCollection booksPublisherCollection = $$x("//div[@class='rt-td'][4]");
    private SelenideElement searchInputField = $(By.id("searchBox"));
    private SelenideElement titleHeaderButton = $x("//div[text() ='Title']");
    private SelenideElement authorHeaderButton = $x("//div[text() ='Author']");
    private SelenideElement publisherHeaderButton = $x("//div[text() ='Publisher']");
    private SelenideElement goToBookStoreButton = $(By.id("gotoStore"));
    private SelenideElement bookStoreLink = $x("//*[text()='Book Store']");
    private SelenideElement headerBooksTable = $(By.cssSelector("[class='rt-table']"));
    private SelenideElement actionColumn = $x("//div[text() ='Action']");
    private ElementsCollection actionDelete = $$(By.id("delete-record-undefined"));
    private SelenideElement recommendedBooks = $x("//div[text()='recommended books']");


    private SelenideElement rowsSelector = $(By.cssSelector("[aria-label='rows per page']"));
    private SelenideElement pageActualValue = $("[aria-label='jump to page']");
    private SelenideElement totalPagesActualValue = $("[class='-totalPages']");

    private SelenideElement nextButton = $(byText("Next"));
    private SelenideElement previousButton = $(byText("Previous"));
    private SelenideElement deleteAllBooksButton = $("[class='text-right button di']");
    private SelenideElement confirmModalWindow = $(By.id("closeSmallModal-ok"));
    private SelenideElement deleteAccountButton = $x("//*[text()='Delete Account']");

    private ElementsCollection rowsCollection = $$(By.cssSelector("[aria-label='rows per page']"));
    private SelenideElement fiveRowsPerPage = $(By.cssSelector("[value='5']"));
    private SelenideElement tenRowsPerPage = $(By.cssSelector("[value='10']"));
    private SelenideElement twentyRowsPerPage = $(By.cssSelector("[value='20']"));
    private SelenideElement twentyFiveRowsPerPage = $(By.cssSelector("[value='25']"));
    private SelenideElement fiftyRowsPerPage = $(By.cssSelector("[value='50']"));
    private SelenideElement hundredRowsPerPage = $(By.cssSelector("[value='100']"));
    private SelenideElement borrowingHistory = $x("//div[text()='Borrowing History']");
    private SelenideElement twoFAAuthentication = $(byText("2FA"));


    //                     ****** search ********
    public String getSearchAuthor(int bookIndex) {
        return booksAuthorCollection.get(bookIndex).shouldBe(visible).getText();
    }

    public void authorSearchAssert(String inputSearch) {
        searchInputField.sendKeys(inputSearch);
        for (SelenideElement author : booksAuthorCollection.filter(not(empty))) {
            author.shouldHave(text(inputSearch));
        }
    }

    public String getSearchTitle(int bookIndex) {
        return booksTitleCollection.get(bookIndex).shouldBe(visible, ofSeconds(10)).getText();
    }

    public void titleSearchAssert(String inputSearch) {
        searchInputField.scrollTo().sendKeys(inputSearch);
        for (SelenideElement title : booksTitleCollection.filter(not(empty))) {
            title.shouldBe(visible).shouldHave(text(inputSearch));
        }
    }

    public String getSearchPublisher(int bookIndex) {
        return booksPublisherCollection.get(bookIndex).shouldBe(visible).getText();
    }

    public void publisherSearchAssert(String inputSearch) {
        searchInputField.sendKeys(inputSearch);
        for (SelenideElement publisher : booksPublisherCollection.filter(not(empty))) {
            publisher.shouldHave(text(inputSearch));
        }
    }

    //                 ******    Sort    *****

    public void sortTitleA_Z() {
        List<String> actualTitleSorting = booksTitleCollection.filter(not(empty)).texts();
        List<String> expectedTitleSorting = new ArrayList<>(actualTitleSorting);
        sort(expectedTitleSorting);
        assertEquals(expectedTitleSorting, actualTitleSorting);
    }

    public void sortTitleZ_A() {
        List<String> actualTitleSorting = booksTitleCollection.filter(not(empty)).texts();
        List<String> expectedTitleSorting = new ArrayList<>(actualTitleSorting);
        expectedTitleSorting.sort(reverseOrder());
        assertEquals(expectedTitleSorting, actualTitleSorting);
    }

    public void sortAuthorA_Z() {
        List<String> actualAuthorSorting = booksAuthorCollection.filter(not(empty)).texts();
        List<String> expectedTitleSorting = new ArrayList<>(actualAuthorSorting);
        sort(expectedTitleSorting);
        assertEquals(expectedTitleSorting, actualAuthorSorting);
    }

    public void sortAuthorZ_A() {
        List<String> actualAuthorSorting = booksAuthorCollection.filter(not(empty)).texts();
        List<String> expectedAuthorSorting = new ArrayList<>(actualAuthorSorting);
        expectedAuthorSorting.sort(reverseOrder());
        assertEquals(expectedAuthorSorting, actualAuthorSorting);
    }

    public void sortPublisherA_Z() {
        List<String> actualPublisherSorting = booksPublisherCollection.filter(not(empty)).texts();
        List<String> expectedPublisherSorting = new ArrayList<>(actualPublisherSorting);
        sort(expectedPublisherSorting);
        assertEquals(expectedPublisherSorting, actualPublisherSorting);
    }

    public void sortPublisherZ_A() {
        List<String> actualPublisherSorting = booksPublisherCollection.filter(not(empty)).texts();
        List<String> expectedPublisherSorting = new ArrayList<>(actualPublisherSorting);
        expectedPublisherSorting.sort(reverseOrder());
        assertEquals(expectedPublisherSorting, actualPublisherSorting);
    }


    public void clickTitleHeader() {
        titleHeaderButton.shouldBe(visible).click();
    }

    public void doubleClickTitleHeader() {
        titleHeaderButton.shouldBe(visible).doubleClick();
    }

    public void clickAuthorHeader() {
        authorHeaderButton.shouldBe(visible).click();
    }

    public void doubleClickAuthorHeader() {
        authorHeaderButton.shouldBe(visible).doubleClick();
    }

    public void clickPublisherHeader() {
        publisherHeaderButton.shouldBe(visible).click();
    }

    public void doubleClickPublisherHeader() {
        publisherHeaderButton.shouldBe(visible).doubleClick();
    }

    public void clickLogOutButton() {
        logOutButton.shouldBe(visible).click();
    }

    public void deleteAccount() {
        deleteAccountButton.scrollTo().shouldBe(visible).click();
    }

    public void confirmModalWindow() {
        if (confirmModalWindow.isDisplayed()) {
            confirmModalWindow.click();
        } else {
            confirm();
        }
    }

    public void followBookStoreLink() {
        bookStoreLink.shouldBe(visible).scrollTo().click();
    }

    public void clickDeleteAllBooksButton() {
        deleteAllBooksButton.scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void deleteOneBook(int bookIndex) {
        actionDelete.get(bookIndex).click();
    }


    public String getTitleCollection(int index) {
        return booksTitleCollection.filter(not(empty)).get(index).shouldBe(visible).getText();
    }

    public void selectBook(int bookIndex) {
        //booksTitleCollection.get(0).shouldBe(visible, Duration.ofSeconds(15));
        booksTitleCollection.filter(not(empty)).get(bookIndex).scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void containsTitle(String title) {
        for (SelenideElement bookTittle : booksTitleCollection) {
            bookTittle.shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(title));
        }
    }

    public void doesNotContainsTitle(String title) {
        for (SelenideElement bookTittle : booksTitleCollection) {
            bookTittle.shouldBe(visible).shouldNotHave(text(title));
        }
    }

    public List<String> getRowsOptions() {
        List<String> actualRows = new ArrayList<>();
        actualRows.add(fiveRowsPerPage.shouldBe(visible).getText());
        actualRows.add(tenRowsPerPage.shouldBe(visible).getText());
        actualRows.add(twentyRowsPerPage.shouldBe(visible).getText());
        actualRows.add(twentyFiveRowsPerPage.shouldBe(visible).getText());
        actualRows.add(fiftyRowsPerPage.shouldBe(visible).getText());
        actualRows.add(hundredRowsPerPage.shouldBe(visible).getText());
        return actualRows;
    }

    public int getActualTotalPages() {
        return parseInt(totalPagesActualValue.scrollTo().shouldBe(visible).getText());
    }

    public void clickRowSelector() {
        rowsSelector.scrollTo().shouldBe(visible).click();
    }

    public void select10Rows() {
        tenRowsPerPage.scrollTo().shouldBe(visible).click();
    }

    public void select25Rows() {
        twentyFiveRowsPerPage.scrollTo().shouldBe(visible).click();
    }

    public void select100Rows() {
        hundredRowsPerPage.scrollTo().shouldBe(visible).click();
    }

    public void clickNextButton() {
        nextButton.scrollIntoView(true).shouldBe(visible).click();
    }

    public void clickPreviousButton() {
        previousButton.scrollTo().shouldBe(visible).click();
    }


    public void confirmLogin(String userName) {
        registeredUserName.shouldBe(visible).shouldHave(text(userName));
    }

    public void isBookCollectionDisplayed() {
        for (SelenideElement book : booksCollection) {
            book.shouldBe(visible);
        }
    }

}


