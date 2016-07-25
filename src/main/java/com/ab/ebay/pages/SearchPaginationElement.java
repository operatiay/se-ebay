package com.ab.ebay.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchPaginationElement extends EbayPage{
    /** finds all accessible links. */
    private static final By ACCESSIBLE_RESULTSPAGE_LINKS_FINDER = By.cssSelector(".pages .pg");

    public SearchPaginationElement(SearchResultPage parentPage) {
        super(parentPage);
    }

    public Integer[] getAccessibleSearchResultPages() {
        List<WebElement> accessibleResultPageLinks = getDriver().findElements(ACCESSIBLE_RESULTSPAGE_LINKS_FINDER);
        return accessibleResultPageLinks.stream()
                .map(WebElement::getText)
                .map(Integer::valueOf)
                .collect(Collectors.toList())
                .toArray(new Integer[accessibleResultPageLinks.size()]);
    }

    public void navigateToResultPageByNumber(Integer pageNumber) {
        Optional<WebElement> pageWithRightNumber = getDriver().findElements(ACCESSIBLE_RESULTSPAGE_LINKS_FINDER).stream().filter(we -> Integer.valueOf(we.getText()).equals(pageNumber)).findFirst();
        pageWithRightNumber.orElseThrow(() -> new ElementNotFoundException("page button", "text()", pageNumber+"")).click();
        getParentPage().waitForLoad();
    }

    @Override
    void waitForLoad() {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(ACCESSIBLE_RESULTSPAGE_LINKS_FINDER));
    }
}
