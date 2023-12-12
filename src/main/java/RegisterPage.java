import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Getter
@Setter
public class RegisterPage {
    private SelenideElement registerPageHeader =$("[class='main-header']");
    private SelenideElement backToLoginButton = $(By.id("gotologin"));
    private SelenideElement registerButton =$(By.id("register"));
    private SelenideElement verifyRecaptchaMessage = $(By.id("name"));
    private SelenideElement registrationForm = $(By.id("userForm"));
    private SelenideElement firstNameInputField = $(By.id("firstname"));
    private SelenideElement lastNameInputField = $(By.id("lastname"));
    private SelenideElement userNameInputField = $(By.id("userName"));
    private SelenideElement passwordInputField = $(By.id("password"));
    private SelenideElement countryInputField = $(By.id("country"));
    private SelenideElement cityInputField = $(By.id("city"));
    private SelenideElement confirmPasswordInputField = $(By.id("confirmPassword"));
    private SelenideElement emailInputField = $(By.id("email"));


public void filInnRegistrationForm(String firstName, String lastName, String userName, String password){
    firstNameInputField.shouldBe(Condition.visible).setValue(firstName);
    lastNameInputField.shouldBe(Condition.visible).setValue(lastName);
    userNameInputField.shouldBe(Condition.visible).setValue(userName);
    passwordInputField.shouldBe(Condition.visible).setValue(password);

}

public void clickRegisterButton(){
    registerButton.scrollTo().shouldBe(Condition.visible).click();
}
    public void clickBackToLoginButton(){
        backToLoginButton.scrollTo().shouldBe(Condition.visible).click();
    }
}
