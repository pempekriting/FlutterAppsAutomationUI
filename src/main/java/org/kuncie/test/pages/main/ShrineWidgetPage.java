package org.kuncie.test.pages.main;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShrineWidgetPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Open menu']")
    WebElement btnMenu;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Shopping cart')]")
    WebElement shoppingCart;

    public ShrineWidgetPage(TestContext context) {
        super(context);
    }

    public ShrineWidgetPage clickPrimaryMenu() {
        btnMenu.click();
        return this;
    }

    public ShrineWidgetPage clickSubMenu(String menu) {
        findBy(By.xpath("//android.widget.Button[@content-desc='" + menu + "']")).click();
        return this;
    }

    public ShrineWidgetPage clickShoppingCart() {
        tapOnPoint(shoppingCart.getLocation().x + 20, shoppingCart.getLocation().y + 50);
        return this;
    }
}