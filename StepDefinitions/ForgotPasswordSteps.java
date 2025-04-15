package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.hint.PageObject.ForgotPasswordPage;
import org.hint.PageObject.SignInPage;

import java.io.IOException;

public class ForgotPasswordSteps {

    private final WebDriver driver = Hooks.driver;
    ForgotPasswordPage forgotPass = new ForgotPasswordPage(driver);
    SignInPage signIn = new SignInPage(driver);



    @And("check reset password link is expired or not")
    public void checkResetPasswordLinkIsExpiredOrNot() throws InterruptedException {
        forgotPass.openResetPasswordLink();
        forgotPass.checkingResetPasswordLinkActiveOrNot();
    }

    @And("user open forgot password page")
    public void userOpenForgotPasswordPage() {
        signIn.clickBtnAccount();
        forgotPass.goToForgotPasswordPage();
    }

    @And("user input registered email to forgot password")
    public void userInputRegisteredEmailToForgotPassword() throws IOException {
        forgotPass.inputEmailForgotPass();
    }

    @And("user click send email forgot password")
    public void userClickSendEmailForgotPassword() {
        forgotPass.clickSendEmailForgotPass();
    }

    @Then("user successfully forgot password")
    public void userSuccessfullyForgotPassword() {
        forgotPass.verifySuccessfullySendEmailForgotPass();
    }

    @And("user open reset password link")
    public void userOpenResetPasswordLink() {
        forgotPass.openResetPasswordLink();
    }

    @And("user input new password")
    public void userInputNewPassword() {
        forgotPass.inputNewPassword();
    }

    @And("user input new confirm password")
    public void userInputNewConfirmPassword() {
        forgotPass.inputNewConfirmPassword();
    }

    @And("user click submit password button")
    public void userClickSubmitPasswordButton() {
        forgotPass.clickBtnSubmitNewPass();
    }

    @Then("verify showing reset password successfully")
    public void verifyShowingResetPasswordSuccessfully() {
        forgotPass.verifySuccessfullyResetPassword();
    }

    @Then("verify showing reset password link is expired")
    public void verifyShowingResetPasswordLinkIsExpired() {
        forgotPass.verifyPasswordResetLinkExpired();
    }

    @Then("see error message 'Required field.' on reset password field")
    public void seeErrorMessageRequiredFieldOnResetPasswordField() {
        forgotPass.verifyPassAndPassConfirmFieldRequired();
    }

    @And("user input password and confirm password which doesnot match")
    public void userInputPasswordAndConfirmPasswordWhichDoesnotMatch() {
        forgotPass.inputNewPassAndConfirmPassDoesntMatch();
    }

    @Then("see error message 'The Confirm New Password field does not match the New Password field.' on reset password field")
    public void seeErrorMessageTheConfirmNewPasswordFieldDoesNotMatchTheNewPasswordFieldOnResetPasswordField() {
        forgotPass.verifyPassAndPassConfirmDoesntMatch();
    }

}
