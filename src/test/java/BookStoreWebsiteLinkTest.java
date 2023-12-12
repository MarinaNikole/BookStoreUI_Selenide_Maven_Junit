import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;


public class BookStoreWebsiteLinkTest extends BaseTest {


    @Test
    public void openFirstBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(0);
        bookStorePage.selectBook(0);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSecondBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(1);
        bookStorePage.selectBook(1);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openThirdBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(2);
        bookStorePage.selectBook(2);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openForthBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(3);
        bookStorePage.selectBook(3);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openFifthBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(4);
        bookStorePage.selectBook(4);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSixthBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(5);
        bookStorePage.selectBook(5);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openSeventhBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(6);
        bookStorePage.selectBook(6);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }

    @Test
    public void openEighthBookWebsite() {
        String bookToFollow = bookStorePage.getSearchTitle(7);
        bookStorePage.selectBook(7);
        bookDetailedInformation.getWebsite().scrollTo().shouldBe(visible);
        bookDetailedInformation.followWebsite();
        switchTo().window(1);
        bookDetailedInformation.createSelenidElement(bookToFollow).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(bookToFollow));
    }
}
