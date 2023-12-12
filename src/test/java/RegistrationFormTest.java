import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

public class RegistrationFormTest extends BaseTest {
    @Test
    public void newUserButtonTest() {
        sideBar.followLoginLink();
        loginPage.clickNewUserButton();
        registerPage.getRegisterPageHeader().shouldBe(visible).shouldHave(text("Register"));
        registerPage.clickBackToLoginButton();
        loginPage.getLoginHeader().shouldBe(visible);
    }

    @Test
    public void NavigationToRegistrationPage() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.getRegistrationForm().shouldBe(visible);
    }

    @Test
    public void fieldsWithValidDataWithoutRECAPTCA() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.filInnRegistrationForm("Anna", "Smith", "Anna", "123Anna321&");
        registerPage.clickRegisterButton();
        registerPage.getVerifyRecaptchaMessage().scrollTo().shouldBe(visible).shouldHave(text("Please verify reCaptcha to register!"));
    }

    @Test
    public void countryInputFieldIsVisible() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.getCountryInputField().shouldBe(visible);
    }

    @Test
    public void cityInputFieldIsVisible() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.getCityInputField().shouldBe(visible);
    }

    @Test
    public void emailInputFieldIsVisible() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.getEmailInputField().shouldBe(visible);
    }

    @Test
    public void confirmEmailInputFieldIsVisible() {
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.getEmailInputField().shouldBe(visible);
    }

    @Test
    public void emptyFieldsWithoutRecaptcha(){
        bookStorePage.clickLoginButton();
        loginPage.clickNewUserButton();
        registerPage.clickRegisterButton();
        registerPage.getFirstNameInputField().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
        registerPage.getLastNameInputField().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
        registerPage.getUserNameInputField().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
        registerPage.getPasswordInputField().shouldBe(visible).
                shouldHave(attribute("validationMessage", "Please fill out this field."));
    }

}
