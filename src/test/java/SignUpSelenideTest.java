import org.junit.*;
import static com.codeborne.selenide.Selenide.*;

public class SignUpSelenideTest {
    SignUpPageForSelenide page;

    @BeforeClass
    public static void SetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        String baseUrl = "https://www.spotify.com/us/signup/";
        open(baseUrl);
    }

    @Test
    public void typeInvalidYear() {
        page = new SignUpPageForSelenide();
        page.setMonth("July").
                setDay("20").
                setYear("85").
                setShare(true);
        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
    }

    @Test
    public void typeInvalidEmail() {
        page = new SignUpPageForSelenide();
        page.typeEmail("test@mail.test").
                typeConfirmEmailField("wrong@mail.test").
                typeName("TestName").
                clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Email address doesn't match."));
    }

    @Test
    public void signUpWithEmptyPassword() {
        page = new SignUpPageForSelenide();
        page.typeEmail("test@mail.test")
                .typeConfirmEmailField("wrong@mail.test")
                .typeName("TestName")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Enter a password to continue."));
    }

    @Test
    public void typeInvalidValues() throws InterruptedException {
        page = new SignUpPageForSelenide();
        page.typeEmail("test@mail").
                typeConfirmEmailField("wrong@mail.test")
                .typePasswordField("542fffffjkk")
                .typeName("TestName")
                .setSex("Male")
                .setShare(false).
                clickSignUpButton();
        Assert.assertEquals(6, page.getErrors().size());
        Assert.assertEquals("Please enter your birth month.", page.getErrorByNumber(3));
    }

}
