package org.hint.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.hint.BasePage;

public class CurrencyPage extends BasePage {

    public CurrencyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[contains(@class,'header-icon')]//li[contains(@class,'nav-item')]//div[@class='curr']") //ini selector currency diluar flow order
    private WebElement btnCurrencyOnHomepage;
    private By btnCurrencyOnOrder = By.cssSelector(".nav-item"); //ini selector currency saat order
    private By popupChangeCurrency = By.cssSelector(".sticky-currency");
    private By USD = By.xpath("//div[contains(text(),'United States Dollar')]");
    private By MYR = By.xpath("//div[contains(text(),'Malaysian Ringgit')]");
    private By SGD = By.xpath("//div[contains(text(),'Singapore Dollar')]");
    private By IDR = By.xpath("//div[contains(text(),'Indonesian Rupiah')]");


    public void changeIDRcurrency(){
        newWaitForElementVisible(btnCurrencyOnOrder);
        newClick(btnCurrencyOnOrder);
        newIsDisplayed(popupChangeCurrency);
        newWaitForElementVisible(IDR);
        newClick(IDR);
    }

    public void changeUSDcurrency(){
        newWaitForElementVisible(btnCurrencyOnOrder);
        newClick(btnCurrencyOnOrder);
        newIsDisplayed(popupChangeCurrency);
        newWaitForElementVisible(USD);
        newClick(USD);
    }

    public void changeSGDcurrency(){
        newWaitForElementVisible(btnCurrencyOnOrder);
        newClick(btnCurrencyOnOrder);
        newIsDisplayed(popupChangeCurrency);
        newWaitForElementVisible(SGD);
        newClick(SGD);
    }

    public void changeMYRcurrency(){
        newWaitForElementVisible(btnCurrencyOnOrder);
        newClick(btnCurrencyOnOrder);
        newIsDisplayed(popupChangeCurrency);
        newWaitForElementVisible(MYR);
        newClick(MYR);
    }

}
