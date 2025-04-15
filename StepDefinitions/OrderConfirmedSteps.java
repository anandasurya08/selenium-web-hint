package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.Then;
import org.hint.PageObject.OrderConfirmedPage;
import org.openqa.selenium.WebDriver;

public class OrderConfirmedSteps {

    private final WebDriver driver = Hooks.driver;
    OrderConfirmedPage confirmedPage = new OrderConfirmedPage(driver);


    @Then("verify showing shipping disc information")
    public void verifyShowingShippingDiscInformation() {
        confirmedPage.assertIsOnConfirmedPage();
        confirmedPage.verifyShowShippingDiscInfo();
    }

    @Then("verify showing order ID information")
    public void verifyShowingOrderIDInformation() {
        confirmedPage.assertIsOnConfirmedPage();
        confirmedPage.verifyShowOrderIDInfo();
    }

    @Then("verify didn't showing shipping disc information")
    public void verifyDidnTShowingShippingDiscInformation() {
        confirmedPage.verifyNotShowShippingDiscInfo();
    }

    @Then("verify showing discount information")
    public void verifyShowingDiscountInformation() {
        confirmedPage.assertIsOnConfirmedPage();
        confirmedPage.verifyShowDiscountInfo();
    }

    @Then("verify showing IDR currency information")
    public void verifyShowingIDRCurrencyInformation() {
        confirmedPage.verifyIDRcurrency();
    }

    @Then("verify showing MYR currency information")
    public void verifyShowingMYRCurrencyInformation() {
        confirmedPage.verifyMYRcurrency();
    }

    @Then("verify showing SGD currency information")
    public void verifyShowingSGDCurrencyInformation() {
        confirmedPage.verifySGDcurrency();
    }

    @Then("verify showing USD currency information")
    public void verifyShowingUSDCurrencyInformation() {
        confirmedPage.verifyUSDcurrency();
    }

    @Then("verify showing JNE as delivery courier information")
    public void verifyShowingJNEAsDeliveryCourierInformation() {
        confirmedPage.verifyShowJNEInfo();
    }

    @Then("verify showing JNT as delivery courier information")
    public void verifyShowingJNTAsDeliveryCourierInformation() {
        confirmedPage.verifyShowJNTInfo();
    }

    @Then("verify showing added engrave letter")
    public void verifyShowingAddedEngraveLetter() {
        confirmedPage.verifyAddedEngraveLetter();
    }

    @Then("verify showing no any engrave letter appear")
    public void verifyShowingNoAnyEngraveLetterAppear() {
        confirmedPage.verifyEngraveLetterNotExists();
    }

}
