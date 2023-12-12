import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class ProfileDetailedInformationTest extends BaseTest{
    String username = "Ronny";
    String password = "123Ron321&";
    @Test
    public void availableFormatEPUBIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookFormatEPUB().shouldBe(visible);
    }

    @Test
    public void availableFormatFB2IsDisplayed(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookFormatFB2().shouldBe(visible);
    }
    @Test
    public void availableFormatMOBIIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookFormatMOBI().shouldBe(visible);
    }
    @Test
    public void availableFormatTXTIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(exactText(username));
        bookStorePage.selectBook(1);
        bookDetailedInformation.getBookFormatTXT().shouldBe(visible);
    }
}
