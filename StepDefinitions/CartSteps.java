package StepDefinitions;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hint.PageObject.CartPage;
import org.hint.PageObject.SignInPage;
import org.hint.PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CartSteps {
    private final WebDriver driver = Hooks.driver;
    SignInPage signInPage = new SignInPage(driver);
    CartPage cartPage = new CartPage(driver);

    @And("open cart sidebar")
    public void openCartSidebar() {
        cartPage.openCartSidebar();
    }

    @Then("add quantity in cart")
    public void addQuantityInCart() {
        cartPage.addQuantityInCart();
    }

    @Then("subtract quantity in cart")
    public void subtractQuantityInCart() {
        cartPage.subtractQuantityInCart();
    }

    @Then("delete product in cart")
    public void deleteProductInCart() {
        cartPage.deleteProductInCart();
    }
}
