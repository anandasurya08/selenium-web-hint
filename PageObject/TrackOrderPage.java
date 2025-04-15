package org.hint.PageObject;

import org.hint.BasePage;
import org.hint.Utils.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class TrackOrderPage extends BasePage {
    public TrackOrderPage(WebDriver driver) {
        super(driver);
    }

    private static String ORDER_ID = "H20250128UCGYS";
    private static String INVALID_ORDER_ID = "H20248828UCGYS";
    private static String INVALID_EMAIL = "testakun1@gmail.com";

    private By linkTrackOrder = By.xpath("(//a[normalize-space()='Track Order'])[1]");
    private By txtOrderID = By.name("order_id");
    private By txtEmail = By.name("email");
    private By btnSubmitTrack = By.xpath("//button[normalize-space()='Submit']");
    private By lblErrorGlobal = By.xpath("//div[contains(@class,'invalid-feedback')]");
    private By lblErrorFieldOrderID = By.cssSelector("input[placeholder='Order ID'] + .invalid-feedback");
    private By lblErrorFieldEmail = By.cssSelector("input[placeholder='Email address'] + .invalid-feedback");
    private By lblTitleTrackOrderPage = By.xpath("(//div[@class='bold text-lg2 mb-2'])[1]");


    public void goToTrackOrderPage(){
        newScrollToElement(linkTrackOrder);
        newClick(linkTrackOrder);
        forLoading();

        // Now assert that the URL has redirected to the expected one
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);

        String expectedUrl = "https://hintofyou.playbybeautyhaul.com/en/track";

        // Assertion to check if the actual URL matches the expected URL
        Assert.assertEquals("The URL did not redirect as expected.", expectedUrl, actualUrl);

    }

    public void inputValidOrderID(){
        newWaitForElementVisible(txtOrderID);
        newSendKeys(txtOrderID, ORDER_ID);
    }

    public void inputValidEmail() throws IOException {
        newWaitForElementVisible(txtEmail);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String email = ExcelUtils.getCellData(1, 0); // assuming email is in the second row, first column
        newSendKeys(txtEmail, email);
    }

    public void inputInvalidOrderID(){
        newWaitForElementVisible(txtOrderID);
        newSendKeys(txtOrderID, INVALID_ORDER_ID);
    }

    public void inputInvalidEmail() {
        newWaitForElementVisible(txtEmail);
        newSendKeys(txtEmail, INVALID_EMAIL);
    }

    public void clickSubmitTrack(){
        newClick(btnSubmitTrack);
    }

    public void verifyErrorInvalidOrderIDorEmail(){
        newWaitForElementVisible(lblErrorGlobal);
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(lblErrorGlobal);
        // Assert that the error label is displayed
        Assert.assertTrue("Element displayed, continue asserting text...", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedMessage = "Invalid Order ID or Email";
        String actualMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public void verifySuccessGetTrackOrder(){
        newWaitForElementVisible(lblTitleTrackOrderPage);
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(lblTitleTrackOrderPage);
        // Assert that the error label is displayed
        Assert.assertTrue("Element displayed, continue asserting text...", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedMessage = "Track Order";
        String actualMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public void checkRequiredFieldTrackOrder(){
        assertRequiredField(lblErrorFieldOrderID, "Field Order ID");
        assertRequiredField(lblErrorFieldEmail, "Field Email");
    }




}
