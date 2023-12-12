import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Setter
public class LoginPage {
    private SelenideElement loginHeader = $x("//div[text()='Login']");
    private SelenideElement userNameInputField = $(By.id("userName"));
    private SelenideElement passwordInputField = $(By.id("password"));
    private SelenideElement invalidUserNameFormControl = $x("//*[@class='mr-sm-2 is-invalid form-control' and @id='userName']");
    private SelenideElement invalidPasswordFormControl = $x("//*[@class='mr-sm-2 is-invalid form-control' and @id='password']");
    private SelenideElement loginButton = $(By.cssSelector("[class='btn btn-primary']"));
    private SelenideElement newUserButton = $(byText("New User"));

    private SelenideElement invalidUsernameAndPasswordMessage = $(By.id("name"));
    private SelenideElement offBullets = $x("//*[text()='off Bullets']");
    private SelenideElement rememberMeCheckbox = $(byText("Remember me"));
    private SelenideElement resetPasswordButton = $(byText("Reset password"));
    private SelenideElement continueWithGoogleButton = $x( "//div[contains(text(), 'Continue with Google')]");
    private SelenideElement loginViaFacebookButton = $x("//div[contains(text(), 'Login via Facebook')]");


    public void clickLoginButton(){
        loginButton.scrollTo().click();
    }
    public void clickNewUserButton(){
        newUserButton.scrollTo().shouldBe(visible).click();
    }
    public void userNameInput(String userName){
        userNameInputField.shouldBe(visible).setValue(userName);
    }
    public void passwordInput(String password){
        passwordInputField.shouldBe(visible).setValue(password);
    }
    public void loginProcess(String userName, String password){
        userNameInputField.shouldBe(visible).setValue(userName);
        passwordInputField.shouldBe(visible).setValue(password);
        loginButton.scrollTo().shouldBe(visible).click();
    }

    public void clickOffBullets(){
        offBullets.shouldHave(visible).click();
    }
}








