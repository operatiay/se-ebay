package com.ab.ebay.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchSortElement extends EbayPage {

    public enum SearchSortOptionEnum{
        LOWEST_PRICE("Lowest price"),
        LOWEST_PRICE_P_P("Lowest price + P&P"),
        HIGHEST_PRICE("Highest price"),
        HIGHEST_PRICE_P_P("Highest price + P&P"),
        NEWLY_LISTED("Newly listed"),
        ENDING_SOONEST("Ending soonest"),
        NEAREST_FIRST("Nearest first");


        private static final String OPTION_FINDER_TEMPLATE = "//*[contains(@id,'SortMenu')]//*[text()='%s']";
        private final By finder;

        SearchSortOptionEnum(String optionName) {
            this.finder = By.xpath(String.format(OPTION_FINDER_TEMPLATE, optionName));
        }

        public By getFinder() {
            return finder;
        }
    }

    public static final By SEARCH_SORT_FINDER = By.cssSelector("[aria-controls='SortMenu']");

    public SearchSortElement(SearchResultPage parent) {
        super(parent);
    }

    public void sortResults(SearchSortElement.SearchSortOptionEnum sortOption){
        new WebDriverWait(getDriver(), 3).until(
                        ExpectedConditions.elementToBeClickable(SEARCH_SORT_FINDER)).click();
        new WebDriverWait(getDriver(), 3).until(
                        ExpectedConditions.elementToBeClickable(sortOption.getFinder())).click();
        waitForLoad();
    }


    @Override
    public void waitForLoad() {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(SEARCH_SORT_FINDER));
    }
}
