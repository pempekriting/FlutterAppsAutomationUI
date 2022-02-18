package org.kuncie.test.pages.main;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShrineProductsLayoutPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Shopping cart')]/following-sibling::android.view.View/android.view.View[2]")
    WebElement productsScroll;

    public ShrineProductsLayoutPage(TestContext context) {
        super(context);
    }

    public ShrineProductsLayoutPage clickProduct(String productName) {
        scrollHorizontalUntilFoundTheElement(By.xpath("//android.widget.Button[contains(@content-desc,'" + productName + "')]"), productsScroll, true, true);
        return this;
    }
}
