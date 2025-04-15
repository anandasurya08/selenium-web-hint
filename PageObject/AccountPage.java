package org.hint.PageObject;

import org.hint.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private static String ORDER_LIST_URL = BASE_URL + "account/order/";

    @FindBy(xpath = "//div[normalize-space()='Order is in progress']")
    private WebElement lblStatusOrderInProgress;
    @FindBy(xpath = "//div[normalize-space()='ShopeePay']")
    private WebElement lblPaymentShopee;
    @FindBy(xpath = "//div[normalize-space()='Virtual Account Bank Lain']")
    private WebElement lblPaymentVABankLain;
    @FindBy(xpath = "//div[normalize-space()='Gopay']")
    private WebElement lblPaymentGopay;
    @FindBy(xpath = "//div[normalize-space()='QRIS']")
    private WebElement lblPaymentQRIS;
    @FindBy(xpath = "//li[@class='nav-item nav-menu-account']//button[@class='btn btn-icon-login']")
    private WebElement btnAccountAfterLogin;
    @FindBy(css = "a[href='https://hintofyou.playbybeautyhaul.com/en/account/logout']")
    private WebElement btnLogout;
    @FindBy(xpath = "//li[@class='nav-item nav-menu-account']//button[@class='btn btn-icon']")
    private WebElement btnAccountAfterLogout;

    public void clickSignOutAccount(){
        waitForElementClickable(btnAccountAfterLogin);
        click(btnAccountAfterLogin);
        isDisplayed(btnLogout);
        waitForElementClickable(btnLogout);
        click(btnLogout);
    }

    public void verifySuccessfullyLogout(){
        isDisplayed(btnAccountAfterLogout);
    }


    public void openSpecificOrderIDDetailPage(){
        driver.get(ORDER_LIST_URL + BasePage.orderID);
        forLoading();
    }

    public void verifyStatusOrderInProgress(){
        waitForElementVisible(lblStatusOrderInProgress);
        // Assert that the error label is displayed
        Assert.assertTrue("Order is in progress", lblStatusOrderInProgress.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Order is in progress";
        String actualErrorMessage = lblStatusOrderInProgress.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyPaymentShopee(){
        isDisplayed(lblPaymentShopee);
    }

    public void verifyPaymentVABankLain(){
        isDisplayed(lblPaymentVABankLain);
    }

    public void verifyPaymentGopay(){
        isDisplayed(lblPaymentGopay);
    }

    public void verifyPaymentQRIS(){
        isDisplayed(lblPaymentQRIS);
    }


}
