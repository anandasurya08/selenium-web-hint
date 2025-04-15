package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hint.PageObject.AccountPage;
import org.openqa.selenium.WebDriver;

public class AccountSteps {

    private final WebDriver driver = Hooks.driver;
    AccountPage account = new AccountPage(driver);


    @And("user click Sign Out")
    public void userClickSignOut() {
        account.clickSignOutAccount();
    }

    @And("appear white icon profile as the user has signed out")
    public void appearWhiteIconProfileAsTheUserHasSignedOut() {
        account.verifySuccessfullyLogout();
    }

    @Then("verify showing Gopay payment information")
    public void verifyShowingGopayPaymentInformation() {
        account.openSpecificOrderIDDetailPage();
//        account.verifyStatusOrderInProgress();
        account.verifyPaymentGopay();
    }

    @Then("verify showing QRIS payment information")
    public void verifyShowingQRISPaymentInformation() {
        account.openSpecificOrderIDDetailPage();
        account.verifyPaymentQRIS();
    }

    @Then("verify showing Shopeepay payment information")
    public void verifyShowingShopeepayPaymentInformation() {
        account.openSpecificOrderIDDetailPage();
        account.verifyPaymentShopee();
    }

    @Then("verify showing VA Bank Lain payment information")
    public void verifyShowingVABankLainPaymentInformation() {
        account.openSpecificOrderIDDetailPage();
        account.verifyPaymentVABankLain();
    }
}
