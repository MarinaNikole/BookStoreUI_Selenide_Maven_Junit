import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    final String BASE_URL = "https://demoqa.com/books";

    @Before
    public void setUp(){
        //  Configuration.browserSize = "2560x1440";
        open(BASE_URL);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    SideBarPage sideBar = new SideBarPage();
    BookStorePage bookStorePage = new BookStorePage();
    ProfilePage profilePage = new ProfilePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    BookDetailedInformationPage bookDetailedInformation = new BookDetailedInformationPage();

}
