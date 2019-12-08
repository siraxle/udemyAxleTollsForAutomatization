//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//
//import static java.lang.String.format;
//import static org.openqa.selenium.By.xpath;
//
//public class SignUpPage {
//    WebDriver driver;
//
//    public SignUpPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    By emailField = By.id("register-email");
//    By ConfirmEmailField = By.id("register-confirm-email");
//    By PasswordField = By.id("register-password");
//    By nameField = By.id("register-displayname");
//    By monthDropDown = By.id("register-dob-month");
//    String getMonthDropDownOption = "//option[contains(text(),'%s')]";
//    By dayField = By.id("register-dob-day");
//    By yearField = By.id("register-dob-year");
//    String sexRadioButton = "//li[@id='li-gender']/label[normalize-space()='%s']/input";
//    By shareCheckBox = By.id("register-thirdparty");
//    By submitButton = By.id("register-button-email-submit");
//    By errorLabel = By.xpath("//label[@class='has-error' and string-length(text())>0]");
//    String errorByText = "//label[@class='has-error' and text()=\"%s\"]";
//
//    public SignUpPage typeEmail(String email) {
//        driver.findElement(emailField).sendKeys(email);
//        return this;
//    }
//
//    public SignUpPage typeConfirmEmailField(String email) {
//        driver.findElement(ConfirmEmailField).sendKeys(email);
//        return this;
//    }
//
//    public SignUpPage typePasswordField(String password) {
//        driver.findElement(PasswordField).sendKeys(password);
//        return this;
//    }
//
//    public SignUpPage typeName(String name){
//        driver.findElement(nameField).sendKeys(name);
//        return this;
//    }
//
//    public SignUpPage setMonth(String month) {
//        driver.findElement(monthDropDown).click();
//        new WebDriverWait(driver, 5)
//                .until(ExpectedConditions.visibilityOfElementLocated(xpath(format(getMonthDropDownOption, month)))).click();
//        return this;
//    }
//
//    public SignUpPage setDay(String day) {
//        driver.findElement(dayField).sendKeys(day);
//        return this;
//    }
//
//    public SignUpPage setYear(String year) {
//        driver.findElement(yearField).sendKeys(year);
//        return this;
//    }
//
//    public SignUpPage setSex(String value) throws InterruptedException {
//        Thread.sleep(1000);
//        driver.findElement(xpath(format(sexRadioButton, value))).click();
//        return this;
//    }
//
//    public SignUpPage setShare(boolean value) {
//        WebElement checkBox = driver.findElement(shareCheckBox);
//        if (!checkBox.isSelected() == value){
//            checkBox.click();
//        }
//        return this;
//    }
//
//    public SignUpPage clickSignUpButton() {
//        driver.findElement(submitButton).click();
//        return this;
//    }
//
//    public List<WebElement> getErrors() {
//        return driver.findElements(errorLabel);
//    }
//
//    public String getErrorByNumber(int number) {
//        return getErrors().get(number - 1).getText();
//    }
//
//    public boolean isErrorVisible(String message) {
//        return driver.findElements(xpath(format(errorByText, message))).size() > 0
//                && driver.findElements(xpath(format(errorByText, message))).get(0).isDisplayed();
//    }
//}
