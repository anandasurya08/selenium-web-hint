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

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

        super(driver);
    }


    private By btnGoToBagSidebar = By.xpath("//li[@class='nav-item nav-menu-cart d-none d-sm-block']//span[@class='i']");
    private By btnAddQty = By.xpath("(//div[@class='plus-desktop'])[1]");
    private By btnSubtractQuantity = By.xpath("//div[contains(@class,'min-desktop')]");
    private By btnRemoveProduct = By.xpath("//div[contains(@class,'min-desktop')]");


    public void openCartSidebar(){
        newWaitForElementClickable(btnGoToBagSidebar);
        newClick(btnGoToBagSidebar);
    }

    public void addQuantityInCart(){
        newWaitForElementClickable(btnAddQty);
        newClick(btnAddQty);
    }

    public void subtractQuantityInCart(){
        newWaitForElementClickable(btnSubtractQuantity);
        newClick(btnSubtractQuantity);
    }

    public void deleteProductInCart(){
        newWaitForElementClickable(btnRemoveProduct);
        newClick(btnRemoveProduct);
    }
}


