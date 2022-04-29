package google.model;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@RequiredArgsConstructor
public class SearchPage extends Driver {

    private final String SEARCH_PAGE_URL = "search";

    public boolean isSearchPage() {
        wait.until(ExpectedConditions.urlContains(SEARCH_PAGE_URL));
        return driver.getCurrentUrl().contains(SEARCH_PAGE_URL);
    }

}