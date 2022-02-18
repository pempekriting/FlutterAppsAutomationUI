package org.kuncie.test.pages.main;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.base.BasePage;
import org.openqa.selenium.WebElement;

public class ShrineLoginPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
    WebElement btnLogin;

    public ShrineLoginPage(TestContext context) {
        super(context);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }
}