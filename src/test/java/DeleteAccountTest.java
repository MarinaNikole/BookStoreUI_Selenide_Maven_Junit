import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DeleteAccountTest extends BaseTest{
    ApiHelper apiHelper = new ApiHelper();
    Faker faker = new Faker();
    String username = faker.name().username();
    String password = "123Bob321&";
    @Before
    public void createUser(){
        apiHelper.createUser(username, password);
    }

    @Test
    public void deleteAccountTest(){
        sideBar.followLoginLink();
        loginPage.loginProcess(username, password);
        profilePage.getHeaderBooksTable().shouldBe(visible);
        profilePage.getRegisteredUserName().shouldBe(visible).shouldHave(text(username));
        profilePage.isBookCollectionDisplayed();
        profilePage.deleteAccount();
        profilePage.confirmModalWindow();
        loginPage.getLoginHeader().shouldBe(visible);
        loginPage.loginProcess(username, password);
        loginPage.getInvalidUsernameAndPasswordMessage().shouldBe(visible).shouldHave(text("Invalid username or password!"));
    }

}
