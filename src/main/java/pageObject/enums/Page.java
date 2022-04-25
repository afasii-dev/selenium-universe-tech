package pageObject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Page {
    HOME_PAGE("https://www.google.com/"),
    SEARCH_PAGE("https://www.google.com/search");

    private String url;
}
