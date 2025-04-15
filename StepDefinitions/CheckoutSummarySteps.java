package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hint.PageObject.CheckoutShippingPage;
import org.hint.PageObject.CheckoutSummaryPage;
import org.openqa.selenium.WebDriver;

public class CheckoutSummarySteps {

    private final WebDriver driver = Hooks.driver;
    CheckoutSummaryPage summaryPage = new CheckoutSummaryPage(driver);


    @And("go to confirmed page")
    public void goToConfirmedPage() {
        summaryPage.assertURLIsOnConfirmPage();
        summaryPage.goToConfirmedPage();
    }

}
