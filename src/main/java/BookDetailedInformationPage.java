import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Getter
@Setter
public class BookDetailedInformationPage {
    private SelenideElement ISBN = $(By.id("ISBN-label"));
    private SelenideElement title = $(By.id("title-label"));
    private SelenideElement author = $x("//*[text()='Author : ']");
    private SelenideElement publisher = $x("//*[text()='Publisher : ']");
    private SelenideElement totalPages = $(By.id("pages-label"));
    private SelenideElement synopsis = $(By.id("description-label"));
    private SelenideElement website = $x("//label[contains(text(),'http')]");
    private SelenideElement yearOfPublication = $(By.id("yearOfPublication-label"));


    private SelenideElement websiteBookHeader = $x( "//div[contains(text(), 'Profile')]");
    private SelenideElement bookRatingDisplay = $x( "//*[contains(text(), 'Rating')]");
    private SelenideElement bookReviewDisplay = $x( "//*[contains(text(), 'Review')]");
    private SelenideElement bookFormatEPUB = $x(  "//*[contains(text(), 'EPUB')]");
    private SelenideElement bookFormatFB2 = $x(  "//*[contains(text(), 'FB2')]");
    private SelenideElement bookFormatMOBI = $x( "//*[contains(text(), 'MOBI')]");
    private SelenideElement bookFormatTXT = $x( "//*[contains(text(), 'TXT')]");

    private SelenideElement addToYourCollectionButton = $(byText("Add To Your Collection"));
    private SelenideElement backToBookStoreButton = $("[class=\"text-left fullButton\"]");
    private SelenideElement confirmModalWindow = $(By.id("closeSmallModal-ok"));


    public void followWebsite() {
        website.scrollIntoView(true).shouldBe(visible).click();
    }

    public SelenideElement createSelenidElement(String title) {
        return $x("//*[text()='" + title + "']");
    }

    public void confirmModalWindow (){
        if (confirmModalWindow.isDisplayed()){
            confirmModalWindow.click();
        } else {
            switchTo().alert().accept();
        }
    }

    public void clickAddToCollectionButton(){
        addToYourCollectionButton.scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void clickBackToBookStore(){
        backToBookStoreButton.shouldBe(enabled, Duration.ofSeconds(15)).click();
    }

}

