package google.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GooglePage {
    HOME_PAGE("https://www.google.com/"),
    SEARCH_PAGE("https://www.google.com/search");

    private final String url;
}
