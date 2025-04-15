package org.hint.PageObject;

import org.hint.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {

    public BagPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//li[@class='nav-item nav-menu-cart d-none d-sm-block']//span[@class='i']")
    private WebElement btnGoToBag;
    @FindBy(xpath = "//div[@class='heading']")
    private WebElement lblHeaderBag;
    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    private WebElement btnCheckoutOnBag;
    @FindBy(linkText = "Add Engrave")
    private WebElement btnAddEngrave;
    @FindBy(linkText = "Edit Engrave")
    private WebElement btnEditEngrave;


    public void openBag(){
        waitForElementClickable(btnGoToBag);
        click(btnGoToBag);
        isDisplayed(lblHeaderBag);
    }

    public void openAddEngraveMenuOnBag(){
        openBag();
        waitForElementClickable(btnAddEngrave);
        click(btnAddEngrave);
    }

    public void openEditEngraveMenuOnBag(){
        openBag();
        waitForElementClickable(btnEditEngrave);
        click(btnEditEngrave);
    }

    public void goToCheckoutPage(){
        waitForElementClickable(btnCheckoutOnBag);
        click(btnCheckoutOnBag);
        forLoading();
    }

}
