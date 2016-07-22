package com.ab.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends EbayPage {
    public static final By SEARCH_QUERY_TITLE_FINDER = By.cssSelector("h1 b");
    private final SearchSortElement searchSortElement;
    private final SearchFilterElement searchFilterElement;
    private final SearchPaginationElement searchPaginationElement;
    String searchQuery;

    public SearchResultPage(String searchQuery, AbstractPage parentPage) {
        super(parentPage);
        this.searchQuery = searchQuery;
        this.searchSortElement = new SearchSortElement(this);
        this.searchFilterElement = new SearchFilterElement(this);
        this.searchPaginationElement = new SearchPaginationElement(this);
    }

    public SearchResultPage sortResults(SearchSortElement.SearchSortOptionEnum sortOption){
        searchSortElement.sortResults(sortOption);
        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.refreshed(ExpectedConditions.textToBe(SEARCH_QUERY_TITLE_FINDER, searchQuery)));
        return this;
    }

    public SearchResultPage filter(SearchFilterElement.SearchFilterOptionEnum filterOption) {
        searchFilterElement.filter(filterOption);
        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.refreshed(ExpectedConditions.textToBe(SEARCH_QUERY_TITLE_FINDER, searchQuery)));
        return this;
    }

    public Integer[] getAccessibleSearchResultPages() {
        return searchPaginationElement.getAccessibleSearchResultPages();
    }

    @Override
    public void waitForLoad() {
        if (searchQuery != null) {
            new WebDriverWait(getDriver(), 3).until(ExpectedConditions.textToBe(SEARCH_QUERY_TITLE_FINDER, searchQuery));
        }
    }

    public SearchResultPage navigateToResultPage(Integer pageNumber) {
        searchPaginationElement.navigateToResultPageByNumber(pageNumber);
        return this;
    }
}
