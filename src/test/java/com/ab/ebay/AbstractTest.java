package com.ab.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTest {


    private WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        FirefoxProfile profile = new ProfilesIni().getProfile("default");
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("network.cookie.cookieBehavior", 2);
        profile.setEnableNativeEvents(true);
        setDriver(new FirefoxDriver(profile));
    }

    @AfterTest
    public void stopBrowser() {
        getDriver().quit();
    }

    void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver getDriver() {
        return this.driver;
    }
}
