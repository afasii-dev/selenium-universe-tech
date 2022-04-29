package phptravels.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PhpTravelsPage {
    HOME_PAGE(""),
    SEARCH_PAGE(""),
    REGISTER_PAGE("");

    private final String url;
}
