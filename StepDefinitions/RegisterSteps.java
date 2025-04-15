package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hint.PageObject.SignInPage;
import org.hint.PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterSteps {

    private final WebDriver driver = Hooks.driver;
    RegisterPage registerPage = new RegisterPage(driver);
    SignInPage signInPage = new SignInPage(driver);


    @Given("open hint website")
    public void openHintWebsite() {
    }

    @And("user close popup banner")
    public void userClosePopupBanner() {
        signInPage.closePopupBanner();
    }

    @Then("open register page")
    public void openRegisterPage() {
        signInPage.clickBtnAccount();
        registerPage.goToRegisterPage();
    }

    @And("input first name")
    public void inputFirstName() {
        registerPage.inputFirstName();
    }

    @And("input last name")
    public void inputLastName() {
        registerPage.inputLastName();
    }

    @And("input new email")
    public void inputNewEmail() {
        registerPage.inputNewEmail();
    }

    @And("input new password")
    public void inputNewPassword() {
        registerPage.inputNewPassword();
    }

    @And("input new password confirmation")
    public void inputNewPasswordConfirmation() {
        registerPage.inputNewPasswordConfirmation();
    }

    @And("input new birth date")
    public void inputNewBirthDate() throws InterruptedException {
        registerPage.inputDoB();
    }

    @And("user click checkbox terms and conditions")
    public void userClickCheckboxTermsAndConditions() {
        registerPage.clickTermsAndConditions();
    }

    @And("click register button")
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("see label congratulations registration is success")
    public void seeLabelCongratulationsRegistrationIsSuccess() {
        registerPage.verifyAfterRegister();
    }

    @And("user see error message all register fields are required")
    public void userSeeErrorMessageAllRegisterFieldsAreRequired() {
        registerPage.verifyAllRegisterFieldsRequired();
    }

    @And("input new password confirmation doesn't match")
    public void inputNewPasswordConfirmationDoesnTMatch() {
        registerPage.inputNewPasswordConfirmationDoesntMatch();
    }

    @And("user see error message doesn't match on password confirmation field")
    public void userSeeErrorMessageDoesnTMatchOnPasswordConfirmationField() {
        registerPage.verifyInvalidConfirmPassword();
    }

    @And("input first name with symbol")
    public void inputFirstNameWithSymbol() {
        registerPage.inputInvalidFirstName();
    }

    @And("user see error message may contain alphabets and space on first name field")
    public void userSeeErrorMessageMayContainAlphabetsAndSpaceOnFirstNameField() {
        registerPage.verifyInvalidFirstNameMayContainAlphabetAndNumber();
    }

    @And("input invalid format email")
    public void inputInvalidFormatEmail() throws IOException {
        registerPage.inputInvalidFormatEmail();
    }

    @And("user see error message invalid email address on email field")
    public void userSeeErrorMessageInvalidEmailAddressOnEmailField() {
        registerPage.verifyInvalidFormatEmail();
    }

    @And("input last name with symbol")
    public void inputLastNameWithSymbol() {
        registerPage.inputInvalidLastName();
    }

    @And("user see error message may contain alphabets and space on last name field")
    public void userSeeErrorMessageMayContainAlphabetsAndSpaceOnLastNameField() {
        registerPage.verifyInvalidLastNameMayContainAlphabetAndNumber();
    }

    @And("input new password less than six characters")
    public void inputNewPasswordLessThanSixCharacters() {
        registerPage.inputNewPasswordLessThan6Char();
    }

    @And("user see error message password at least six characters on password field")
    public void userSeeErrorMessagePasswordAtLeastSixCharactersOnPasswordField() {
        registerPage.verifyInvalidPasswordLessThan6Chars();
    }

    @And("input new password which not combine alphabet and number")
    public void inputNewPasswordWhichNotCombineAlphabetAndNumber() {
        registerPage.inputNewPasswordNotCombination();
    }

    @And("user see error message must have one character and one number on password field")
    public void userSeeErrorMessageMustHaveOneCharacterAndOneNumberOnPasswordField() {
        registerPage.verifyInvalidPasswordNotCombination();
    }

    @And("input registered email")
    public void inputRegisteredEmail() throws IOException {
        registerPage.inputRegisteredEmail();
    }

    @And("user see error message registered email on email field")
    public void userSeeErrorMessageRegisteredEmailOnEmailField() {
        registerPage.verifyRegisteredEmail();
    }

    @And("input temporary email")
    public void inputTemporaryEmail() throws IOException {
        registerPage.inputTemporaryEmail();
    }

    @And("user see error message invalid email on email field")
    public void userSeeErrorMessageInvalidEmailOnEmailField() {
        registerPage.verifyInvalidEmail();
    }


    @And("user register and login new account")
    public void userRegisterAndLoginNewAccount() {
        signInPage.clickBtnAccount();
        registerPage.goToRegisterPage();
        registerPage.inputFirstName();
        registerPage.inputLastName();
        registerPage.registerStoredAccount();
        registerPage.inputNewPasswordConfirmation();
        registerPage.clickTermsAndConditions();
        registerPage.clickRegisterButton();
        registerPage.verifyAfterRegister();
        signInPage.clickBtnAccount();
        signInPage.loginStoredAccount();
    }

}
