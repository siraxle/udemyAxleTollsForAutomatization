import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SignUpPageForSelenide {

    public SignUpPageForSelenide open() {
        Selenide.open("/");
        return this;
    }

    public SignUpPageForSelenide() { }

    By emailField = By.id("register-email");
    By ConfirmEmailField = By.id("register-confirm-email");
    By PasswordField = By.id("register-password");
    By nameField = By.id("register-displayname");
    By monthDropDown = By.id("register-dob-month");
    String getMonthDropDownOption = "//option[contains(text(),'%s')]";
    By dayField = By.id("register-dob-day");
    By yearField = By.id("register-dob-year");
    By sexRadioButton = By.xpath("//li[@id='li-gender']");
    By shareCheckBox = By.id("register-thirdparty");
    By submitButton = By.id("register-button-email-submit");
    By errorLabel = xpath("//label[@class='has-error' and string-length(text())>0]");
    String errorByText = "//label[@class='has-error' and text()=\"%s\"]";

    public SignUpPageForSelenide typeEmail(String email) {
        $(emailField).setValue(email);
        return this;
    }

    public SignUpPageForSelenide typeConfirmEmailField(String email) {
        $(ConfirmEmailField).setValue(email);
        return this;
    }

    public SignUpPageForSelenide typePasswordField(String password) {
        $(PasswordField).setValue(password);
        return this;
    }

    public SignUpPageForSelenide typeName(String name){
        $(nameField).setValue(name);
        return this;
    }

    public SignUpPageForSelenide setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPageForSelenide setDay(String day) {
        $(dayField).setValue(day);
        return this;
    }

    public SignUpPageForSelenide setYear(String year) {
        $(yearField).setValue(year);
        return this;
    }

    public SignUpPageForSelenide setSex(String value) throws InterruptedException {
        $(sexRadioButton).selectRadio(value);
        return this;
    }

    public SignUpPageForSelenide setShare(boolean value) {
        $(shareCheckBox).setSelected(value);
        return this;
    }

    public SignUpPageForSelenide clickSignUpButton() {
        $(submitButton).click();
        return this;
    }

    public ElementsCollection getErrors() {
        return $$(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).text();
    }

    public boolean isErrorVisible(String message) {
        return $(xpath(format(errorByText, message))).isDisplayed();
    }
}
