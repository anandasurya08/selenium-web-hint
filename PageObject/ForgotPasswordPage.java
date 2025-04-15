package org.hint.PageObject;

import org.hint.BasePage;
import org.hint.Utils.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private static String RESET_PASSWORD_URL = "https://hintofyou.playbybeautyhaul.com/en/account/resetpassword/abcde12345fghij678910?utm_source=system&utm_medium=email&utm_campaign=Request+New+Password";

    private By txtEmail = By.xpath("//input[@placeholder='Email Address']");
    @FindBy(linkText = "Forgot Password?")
    private WebElement linkGoToForgotPass;
    @FindBy(xpath = "(//button[normalize-space()='Send Email'])[1]")
    private WebElement btnSendEmailForgotPass;
    @FindBy(xpath = "//div[@class='text-center'][contains(text(), 'reset your password.')]")
    private WebElement lblSuccessSendEmailForgotPass;
    @FindBy(xpath = "(//h3[normalize-space()='Reset Password'])[1]")
    private WebElement lblResetPasswordPage;
    @FindBy(xpath = "(//input[@placeholder='New password'])[1]")
    private WebElement txtNewPass;
    @FindBy(xpath = "(//input[@placeholder='Confirm new password'])[1]")
    private WebElement txtConfirmNewPass;
    @FindBy(xpath = "(//button[normalize-space()='Submit'])[1]")
    private WebElement btnSubmitNewPass;
    @FindBy(xpath = "(//p[normalize-space()='Password reset success'])[1]")
    private WebElement lblSuccessResetPass;
    @FindBy(xpath = "(//h3[normalize-space()='Password Reset Link Expired'])[1]")
    private WebElement lblResetLinkExpired;
    private By lblError = By.cssSelector(".form-error p");

    public void openResetPasswordLink(){
        driver.get(RESET_PASSWORD_URL);
        forLoading();
    }

    public void checkingResetPasswordLinkActiveOrNot() throws InterruptedException {
        Random random = new Random();

        // Loop indefinitely until the expired page appears
        while (true) {
            driver.navigate().refresh(); // Refresh the page to reload the reset link

            try {
                // Check if the expired message is displayed
                if (lblResetLinkExpired.isDisplayed()) {
                    System.out.println("Reset password link is expired.");
                    break; // Exit loop if link is expired
                }
            } catch (NoSuchElementException e) {
                // Expired message is not displayed, proceed with reset process
            }

            String password = "123456Xx??";

            // Enter the password and submit
            txtNewPass.clear();
            txtConfirmNewPass.clear();
            txtNewPass.sendKeys(password);
            txtConfirmNewPass.sendKeys(password);
            btnSubmitNewPass.click();

            // Optional: Add a delay to avoid triggering rate limits
            Thread.sleep(2000); // 2-second delay (adjust as needed)

            waitForElementVisible(lblSuccessResetPass);
        }
    }

    public void goToForgotPasswordPage(){
        newWaitForElementVisible(txtEmail);
        click(linkGoToForgotPass);
        forLoading();
    }

    public void inputEmailForgotPass() throws IOException {
        newWaitForElementVisible(txtEmail);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String email = ExcelUtils.getCellData(1, 0); // assuming email is in the second row, first column
        newSendKeys(txtEmail, email);
    }

    public void clickSendEmailForgotPass(){
        waitForElementClickable(btnSendEmailForgotPass);
        click(btnSendEmailForgotPass);
    }

    public void verifySuccessfullySendEmailForgotPass(){
        waitForElementVisible(lblSuccessSendEmailForgotPass);
        // Assert that the error label is displayed
        Assert.assertTrue("You should receive an email shortly. Please check your inbox/ spam and click on the link to reset your password.", lblSuccessSendEmailForgotPass.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "You should receive an email shortly. Please check your inbox/ spam and click on the link to reset your password.";
        String actualErrorMessage = lblSuccessSendEmailForgotPass.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void inputNewPassword(){
        waitForElementVisible(lblResetPasswordPage);

        String password = "123456Xx??";
        sendKeys(txtNewPass, password);
    }

    public void inputNewConfirmPassword(){
        waitForElementVisible(txtConfirmNewPass);

        String password = "123456Xx??";
        sendKeys(txtConfirmNewPass, password);
    }

    public void clickBtnSubmitNewPass(){
        waitForElementClickable(btnSubmitNewPass);
        click(btnSubmitNewPass);
    }

    public void verifySuccessfullyResetPassword(){
        waitForElementVisible(lblSuccessResetPass);
        // Assert that the error label is displayed
        Assert.assertTrue("Password reset success", lblSuccessResetPass.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Password reset success";
        String actualErrorMessage = lblSuccessResetPass.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyPasswordResetLinkExpired(){
        waitForElementVisible(lblResetLinkExpired);
        // Assert that the error label is displayed
        Assert.assertTrue("Password Reset Link Expired", lblResetLinkExpired.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Password Reset Link Expired";
        String actualErrorMessage = lblResetLinkExpired.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyPassAndPassConfirmFieldRequired(){
        waitForElementVisible(txtNewPass);

        // Find all elements with the error message selector
        List<WebElement> errorMessages = driver.findElements(lblError);

        // Assert that there are exactly two error messages
        if (errorMessages.size() == 2) {
            System.out.println("Test Passed: Two error messages found.");

            // Expected error message text
            String expectedErrorMessage = "Required field.";

            // Check if the text of both error messages is correct
            boolean allMessagesCorrect = true;
            for (WebElement errorMessage : errorMessages) {
                if (!errorMessage.getText().equals(expectedErrorMessage)) {
                    allMessagesCorrect = false;
                    System.out.println("Test Failed: Incorrect error message: " + errorMessage.getText());
                }
            }

            if (allMessagesCorrect) {
                System.out.println("Test Passed: All error messages are correct.");
            }
        } else {
            System.out.println("Test Failed: Expected 2 error messages, but found " + errorMessages.size());
        }
    }

    public void inputNewPassAndConfirmPassDoesntMatch(){
        waitForElementVisible(lblResetPasswordPage);

        String pass = "123456Xx??";
        String passC = "123456Xx>>";
        sendKeys(txtNewPass, pass);
        sendKeys(txtConfirmNewPass, passC);
    }

    public void verifyPassAndPassConfirmDoesntMatch(){
        newWaitForElementVisible(lblError);
        WebElement element = driver.findElement(lblError);
        // Assert that the error label is displayed
        Assert.assertTrue("The Confirm New Password field does not match the New Password field.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedMessage = "The Confirm New Password field does not match the New Password field.";
        String actualMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

}
