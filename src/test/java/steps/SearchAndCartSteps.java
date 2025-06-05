package steps;

import components.FoundProduct;
import exceptions.PageNotPresentException;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.MainPage;
import pages.ProductAddedToCartPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class SearchAndCartSteps extends CommonSteps {

    @When("I search $product")
    public void searchProduct(String product) throws PageNotPresentException {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(product);
    }

    @When("Select first product from result list")
    public void selectFirstProduct() throws PageNotPresentException {
        MainPage mainPage = new MainPage(driver);
        List<FoundProduct> foundProducts = mainPage.getFoundProducts();
        assertFalse("Products not found", foundProducts.isEmpty());
        System.out.println("Elements - " + foundProducts.size());
        foundProducts.getFirst().tapToElement();
    }

    @Then("Product page is opened")
    public void productPageIsOpened() throws PageNotPresentException {
        new ProductPage(driver);
    }

    @When("I click to 'Add to cart' button")
    public void clickToAddToCartButton() throws PageNotPresentException {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddToCartButton();
    }

    @Then("'Product added to cart' page is opened")
    public void productAddedToCartPageIsOpened() throws PageNotPresentException {
        new ProductAddedToCartPage(driver);
    }

    @When("I click to 'Confirm order' button")
    public void clickToConfirmOrderButton() throws PageNotPresentException {
        ProductAddedToCartPage productAddedToCartPage = new ProductAddedToCartPage(driver);
        productAddedToCartPage.clickToConfirmButton();
    }

    @Then("Shopping Cart page is opened")
    public void shoppingCartPageIsOpened() throws PageNotPresentException {
        new ShoppingCartPage(driver);
    }

}
