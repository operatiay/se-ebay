package com.ab.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFilterElement extends EbayPage{
    public enum SearchFilterOptionEnum{
        ALL_LISTINGS("All listings"),
        AUCTION("Auction"),
        BUY_NOW("Buy it now");

        private static final String FILTER_OPTION_CSS_FINDER_TEMPLATE = ".tgl_button[title='%s']";

        private final By finder;

        SearchFilterOptionEnum(String optionName) {
            finder = By.cssSelector(String.format(FILTER_OPTION_CSS_FINDER_TEMPLATE, optionName));
        }
    }

    public SearchFilterElement(SearchResultPage searchResultPage) {
        super(searchResultPage);
    }

    public void filter(SearchFilterOptionEnum filterOption) {
        getDriver().findElement(filterOption.finder).click();
        waitForLoad();
    }

    @Override
    public void waitForLoad() {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(SearchFilterOptionEnum.ALL_LISTINGS.finder));
    }
}
