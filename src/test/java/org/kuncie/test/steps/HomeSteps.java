package org.kuncie.test.steps;

import io.cucumber.java.en.Given;
import org.kuncie.test.context.TestContext;
import org.kuncie.test.pages.main.HomePage;
import org.kuncie.test.pages.main.ShrineLoginPage;

public class HomeSteps {
    HomePage homePage;
    ShrineLoginPage shrineLoginPage;

    public HomeSteps(TestContext testContext) {
        homePage = new HomePage(testContext);
        shrineLoginPage = new ShrineLoginPage(testContext);
    }

    @Given("User go to Shrine Gallery")
    public void userGoToShrineGallery() {
        homePage.clickShrineGallery();
        shrineLoginPage.clickLoginButton();
    }
}
