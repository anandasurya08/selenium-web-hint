package org.hint.PageObject;

import org.hint.BasePage;
import org.hint.Utils.ExcelUtils;
import org.hint.Utils.RandomizeGenerate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By btnGoToRegister = By.xpath("//button[normalize-space()='Register']");
    private By lblTitleRegisterPage = By.xpath("//div[text()='Create An Account']");
    private By txtFname = By.name("fname");
    private By txtLname = By.name("lname");
    private By txtEmail = By.cssSelector("input[placeholder='Email Address']");
    private By txtPhoneNumber = By.name("phone");
    private By txtPass = By.name("pass");
    private By txtPassC = By.name("passc");
    private By txtDoB = By.name("dob");
    private By btnChangeMonthDoB = By.xpath("//li[@data-view='month current']");
    private By btnChangeYearDoB = By.xpath("//li[@data-view='year current']");
    private By btnChooseYearDoB = By.xpath("//li[contains(text(),'2007')]");
    private By btnChooseMonthDoB = By.xpath("//li[contains(text(),'Mar')]");
    private By btnChooseDateDoB = By.cssSelector(".pl-2 > .btn-secondary");
    private By chkTermAndConditions = By.cssSelector("label[for='termCondition']");
    private By btnRegisterAccount = By.xpath("//button[normalize-space()='Register']");
    private By lblSuccessRegister = By.xpath("//h3[normalize-space()='Selamat!']");
    @FindBy(xpath = "//p[contains(text(),'Required field.')]")
    private List<WebElement> lblErrorRequiredField;
    private By lblErrorFname = By.cssSelector("input[name=fname] + .form-control-label-custom + .form-error p");
    private By lblErrorLname = By.cssSelector("input[name=lname] + .form-control-label-custom + .form-error p");
    private By lblErrorEmail = By.cssSelector("input[name=email] + .form-control-label-custom + .form-error p");
    private By lblErrorRegisteredEmail = By.xpath("//p[contains(text(),'This email has been registered. Please use another email.')]");
    private By lblErrorInvalidEmail = By.xpath("//p[contains(text(),'Invalid email.')]");
    private By lblErrorInvalidFormatEmail = By.xpath("//p[contains(text(),'Invalid email address.')]");
    private By lblErrorPass = By.cssSelector("input[name=pass] + .form-control-label-custom + .pass-eye + .form-error p");
    private By lblErrorPassC = By.cssSelector("input[name=passc] + .form-control-label-custom + .pass-eye + .form-error p");



    public void goToRegisterPage(){
        newWaitForElementClickable(btnGoToRegister);
        newClick(btnGoToRegister);
        forLoading();
        newIsDisplayed(lblTitleRegisterPage);
    }
    public void inputFirstName() {
        String firstName = "staging";
        newSendKeys(txtFname, firstName);
    }
    public void inputInvalidFirstName() {
        String firstName = "sh4brin$";
        newSendKeys(txtFname, firstName);
    }
    public void inputLastName() {
        String lastName = "testing";
        newSendKeys(txtLname, lastName);
    }
    public void inputInvalidLastName() {
        String lastName = "beaut1h48$";
        newSendKeys(txtLname, lastName);
    }
    public void inputNewEmail() {
        String randomEmail = RandomizeGenerate.generateRandomEmail();

        // Now you can use this email as an input variable
        newSendKeys(txtEmail, randomEmail);
    }
    public void inputInvalidFormatEmail() throws IOException {
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String invalidFormatEmail = ExcelUtils.getCellData(3, 0); // assuming email is in the third row, first column

        wait3second();
        newScrollIntoView(txtEmail);
        newSendKeys(txtEmail, invalidFormatEmail);
    }
    public void inputRegisteredEmail() throws IOException {
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String registeredEmail = ExcelUtils.getCellData(1, 0); // assuming email is in the second row, first column

        wait3second();
        newScrollIntoView(txtEmail);
        newSendKeys(txtEmail, registeredEmail);
    }
    public void inputTemporaryEmail() throws IOException {
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String temporaryEmail = ExcelUtils.getCellData(5, 0); // assuming email is in the second row, first column

        wait3second();
        newScrollIntoView(txtEmail);
        newSendKeys(txtEmail, temporaryEmail);
    }
    public void inputNewPassword() {
        String pass = "asdf1234";
        newSendKeys(txtPass, pass);
    }
    public void inputNewPasswordLessThan6Char() {
        String pass = "abc12";
        newSendKeys(txtPass, pass);
    }
    public void inputNewPasswordNotCombination() {
        String pass = "asdfghjk";
        newSendKeys(txtPass, pass);
    }
    public void inputNewPasswordConfirmation() {
        String passc = "asdf1234";
        newSendKeys(txtPassC, passc);
    }
    public void inputNewPasswordConfirmationDoesntMatch() {
        String passc = "qwerty1234";
        newSendKeys(txtPassC, passc);
    }
    public void inputDoB() throws InterruptedException {
        newClick(txtDoB);
        newClick(btnChangeMonthDoB);
        Thread.sleep(PAUSE);
        newClick(btnChangeYearDoB);
        Thread.sleep(PAUSE);
        newClick(btnChooseYearDoB);
        Thread.sleep(PAUSE);
        newClick(btnChooseMonthDoB);
        Thread.sleep(PAUSE);
        newClick(btnChooseDateDoB);
    }
    public void clickTermsAndConditions(){
        newScrollIntoView(chkTermAndConditions);
        newWaitForElementClickable(chkTermAndConditions);
        newClick(chkTermAndConditions);
    }
    public void clickRegisterButton(){
        newScrollIntoView(btnRegisterAccount);
        newWaitForElementClickable(btnRegisterAccount);
        newClick(btnRegisterAccount);
    }

    public boolean verifyAfterRegister(){
        return newIsDisplayed(lblSuccessRegister);
    }

    public void registerStoredAccount(){
        BasePage.email = RandomizeGenerate.generateRandomEmail();
        BasePage.password = "asdf1234";

        newSendKeys(txtEmail, BasePage.email);
        newSendKeys(txtPass, BasePage.password);
    }

    public void verifyAllRegisterFieldsRequired(){
        // Common XPath selector for all 'Required field.' messages
        List<WebElement> requiredFields = lblErrorRequiredField;

        // Check that 5 fields are showing the 'Required field.' message
        if (requiredFields.size() == 5) {
            for (WebElement field : requiredFields) {
                // Pass the Duration to WebDriverWait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
                wait.until(ExpectedConditions.visibilityOf(field));
                System.out.println("Field is displaying the required message: " + field.getText());
                // You can add an assertion here to verify the text
                assert field.getText().equals("Required field.") : "Field does not display required message!";
            }
        } else {
            System.out.println("The number of required fields does not match the expected 5.");
        }
    }

    public void verifyInvalidConfirmPassword(){
        newWaitForElementVisible(lblErrorPassC);

        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorPassC);
        // Assert that the error label is displayed
        Assert.assertTrue("The Confirm password field does not match the Password field.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "The Confirm password field does not match the Password field.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidFirstNameMayContainAlphabetAndNumber(){
        // Assert each field using the generic method
        assertMayContainAlphabetAndSpaceChar(lblErrorFname, "First Name");
    }

    public void verifyInvalidLastNameMayContainAlphabetAndNumber(){
        // Assert each field using the generic method
        assertMayContainAlphabetAndSpaceChar(lblErrorLname, "Last Name");
    }

    public void verifyInvalidFormatEmail(){
        newScrollIntoView(lblErrorInvalidFormatEmail);
        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorPass);
        // Assert that the error label is displayed
        Assert.assertTrue("Invalid email address.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Invalid email address.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidPasswordLessThan6Chars(){
        newScrollIntoView(lblErrorPass);
        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorPass);
        // Assert that the error label is displayed
        Assert.assertTrue("The Password field must be at least 6 characters in length.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "The Password field must be at least 6 characters in length.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidPasswordNotCombination(){
        newScrollIntoView(lblErrorPass);
        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorPass);
        // Assert that the error label is displayed
        Assert.assertTrue("Password field must have at least 1 character and 1 number.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Password field must have at least 1 character and 1 number.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyRegisteredEmail(){
        newScrollIntoView(lblErrorRegisteredEmail);
        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorRegisteredEmail);
        // Assert that the error label is displayed
        Assert.assertTrue("This email has been registered. Please use another email.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "This email has been registered. Please use another email.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidEmail(){
        newScrollIntoView(lblErrorInvalidEmail);
        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblErrorInvalidEmail);
        // Assert that the error label is displayed
        Assert.assertTrue("Invalid email.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Invalid email.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }


}
