//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class SignUpTest {
//    WebDriver driver;
//    SignUpPage page;
//
//    @Before
//    public void SetUp() {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://www.spotify.com/us/signup/");
//    }
//
//    @Test
//    public void typeInvalidYear() {
//        page = new SignUpPage(driver);
//        page.setMonth("July").
//                setDay("20").
//                setYear("85").
//                setShare(true);
//        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
//    }
//
//    @Test
//    public void typeInvalidEmail() {
//        page = new SignUpPage(driver);
//        page.typeEmail("test@mail.test").
//                typeConfirmEmailField("wrong@mail.test").
//                typeName("TestName").
//                clickSignUpButton();
//        Assert.assertTrue(page.isErrorVisible("Email address doesn't match."));
//    }
//
//    @Test
//    public void signUpWithEmptyPassword() {
//        page = new SignUpPage(driver);
//        page.typeEmail("test@mail.test")
//                .typeConfirmEmailField("wrong@mail.test")
//                .typeName("TestName")
//                .clickSignUpButton();
//        Assert.assertTrue(page.isErrorVisible("Enter a password to continue."));
//    }
//
//    @Test
//    public void typeInvalidValues() throws InterruptedException {
//        page = new SignUpPage(driver);
//        page.typeEmail("test@mail").
//                typeConfirmEmailField("wrong@mail.test")
//                .typePasswordField("542fffffjkk")
//                .typeName("TestName")
//                .setSex("Male")
//                .setShare(false).
//                clickSignUpButton();
//        Assert.assertEquals(6, page.getErrors().size());
//        Assert.assertEquals("Please enter your birth month.", page.getErrorByNumber(3));
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}
