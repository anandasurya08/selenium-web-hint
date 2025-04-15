package org.hint.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hint.BasePage;

public class OrderConfirmedPage extends BasePage {

    public OrderConfirmedPage(WebDriver driver) {
        super(driver);
    }

    private static String CONFIRMED_URL = BASE_URL + "cart/confirmed";


    //confirm payment
    @FindBy(xpath = "//a[contains(@class,'btn-custom-bag')][text()='Confirm Payment']")
    private WebElement btnConfirmPayment;

    @FindBy(css = ".payment-info-wrapper")
    private WebElement divPaymentInformation;
    @FindBy(xpath = "//div[text()='ORDER ID']")
    private WebElement lblTitleOrderID;
    @FindBy(xpath = "(//div[@class='cart-detail text-lg'])[2]")
    private WebElement lblValueOrderID;
    @FindBy(css = "div[class='col-md-d2 mb-3 mb-lg-0'] div[class='bold text-lg2 mb-2']")
    private WebElement lblValueOrderIDOnTrackOrder;
    @FindBy(xpath = "//div[contains(@class,'cart-total')]//div[contains(@class,'value')]")
    private WebElement lblTotalAmountInfo;
    private By lblShippingDisc = By.xpath("//div[normalize-space()='Shipping Disc.']");

    @FindBy(xpath = "//div[normalize-space()='Discount']")
    private WebElement lblDiscount;
    @FindBy(xpath = "//strong[contains(text(),'JNE')]")
    private WebElement lblJNEInfo;
    @FindBy(xpath = "//strong[contains(text(),'J&T')]")
    private WebElement lblJNTInfo;
    private By lblAddedEngraveLetter = By.cssSelector(".cart-engrave-letter");



    public void openConfirmedPage(){
        wait3second();
        driver.get(CONFIRMED_URL);
        forLoading();
    }

    public void clickConfirmPayment(){
        waitForElementClickable(btnConfirmPayment);
        click(btnConfirmPayment);
    }

    public void verifyOrderID(){
        waitForElementVisible(lblTitleOrderID);
        isDisplayed(lblTitleOrderID);
    }

    public void storeValueOrderID(){
        BasePage.orderID = lblValueOrderID.getText();
    }

    public void storeValueOrderIDOnTrackOrder(){
        BasePage.orderID = lblValueOrderIDOnTrackOrder.getText();
    }

    public boolean verifyShowShippingDiscInfo(){
        return newIsDisplayed(lblShippingDisc);
    }

    public void verifyNotShowShippingDiscInfo(){
        waitForElementDisappear(lblShippingDisc);
    }

    public boolean verifyShowOrderIDInfo(){
//        switchToDefaultContent();
        return isDisplayed(lblTitleOrderID);
    }

    public void assertIsOnConfirmedPage(){
        forLoading();
        // Now assert that the URL has redirected to the expected one
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);

        String expectedUrl = "https://hintofyou.playbybeautyhaul.com/en/cart/confirmed";

        // Assertion to check if the actual URL matches the expected URL
        Assert.assertEquals("The URL did not redirect as expected.", expectedUrl, actualUrl);
    }

    public boolean verifyShowDiscountInfo(){
        return isDisplayed(lblDiscount);
    }

    public void verifyIDRcurrency(){
        // Get the text of the total element
        String totalText = lblTotalAmountInfo.getText();

        // Assert that "Rp" is present in the total text
        boolean hasIDRcurrency = totalText.contains("Rp");

        // Verify that the text contains "Rp" to indicate the currency prefix
        Assert.assertTrue("Total amount does not contain the 'Rp' currency prefix", hasIDRcurrency);
    }

    public void verifyUSDcurrency(){
        driver.switchTo().defaultContent();
        // Get the text of the total element
        String totalText = lblTotalAmountInfo.getText();

        // Assert that "Rp" is present in the total text
        boolean hasUSDcurrency = totalText.contains("$");

        // Verify that the text contains "Rp" to indicate the currency prefix
        Assert.assertTrue("Total amount does not contain the '$' currency prefix", hasUSDcurrency);
    }

    public void verifySGDcurrency(){
        // Get the text of the total element
        String totalText = lblTotalAmountInfo.getText();

        // Assert that "Rp" is present in the total text
        boolean hasSGDcurrency = totalText.contains("S$");

        // Verify that the text contains "Rp" to indicate the currency prefix
        Assert.assertTrue("Total amount does not contain the 'S$' currency prefix", hasSGDcurrency);
    }

    public void verifyMYRcurrency(){
        // Get the text of the total element
        String totalText = lblTotalAmountInfo.getText();

        // Assert that "Rp" is present in the total text
        boolean hasMYRcurrency = totalText.contains("RM");

        // Verify that the text contains "Rp" to indicate the currency prefix
        Assert.assertTrue("Total amount does not contain the 'RM' currency prefix", hasMYRcurrency);
    }

    public boolean verifyShowJNEInfo(){
        return isDisplayed(lblJNEInfo);
    }

    public boolean verifyShowJNTInfo(){
        return isDisplayed(lblJNTInfo);
    }

    public void verifyAddedEngraveLetter(){
        newWaitForElementVisible(lblAddedEngraveLetter);
        WebElement element = driver.findElement(lblAddedEngraveLetter); // Locate dynamically

        // Assert that the label is displayed
        Assert.assertTrue("Engrave letter added is displayed", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedMessage = "Engraved letter \"" + BasePage.engraveLetter + "\"";
        String actualMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public void verifyEngraveLetterNotExists(){
        waitForElementDisappear(lblAddedEngraveLetter);
    }

}
