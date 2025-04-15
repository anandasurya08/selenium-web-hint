package org.hint.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hint.BasePage;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {

        super(driver);
    }

    private static final String BASE_URL = "https://hintofyou.playbybeautyhaul.com/en/product/detail/";

    // Define URL constants
    private static String SINGLE_URL = BASE_URL + "single-sanity1";
    private static String SINGLE_VARIANT_URL = BASE_URL + "single-variant-snty2";
    private static String BUNDLE_URL = BASE_URL + "bundle-variant-snty1";
    private static String BUNDLE_VARIANT_URL = BASE_URL + "bundle-variant-snty2";
    private static String LIMIT_ORDER_URL = BASE_URL + "travel-size-realm";
    private static String FREE_SHIPPING_URL = BASE_URL + "hint-realm-2";
    private static String PROMOTION_PRODUCT_URL = BASE_URL + "testing-single-snty";

    private static String INPUT_ENGRAVE_LETTER = "addengrave";
    private static String EDIT_ENGRAVE_LETTER = "editngrave";


    @FindBy(css = ".products-detail")
    private WebElement layoutProductDetail;

    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Add to Bag']")
    private WebElement btnAddToBag;
    @FindBy(xpath = "//div[@class='cart-added']/div[@class='container-fluid'][text()='Product successfully added to cart']")
    private WebElement lblSuccessAddToBag;
    @FindBy(xpath = "//div[@class='plus']")
    private WebElement btnPlusQty;
    @FindBy(xpath = "//div[@class='min']")
    private WebElement btnMinQty;

    private By btnEngraveFromProductDetail = By.xpath("//button[contains(text(),'Engrave Now')]");



    @FindBy(xpath = "//div[@class='bold'][normalize-space()='Engrave']")
    private WebElement popupEngrave;
    @FindBy(name = "engrave")
    private WebElement txtEngrave;
    @FindBy(css = ".form-error.pt-2")
    private WebElement lblErrorEngrave;
    @FindBy(xpath = "//button[contains(text(),'Save Customization')]")
    private WebElement btnSaveCustomizationEngrave;
    @FindBy(xpath = "//div[@class='cart-added']/div[@class='container-fluid'][text()='Product successfully engraved']")
    private WebElement lblSuccessfullyEngrave;



    public void openProductSingleURL(){
        driver.get(SINGLE_URL);
        forLoading();
    }

    public void openProductSingleVariantURL(){
        driver.get(SINGLE_VARIANT_URL);
        forLoading();
    }

    public void openProductBundleURL(){
        driver.get(BUNDLE_URL);
        forLoading();
    }

    public void openProductBundleVariantURL(){
        driver.get(BUNDLE_VARIANT_URL);
        forLoading();
    }

    public void openPromotionProduct(){
        driver.get(PROMOTION_PRODUCT_URL);
        forLoading();
    }

    public void openProductFreeShipping(){
        driver.get(FREE_SHIPPING_URL);
        forLoading();
    }

    public void openProductLimitOrder(){
        driver.get(LIMIT_ORDER_URL);
        forLoading();
    }

    public void clickAddQty(){
        waitForElementClickable(btnPlusQty);
        click(btnPlusQty);
    }

    public void clickAddToBag(){
        waitForElementClickable(btnAddToBag);
        click(btnAddToBag);
    }

    public void openEngraveFromProductDetail(){
        newWaitForElementClickable(btnEngraveFromProductDetail);
        newClick(btnEngraveFromProductDetail);
    }

    public void verifyEngraveBtnNotExists(){
        waitForElementDisappear(btnEngraveFromProductDetail);

    }

    public void inputEmptyEngrave(){
        newWaitForElementClickable(btnEngraveFromProductDetail);
        newClick(btnEngraveFromProductDetail);
        isDisplayed(popupEngrave);
        waitForElementClickable(btnSaveCustomizationEngrave);
        click(btnSaveCustomizationEngrave);
    }

    public void inputEngrave(){
        BasePage.engraveLetter = INPUT_ENGRAVE_LETTER;

        isDisplayed(popupEngrave);
        waitForElementVisible(txtEngrave);
        sendKeys(txtEngrave, BasePage.engraveLetter);
        waitForElementClickable(btnSaveCustomizationEngrave);
        click(btnSaveCustomizationEngrave);
    }

    public void editEngrave(){
        BasePage.engraveLetter = EDIT_ENGRAVE_LETTER;

        isDisplayed(popupEngrave);
        waitForElementVisible(txtEngrave);
        clear(txtEngrave);
        sendKeys(txtEngrave, BasePage.engraveLetter);
        waitForElementClickable(btnSaveCustomizationEngrave);
        click(btnSaveCustomizationEngrave);
    }

    public void inputInvalidEngrave(){
        BasePage.engraveLetter = "!@#$%*";

        newClick(btnEngraveFromProductDetail);
        isDisplayed(popupEngrave);
        waitForElementVisible(txtEngrave);
        sendKeys(txtEngrave, BasePage.engraveLetter);
        waitForElementClickable(btnSaveCustomizationEngrave);
        click(btnSaveCustomizationEngrave);
    }

    public void inputAlphabetNumericSpaceEngrave(){
        BasePage.engraveLetter = "test1 2";

        newClick(btnEngraveFromProductDetail);
        isDisplayed(popupEngrave);
        waitForElementVisible(txtEngrave);
        sendKeys(txtEngrave, BasePage.engraveLetter);
        waitForElementClickable(btnSaveCustomizationEngrave);
        click(btnSaveCustomizationEngrave);
    }

    public void verifyErrorEngraveMayContainAlphabetAndNumber(){
        isDisplayed(lblErrorEngrave);
        // Assert that the text matches the expected message
        String expectedMessage = "May only contain alphabetical and number characters.";
        String actualMessage = lblErrorEngrave.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public void verifySuccessfullyEngrave(){
        isDisplayed(lblSuccessfullyEngrave);
        // Assert that the text matches the expected message
        String expectedMessage = "Product successfully engraved";
        String actualMessage = lblSuccessfullyEngrave.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    public boolean verifyAfterAddToBag(){
        return isDisplayed(lblSuccessAddToBag);
    }



}
