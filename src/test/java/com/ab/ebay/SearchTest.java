package com.ab.ebay;

import com.ab.ebay.pages.EbayHomePage;
import com.ab.ebay.pages.SearchFilterElement;
import com.ab.ebay.pages.SearchResultPage;
import com.ab.ebay.pages.SearchSortElement;
import org.testng.annotations.Test;

public class SearchTest extends AbstractTest {

    @Test
    public void canSearchSortFilter() {
        EbayHomePage homePage = new EbayHomePage(getDriver());
        SearchResultPage searchResultPage = homePage.search("IPhone");
        searchResultPage = searchResultPage.sortResults(SearchSortElement.SearchSortOptionEnum.ENDING_SOONEST);
        searchResultPage = searchResultPage.filter(SearchFilterElement.SearchFilterOptionEnum.BUY_NOW);
        searchResultPage = searchResultPage.navigateToResultPage(searchResultPage.getAccessibleSearchResultPages()[2]);
    }
}
