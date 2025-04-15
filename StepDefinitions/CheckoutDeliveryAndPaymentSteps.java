package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hint.PageObject.CheckoutDeliveryAndPaymentPage;
import org.openqa.selenium.WebDriver;

public class CheckoutDeliveryAndPaymentSteps {

    private final WebDriver driver = Hooks.driver;
    CheckoutDeliveryAndPaymentPage deliveryAndPaymentPage = new CheckoutDeliveryAndPaymentPage(driver);

    @And("choose JNE as delivery courier")
    public void chooseJNEAsDeliveryCourier() {
        deliveryAndPaymentPage.chooseJNE();
    }


    @And("choose JNT as delivery courier")
    public void chooseJNTAsDeliveryCourier() {
        deliveryAndPaymentPage.chooseJNT();
    }

    @And("choose Virtual Account BCA as payment method")
    public void chooseVirtualAccountBCAAsPaymentMethod() {
        deliveryAndPaymentPage.chooseVABCA();
    }

    @And("go to checkout summary page")
    public void goToCheckoutSummaryPage() {
        deliveryAndPaymentPage.goToCheckoutSummaryPage();
    }

    @And("verify showing free shipping information on delivery method")
    public void verifyShowingFreeShippingInformationOnDeliveryMethod() {
        deliveryAndPaymentPage.verifyFreeShipping();
    }

    @And("user input order notes")
    public void userInputOrderNotes() {
        deliveryAndPaymentPage.inputOrderNote();
    }

    @Then("verify showing limit order in a day information")
    public void verifyShowingLimitOrderInADayInformation() {
        deliveryAndPaymentPage.verifyLimitOrderInformation();
    }

    @And("user input shipping code without minimum purchase")
    public void userInputShippingCodeWithoutMinimumPurchase() {
        deliveryAndPaymentPage.inputShippingCodeWithoutMinimum();
    }

    @And("user input shipping code with collection purchase")
    public void userInputShippingCodeWithCollectionPurchase() {
        deliveryAndPaymentPage.inputShippingCodeCollectionPurpose();

    }

    @And("user input shipping code with product purchase")
    public void userInputShippingCodeWithProductPurchase() {
        deliveryAndPaymentPage.inputShippingCodeProductPurpose();
    }

    @And("user can't apply free shipping from code because already qualified for free shipping")
    public void userCanTApplyFreeShippingFromCodeBecauseAlreadyQualifiedForFreeShipping() {
        deliveryAndPaymentPage.verifyShippingCodeDidntApplied();
    }

    @And("user input shipping code when user already got free shipping")
    public void userInputShippingCodeWhenUserAlreadyGotFreeShipping() {
        deliveryAndPaymentPage.inputShippingCodeWithFreeShipping();
    }

    @And("user input voucher code with collection purchase")
    public void userInputVoucherCodeWithCollectionPurchase() {
        deliveryAndPaymentPage.inputVoucherCodeCollectionPurpose();
    }

    @And("user input voucher code with product purchase")
    public void userInputVoucherCodeWithProductPurchase() {
        deliveryAndPaymentPage.inputVoucherCodeProductPurpose();

    }

    @And("user input voucher code without minimum purchase")
    public void userInputVoucherCodeWithoutMinimumPurchase() {
        deliveryAndPaymentPage.inputVoucherCodeWithoutMinimum();
    }

    @And("choose Gopay as payment method")
    public void chooseGopayAsPaymentMethod() {
        deliveryAndPaymentPage.chooseGopay();
    }

    @And("choose QRIS as payment method")
    public void chooseQRISAsPaymentMethod() {
        deliveryAndPaymentPage.chooseQRIS();
    }

    @And("choose VA Bank Lain as payment method")
    public void chooseVABankLainAsPaymentMethod() {
        deliveryAndPaymentPage.chooseVABankLain();
    }

    @And("choose Shopee as payment method")
    public void chooseShopeeAsPaymentMethod() {
        deliveryAndPaymentPage.chooseShopee();
    }
}
