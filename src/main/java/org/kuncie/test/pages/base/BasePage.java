package org.kuncie.test.pages.base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.kuncie.test.context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriverWait wait;
    private final AndroidDriver<AndroidElement> androidDriver;
    private final TouchAction action;
    private final JavascriptExecutor js;

    public BasePage(TestContext context) {
        wait = new WebDriverWait(context.androidDriver, 1);
        androidDriver = context.androidDriver;
        action = new TouchAction(context.androidDriver);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        js = context.androidDriver;
    }

    private AndroidDriver<AndroidElement> getDriver() {
        return androidDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getValueAttribute(WebElement webElement, String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    public void scrollHorizontal(WebElement webElement, boolean scrollRight, boolean shortScroll) {
        Rectangle rec = webElement.getRect();

        int refElMidY = rec.getY() + rec.getHeight() / 2;
        int refElSmallX = (int) (rec.getX() + rec.getWidth() * 0.1);
        int refElBigX = (int) (rec.getX() + rec.getWidth() * 0.9);

        if (shortScroll) {
            refElSmallX = (int) (rec.getX() + rec.getWidth() * 0.5);
        }

        if (scrollRight) {
            action.longPress(PointOption.point(refElBigX, refElMidY))
                    .moveTo(PointOption.point(refElSmallX, refElMidY))
                    .release()
                    .perform();
        } else {
            action.longPress(PointOption.point(refElSmallX, refElMidY))
                    .moveTo(PointOption.point(refElBigX, refElMidY))
                    .release()
                    .perform();
        }
    }

    public void waitABit(Integer seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public WebElement findBy(By by) {
        return getDriver().findElement(by);
    }

    public void clickOnJs(WebElement webElement) {
        js.executeScript("arguments[0].click();", webElement);
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void tapOnPoint(int x, int y) {
        action.longPress(PointOption.point(x, y)).release().perform();
    }

    public void scrollHorizontalUntilFoundTheElement(By toFind, WebElement toScroll, boolean scrollRight, boolean shortScroll) {
        boolean tempBool = false;
        while (!tempBool) {
            scrollHorizontal(toScroll, scrollRight, shortScroll);
            if (checkElementExistByVisibilityOfElementLocated(toFind)) {
                findBy(toFind).click();
                tempBool = true;
            }
        }
    }

    public boolean checkElementExistByVisibilityOfElementLocated(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}