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

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static String InputSearch = "xzxzxzxzx";

    private By btnSearchBar = By.xpath("//li[@class='nav-item nav-menu-search-icon']//button[@type='button']");
    private By txtInputSearch = By.name("keyword");
    private By lblSearchResult = By.xpath("//div[normalize-space()='single sanity1']");
    private By btnCloseSearchBar = By.xpath("//a[normalize-space()='Close']");
    private By btnRemoveSearchKeyword = By.xpath("//div[@class='clear-search']");
    private By lblNoResult = By.xpath("//div[@class='text-search bold']");

    public void userClickSearchBar(){
        newWaitForElementClickable(btnSearchBar);
        newClick(btnSearchBar);
    }

    public void userInputKeywords(){
        String InputSearch = "single sanity1";
        newSendKeys(txtInputSearch, InputSearch);
    }

    public void showSearchResult(){
        forLoading();
        newIsDisplayed(lblSearchResult);
    }

    public void closeSearchBar(){
        newWaitForElementClickable(btnCloseSearchBar);
        newClick(btnCloseSearchBar);
    }

    public void userRemoveKeyword(){
        newWaitForElementClickable(btnRemoveSearchKeyword);
        newClick(btnRemoveSearchKeyword);
        waitForElementDisappear(lblSearchResult);
    }

    public void userInputKeywordsNoResult(){
        newSendKeys(txtInputSearch, InputSearch);
    }

    public void showSearchNoResult(){
        newWaitForElementVisible(lblNoResult);

        // Dynamically locate the WebElement
        WebElement element = driver.findElement(lblNoResult);
        // Assert that the error label is displayed
        Assert.assertTrue("No Result for xzxzxzxzx", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "No Result for \"" + InputSearch + "\"";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);
    }
}
