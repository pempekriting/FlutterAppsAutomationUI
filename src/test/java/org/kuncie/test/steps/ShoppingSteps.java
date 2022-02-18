package org.kuncie.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.main.ShrineProductsLayoutPage;
import org.kuncie.test.pages.main.ShrineShoppingCartPage;
import org.kuncie.test.pages.main.ShrineWidgetPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingSteps {
    ShrineWidgetPage shrineWidgetPage;
    ShrineProductsLayoutPage shrineProductsLayoutPage;
    ShrineShoppingCartPage shrineShoppingCartPage;

    public ShoppingSteps(TestContext testContext) {
        shrineWidgetPage = new ShrineWidgetPage(testContext);
        shrineProductsLayoutPage = new ShrineProductsLayoutPage(testContext);
        shrineShoppingCartPage = new ShrineShoppingCartPage(testContext);
    }

    @And("User Add {string} to the cart")
    public void userAddToTheCart(String product) {
        shrineProductsLayoutPage.clickProduct(product);
    }

    @And("User go to {string} filter")
    public void userGoToFilter(String menu) {
        shrineWidgetPage.clickPrimaryMenu()
                .clickSubMenu(menu)
                .clickShoppingCart()
                .navigateBack();
        shrineWidgetPage.waitABit(2);
    }

    @Then("Shopping cart should have a {int} items")
    public void shoppingCartShouldHaveAItems(int totalItem) {
        shrineWidgetPage.clickShoppingCart();
        shrineWidgetPage.waitABit(3);
        assertThat(shrineShoppingCartPage.getTotalItemInShoppingCart()).isEqualTo(totalItem);
    }

    @And("User clear the shopping cart")
    public void userClearTheShoppingCart() {
        shrineShoppingCartPage.clickClearCartButton();
    }
}
