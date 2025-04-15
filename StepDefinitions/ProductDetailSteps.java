package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hint.PageObject.BagPage;
import org.hint.PageObject.ProductDetailPage;
import org.openqa.selenium.WebDriver;

public class ProductDetailSteps {

    private final WebDriver driver = Hooks.driver;
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    BagPage bag = new BagPage(driver);


    @Then("open product for free shipping")
    public void openProductForFreeShipping() {
        productDetailPage.openProductFreeShipping();
    }


    @And("add to bag")
    public void addToBag() {
        productDetailPage.clickAddToBag();
        productDetailPage.verifyAfterAddToBag();
    }

    @Then("open product single detail")
    public void openProductSingleDetail() {
        productDetailPage.openProductSingleURL();

    }

    @Then("open product bundle detail")
    public void openProductBundleDetail() {
        productDetailPage.openProductBundleURL();
    }

    @Then("open product bundle variant detail")
    public void openProductBundleVariantDetail() {
        productDetailPage.openProductBundleVariantURL();
    }

    @Then("open product single variant detail")
    public void openProductSingleVariantDetail() {
        productDetailPage.openProductSingleVariantURL();
    }

    @Then("open promotion product detail")
    public void openPromotionProductDetail() {
        productDetailPage.openPromotionProduct();
    }

    @Then("open product with limit order")
    public void openProductWithLimitOrder() {
        productDetailPage.openProductLimitOrder();
    }

    @And("user set qty product into two")
    public void userSetQtyProductIntoTwo() {
        productDetailPage.clickAddQty();
    }

    @And("user engrave product on bag")
    public void userEngraveProductOnBag() {
        bag.openAddEngraveMenuOnBag();
        productDetailPage.inputEngrave();
        productDetailPage.verifySuccessfullyEngrave();
    }

    @And("user engrave product on product detail")
    public void userEngraveProductOnProductDetail() {
        productDetailPage.openEngraveFromProductDetail();
        productDetailPage.inputEngrave();
        productDetailPage.verifyAfterAddToBag();
    }

    @And("user edit engrave on bag")
    public void userEditEngraveOnBag() {
        bag.openEditEngraveMenuOnBag();
        productDetailPage.editEngrave();
        productDetailPage.verifySuccessfullyEngrave();
    }


    @And("user engrave product but with empty field")
    public void userEngraveProductButWithEmptyField() {
        productDetailPage.inputEmptyEngrave();
        productDetailPage.verifyAfterAddToBag();
    }

    @And("user engrave product but with invalid letter")
    public void userEngraveProductButWithInvalidLetter() {
        productDetailPage.inputInvalidEngrave();
    }

    @Then("verify showing error message engrave letter may contain alphabet and number")
    public void verifyShowingErrorMessageEngraveLetterMayContainAlphabetAndNumber() {
        productDetailPage.verifyErrorEngraveMayContainAlphabetAndNumber();
    }

    @And("user engrave product but with alphabet numeric and space on engrave letter")
    public void userEngraveProductButWithAlphabetNumericAndSpaceOnEngraveLetter() {
        productDetailPage.inputAlphabetNumericSpaceEngrave();
        productDetailPage.verifyAfterAddToBag();
    }

    @And("verify Engrave button is not exists")
    public void verifyEngraveButtonIsNotExists() {
    }
}
