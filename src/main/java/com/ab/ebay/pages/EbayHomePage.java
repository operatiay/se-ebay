package com.ab.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayHomePage extends EbayPage{

    private By searchFieldFinder = By.cssSelector("input[placeholder='Search...']");

    public EbayHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForLoad() {
        getDriver().get("http://www.ebay.co.uk");
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#gh-la")));
    }

    public SearchResultPage search(String query) {
        getDriver().findElement(searchFieldFinder).sendKeys(query + "\n");
        return new SearchResultPage(query, this);
    }
}
