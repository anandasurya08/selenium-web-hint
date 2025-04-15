package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hint.PageObject.SignInPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SignInSteps {

    private final WebDriver driver = Hooks.driver;
    SignInPage signInPage = new SignInPage(driver);


    @Given("user already logged in")
    public void userAlreadyLoggedIn() throws IOException {
        signInPage.clickBtnAccount();
        signInPage.inputEmail();
        signInPage.inputPassword();
        signInPage.clickLoginBtn();
        signInPage.verifyUserHasBeenLoggedIn();
    }

    @Then("open login page")
    public void openLoginPage() {
        signInPage.clickBtnAccount();
    }

    @And("user input email")
    public void userInputEmail() throws IOException {
        signInPage.inputEmail();
    }

    @And("user input password")
    public void userInputPassword() throws IOException {
        signInPage.inputPassword();
    }

    @And("user click login button")
    public void userClickLoginButton() {
        signInPage.clickLoginBtn();
    }

    @Then("user has been logged in")
    public void userHasBeenLoggedIn() {
        signInPage.verifyUserHasBeenLoggedIn();
    }

    @Then("user see error message all login fields are required")
    public void userSeeErrorMessageAllLoginFieldsAreRequired() {
        signInPage.verifyRequiredFieldEmailAndPassword();
    }

    @And("user input invalid email")
    public void userInputInvalidEmail() throws IOException {
        signInPage.inputInvalidEmail();
    }

    @And("user input unregistered email")
    public void userInputUnregisteredEmail() throws IOException {
        signInPage.inputUnregisteredEmail();
    }

    @Then("user see error message invalid email")
    public void userSeeErrorMessageInvalidEmail() {
        signInPage.verifyInvalidEmail();
    }

    @Then("user see error message email not registered")
    public void userSeeErrorMessageEmailNotRegistered() {
        signInPage.verifyUnregisteredEmail();
    }

    @And("user input invalid password")
    public void userInputInvalidPassword() throws IOException {
        signInPage.inputInvalidPassword();
    }

    @Then("user see error message invalid password")
    public void userSeeErrorMessageInvalidPassword() {
        signInPage.verifyInvalidPassword();
    }

}
