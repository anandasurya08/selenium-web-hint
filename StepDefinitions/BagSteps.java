package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import org.hint.PageObject.BagPage;
import org.openqa.selenium.WebDriver;

public class BagSteps {

    private final WebDriver driver = Hooks.driver;
    BagPage bagPage = new BagPage(driver);


    @And("go to checkout shipping page")
    public void goToCheckoutShippingPage() {
        bagPage.openBag();
        bagPage.goToCheckoutPage();
    }

}
