package org.hint.PageObject;

import org.hint.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutDeliveryAndPaymentPage extends BasePage {

    public CheckoutDeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private static String SHIPPING_CODE_NOMINIMUM = "ship-nominimum";
    private static String SHIPPING_CODE_PRODUCT = "ship-product";
    private static String SHIPPING_CODE_COLLECTION = "ship-collection";
    private static String SHIPPING_CODE_FREE_SHIPPING = "ship-free";

    private static String VOUCHER_CODE_NOMINIMUM = "auto-allorder";
    private static String VOUCHER_CODE_PRODUCT = "auto-product";
    private static String VOUCHER_CODE_COLLECTION = "auto-collection";

    private By divDelivery = By.cssSelector(".content-checkout.content-checkout-delivery");
    @FindBy(xpath = "//label[@for='shipping-4']//span[@class='cred'][normalize-space()='Free Shipping']")
    private WebElement lblFreeShipping;
    @FindBy(xpath = "//div[normalize-space()='Shipping Disc.']")
    private WebElement lblShippingDisc;

    //delivery method
    @FindBy(xpath = "//div[contains(text(), 'JNE')]")
    private WebElement JNE;
    @FindBy(xpath = "//div[contains(text(), 'J&T')]")
    private WebElement JNT;
    @FindBy(xpath = "(//div[normalize-space()='Instant Delivery'])[1]")
    private WebElement GOSEND_INSTANT;
    @FindBy(xpath = "(//div[normalize-space()='Same Day Delivery'])[1]")
    private WebElement GOSEND_SAMEDAY;

    //payment method
    private By VA_BCA = By.xpath("//div[contains(text(),'Virtual Account BCA')]");
    @FindBy(xpath = "//div[contains(text(),'ShopeePay')]")
    private WebElement SHOPEEPAY;
    @FindBy(xpath = "//div[contains(text(),'Gopay')]")
    private WebElement GOPAY;
//    private By GOPAY = By.xpath("//div[contains(text(),'Gopay')]");
    @FindBy(xpath = "//div[contains(text(),'Virtual Account Bank Lain')]")
    private WebElement VA_BANK_LAIN;
    @FindBy(xpath = "//div[contains(text(),'QRIS')]")
    private WebElement QRIS;

    @FindBy(name = "voucher")
    private WebElement txtInputCode;
    @FindBy(xpath = "//button[contains(@class,'btn-custom-bag')][normalize-space()='Apply']")
    private WebElement btnApplyCode;
    @FindBy(xpath = "//button[contains(@class,'btn-custom-bag')][normalize-space()='Remove']")
    private WebElement btnRemoveCode;
    @FindBy(xpath = "//div[normalize-space()='Shipping Disc Voucher.']")
    private WebElement lblShippingDiscAfterApplied;
    @FindBy(xpath = "//div[normalize-space()='Discount']")
    private WebElement lblVoucherDiscAfterApplied;

    @FindBy(name = "note")
    private WebElement txtNote;

    @FindBy(xpath = "//div[contains(@class,'limit-error')][normalize-space()='Some item(s) has been updated / removed']")
    private WebElement lblErrorLimitOrder;
    @FindBy(xpath = "//div[contains(@class,'limit-text')][text()='Limit belanja produk ini adalah 1pc/Month/User.']")
    private WebElement lblErrorLimitOrder2;

    private By btnNextStep = By.xpath("(//button[normalize-space()='Next Step'])[1]");

    public void inputShippingCodeWithFreeShipping(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, SHIPPING_CODE_FREE_SHIPPING);
        click(btnApplyCode);
        forLoading();
    }

    public void verifyShippingCodeDidntApplied(){
        waitForElementDisappear(lblShippingDiscAfterApplied);
    }

    public void inputShippingCodeWithoutMinimum(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, SHIPPING_CODE_NOMINIMUM);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblShippingDiscAfterApplied);
    }

    public void inputShippingCodeCollectionPurpose(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, SHIPPING_CODE_COLLECTION);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblShippingDiscAfterApplied);
    }

    public void inputShippingCodeProductPurpose(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, SHIPPING_CODE_PRODUCT);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblShippingDiscAfterApplied);
    }

    public void inputVoucherCodeWithoutMinimum(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, VOUCHER_CODE_NOMINIMUM);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblVoucherDiscAfterApplied);
    }

    public void inputVoucherCodeCollectionPurpose(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, VOUCHER_CODE_COLLECTION);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblVoucherDiscAfterApplied);
    }

    public void inputVoucherCodeProductPurpose(){
        forElementToBeDisplayed(txtInputCode, "txtInputCode");
        sendKeys(txtInputCode, VOUCHER_CODE_PRODUCT);
        click(btnApplyCode);
        forLoading();
        isDisplayed(lblVoucherDiscAfterApplied);
    }

    public void chooseVABCA(){
        newIsDisplayed(divDelivery);
        newWaitForElementVisible(VA_BCA);
        newClick(VA_BCA);
    }

    public void chooseGopay(){
        newIsDisplayed(divDelivery);
        waitForElementClickable(GOPAY);
        click(GOPAY);
    }

    public void chooseShopee(){
        newIsDisplayed(divDelivery);
        waitForElementClickable(SHOPEEPAY);
        click(SHOPEEPAY);
    }

    public void chooseQRIS(){
        newIsDisplayed(divDelivery);
        waitForElementClickable(QRIS);
        click(QRIS);
    }

    public void chooseVABankLain(){
        newIsDisplayed(divDelivery);
        waitForElementClickable(VA_BANK_LAIN);
        click(VA_BANK_LAIN);
    }

    public void chooseJNE(){
        waitForElementClickable(JNE);
        click(JNE);
    }

    public void chooseJNT(){
        waitForElementClickable(JNT);
        click(JNT);
    }

    public void inputOrderNote(){
        forElementToBeDisplayed(txtNote, "txtOrderNote");
        sendKeys(txtNote, "ini adalah testing untuk notes dari order yang dilakukan");
    }

    public void verifyFreeShipping(){
        waitForElementVisible(lblFreeShipping);
        // Assert that the error label is displayed
        Assert.assertTrue("Free Shipping", lblFreeShipping.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Free Shipping";
        String actualErrorMessage = lblFreeShipping.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public boolean verifyShippingDisc(){
        return isDisplayed(lblShippingDisc);
    }

    public void verifyLimitOrderInformation(){
        waitForElementVisible(lblErrorLimitOrder);
        // Assert that the error label is displayed
        Assert.assertTrue("Limit belanja produk ini adalah 1pc/Month/User.", lblErrorLimitOrder2.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Limit belanja produk ini adalah 1pc/Month/User.";
        String actualErrorMessage = lblErrorLimitOrder2.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void goToCheckoutSummaryPage(){
        newWaitForElementVisible(btnNextStep);
        newClick(btnNextStep);
    }


}
