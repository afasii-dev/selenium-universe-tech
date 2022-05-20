package phptravels.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PhpFlightPage {
     FLIGHT_PAGE("https://www.phptravels.net/flights");

    private final String url;
}
