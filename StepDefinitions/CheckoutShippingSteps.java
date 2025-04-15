package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import org.hint.PageObject.BagPage;
import org.hint.PageObject.CheckoutShippingPage;
import org.hint.PageObject.CurrencyPage;
import org.openqa.selenium.WebDriver;

public class CheckoutShippingSteps {

    private final WebDriver driver = Hooks.driver;
    CheckoutShippingPage shippingPage = new CheckoutShippingPage(driver);
    CurrencyPage currency = new CurrencyPage(driver);


    @And("go to checkout delivery and payment page")
    public void goToCheckoutDeliveryAndPaymentPage() {
        shippingPage.goToCheckoutDeliveryAndPaymentPage();
    }

    @And("user input dropshipper data")
    public void userInputDropshipperData() {
        shippingPage.inputDropshipperData();
    }

    @And("user input shipping data")
    public void userInputShippingData() {
        shippingPage.inputShippingFirstName();
        shippingPage.inputShippingLastName();
        shippingPage.inputShippingAddress();
        shippingPage.chooseShippingCity();
        shippingPage.chooseShippingZip();
        shippingPage.inputShippingPhone();
    }

    @And("user change into IDR currency")
    public void userChangeIntoIDRCurrency() {
        currency.changeIDRcurrency();
    }

    @And("user change into MYR currency")
    public void userChangeIntoMYRCurrency() {
        currency.changeMYRcurrency();
    }

    @And("user change into SGD currency")
    public void userChangeIntoSGDCurrency() {
        currency.changeSGDcurrency();
    }

    @And("user change into USD currency")
    public void userChangeIntoUSDCurrency() {
        currency.changeUSDcurrency();
    }

    @And("verify selected address on checkout was default address")
    public void verifySelectedAddressOnCheckoutWasDefaultAddress() {
        shippingPage.verifyDefaultAddressAppear();
    }
}
