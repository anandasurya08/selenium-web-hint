package org.hint.PageObject;

import org.hint.BasePage;
import org.hint.Utils.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By btnCloseBanner = By.cssSelector(".popup-close");
    private By btnAccount = By.xpath("//li[@class='nav-item nav-menu-account']//button[@type='button']");
    private By txtEmail = By.xpath("//input[@placeholder='Email Address']");
    private By txtPassword = By.name("password");
    private By btnLogin = By.xpath("(//button[normalize-space()='Login'])");
    private By btnAfterLogin = By.cssSelector(".btn-icon-login");
//    private By lblErrorEmail = By.cssSelector("input[name=email] + .form-control-label-custom + .form-error");
//    private By lblErrorPassword = By.cssSelector("input[name=password] + .form-control-label-custom + .pass-eye + .form-error");
    private By lblError = By.cssSelector(".form-error");


    public void closePopupBanner(){
        newWaitForElementClickable(btnCloseBanner);
        newClick(btnCloseBanner);
    }

    public void clickBtnAccount(){
        newWaitForElementClickable(btnAccount);
        newClick(btnAccount);
    }

    public void inputEmail() throws IOException {
        newWaitForElementClickable(txtEmail);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String email = ExcelUtils.getCellData(1, 0); // assuming email is in the second row, first column
        newSendKeys(txtEmail, email);
    }

    public void inputInvalidEmail() throws IOException {
        newWaitForElementVisible(txtEmail);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String email = ExcelUtils.getCellData(3, 0); // assuming email is in the second row, first column
        newSendKeys(txtEmail, email);
    }

    public void inputUnregisteredEmail() throws IOException {
        newWaitForElementVisible(txtEmail);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String email = ExcelUtils.getCellData(4, 0); // assuming email is in the second row, first column
        newSendKeys(txtEmail, email);
    }

    public void inputPassword() throws IOException {
        newWaitForElementVisible(txtPassword);
        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
        String password = ExcelUtils.getCellData(1, 1); // assuming pass is in the second row, second column
        newSendKeys(txtPassword, password);
    }

    public void inputInvalidPassword() throws IOException {
        newWaitForElementVisible(txtPassword);
//        ExcelUtils.setExcelFile("src/test/resources/Data/Account.xlsx", "Sheet1");
//        String password = ExcelUtils.getCellData(4, 1); // assuming pass is in the second row, second column
        String pass = "asdf1234";
        newSendKeys(txtPassword, pass);
    }

    public void clickLoginBtn(){
        newWaitForElementClickable(btnLogin);
        newClick(btnLogin);
    }

    public boolean verifyUserHasBeenLoggedIn(){
        return newIsDisplayed(btnAfterLogin);
    }

    public boolean loginStoredAccount(){
        newSendKeys(txtEmail, BasePage.email);
        newSendKeys(txtPassword, BasePage.password);
        newScrollIntoView(btnLogin);
        newWaitForElementClickable(btnLogin);
        newClick(btnLogin);
        return newIsDisplayed(btnAfterLogin);
    }

    public void verifyRequiredFieldEmailAndPassword(){
        assertRequiredField(lblError, "Email");
        assertRequiredField(lblError, "Password");
    }

    public void verifyUnregisteredEmail(){
        newWaitForElementVisible(lblError);
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(lblError);
        // Assert that the error label is displayed
        Assert.assertTrue("This email is not registered yet.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "This email is not registered yet.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidEmail(){
        newWaitForElementVisible(lblError);
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(lblError);
        // Assert that the error label is displayed
        Assert.assertTrue("Invalid email address.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Invalid email address.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void verifyInvalidPassword(){
        newWaitForElementVisible(lblError);
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(lblError);
        // Assert that the error label is displayed
        Assert.assertTrue("Invalid email address / password.", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Invalid email address / password.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }




}
