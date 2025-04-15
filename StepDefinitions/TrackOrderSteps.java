package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hint.PageObject.TrackOrderPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TrackOrderSteps {

    private final WebDriver driver = Hooks.driver;
    TrackOrderPage trackOrder = new TrackOrderPage(driver);


    @And("user open track order page")
    public void userOpenTrackOrderPage() {
        trackOrder.goToTrackOrderPage();
    }

    @And("user input invalid order ID to be tracked")
    public void userInputInvalidOrderIDToBeTracked() {
        trackOrder.inputInvalidOrderID();
    }

    @And("user input invalid email to be tracked")
    public void userInputInvalidEmailToBeTracked() {
        trackOrder.inputInvalidEmail();
    }

    @Then("user click submit to track order")
    public void userClickSubmitToTrackOrder() {
        trackOrder.clickSubmitTrack();
    }

    @And("appear error message 'Invalid order ID or email'")
    public void appearErrorMessageInvalidOrderIDOrEmail() {
        trackOrder.verifyErrorInvalidOrderIDorEmail();
    }


    @And("user input valid order ID to be tracked")
    public void userInputValidOrderIDToBeTracked() {
        trackOrder.inputValidOrderID();
    }

    @And("user input valid email to be tracked")
    public void userInputValidEmailToBeTracked() throws IOException {
        trackOrder.inputValidEmail();
    }

    @And("verify redirected to track order page with appear status of certain order ID")
    public void verifyRedirectedToTrackOrderPageWithAppearStatusOfCertainOrderID() {
        trackOrder.verifySuccessGetTrackOrder();
    }

    @Then("appear error message 'Required fields.' on order ID and email field")
    public void appearErrorMessageRequiredFieldsOnOrderIDAndEmailField() {
        trackOrder.checkRequiredFieldTrackOrder();
    }
}
