package org.kuncie.test.pages.main;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.base.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShrineShoppingCartPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Close cart')]/following-sibling::android.view.View[2]//android.view.View[contains(@content-desc,'$')]")
    List<WebElement> totalItemInShoppingCart;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CLEAR CART']")
    WebElement btnClearCart;

    public ShrineShoppingCartPage(TestContext context) {
        super(context);
    }

    public int getTotalItemInShoppingCart() {
        return totalItemInShoppingCart.size();
    }

    public void clickClearCartButton() {
        btnClearCart.click();
    }
}
