package org.hint.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hint.BasePage;

public class CheckoutShippingPage extends BasePage {

    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    private By divShipping = By.cssSelector(".card-ship-address");

    @FindBy(name = "ship_fname")
    private WebElement txtShippingFname;
    @FindBy(name = "ship_lname")
    private WebElement txtShippingLname;
    @FindBy(name = "ship_address")
    private WebElement txtShippingAddress;
    @FindBy(xpath = "//option[contains(text(),'Default Address')]")
    private WebElement lblDefaultAddress;
    @FindBy(xpath = "//div[contains(@class,'form-control-ship_city')]")
    private WebElement drpdShippingCity;
    @FindBy(xpath = "//div[contains(@class,'select2-dropdown-open')]")
    private WebElement drpdOpenShippingCity;
    @FindBy(css = "#select2-drop input.select2-input")
    private WebElement txtInputShippingCity;
    @FindBy(xpath = "//li[contains(@class,'select2-result-selectable')]/div[@class='select2-result-label']/span[text()='Kembangan']")
    private WebElement txtResultShippingCity; //ini contoh data Kembangan
    @FindBy(xpath = "//span[@class='select2-chosen'][text()='DKI Jakarta, Jakarta Barat, Kembangan']")
    private WebElement txtChosenShippingCity; //ini contoh data Kembangan
    @FindBy(name = "ship_zip")
    private WebElement drpdShippingZip;
    @FindBy(xpath = "//div[@class='replacement'][text()='11630']")
    private WebElement drpdChosenShippingZip;
    @FindBy(name = "ship_phone")
    private WebElement txtShippingPhone;

    @FindBy(xpath = "//label[@for='myonoffswitchdis-dropship']//div[@class='onoffswitchdis-switch']")
    private WebElement switchDropshipper;
    @FindBy(name = "dropship_name")
    private WebElement txtDropshipperName;
    @FindBy(name = "dropship_phone")
    private WebElement txtDropshipperPhone;

    private By btnNextStep = By.xpath("(//button[normalize-space()='Next Step'])[1]");


    public void inputShippingFirstName() {
        String firstName = "staging";
        sendKeys(txtShippingFname, firstName);
    }

    public void inputShippingLastName() {
        String lastName = "staging";
        sendKeys(txtShippingLname, lastName);
    }

    public void inputShippingAddress() {
        String address = "Jl. Kembangan Selatan No. 10";
        sendKeys(txtShippingAddress, address);
    }

    public void chooseShippingCity(){
        waitForElementClickable(drpdShippingCity);
        click(drpdShippingCity);
        waitForElementVisible(drpdOpenShippingCity);
        wait3second();
        sendKeys(txtInputShippingCity, "Kembangan");
        waitForElementVisible(txtResultShippingCity);
        click(txtResultShippingCity);
        isDisplayed(txtChosenShippingCity);
    }

    public void chooseShippingZip(){
        wait3second();
        selectByVisibleText(drpdShippingZip, "11630");
        isDisplayed(drpdChosenShippingZip);
    }

    public void inputShippingPhone(){
        sendKeys(txtShippingPhone, "08123456789");
    }

    public void inputDropshipperData(){
        waitForElementClickable(switchDropshipper);
        click(switchDropshipper);
        waitForElementVisible(txtDropshipperName);
        waitForElementVisible(txtDropshipperPhone);
        sendKeys(txtDropshipperName, "testing webdriver");
        sendKeys(txtDropshipperPhone, "08123456789");
    }

    public void verifyDefaultAddressAppear(){
        waitForElementVisible(lblDefaultAddress);

        // Assert that the text matches the expected message
        String expectedMessage = "Kantor (Default Address)";
        String actualMessage = lblDefaultAddress.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public void goToCheckoutDeliveryAndPaymentPage(){
        newIsDisplayed(divShipping);
        newWaitForElementVisible(btnNextStep);
        newClick(btnNextStep);
    }

}
