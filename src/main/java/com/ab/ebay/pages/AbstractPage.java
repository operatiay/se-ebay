package com.ab.ebay.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    private WebDriver driver;
    private AbstractPage parentPage = null;

    void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    AbstractPage getParentPage() {
        return parentPage;
    }

    void setParentPage(AbstractPage page) {
        this.parentPage = page;
    }

    /**
     * Implement this method to ensure that the page has loaded before interactions
     */
    abstract void waitForLoad();
}
