package org.kuncie.test.pages.main;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.base.BasePage;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    WebElement scrollHorizontalGallery;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Shrine')]")
    WebElement shrineGallery;

    public HomePage(TestContext context) {
        super(context);
    }

    public void clickShrineGallery() {
        scrollHorizontal(scrollHorizontalGallery, true, true);
        waitABit(2);
        shrineGallery.click();
    }
}