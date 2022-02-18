package org.kuncie.test.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.kuncie.test.constans.Constants;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverInstance {
    public static AndroidDriver<AndroidElement> initialize() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "device");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("ignoreHiddenApiPolicyError", true);
        caps.setCapability("noReset", false);
        caps.setCapability("deviceReadyTimeout", 80000);
        caps.setCapability("appWaitDuration", 100000);
        caps.setCapability("newCommandTimeout", 40000);
        caps.setCapability("app", Constants.APK);

        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return androidDriver;
    }
}

