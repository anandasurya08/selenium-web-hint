package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import org.hint.BasePage;
import org.hint.PageObject.MidtransPage;
import org.hint.PageObject.OrderConfirmedPage;
import org.openqa.selenium.WebDriver;

public class MidtransSteps {

    private final WebDriver driver = Hooks.driver;
    MidtransPage midtransPage = new MidtransPage(driver);
    OrderConfirmedPage orderConfirmed = new OrderConfirmedPage(driver);


    @And("user paid Gopay payment on midtrans page")
    public void userPaidGopayPaymentOnMidtransPage() {
        midtransPage.closeSnapMidtrans();
        orderConfirmed.verifyShowOrderIDInfo();
        orderConfirmed.storeValueOrderID();
        orderConfirmed.clickConfirmPayment();
        midtransPage.storeAndInputQRGopay();
        midtransPage.clickPay();
        midtransPage.verifySuccessfulPayMidtrans();
    }

    @And("user close snap midtrans")
    public void userCloseSnapMidtrans() {
        midtransPage.closeSnapMidtrans();
    }

    @And("user paid QRIS payment on midtrans page")
    public void userPaidQRISPaymentOnMidtransPage() {
        midtransPage.closeSnapMidtrans();
        BasePage.switchToDefaultContent();
        orderConfirmed.verifyShowOrderIDInfo();
        orderConfirmed.storeValueOrderID();
        orderConfirmed.clickConfirmPayment();
        midtransPage.storeAndInputQRISQRLink();
        midtransPage.clickPay();
        midtransPage.verifySuccessfulPayMidtrans();

    }

    @And("user paid VA Bank Lain payment on midtrans page")
    public void userPaidVABankLainPaymentOnMidtransPage() {
        midtransPage.closeSnapMidtrans();
        BasePage.switchToDefaultContent();
//        orderConfirmed.verifyShowOrderIDInfo();
        orderConfirmed.storeValueOrderIDOnTrackOrder();
        orderConfirmed.clickConfirmPayment();
        midtransPage.storeAndInputVABankLainPermata();
        midtransPage.clickPay();
        midtransPage.verifySuccessfulPayMidtrans();
    }

    @And("user paid Shopeepay payment on midtrans page")
    public void userPaidShopeepayPaymentOnMidtransPage() {
        midtransPage.closeSnapMidtrans();
        BasePage.switchToDefaultContent();
//        orderConfirmed.verifyShowOrderIDInfo();
        orderConfirmed.storeValueOrderIDOnTrackOrder();
        orderConfirmed.clickConfirmPayment();
        midtransPage.storeAndInputQRShopee();
        midtransPage.clickPay();
        midtransPage.verifySuccessfulPayMidtrans();
    }
}
