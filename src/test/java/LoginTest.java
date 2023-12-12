import org.junit.Test;
import static com.codeborne.selenide.Condition.*;

public class LoginTest extends BaseTest{

    @Test
    public void successLogin()  {
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        profilePage.getHeaderBooksTable().shouldBe(visible);
        profilePage.getActionColumn().shouldBe(visible);
        profilePage.isBookCollectionDisplayed();
    }

    @Test
    public void rememberMeCheckBoxIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321&");
        loginPage.getRememberMeCheckbox().shouldBe(visible);
    }

    @Test
    public void resetPasswordButtonIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.getResetPasswordButton().shouldBe(visible);
    }

    @Test
    public void tenInvalidLoginAttempt(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.getInvalidUsernameAndPasswordMessage().shouldBe(visible).shouldHave(text("The account is temporary locked."));
    }
    @Test
    public void validUserNameInvalidPasswordTest(){
        sideBar.followLoginLink();
        loginPage.loginProcess("Ronny", "123Ron321");
        loginPage.getInvalidUsernameAndPasswordMessage().shouldHave(text("Invalid username or password!"));
    }

    @Test
    public void invalidUsernameValidPassword(){
        bookStorePage.clickLoginButton();
        loginPage.loginProcess("Ronn", "123Ron321&");
        loginPage.getInvalidUsernameAndPasswordMessage().shouldHave(text("Invalid username or password!"));
    }


    @Test
    public void emptyRequiredFields(){
        sideBar.followLoginLink();
        loginPage.clickLoginButton();
        loginPage.getInvalidUserNameFormControl().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
        loginPage.getInvalidPasswordFormControl().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
    }

    @Test
    public void emptyPasswordField(){
        sideBar.followLoginLink();
        loginPage.userNameInput("Ronny");
        loginPage.clickLoginButton();
        loginPage.getInvalidPasswordFormControl().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
    }

    @Test
    public void emptyUserNameField(){
        sideBar.followLoginLink();
        loginPage.passwordInput("123Ron321&");
        loginPage.clickLoginButton();
        loginPage.getInvalidUserNameFormControl().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
    }

    @Test
    public void loginViaGoogleAccountIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.getContinueWithGoogleButton().shouldBe(visible);
    }
    @Test
    public void loginViaFacebookAccountIsDisplayed(){
        sideBar.followLoginLink();
        loginPage.getLoginViaFacebookButton().shouldBe(visible);
    }

    @Test
    public void switchOffBulletsForPassword(){
        sideBar.followLoginLink();
        loginPage.getUserNameInputField().setValue("Ronny");
        loginPage.getPasswordInputField().setValue("123Ron321&");
        loginPage.clickOffBullets();
        loginPage.getPasswordInputField().shouldHave(visible).shouldHave(text("123Ron321&"));
    }

}
