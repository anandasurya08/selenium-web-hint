package org.hint.PageObject;

import org.hint.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MidtransPage extends BasePage {

    public MidtransPage(WebDriver driver) {
        super(driver);
    }

    private static final String MIDTRANS_QRIS_URL = "https://simulator.sandbox.midtrans.com/qris/index";
    private static final String MIDTRANS_VA_BANK_LAIN_PERMATA_URL = "https://simulator.sandbox.midtrans.com/openapi/va/index?bank=permata";
    private static final String MIDTRANS_QRIS_PIN = "123456";
    private static final String MIDTRANS_CC_NUMBER = "5211111111111117";
    private static final String MIDTRANS_CC_EXPIRY = "0128";
    private static final String MIDTRANS_CC_CVV = "123";
    private static final String MIDTRANS_CC_OTP = "112233";

    //frame
    @FindBy(css = "#application")
    private WebElement frameSnapMidtrans;
    @FindBy(css = ".close-snap-button.clickable")
    private WebElement btnCloseMidtrans;

    //payment method VA Bank Lain
    @FindBy(xpath = "//span[text()='Permata']")
    private WebElement lblOptionBankPermata;
    @FindBy(xpath = "//span[contains(@class,'title-text')][text()='Bank Permata']")
    private WebElement lblTitleBankPermata;
    @FindBy(xpath = "//div[@id='vaField']")
    private WebElement lblVANumber;
    @FindBy(css = "form[action='https://simulator.sandbox.midtrans.com/openapi/va/inquiry?bank=permata']")
    private WebElement formVABankLain;
    @FindBy(xpath = "//input[@id='inputMerchantId']")
    private WebElement txtInputVANumber;
    @FindBy(xpath = "//input[@value='Inquire']")
    private WebElement btnInquire;

    //input CC
    @FindBy(xpath = "(//input[@class='valid-input-value'])[1]")
    private WebElement txtCCNumber;
    @FindBy(id = "card-expiry")
    private WebElement txtCCExpiry;
    @FindBy(id = "card-cvv")
    private WebElement txtCCCVV;
    @FindBy(xpath = "//button[text()='Pay now']")
    private WebElement btnPayNow;
    @FindBy(id = "otp")
    private WebElement txtOTPCC;
    @FindBy(name = "ok")
    private WebElement btnOK;

    //QR Payment (QRIS, Gopay, Shopee)
    @FindBy(xpath = "//span[@class='expiry-countdown-timer'][text()='00:04:35']")
    private WebElement lblTimerShopee;
    @FindBy(xpath = "//span[@class='expiry-countdown-timer'][text()='00:14:40']")
    private WebElement lblTimerGopay;
    @FindBy(xpath = "//img[@class='qr-image']")
    private WebElement imgQR;
    @FindBy(xpath = "//div[@class='qr-wrapper']/img[@class='qr-image']@src")
    private WebElement srcImgQR;
    @FindBy(xpath = "//form[@role='form']")
    private WebElement formQR;
    @FindBy(xpath = "//input[@id='qrCodeUrl']")
    private WebElement txtInputQRURL;
    @FindBy(xpath = "//input[@value='Scan QR']")
    private WebElement btnScanQR;
    @FindBy(xpath = "//input[@value='Pay']")
    private WebElement btnPayQR;
    @FindBy(xpath = "//input[@id='pin']")
    private WebElement txtInputPIN;
    @FindBy(xpath = "//input[@value='Confirm']")
    private WebElement btnConfirmPay;
    @FindBy(xpath = "//*[@class='success'][text()='successful']")
    private WebElement lblSuccessfulPay;

    public void goToMidtransQRPage(){
        driver.get(MIDTRANS_QRIS_URL);
        forLoading();
    }

    public void goToMidtransVABankLainPage(){
        driver.get(MIDTRANS_VA_BANK_LAIN_PERMATA_URL);
        forLoading();
    }


    public void storeAndInputQRISQRLink(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }

        waitForElementVisible(imgQR);
        String QR = imgQR.getAttribute("src");

        goToMidtransQRPage();

        waitForElementVisible(formQR);
        waitForElementVisible(txtInputQRURL);
        sendKeys(txtInputQRURL, QR);
        click(btnScanQR);
    }

    public void storeAndInputQRGopay(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }

        waitForElementVisible(imgQR);
        String QRGopay = imgQR.getAttribute("src");
        System.out.println("QR code source: " + QRGopay);

        goToMidtransQRPage();

        waitForElementVisible(formQR);
        waitForElementVisible(txtInputQRURL);
        sendKeys(txtInputQRURL, QRGopay);
        click(btnScanQR);
    }

    public void storeAndInputVABankLainPermata(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }

        waitForElementVisible(lblOptionBankPermata);
        click(lblOptionBankPermata);
        waitForElementVisible(lblTitleBankPermata);
        waitForElementVisible(lblVANumber);

        String VANumberPermata = lblVANumber.getText();
        System.out.println("VA Number is: " + VANumberPermata);

        goToMidtransVABankLainPage();

        waitForElementVisible(formVABankLain);
        waitForElementVisible(txtInputVANumber);
        sendKeys(txtInputVANumber, VANumberPermata);
        click(btnInquire);
    }

    public void storeAndInputQRShopee(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }

        waitForElementVisible(imgQR);
        String QRShopee = imgQR.getAttribute("src");

        goToMidtransQRPage();

        waitForElementVisible(formQR);
        waitForElementVisible(txtInputQRURL);
        sendKeys(txtInputQRURL, QRShopee);
        click(btnScanQR);
    }

    public void inputCC(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }

        waitForElementVisible(txtCCNumber);
        sendKeys(txtCCNumber, MIDTRANS_CC_NUMBER);
        sendKeys(txtCCExpiry, MIDTRANS_CC_EXPIRY);
        sendKeys(txtCCCVV, MIDTRANS_CC_CVV);
        click(btnPayNow);
    }

    public void inputOTPCC(){
        switchToFrame(0);
        waitForElementVisible(txtOTPCC);
        sendKeys(txtOTPCC, MIDTRANS_CC_OTP);
        click(btnOK);
    }

    public void clickPay(){
        waitForElementClickable(btnPayQR);
        click(btnPayQR);
    }

    public void inputPIN(){
        waitForElementVisible(txtInputPIN);
        sendKeys(txtInputPIN, MIDTRANS_QRIS_PIN);
    }

    public void clickConfirm(){
        waitForElementClickable(btnConfirmPay);
        click(btnConfirmPay);
    }

    public boolean verifySuccessfulPayMidtrans(){
        return isDisplayed(lblSuccessfulPay);
    }

    public void closeSnapMidtrans(){
        //Dynamically find the iframe with the Midtrans URL
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + iframes.size());

        for (WebElement iframe : iframes) {
            String src = iframe.getAttribute("src");
            System.out.println("Iframe src: " + src);

            if (src != null && src.contains("app.sandbox.midtrans.com/snap/v4/popup")) {
                switchIntoFrame(iframe);  // Switch to the correct Midtrans iframe
                System.out.println("Switched to Midtrans iframe");
                break;  // Exit loop after switching to the correct iframe
            }
        }
        waitForElementClickable(btnCloseMidtrans);
        click(btnCloseMidtrans);
    }

}
