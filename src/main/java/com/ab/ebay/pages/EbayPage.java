package com.ab.ebay.pages;

import org.openqa.selenium.WebDriver;

public abstract class EbayPage extends AbstractPage{


    public EbayPage(WebDriver driver) {
        setDriver(driver);
        waitForLoad();
    }

    public EbayPage(AbstractPage parentPage) {
        this(parentPage.getDriver());
        setParentPage(parentPage);
    }
}
