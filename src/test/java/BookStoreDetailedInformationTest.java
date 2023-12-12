import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;

public class BookStoreDetailedInformationTest extends BaseTest{
    @Test
    public void requiredBookDetailsAreDisplayedTest() {
        bookStorePage.selectBook(0);
        bookDetailedInformation.getISBN().shouldBe(visible);
        bookDetailedInformation.getTitle().shouldBe(visible);
        bookDetailedInformation.getAuthor().shouldBe(visible);
        bookDetailedInformation.getPublisher().shouldBe(visible);
        bookDetailedInformation.getTotalPages().shouldBe(visible);
        bookDetailedInformation.getSynopsis().shouldBe(visible);
        bookDetailedInformation.getYearOfPublication().shouldBe(visible);
    }

}
