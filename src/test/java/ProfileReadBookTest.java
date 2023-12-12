import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;


public class ProfileReadBookTest extends BaseTest {
    ApiHelper apiHelper = new ApiHelper();;

    String username = "Ronny";
    String password = "123Ron321&";
@Before
public void addEightBooks(){
     apiHelper.addEightBooks();
}
    @Test
    public void openFirstBookWebsite() {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        String bookToFollow = profilePage.getTitleCollection(0);
        profilePage.selectBook(0);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSecondBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        String bookToFollow = profilePage.getTitleCollection(1);
        profilePage.selectBook(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openThirdBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        String bookToFollow = bookStorePage.getSearchTitle(2);
        bookStorePage.selectBook(2);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openForthBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        String bookToFollow = profilePage.getTitleCollection(3);
        profilePage.selectBook(3);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openFifthBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        String bookToFollow = profilePage.getTitleCollection(4);
        profilePage.selectBook(4);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSixthBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.clickNextButton();
        String bookToFollow = profilePage.getTitleCollection(0);
        profilePage.selectBook(0);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSeventhBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.clickNextButton();
        String bookToFollow = profilePage.getTitleCollection(1);
        profilePage.selectBook(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openEighthBookWebsite()  {
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.clickNextButton();
        String bookToFollow = profilePage.getTitleCollection(2);
        profilePage.selectBook(2);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text(bookToFollow));
    }

@After
    public void deleteAllBooks(){
    apiHelper.deleteAllBooks();
}

}
