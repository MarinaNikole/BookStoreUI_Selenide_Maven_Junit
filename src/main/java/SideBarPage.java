import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Getter
@Setter
 public class SideBarPage {
    private SelenideElement loginLink = $(byText("Login"));
    private SelenideElement bookStoreLink = $(byText("Book Store"));
    private SelenideElement profileLink = $(byText("Profile"));


    public void followLoginLink(){
        loginLink.scrollTo().shouldBe(Condition.visible).click();
    }

    public void followBookStoreLink(){
        bookStoreLink.scrollTo().shouldBe(Condition.visible).click();
    }

    public void followProfileLink(){
        profileLink.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
    }
}
