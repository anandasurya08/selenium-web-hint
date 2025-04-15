package org.hint.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hint.BasePage;

public class CheckoutSummaryPage extends BasePage {

    public CheckoutSummaryPage(WebDriver driver) {
        super(driver);
    }

    private By btnPlaceOrder = By.xpath("//button[contains(@class,'btn-checkout')][normalize-space()='Place Order']");

    public void assertURLIsOnConfirmPage(){
        newWaitForElementVisible(btnPlaceOrder);
        // Now assert that the URL has redirected to the expected one
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);

        String expectedUrl = "https://hintofyou.playbybeautyhaul.com/en/cart/confirm";

        // Assertion to check if the actual URL matches the expected URL
        Assert.assertEquals("The URL did not redirect as expected.", expectedUrl, actualUrl);
    }

    public void goToConfirmedPage(){
        newWaitForElementVisible(btnPlaceOrder);
        newClick(btnPlaceOrder);
        forLoading();
    }

}